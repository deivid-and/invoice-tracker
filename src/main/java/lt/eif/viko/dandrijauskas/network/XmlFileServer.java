package lt.eif.viko.dandrijauskas.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class XmlFileServer {
    public static void main(String[] args) {
        int port = 9001;
        String filePath = "src/main/resources/xml/invoices.xml";

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port + ", waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            sendFile(filePath, clientSocket.getOutputStream());

            clientSocket.close();
            System.out.println("File sent successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(String path, OutputStream output) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
             BufferedOutputStream bos = new BufferedOutputStream(output)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            bos.flush();
        }
    }
}
