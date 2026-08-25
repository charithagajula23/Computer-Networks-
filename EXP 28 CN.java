import java.net.InetAddress;
import java.util.Scanner;

public class DNSClient {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("        DNS CLIENT");
        System.out.println("=================================");

        System.out.print("Enter hostname: ");

        String hostname = scanner.nextLine();

        try {

            System.out.println();
            System.out.println("Contacting DNS server...");
            System.out.println("Resolving: " + hostname);

            // Resolve hostname to IP address
            InetAddress address =
                    InetAddress.getByName(hostname);

            System.out.println();
            System.out.println("DNS Resolution Successful!");
            System.out.println("---------------------------------");
            System.out.println("Hostname : " + hostname);
            System.out.println("IP Address : " + address.getHostAddress());
            System.out.println("---------------------------------");

        } catch (Exception e) {

            System.out.println();
            System.out.println("DNS Resolution Failed!");
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}