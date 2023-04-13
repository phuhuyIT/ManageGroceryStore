package DAO;

import java.util.ArrayList;

public interface DaoInterface <T>{
    public int insert(T t);
    public int delete(T t);
    public int update(T t);
    public ArrayList<T> selectALL (T t);
    public T selectByID(T t);

}
