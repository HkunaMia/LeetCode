package socket;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/11 14:49
 * @description：tcp连接socket
 * @modified By：
 */

public class TCPServer {

    public static void main(String[] args) throws IOException {
//        创建socket并绑定监听端口
        ServerSocket sc = new ServerSocket(65000);
        while (true){
//            接收来自客户端的请求
            Socket socket = sc.accept();
            new MyThread(socket).start();
        }

    }

}
