package lt.eif.viko.dandrijauskas.network;

import java.io.*;
import java.net.Socket;

public class XmlFileClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 9001;

        File dir = new File("received_files");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        try (Socket socket = new Socket(serverAddress, port);
             InputStream input = socket.getInputStream();
             FileOutputStream fileOut = new FileOutputStream("received_files/received_invoices.xml")) {

            System.out.println("Connected to server, receiving file...");

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                fileOut.write(buffer, 0, bytesRead);
            }

            System.out.println("File received and saved as 'received_invoices.xml'.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
