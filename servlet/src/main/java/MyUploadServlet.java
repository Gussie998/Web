import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * User:DELL
 * Date:2021-04-01
 * Time:20:42
 */

@MultipartConfig
public class MyUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        UUID uuid = UUID.randomUUID();

        Part part = request.getPart("myfile");
        //用来保存图片的地址以及重命名
        part.write(String.format("D:\\%s%s",uuid,part.getSubmittedFileName()));
        //part.write("C:\\Users\\DELL\\Desktop\\照片\\2亿.png");
        //三个注意事项：1，不要在c盘 2，不要有汉字 3，不要重复
        PrintWriter writer = response.getWriter();
        writer.println("上传成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
