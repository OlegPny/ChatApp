package util;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WriterThread implements Runnable {

    Scanner inputScanner;
    PrintWriter writer;

    public WriterThread(Scanner inputScanner, PrintWriter writer) {
        this.inputScanner = inputScanner;
        this.writer = writer;
        new Thread(this).start();
    }

    public void run() {
        while (inputScanner.hasNext()) {
            String serverOutput = inputScanner.nextLine();
            writer.println(serverOutput);
            writer.flush();
            try {
                TimeUnit.MICROSECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
