package utils;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ReaderThread implements Runnable{

    Scanner inMessageScanner;

    public ReaderThread(Scanner inMessageScanner) {
        this.inMessageScanner = inMessageScanner;
        new Thread(this).start();
    }

    public void run() {
        while (inMessageScanner.hasNext()) {
            String incomingMessage = inMessageScanner.nextLine();
            System.out.println(Colors.ANSI_PURPLE + incomingMessage);
            try {
                TimeUnit.MICROSECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
