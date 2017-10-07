package clientside;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ClientWriteThread implements Runnable {

    PrintWriter writer;
    Scanner scanner;

    public ClientWriteThread(PrintWriter writer, Scanner scanner) {
        this.writer = writer;
        this.scanner = scanner;
        new Thread(this).start();
    }

    public void run() {
        while (scanner.hasNext()) {
            String clientOutput = scanner.nextLine();
            System.out.println(String.format("Вы: %s", clientOutput));
            writer.println(String.format(clientOutput));
            writer.flush();
            try {
                TimeUnit.MICROSECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
