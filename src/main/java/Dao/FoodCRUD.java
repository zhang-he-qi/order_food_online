package Dao;

import entity.Food;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 啦啦啦
 */
public class FoodCRUD {

    QueryRunner query = new QueryRunner(JdbcUtils.lookup(),true);

    public List<Food> query_foods() {
        try (Connection conn = JdbcUtils.getConnection()) {
            String sql = "select * from foodinfo";
            return query.query(conn, sql, new BeanListHandler<>(Food.class));
        } catch (SQLException e) {
            System.err.println("查询菜单失败！" + e.getMessage());
        }
        return null;
    }

    public Food querybyid(int id){

        try (Connection conn = JdbcUtils.getConnection()){
            String sql = "select * from foodinfo where foodId ="+id;
            return query.query(conn, sql, new BeanHandler<>(Food.class));
        } catch (SQLException e) {
            System.err.println("按编号查询失败！"+e.getMessage());
        }
        return null;
    }

    public List<Food> queryby() throws SQLException {

       return this.query.query("select * from userinfo", new BeanListHandler<>(Food.class));
    }
   /* public static void main(String[] args) {
        Food foods = new FoodCRUD().querybyid(2);
        System.out.println(foods.toString());
    }*/
}
