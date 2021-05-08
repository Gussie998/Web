package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * User:DELL
 * Date:2021-04-13
 * Time:21:07
 */
public class UDPClient {
    //定义服务器IP
    private static  final  String ip ="121.4.129.17";
//    private static  final  String ip ="127.0.0.1";

    private  static final int port = 9001;

    private static final int bleng =1024;

    public static void main(String[] args) throws IOException {
        //由系统自动分配动态端口号，服务器才需要固定端口号
        //启动客户端
        DatagramSocket client = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("你：");
            String msg = scanner.nextLine();

            // 2.给服务器端发送消息
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(datagramPacket);

            //3接受返回信息
            DatagramPacket serPacket = new DatagramPacket(
                    new  byte[bleng],
                    bleng
            );
            client.receive(serPacket);

            String serMsg = new String(serPacket.getData());
            System.out.println("傻瓜机器人："+serMsg);
        }
    }
}
