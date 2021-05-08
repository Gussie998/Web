package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User:DELL
 * Date:2021-04-15
 * Time:19:30
 */
public class TCPServer {
    private static final int port = 9002;

    public static void main(String[] args) throws IOException {
        //启动服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动！");
        Socket clientSocket= serverSocket.accept();
        //已有客户端连接
        System.out.println(String.format("IP:%s,PORT:%d",
                clientSocket.getInetAddress().getHostAddress(),
                clientSocket.getPort()));

        //优化，执行完自动回收
        try (
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream())
            );

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            )
        ){
            while (true){
                //收
                String msg= reader.readLine();
                if(msg!=null && !msg.equals("")){
                    System.out.println("客户端端的消息："+msg);
                    //反馈
                    String serMsg="I GOT IT!";
                    writer.write(serMsg+"\n");
                    writer.flush();
                }

            }





        }
//        //收发消息
//        BufferedReader reader=null;
//        try {
//            reader = new BufferedReader(
//                    new InputStreamReader(clientSocket.getInputStream())
//            );
//            String msg= reader.readLine();
//            System.out.println("MSG:"+msg);
//        }finally {
//            if(reader!=null){
//                reader.close();
//            }
//        }
//        //反馈
//        BufferedWriter writer =null;
//        try {
//            writer= new BufferedWriter(
//                    new OutputStreamWriter(clientSocket.getOutputStream())
//            );
//            String serMsg="I GOT IT!";
//            writer.write(serMsg+"/n");
//            writer.flush();
//        }finally {
//            if(writer!=null){
//                writer.close();
//            }
//        }




    }
}
