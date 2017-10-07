package serverside;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int SERVER_PORT = 13000;
    private static String serverName = "";

    public static void main(String[] args) throws IOException {

        System.out.println("Инициализация сервера...");
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Сервер инициализирован. Ожидатся подключение клиента...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Соединение с клиентом установлено, вы можете писать сообщения.");

//        System.out.println("Введите ник и нажмите enter:");
//        serverName = readUserName();

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        Scanner scanner = new Scanner(inputStream);
        Scanner userInput = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(outputStream);

        ServerReadThread readThread = new ServerReadThread(scanner);
        ServerWriteThread writeThread = new ServerWriteThread(writer, userInput);

    }

    public static String readUserName() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
