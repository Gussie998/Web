package services;

import dao.UserInfoDao;
import models.UserInfo;
import utils.DBUtils;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * User:DELL
 * Date:2021-04-04
 * Time:15:07
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ=-1;
        String msg="";

        // 1得到参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if(username!=null && !username.equals("")
        && password !=null && !password.equals("")
        ){
            UserInfoDao userInfoDao = new UserInfoDao();
            try {
                UserInfo userInfo = userInfoDao.getUser(username,password);
                if(userInfo.getId()>0){
                    succ = 1;
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("userinfo",userInfo);

                } else {
                    succ = 0;
                    msg="用户名或密码出现错误";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else{
            msg="参数不完整，非法请求！";
        }

        //3 、返回结果
        HashMap<String,Object> result = new HashMap<>();
        result.put("succ",succ);
        result.put("msg",msg);
        ResultJSONUtils.write(response,result);

    }
}
