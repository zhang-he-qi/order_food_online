package Dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author 啦啦啦
 */
public class JdbcUtils {
    public static final String DRIVER = getValue("jdbc.driver");
    public static final String URL = getValue("jdbc.url");
    public static final String USERNAME = getValue("jdbc.username");
    public static final String PASSWORD = getValue("jdbc.password");

    //加载数据库驱动类，在系统运行时只需加载一次
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.printf("未找到相关驱动" + e.getMessage());
        }
    }

    //获得数据库连接
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.out.printf("数据库连接失败！-->" + e.getMessage());
        }
        return con;
    }

    public static DataSource lookup() {
        try {
            javax.naming.Context context = new InitialContext();
            return (DataSource) context.lookup("java:comp/env/jdbc/scoot");
        } catch (NamingException e) {
            System.err.println("数据源查询失败！" + e.getMessage());
        }
        return null;
    }

    public static String getValue(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("resouces");
        return bundle.getString(key);
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.out.println(con);

    }
}
