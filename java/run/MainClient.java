package run;

import java.io.IOException;
import java.net.Socket;

import console.BookNotFoundException;
import console.ConsoleClient;
import console.FailedConnectionException;
import entity.Book;

public class MainClient {

    public static void main(String[] args) {

        ConsoleClient client = new ConsoleClient();

        try {

            Socket socket = client.connect("localhost", 9595);

            Book book = client.getBook();
            System.out.println(book.toString());

        } catch (FailedConnectionException e) {
            System.out.println("Sorry you can't connect");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
    }
}
