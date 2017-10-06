package clientside;


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

        System.out.println("Инициализация сервера");
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Сервер инициализирован. Ожадется подключение клиента...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Соединение с клиентом установлено");

        System.out.println("Введите ник и нажмите enter:");
        serverName = readUserName();

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        while (scanner.hasNext()) {
            String newMessage = scanner.nextLine();
            if (newMessage.trim().toLowerCase() == "exit") {
                clientSocket.close();
                serverSocket.close();
                break;
            }
            System.out.println(newMessage);
        }




    }

    public static String readUserName() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
