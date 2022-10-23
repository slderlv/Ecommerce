package Database;

import java.sql.ResultSet;

public interface ISQLGenericRepository <T>{
    public void create(T t);
    public ResultSet read(T t);
    public void update(T t);
    public void delete(T t);
}
