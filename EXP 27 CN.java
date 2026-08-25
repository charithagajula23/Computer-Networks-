import java.net.*;
import java.util.Scanner;

public class DNSClient {

    public static void main(String[] args) {

        String serverAddress = "localhost";
        int serverPort = 5000;

        try {

            // Create UDP socket
            DatagramSocket clientSocket =
                    new DatagramSocket();

            Scanner scanner = new Scanner(System.in);

            System.out.println("================================");
            System.out.println("         DNS UDP CLIENT");
            System.out.println("================================");

            System.out.print(
                    "Enter domain name: ");

            String domainName =
                    scanner.nextLine();

            // Convert domain name into bytes
            byte[] sendBuffer =
                    domainName.getBytes();

            InetAddress serverIP =
                    InetAddress.getByName(serverAddress);

            // Create request packet
            DatagramPacket sendPacket =
                    new DatagramPacket(
                            sendBuffer,
                            sendBuffer.length,
                            serverIP,
                            serverPort);

            // Send request
            clientSocket.send(sendPacket);

            System.out.println(
                    "DNS request sent to server.");

            // Receive server response
            byte[] receiveBuffer =
                    new byte[1024];

            DatagramPacket receivePacket =
                    new DatagramPacket(
                            receiveBuffer,
                            receiveBuffer.length);

            clientSocket.receive(receivePacket);

            String ipAddress =
                    new String(
                            receivePacket.getData(),
                            0,
                            receivePacket.getLength());

            System.out.println();
            System.out.println(
                    "DNS Response received:");
            System.out.println(
                    "Domain: " + domainName);
            System.out.println(
                    "IP Address: " + ipAddress);

            // Close socket
            clientSocket.close();
            scanner.close();

        } catch (Exception e) {

            System.out.println(
                    "Client Error: " + e.getMessage());
        }
    }
}