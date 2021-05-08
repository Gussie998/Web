package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * User:DELL
 * Date:2021-04-18
 * Time:15:42
 */
public class TCPClientError {
    private static final String ip="127.0.0.1";

    private static final int port = 9005;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ip,port);

        String msg= "hello,java";
        try (OutputStream outputStream = socket.getOutputStream()){
            for (int i = 0; i <10 ; i++) {
                //发送消息给服务器端
                outputStream.write(msg.getBytes());
                outputStream.flush();
            }
        }


    }
}
