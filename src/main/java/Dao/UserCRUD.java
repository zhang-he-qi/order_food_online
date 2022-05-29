package Dao;

import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCRUD {

    QueryRunner queryRunner = new QueryRunner();

    /**
     * 查询所有顾客
     *
     * @param user
     * @return
     */
    public User queryUser(User user) {

        try (Connection conn = JdbcUtils.getConnection()) {
            return queryRunner.query(conn, "select * from userinfo where loginName= '" + user.getUsername() + "' and loginPass= '" + user.getPassword() + "'", new BeanHandler<>(User.class));
        } catch (SQLException e) {
            System.err.println("查询用户失败!" + e.getMessage());
        }
        return null;
    }

    /**
     * 添加顾客
     *
     * @param user
     * @return
     */
    public boolean addUser(User user) {
        //获取数据用于判断数据库中是否存在此用户
        User user1 = queryUser(user);

        //用户不存在则添加用户导数据库,存在则返回false
        if (user1 == null) {
            try (Connection conn = JdbcUtils.getConnection()) {
                String sql = "insert into userInfo (loginName,loginPass) values ('" + user.getUsername() + "','" + user.getPassword() + "')";
                PreparedStatement ps = conn.prepareStatement(sql);
                int update = ps.executeUpdate();
                if (update == 1) {
                    return true;
                }
            } catch (SQLException e) {
                System.err.println("添加用户失败！" + e.getMessage());
            }
        }
        return false;
    }
}
