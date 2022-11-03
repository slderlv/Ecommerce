package Database;
import java.sql.ResultSet;

public interface ISQLRead <T>{
	ResultSet read (T t);
}
