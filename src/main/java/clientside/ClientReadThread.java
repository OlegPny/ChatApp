package clientside;

import util.Colors;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ClientReadThread implements Runnable {

    private Scanner scanner;

    public ClientReadThread(Scanner scanner) {
        this.scanner = scanner;
        new Thread(this).start();
    }

    public void run() {
        while (scanner.hasNext()) {
            String serverInput = scanner.nextLine();
            System.out.println(Colors.ANSI_PURPLE + serverInput);
            try {
                TimeUnit.MICROSECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
