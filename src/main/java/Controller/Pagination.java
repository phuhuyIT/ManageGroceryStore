package Controller;

import Model.InventoryAlert;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class Pagination {
    protected int Limit;
    protected int offSet;
    protected abstract void showData(int limit, int offSet);
    protected abstract void clearData();
    @FXML
    private Button btn_refresh;
    @FXML
    private Button btn_previousPage;
    @FXML
    private Button btn_nextPage;
    protected int numberData;
    protected void setActionForBtn(){
        btn_previousPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(offSet<=0){
                    InventoryAlert.errorAlert("Error","This is the first page");
                }
                else{
                    offSet-=8;
                    Limit-=8;
                    clearData();
                    showData(Limit,offSet);
                }
            }
        });
        btn_nextPage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                offSet+=8;
                Limit+=8;
                if(offSet>numberData){
                    InventoryAlert.errorAlert("Error","This is the last page");
                }else {
                    clearData();
                    showData(Limit,offSet);
                }

            }
        });
        btn_refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                offSet=0;
                Limit=8;
                clearData();
                showData(Limit,offSet);
            }
        });
    }
}
