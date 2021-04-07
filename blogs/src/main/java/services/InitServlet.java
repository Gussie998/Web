package services;

import dao.ArticleInfoDao;
import models.ArticleInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * User:DELL
 * Date:2021-04-06
 * Time:21:30
 */
@WebServlet("/init")
public class InitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";
        ArticleInfo articleInfo = null;

        int id=Integer.parseInt(request.getParameter("id"));

        if(id>0){
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                articleInfo = articleInfoDao.getArtById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            succ =1;
        } else {
            msg = "无效参数";
        }

        //3 、返回结果
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(response,result);

    }
}
