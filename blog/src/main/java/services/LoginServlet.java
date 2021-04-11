package services;

import dao.UserInfoDao;
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
 * Date:2021-04-09
 * Time:10:21
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ=-1;
        String msg="";

        //1、从前端获取数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //非空校验
        if(username!=null && !username.equals("") && password!=null &&!password.equals("")){
            //2、业务逻辑
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                UserInfo userInfo = userInfoDao.getUser(username,password);
                if(userInfo.getId()>0){
                    succ =1;
                    HttpSession session = req.getSession();
                    session.setAttribute("userinfo",userInfo);

                }else {
                    msg="用户名或密码错误";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            msg="参数不完整！";

        }





        //3、返回结果
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(resp,result);
    }
}
