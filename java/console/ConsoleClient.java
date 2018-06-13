package console;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import entity.Book;

public class ConsoleClient {

    private int id;
    private Socket socket;

    public Socket connect(String host, int port) throws FailedConnectionException {
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            throw new FailedConnectionException("Cannot connect", e);
        }
        return socket;
    }

    public void passingIdToServer () throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter an id: ");
        id = scanner.nextInt();

        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println(id);
    }

    public String receiveResponse() throws IOException {
        Scanner scannerGetData = new Scanner(socket.getInputStream());

        String data = scannerGetData.nextLine();

        return data;
    }

    public Book getBook() throws IOException, BookNotFoundException {


        passingIdToServer();

        String data = receiveResponse();

        if (data.equals("null")) {
            System.out.println("We're really sorry, the book was not found");
            throw new BookNotFoundException("Book was not found");
        }

        String[] dataArray = data.split(",");
        Book book = new Book(Integer.parseInt(dataArray[0]), dataArray[1]);

        return book;
    }
}
