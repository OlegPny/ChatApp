package serverside;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ServerReadThread implements Runnable {

    private Scanner scanner;
    private PrintWriter printWriter;

    public ServerReadThread(Scanner scanner, PrintWriter printWriter) {
        this.scanner = scanner;
        this.printWriter = printWriter;
    }

    public void run() {
        while (scanner.hasNext()) {
            String clientInput = scanner.nextLine();
            System.out.print(clientInput);
            try {
                TimeUnit.MICROSECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
