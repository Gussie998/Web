package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * User:DELL
 * Date:2021-04-13
 * Time:20:52
 */
public class UDPServer {
    //数据包大小
    private static final int bleng =1024;

    //使用1024之后的端口号，端口才不会被占用
    private  static final int port=9001;



    public static void main(String[] args) throws IOException {
        //UDP服务器端（IP 端口号）
        DatagramSocket socket = new DatagramSocket(port);
        while (true){

            //数据包
            DatagramPacket clientPacket = new DatagramPacket(
              new byte[bleng],
              bleng
            );

            //等待客户端的链接
            socket.receive(clientPacket);

            //客户端连接后拿到信息
            String msg =new String(clientPacket.getData()) ;
            System.out.println("客户端信息："+msg);

            //非必须的反馈步骤：响应
            String serMsg = msg.replace("吗","。");
            DatagramPacket serPacket =new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length,//注意是字节长度
                    clientPacket.getAddress(),
                    clientPacket.getPort()
            );
            socket.send(serPacket);


        }
    }
}
