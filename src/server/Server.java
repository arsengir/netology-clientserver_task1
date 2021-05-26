package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 23444;
    private static final int COUNT_THREADS = 4;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        final ExecutorService threadPool = Executors.newFixedThreadPool(COUNT_THREADS);

        while (true) {
            Socket socket = serverSocket.accept();
            threadPool.submit(new CalculationRunnable(socket));
        }
    }
}
