package services;

import dao.ArticleInfoDao;
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
 * Date:2021-04-07
 * Time:10:32
 */

@WebServlet("/upart")
public class UpArtServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";

        int id = Integer.parseInt(request.getParameter("id")) ;
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if(id>0 && title!=null && content!=null
        && !title.equals("") && !content.equals("")
        ){
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();
            try {
                succ=articleInfoDao.upArt(id,title,content);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            msg="无效参数！";
        }




        //3 、返回结果
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(response,result);

    }
}