package Controller;

import DAO.CategoryDao;
import DAO.ProductDAO;
import Model.Category;
import Model.Product;
import callable.CategoryCallable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProductController extends ItemController implements Initializable {
    @FXML
    private TextField txt_search;
    @FXML
    protected Label lb_search;
    @FXML
    private Button btn_addProduct;

    @FXML
    private Label lb_pageNumber;
    @FXML
    private ChoiceBox<String> choiceBox_sort;

    @FXML
    private AnchorPane pane_Product;
    @FXML
    private Button btn_search;
    @FXML
    private Button btn_scanSKU;
    @FXML
    private ImageView iv_scanSKU;
    @FXML
    protected MenuButton mbCategory;
    @FXML
    protected Label lb_Category;
    protected Map<Integer, MenuItem> menuItemMap = new HashMap<>();
    private String[] searchFilter = {"Tìm theo tên" , "Tìm theo Barcode"};

    private String[] list = {"Cake", "Noodle" , "Fast Food" , "Drinking" , "Ice Cream" , "Vegetable"};
    private ArrayList<Product> productList;
    private ArrayList <Product> productSearchList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Limit=8;
        offSet=0;
        choiceBox_sort.getItems().addAll(searchFilter);
        choiceBox_sort.setStyle("-fx-font-size:15px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
        mbCategory.setStyle("-fx-font-size:20px ; -fx-background-color:transparent ; -fx-alignment:Center ; -fx-padding: 0px 5px 5px -2px");
    btn_scanSKU.setVisible(false);
    iv_scanSKU.setVisible(false);
    choiceBox_sort.setValue("Tìm theo tên");
        setUpMenu();
    btn_addProduct.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            loadFXML("views/addProduct.fxml");
        }
    });
        btn_scanSKU.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Runnable clock = new Runnable() {
                        @Override
                        public void run() {
                            CameraApp barCodeScanner= new CameraApp();
                            barCodeScanner.setTextField(txt_search);
                            barCodeScanner.run();
                        }
                    };

                    Thread newClock = new Thread(clock); //Creating new thread
                    newClock.setDaemon(true); //Thread will automatically close on applications closing
                    newClock.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    choiceBox_sort.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(choiceBox_sort.getValue().equals("Tìm theo Barcode")){
                btn_scanSKU.setVisible(true);
                iv_scanSKU.setVisible(true);
            }

        }
    });

    showData(Limit,offSet);
    setActionForBtn();
    setRightLick();
    search();

    }
    @Override
    protected void loadFXML(String fxmlPath) {

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Node node = null;
        try {
            node = loader.<Node>load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        pane_Product.getChildren().set(0,node);
    }

    private void setUpMenu(){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Tạo một CategoryCallable
        CategoryCallable categoryCallable = new CategoryCallable();

        // Thực thi categoryCallable trong luồng riêng
        Future<ArrayList<Category>> future = executor.submit(categoryCallable);
        try {
            // Lấy dữ liệu category từ cơ sở dữ liệu
            ArrayList<Category> categories = future.get();
            // Xử lý dữ liệu category để tạo cấu trúc menu nhiều cấp
            Map<Integer, Menu> menuMap = createCategoryMenuStructure(categories);
            // set sự kiện cho các menu và menuitem
            // Thêm các mục menu vào MenuButton
            for (Menu menu : menuMap.values()) {
                menu.setOnAction(e -> {
                    isSearch=true;
                    productList.clear();
                    for (Category category : categories) {
                        if (category.getName().equals(menu.getText())) {
                            productSearchList = category.getProductList();
                            break;
                        }
                    }
                    clearData();
                    showSearchDate(8,0);
                });

                // Lặp qua các MenuItem trong Menu
                for (MenuItem menuItem : menu.getItems()) {
                    // Đặt sự kiện cho MenuItem
                    menuItem.setOnAction(e -> {
                        isSearch=true;
                        productList.clear();
                        for (Category category : categories) {
                            if (category.getName().equals(menu.getText())) {
                                productSearchList = category.getProductList();
                                break;
                            }
                        }
                        clearData();
                        showSearchDate(8,0);
                    });
                }
                menu.getItems();
                mbCategory.getItems().add(menu);
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();



    }

    protected Map<Integer, Menu> createCategoryMenuStructure(ArrayList<Category> categories){
        Map<Integer, Menu> menuMap = new HashMap<>();
        // Tạo các MenuItem cho từng category

        for (Category category : categories) {
            MenuItem menuItem = new MenuItem(category.getName());
            menuItemMap.put(category.getId(), menuItem);
        }
        // Xác định các category con và cha
        for (Category category : categories) {
            Integer parentId = category.getParentId();
            MenuItem menuItem = menuItemMap.get(category.getId());

            if (parentId == null) {
                // Category là category cha (gốc)
                Menu menu = new Menu(category.getName());
                menu.getItems().add(menuItem);
                menuMap.put(category.getId(), menu);
            } else {
                // Category là category con
                MenuItem parentMenuItem = menuItemMap.get(parentId);
                if (parentMenuItem instanceof Menu) {
                    // Category cha đã được tạo trước đó
                    Menu parentMenu = (Menu) parentMenuItem;
                    parentMenu.getItems().add(menuItem);
                } else {
                    // Tạo menu cho category cha nếu chưa tồn tại
                    Menu menu = new Menu(category.getName());
                    menu.getItems().addAll(menuItem);
                    menuItemMap.put(category.getId(), menu);
                    menuMap.put(category.getId(), menu);
                }
            }
        }

        return menuMap;
    }

    @Override
    protected void showData(int limit, int offSet) {
        isSearch=false;
        numberData = new ProductDAO().getNumProuduct();
        ProductDAO pdao=new ProductDAO();
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));
        productList = pdao.selectALL1();
        if(offSet+8>=numberData)
            limit=numberData-offSet;
        int numberProduct=offSet+limit;
        for (int i=offSet, z=0;i<numberProduct;i++,z++){
                    AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(z+1));
                    ImageView productThumbnail =(ImageView) ap.lookup("#productThumbnail"+(z+1));
                    Label productQuantity =(Label) ap.lookup("#productQuantity"+(z+1));
                    Label productPrice =(Label)ap.lookup("#productPrice"+(z+1));
                    Label productName = (Label)ap.lookup("#productName"+(z+1));
                    String img  = productList.get(i).getThumbnailLink();
                    if(img!=null) {
                        Image image1 = new Image(String.valueOf(img));
                        productThumbnail.setImage(image1);

                    }
                    productName.setText(productList.get(i).getProductName());
                    ap.setUserData(productList.get(i).getProductId());
                    productQuantity.setText(String.valueOf(new ProductDAO().getQuantity((productList.get(i).getProductId()))));
                    productPrice.setText(String.valueOf(productList.get(i).getCostPrice()));
            }
    }
    public void search(){
        btn_search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                isSearch=true;
                productList.clear();
                if(choiceBox_sort.getValue().equals("Tìm theo tên"))
                    productSearchList = new ProductDAO().search(txt_search.getText(),"productname");
                else{
                    productSearchList = new ProductDAO().search(txt_search.getText(), "productSKU");
                }
                clearData();
                showSearchDate(8,0);
            }
        });
    }
    @Override
    protected void clearData() {
        for (int i=0;i<8;i++){
                AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(i+1));

                ImageView productThumbnail =(ImageView) ap.lookup("#productThumbnail"+(i+1));
                Label productQuantity =(Label) ap.lookup("#productQuantity"+(i+1));
                Label productPrice =(Label)ap.lookup("#productPrice"+(i+1));
                Label productName = (Label)ap.lookup("#productName"+(i+1));
                String img  = "D:/java/ManageGroceryStore/src/main/resources/Controller/image/empty.png";
                if(img!=null) {
                    Image image1 = new Image(String.valueOf(img));
                    productThumbnail.setImage(image1);

                }
                ap.setUserData(null);
                productName.setText("");
                productQuantity.setText("");
                productPrice.setText("");

        }
    }

    @Override
    protected void showSearchDate(int limit, int offSet) {
        pageNumber= (offSet+8)/8;
        lb_pageNumber.setText(String.valueOf(pageNumber));
        numberData = productSearchList.size();
        if(offSet+8>=numberData)
            limit=numberData-offSet;
        int numberProduct=offSet+limit;
        for (int i=offSet, z=0;i<numberProduct;i++,z++){
            AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(z+1));
            ImageView productThumbnail =(ImageView) ap.lookup("#productThumbnail"+(z+1));
            Label productQuantity =(Label) ap.lookup("#productQuantity"+(z+1));
            Label productPrice =(Label)ap.lookup("#productPrice"+(z+1));
            Label productName = (Label)ap.lookup("#productName"+(z+1));
            String img  = productSearchList.get(i).getThumbnailLink();
            if(img!=null) {
                Image image1 = new Image(String.valueOf(img));
                productThumbnail.setImage(image1);

            }
            productName.setText(productSearchList.get(i).getProductName());
            ap.setUserData(productSearchList.get(i).getProductId());
            productQuantity.setText(String.valueOf(new ProductDAO().getQuantity((productSearchList.get(i).getProductId()))));
            productPrice.setText(String.valueOf(productSearchList.get(i).getCostPrice()));
        }
    }

    protected void setRightLickAction(ContextMenu contextMenu, MenuItem delete,MenuItem detail){
        Menu addLots = new Menu("Add Lots" );
        ImageView iconaddLots = new ImageView(new Image(getClass().getResourceAsStream("image/add-product.png")));
        iconaddLots.setFitHeight(30);
        iconaddLots.setFitWidth(30);
        addLots.setGraphic(iconaddLots);
        addLots.setText("Add Lots");
        addLots.setStyle("-fx-font-size : 16px ; -fx-padding : 0px 0px 0px 50px;");
        contextMenu.getItems().add(1,addLots);

        MenuItem addNewLot = new MenuItem("Add New Lot");
        MenuItem addOldLot = new MenuItem("Add Old Lot");
        addNewLot.setStyle("-fx-font-size : 16px");
        addOldLot.setStyle("-fx-font-size : 16px");

        addLots.getItems().addAll(addNewLot,addOldLot);

        //set sự kiện cho menu cấp2
        addNewLot.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/addNewLot.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),422, 334);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Add New Lot");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });

        addOldLot.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/addOldLot.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),435, 205);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Add Old Lot");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });


        // Thiết lập sự kiện chuột phải cho productBox
        for (int i=0;i<8;i++){
            AnchorPane ap = (AnchorPane) pane_Product.lookup("#productBox"+(i+1));
            ap.setOnContextMenuRequested(event -> {
                AnchorPane btn= (AnchorPane) event.getSource();
                String id= String.valueOf(btn.getUserData());
                currentItemID = Integer.parseInt(id);
                contextMenu.show(ap, event.getScreenX(), event.getScreenY());
                event.consume(); // đánh dấu sự kiện này đã được xử lý
            });
        }
        //Định dạng contextMenu
        contextMenu.setStyle("-fx-pref-width: 180px; -fx-pref-height: 130px; -fx-padding : 7px 0px 0px 0px;");

        //xử lý sự kiện MenuItem Chuột phải
        delete.setOnAction(event -> {
            new ProductDAO().delete(currentItemID);
        });
        detail.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/detailProduct.fxml"));
            Stage stage = new Stage();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(),1000, 900);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Detail Product");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        });
    }
    protected void setUpMenuAdd(){
        // Lấy dữ liệu category từ cơ sở dữ liệu
        ResultSet rs = new CategoryDao().selectALL(0,0);
        ArrayList<Category> categories = new ArrayList<>();
        try {
            while (rs.next())
                categories.add(new Category(rs.getInt("categoryid"),rs.getString("Name"), rs.getInt("parent_id")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Xử lý dữ liệu category để tạo cấu trúc menu nhiều cấp
        Map<Integer, Menu> menuMap = createCategoryMenuStructure(categories);
        // set sự kiện cho các menu và menuitem
        // Thêm các mục menu vào MenuButton
        for (Menu menu : menuMap.values()) {
            menu.setOnAction(e -> {
                lb_Category.setText(menu.getText());
            });

            // Lặp qua các MenuItem trong Menu
            for (MenuItem menuItem : menu.getItems()) {
                // Đặt sự kiện cho MenuItem
                menuItem.setOnAction(e -> {
                    // Xử lý sự kiện khi MenuItem được chọn
                    lb_Category.setText(menuItem.getText());
                });
            }
            menu.getItems();
            mbCategory.getItems().add(menu);
        }


    }
}

