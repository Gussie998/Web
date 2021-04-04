import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User:DELL
 * Date:2021-04-04
 * Time:9:40
 */
public class MyCalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        int state = -1;
        String msg = " ";
        int sum = 0;

        String num1=request.getParameter("num1");
        String num2=request.getParameter("num2");
        //非空校验
        if(num1!=null && num2!=null && !num1.equals("") && !num2.equals("")){
            sum = Integer.parseInt(num1)+Integer.parseInt(num2);
            state =200;
        } else {
            msg="参数不全，非法请求";
        }

        //返回结果
        // {"state":%d,"msg":"%s","sum":%d}
        PrintWriter writer = response.getWriter();
        writer.println(String.format("{\"state\":%d,\"msg\":\"%s\",\"sum\":%d}",
                state,msg,sum));

    }
}
