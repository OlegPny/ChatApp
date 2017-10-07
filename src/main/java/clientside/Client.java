package clientside;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final static int SERVER_PORT = 13000;
    private final static String SERVER_IP = "localhost";

    public static void main(String[] args) throws IOException {

        System.out.println("Попытка подключения к серверу");
        Socket socket = new Socket();

       socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(inputStream);
        Scanner inputScanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(outputStream);

        ClientReadThread readThread = new ClientReadThread(scanner);

//        label1:
//        while (true) {
//            String usrInput = inputScanner.nextLine();
//            if (usrInput.trim().toLowerCase().equals("exit")) {
//                writer.println(usrInput);
//                writer.flush();
//                socket.close();
//                break label1;
//            }
//            writer.println(usrInput);
//            writer.flush();
//        }
//        System.out.println("Чат закрыт");
    }
}
