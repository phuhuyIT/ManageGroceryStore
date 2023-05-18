package callable;

import DAO.CategoryDao;
import Model.Category;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class CategoryCallable implements Callable<ArrayList<Category>> {
    @Override
    public ArrayList<Category> call() throws Exception {
        // Gọi phương thức selectALL1() của CategoryDao và trả về danh sách danh mục
        return new CategoryDao().selectALL1();
    }
}
