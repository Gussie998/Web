package dao;

import models.UserInfo;
import utils.DBUtlis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User:DELL
 * Date:2021-04-08
 * Time:15:31
 */
public class UserInfoDao {
    public static int regUser(String username, String password) throws SQLException {
        int result = 0;
        Connection connection = DBUtlis.getConnection();
        String sql = "insert into userinfo(username,password) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        result = statement.executeUpdate();
        return result;
    }

    public UserInfo getUser(String username, String password) throws SQLException {
        UserInfo userInfo = new UserInfo();
        Connection connection = DBUtlis.getConnection();
        String sql = "select * from userinfo where username = ? and password=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            userInfo.setId(resultSet.getInt("id"));
            userInfo.setUsername(resultSet.getString("username"));
            userInfo.setPassword(resultSet.getString("password"));
        }
        DBUtlis.close(connection,statement,resultSet);

        return userInfo;
    }
}
