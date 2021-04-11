package services;

import dao.ArticleInfoDao;
import dao.UserInfoDao;
import utils.DBUtlis;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * User:DELL
 * Date:2021-04-08
 * Time:16:05
 */
@WebServlet("/reg")
public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1;
        String msg = "";

        //1、从前端获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //非空校验
        if(!username.equals("") && username!=null &&password!=null && !password.equals("")){
            //2、业务逻辑
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                succ =userInfoDao.regUser(username,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            msg="参数错误！";
        }


        //3、返回结果
        HashMap<String, Object> result = new HashMap<>();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(resp, result);
    }
}
