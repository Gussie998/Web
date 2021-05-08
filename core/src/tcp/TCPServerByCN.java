package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * User:DELL
 * Date:2021-04-15
 * Time:20:42
 */
public class TCPServerByCN {
    private  static final int port=9003;

    static HashMap<String,String> dirMap = new HashMap<>();
    static {
        dirMap.put("hello","你好");
    }


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("已启动服务器端");

        Socket socket = serverSocket.accept();
        System.out.println(String.format("IP:%s,PORT:%d",
                socket.getInetAddress().getHostAddress(),
                socket.getPort()));

        try (
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            )
        ){
            String en = reader.readLine();
            while (en!=null && !en.equals("")){
                //翻译成中文
                String cn=processData(en);
                writer.write(cn+"\n");
                writer.flush();
            }
        }


    }

    //实现方法
    //todo:英译汉
    private static String processData(String en) {
        String cn = "待翻译";

        return cn;
    }

    private static String processData2(String en) {
        String cn = null;
        //todo:爬虫，将数据入库

        return cn;
    }
}
