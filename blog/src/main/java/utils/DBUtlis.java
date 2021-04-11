package utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User:DELL
 * Date:2021-04-08
 * Time:15:38
 */
public class DBUtlis {

    private static MysqlDataSource dataSource=null;


    public static Connection getConnection() throws SQLException {
        if(dataSource==null){
            dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://127.0.0.1:3306/java18blog?charactionEncoding=utf-8&useSSL=true");
            dataSource.setUser("root");
            // [设置你自己的密码]
            dataSource.setPassword("111111");
        }

        return dataSource.getConnection();

    }

    /**
     * 关闭连接
     * @param connection
     * @param statement
     * @param resultSet
     * @throws SQLException
     */

    public static void close(Connection connection,
                             PreparedStatement statement,
                             ResultSet resultSet) throws SQLException {
        if(connection!=null) connection.close();
        if(statement!=null) statement.close();
        if(resultSet!=null) resultSet.close();


    }

}
