import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        String serverAddress = "localhost";
        int port = 5000;

        try {

            // Connect to server
            Socket socket =
                    new Socket(serverAddress, port);

            System.out.println("================================");
            System.out.println("         TCP ECHO CLIENT");
            System.out.println("================================");

            System.out.println(
                    "Connected to echo server.");

            // Input from server
            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            // Output to server
            PrintWriter output =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            Scanner scanner =
                    new Scanner(System.in);

            while (true) {

                System.out.print(
                        "Enter message: ");

                String message =
                        scanner.nextLine();

                // Send message to server
                output.println(message);

                // Receive echoed message
                String response =
                        input.readLine();

                System.out.println(
                        "Echo from server: " + response);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Close connection
            socket.close();
            scanner.close();

            System.out.println(
                    "Connection closed.");

        } catch (IOException e) {

            System.out.println(
                    "Client Error: " + e.getMessage());
        }
    }
}