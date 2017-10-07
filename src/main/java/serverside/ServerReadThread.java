package serverside;

import util.Colors;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ServerReadThread implements Runnable {

    private Scanner scanner;

    public ServerReadThread(Scanner scanner) {
        this.scanner = scanner;
        new Thread(this).start();
    }

    public void run() {
        while (scanner.hasNext()) {
            String clientInput = scanner.nextLine();
            System.out.println(Colors.ANSI_PURPLE + clientInput);
            try {
                TimeUnit.MICROSECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
