package services;

import dao.ArticleInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * User:DELL
 * Date:2021-04-07
 * Time:11:32
 */
@WebServlet("/addart")
public class AddArtServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if(title!=null && content!=null &&!title.equals("") && !content.equals("")){
            HttpSession session = request.getSession(false);


            if (session != null && session.getAttribute("userinfo") != null) {
                UserInfo userInfo = (UserInfo) session.getAttribute("userinfo");
                ArticleInfoDao articleInfoDao = new ArticleInfoDao();

                try {
                    succ = articleInfoDao.addArt(title, content, userInfo.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                msg="非登录状态！";
            }

        } else {
            msg="错误参数";
        }

        //3 、返回结果
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(response,result);

    }
}
