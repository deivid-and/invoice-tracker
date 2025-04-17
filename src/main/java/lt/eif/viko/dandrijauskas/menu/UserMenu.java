package lt.eif.viko.dandrijauskas.menu;

import lt.eif.viko.dandrijauskas.model.*;
import lt.eif.viko.dandrijauskas.network.XmlFileClient;
import lt.eif.viko.dandrijauskas.network.XmlFileServer;
import lt.eif.viko.dandrijauskas.service.ReceivedFileProcessor;
import lt.eif.viko.dandrijauskas.service.XMLTransformer;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class UserMenu {

    private final ClientList clientList;
    private final XMLTransformer transformer;

    public UserMenu() {
        this.clientList = new ClientList();
        this.transformer = new XMLTransformer();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                   ___                 _            _____               _             
                  |_ _|_ ____   _____ (_) ___ ___  |_   _| __ __ _  ___| | _____ _ __ 
                   | || '_ \\ \\ / / _ \\| |/ __/ _ \\   | || '__/ _` |/ __| |/ / _ \\ '__|
                   | || | | \\ V / (_) | | (_|  __/   | || | | (_| | (__|   <  __/ |   
                  |___|_| |_|\\_/ \\___/|_|\\___\\___|   |_||_|  \\__,_|\\___|_|\\_\\___|_|   

                    1. Load clients from XML
                    2. Add new client
                    3. Add invoice to existing client
                    4. View all clients
                    5. View all invoices 
                    6. Save to XML
                    7. Start XML File Server
                    8. Start XML File Client
                    9. Process Received File
                    0. Exit
            """);

            switch (scanner.nextLine()) {
                case "1" -> loadClientsFromXML();
                case "2" -> addClient(scanner);
                case "3" -> addInvoice(scanner);
                case "4" -> viewClients();
                case "5" -> viewInvoices();
                case "6" -> saveToXML();
                case "7" -> startFileServer();
                case "8" -> startFileClient();
                case "9" -> processReceivedFile();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void loadClientsFromXML() {
        Path path = Paths.get("src/main/resources/xml/invoices.xml");

        if (!Files.exists(path)) {
            System.out.println("No XML file found. Starting fresh.\n");
            clientList.setClients(new ArrayList<>());
            return;
        }

        try (InputStream is = Files.newInputStream(path)) {
            ClientList loaded = transformer.transformToPOJO(is, ClientList.class);
            clientList.setClients(loaded.getClients());

            System.out.println("Loaded: " + clientList.getClients().size() + " clients.\n");

            for (Client client : clientList.getClients()) {
                System.out.println("Client: " + client.getClientName() + " (" + client.getClientId() + ")");
                for (Invoice invoice : client.getInvoices()) {
                    System.out.printf(" - %s | %.2f %s | Status: %s%n",
                            invoice.getInvoiceNumber(),
                            invoice.getTotalAmount(),
                            invoice.getCurrency(),
                            invoice.getStatus());
                }
            }

        } catch (Exception e) {
            System.out.println("Failed to load XML: " + e.getMessage());
        }
    }

    private void addClient(Scanner scanner) {
        System.out.print("Client ID: ");
        String id = scanner.nextLine();
        System.out.print("Client Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();

        Client client = new Client(id, name, email, phone, type, new ArrayList<>());
        clientList.getClients().add(client);
        System.out.println("Client added.");
    }

    private void addInvoice(Scanner scanner) {
        System.out.print("Enter client ID: ");
        String id = scanner.nextLine();

        Client client = null;
        for (Client c : clientList.getClients()) {
            if (c.getClientId().equalsIgnoreCase(id)) {
                client = c;
                break;
            }
        }

        if (client == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Invoice Number: ");
        String invNum = scanner.nextLine();
        System.out.print("Sender Name: ");
        String senderName = scanner.nextLine();
        System.out.print("Sender Email: ");
        String senderEmail = scanner.nextLine();
        System.out.print("Service Description: ");
        String desc = scanner.nextLine();
        System.out.print("Currency: ");
        String currency = scanner.nextLine();
        System.out.print("Notes: ");
        String notes = scanner.nextLine();
        System.out.print("Amount: ");
        float amount = Float.parseFloat(scanner.nextLine());

        String issued = java.time.LocalDate.now().toString();
        String due = java.time.LocalDate.now().plusDays(30).toString();
        String updated = java.time.LocalDateTime.now().toString();

        Invoice invoice = new Invoice(
                invNum, senderName, senderEmail,
                client.getClientName(), client.getContactEmail(), desc,
                currency, notes, amount,
                issued, due, null, updated, InvoiceStatus.DRAFT
        );

        client.getInvoices().add(invoice);
        System.out.println("Invoice added.");
    }

    private void viewClients() {
        for (Client client : clientList.getClients()) {
            System.out.println(client.getClientId() + " - " + client.getClientName());
        }
    }

    private void viewInvoices() {
        for (Client client : clientList.getClients()) {
            System.out.println("Client: " + client.getClientName());
            for (Invoice invoice : client.getInvoices()) {
                System.out.println("  " + invoice.getInvoiceNumber() + " - " + invoice.getTotalAmount());
            }
        }
    }

    private void saveToXML() {
        transformer.transformToXML(clientList);
        System.out.println("Saved to XML.");
    }

    private void startFileServer() {
        new Thread(() -> XmlFileServer.main(new String[0])).start();
        System.out.println("Server started on port 9001. Waiting for client...");
    }

    private void startFileClient() {
        XmlFileClient.main(new String[0]);
    }

    private void processReceivedFile() {
        ReceivedFileProcessor.main(new String[0]);
    }

}
