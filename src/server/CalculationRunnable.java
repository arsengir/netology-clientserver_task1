package server;

import java.io.*;
import java.net.Socket;

public class CalculationRunnable implements Runnable{

    private final Socket socket;

    public CalculationRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            String line;
            while((line = in.readLine()) != null){
                try {
                    out.println(Fibonacci.calculation(Integer.parseInt(line)));
                } catch (NumberFormatException e) {
                    out.println("Ошибка ввода. Повторите действие еще раз.");
                    e.printStackTrace(System.out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
