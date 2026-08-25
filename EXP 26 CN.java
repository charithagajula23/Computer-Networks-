import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        String serverAddress = "localhost";
        int port = 5000;

        try {

            System.out.println("================================");
            System.out.println("       DATE TIME CLIENT");
            System.out.println("================================");

            System.out.println("Connecting to server...");

            // Connect to server
            Socket socket =
                    new Socket(serverAddress, port);

            System.out.println("Connected to server!");

            // Receive data from server
            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            String dateTime = input.readLine();

            // Display date and time
            System.out.println();
            System.out.println("Date and Time received from server:");
            System.out.println("--------------------------------");
            System.out.println(dateTime);
            System.out.println("--------------------------------");

            // Close connection
            socket.close();

            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}