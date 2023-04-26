package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DaoInterface <T>{
    public void insert(T t);
    public int delete(String t) throws SQLException;
    public int update(T t);
    public ResultSet selectALL () ;
    public T selectByID(int ID);
    public int addFunction(T t);
}
