import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User:DELL
 * Date:2021-04-01
 * Time:19:16
 */
public class SetCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        cookie代码写入
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //创建cookie
        Cookie usernameCookie = new Cookie("username","java");
        //设置cookie的最大存活时间
        usernameCookie.setMaxAge(3600);//3600s
        response.addCookie(usernameCookie);

        //创建第二个cookie
        Cookie pwdCookie = new Cookie("pwd","word");
        pwdCookie.setMaxAge(-1);//永不过时
        response.addCookie(pwdCookie);


        PrintWriter writer = response.getWriter();
        writer.println("<h1>Cookie" +
                " 存储成功</h1>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
