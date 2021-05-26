package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 23444;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)){

            String line;
            System.out.println("Вычисление N-го члена ряда Фибоначчи");

            while (true){
                System.out.println("Введите номер для расчета, или 'end' для завершения:");
                line = scanner.nextLine();
                if ("end".equals(line)){
                    break;
                }
                out.println(line);
                String answer = in.readLine();
                if (answer.contains("Ошибка")){
                    System.out.println(answer);
                } else {
                    System.out.printf("%s член ряда Фибоначчи равен: %s \n", line, answer);
                }
            }
        }

    }
}
