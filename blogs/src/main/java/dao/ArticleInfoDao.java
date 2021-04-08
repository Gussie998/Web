package dao;

import models.ArticleInfo;
import sun.security.pkcs11.Secmod;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User:DELL
 * Date:2021-04-04
 * Time:17:34
 */
public class ArticleInfoDao {

    //使用uid查找
    public List<ArticleInfo> getListByUID(int uid) throws SQLException {
        List<ArticleInfo> list = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        String sql = "select * from articleinfo where uid=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, uid);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setId(resultSet.getInt("id"));
            articleInfo.setRcount(resultSet.getInt("rcount"));
            articleInfo.setTitle(resultSet.getString("title"));
            articleInfo.setContent(resultSet.getString("Content"));
            articleInfo.setCreatetime(resultSet.getDate("createtime"));
            list.add(articleInfo);
        }
        //数据库的关闭
        DBUtils.close(connection,statement,resultSet);
        return list;
    }


    //使用id删除文章
    public int del(int id) throws SQLException {
        int result=0;
        if(id>0){
            Connection connection = DBUtils.getConnection();
            String sql = "delete from articleinfo where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            result = statement.executeUpdate();
            DBUtils.close(connection,statement,null);
        }
        return result;
    }

    //通过文章id获取文章内容
    public ArticleInfo getArtById(int id) throws SQLException {
        ArticleInfo articleInfo = new ArticleInfo();
        if(id>0){
            Connection connection = DBUtils.getConnection();
            String sql = "select * from articleinfo where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                articleInfo.setId(resultSet.getInt("id"));
                articleInfo.setTitle(resultSet.getString("title"));
                articleInfo.setContent(resultSet.getString("content"));
            }
            DBUtils.close(connection,statement,resultSet);
        }

        return articleInfo;
    }


    //修改文章
    public int upArt(int id, String title, String content) throws SQLException {
        int result =0;
        Connection connection = DBUtils.getConnection();
        String sql = "update articleinfo set title=?,content=? where id  =?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,content);
        statement.setInt(3,id);
        result=statement.executeUpdate();
        DBUtils.close(connection,statement,null);

        return result;

    }

    //增加文章
    public int addArt(String title, String content, int uid) throws SQLException {
        int result = 0;
        Connection connection = DBUtils.getConnection();
        String sql = "insert into articleinfo(title,content,uid) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,content);
        statement.setInt(3,uid);
        result=statement.executeUpdate();
        DBUtils.close(connection,statement,null);
        return result;
    }
}
