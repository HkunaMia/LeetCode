package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ：mzr
 * @date ：Created in 2020/5/11 15:02
 * @description：
 * @modified By：
 */

public class MyThread extends Thread{

    private Socket socket;

    public MyThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
//            输出流
            OutputStream os = socket.getOutputStream();
//            输入流
            InputStream is = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            ch = is.read(buff);
            String conrent = new String(buff,0,ch);
            System.out.println(conrent);
            os.write(String.valueOf(conrent.length()).getBytes());

            is.close();
            os.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
