package serverside;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ServerWriteThread implements Runnable {

    PrintWriter writer;
    Scanner scanner;

    public ServerWriteThread(PrintWriter writer, Scanner scanner) {
        this.writer = writer;
        this.scanner = scanner;
        new Thread(this).start();
    }

    public void run() {
        while (scanner.hasNext()) {
            String serverOutput = scanner.nextLine();
            System.out.println(String.format("Вы: %s", serverOutput));
            writer.println(String.format("Вы: %s", serverOutput));
            try {
                TimeUnit.MICROSECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
