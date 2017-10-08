package serverside;


import util.WriterThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int SERVER_PORT = 13000;

    public static void main(String[] args) throws IOException {

        System.out.println("Инициализация сервера...");
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Сервер инициализирован. Ожидается подключение клиента...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Соединение с клиентом установлено, вы можете писать сообщения.");

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        Scanner scanner = new Scanner(inputStream);
        Scanner inputScanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(outputStream);

        ServerReadThread readThread = new ServerReadThread(scanner);
        WriterThread writeThread = new WriterThread(inputScanner, writer);
    }

    public static String readUserName() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
