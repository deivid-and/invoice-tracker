package lt.eif.viko.dandrijauskas.service;

import lt.eif.viko.dandrijauskas.model.Client;
import lt.eif.viko.dandrijauskas.model.ClientList;
import lt.eif.viko.dandrijauskas.model.Invoice;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReceivedFileProcessor {
    public static void main(String[] args) {
        XMLTransformer transformer = new XMLTransformer();
        String path = "received_files/received_invoices.xml";

        try (InputStream xml = new FileInputStream(path)) {
            ClientList clients = transformer.transformToPOJO(xml, ClientList.class);

            System.out.println("XML transformed to POJO.\n");
            for (Client client : clients.getClients()) {
                System.out.println("Client: " + client.getClientName() + " (" + client.getClientId() + ")");
                for (Invoice invoice : client.getInvoices()) {
                    System.out.println("  Invoice: " + invoice.getInvoiceNumber());
                    System.out.println("  Amount: " + invoice.getTotalAmount());
                    System.out.println("  Status: " + invoice.getStatus());
                    System.out.println("  ---");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println("Failed to transform XML: " + e.getMessage());
        }
    }
}
