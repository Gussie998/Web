package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * User:DELL
 * Date:2021-04-04
 * Time:15:10
 */
public class ResultJSONUtils {
    /**
     * 给前端输出json数据
     */
    public static void write(HttpServletResponse response, HashMap<String,Object> data) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.println(mapper.writeValueAsString(data));




    }
}
