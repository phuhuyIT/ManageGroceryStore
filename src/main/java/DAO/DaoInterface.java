package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DaoInterface <T>{
    public void insert(T t);
    public int delete(T t) throws SQLException;
    public int update(T t);
    public ArrayList<T> selectALL () ;
    public T selectByID(int ID);
    public int addFunction(T t);
}
