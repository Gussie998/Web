package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * User:DELL
 * Date:2021-04-15
 * Time:19:53
 */
public class TCPClient {
    private static final String ip="127.0.0.1";
    //private static final int port = 9002;
    private static final int port = 9003;


    public static void main(String[] args) throws IOException {
       //创建客户端
        Socket socket = new Socket(ip,port);

        try (
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            Scanner scanner = new Scanner(System.in);
        ){
            while (true){
                System.out.print("-->");
                //构建消息：
                String msg = scanner.nextLine();
                writer.write(msg+"\n");
                writer.flush();

                //接受服务器端的消息
                String serMsg = reader.readLine();
                if(serMsg!=null && !serMsg.equals("")){
                    System.out.println("服务器端的消息："+serMsg);
                }
            }

        }

    }
}
