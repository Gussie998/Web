package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User:DELL
 * Date:2021-04-18
 * Time:15:38
 */
public class TCPServerError {
    private static final int port = 9005;
    private static final int bleng = 1024;

    public static void main(String[] args) throws IOException {
        //启动服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动！");
        Socket socket = serverSocket.accept();
        //已有客户端连接
        System.out.println(String.format("IP:%s,PORT:%d",
                socket.getInetAddress().getHostAddress(),
                socket.getPort()));

        try(InputStream inputStream = socket.getInputStream()){
            while (true){
                byte[] bytes = new byte[bleng];
                int res=inputStream.read(bytes,0,bleng);
                if(res>0){
                    String msg = new String(bytes);
                    System.out.println("got:"+msg);
                }
                //数据流没有边界，容易沾包将缓冲区数据一次读完
                //解决问题方案：1.以\n作为数据流的边界
                // inputStreamReader =>reader.readLine();
                //服务器已启动！
                //IP:127.0.0.1,PORT:58873
                //got:hello,javahello,javahello,javahello,javahello,javahello,javahello,javahello,javahello,javahello,java
                ////解决问题方案：2.发送固定大小的数据流信息
                //规定每个流的大小就是1024-》byte[] bytes = new byte[1024];
                //



            }
        }


    }
}
