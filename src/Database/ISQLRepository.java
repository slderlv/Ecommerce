package Database;

import java.sql.ResultSet;

public interface ISQLRepository {
    public void create();
    public ResultSet read();
    public void update();
    public void delete();
}
