import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User:DELL
 * Date:2021-04-01
 * Time:20:10
 */
public class MySessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //验权
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        PrintWriter writer = response.getWriter();
        if(name!=null && pwd!=null &&name.equals("root")&&pwd.equals("root")){
            //true 尝试从客户端获取session信息，如果获取不到则创建一个session信息
            //false 尝试从客户端获取session信息，如果获取不到则不会创建新的session信息
            HttpSession session = request.getSession(true);

            String sessionId=session.getId();
            writer.println("welcome");
            writer.println(String.format("sessionId:%s",sessionId));

            String countKey = "countkey";
            if(session.isNew()|| session.getAttribute(countKey)==null){
                //存储
                session.setAttribute(countKey,1);
                writer.println("count:1");
            } else {
                //拿到当前数据
                int count = (int)session.getAttribute(countKey);
                //更新
                count++;
                session.setAttribute(countKey,count);
                writer.println(String.format("count:%d",count));
            }

        }else {
            writer.println("error");
        }
    }
}
