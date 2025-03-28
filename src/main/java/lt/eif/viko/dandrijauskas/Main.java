package lt.eif.viko.dandrijauskas;

import lt.eif.viko.dandrijauskas.model.*;
import lt.eif.viko.dandrijauskas.service.XMLTransformer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Invoice> businessInvoices = new ArrayList<>();
        businessInvoices.add(new Invoice(
                "INV-001", "Freelancer Dev", "me@freelancer.com",
                "Rand Restaurant", "rand@business.com",
                "Web design services", "EUR", "300 deposit was received",
                1200.0f, LocalDate.of(2025, 3, 1),
                LocalDate.of(2025, 3, 30), null,
                LocalDateTime.now(), 'D'
        ));
        businessInvoices.add(new Invoice(
                "INV-002", "Freelancer Dev", "me@freelancer.com",
                "Rand Restaurant", "rand@business.com",
                "Python task automation", "EUR", "Final payment due",
                500.0f, LocalDate.of(2025, 3, 2),
                LocalDate.of(2025, 3, 31), null,
                LocalDateTime.now(), 'S'
        ));

        Client businessClient = new Client(
                "CL-001", "Rand Restaurant", "rand@business.com",
                "+37060000000", "Business", businessInvoices
        );

        List<Invoice> individualInvoices = new ArrayList<>();
        individualInvoices.add(new Invoice(
                "INV-003", "Freelancer Dev", "me@freelancer.com",
                "Nham Lasther", "nham@email.com",
                "Landing page setup", "EUR", "Paid in full",
                200.0f, LocalDate.of(2025, 3, 5),
                LocalDate.of(2025, 3, 12),
                LocalDate.of(2025, 3, 6),
                LocalDateTime.now(), 'P'
        ));

        Client individualClient = new Client(
                "CL-002", "Nham Lasther", "nham@email.com",
                "+37060000001", "Individual", individualInvoices
        );

        List<Client> allClients = new ArrayList<>();
        allClients.add(businessClient);
        allClients.add(individualClient);

        ClientList clientList = new ClientList(allClients);

        XMLTransformer transformer = new XMLTransformer();
        System.out.println(transformer.transformToXML(clientList));
    }
}
