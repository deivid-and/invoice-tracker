package lt.eif.viko.dandrijauskas.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Client {
    private String clientId;
    private String clientName;
    private String contactEmail;
    private String phoneNumber;
    private String clientType;
    private List<Invoice> invoices;

    public Client() {
    }

    public Client(String clientId, String clientName, String contactEmail, String phoneNumber, String clientType, List<Invoice> entries) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.contactEmail = contactEmail;
        this.phoneNumber = phoneNumber;
        this.clientType = clientType;
        this.invoices = invoices;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @XmlElementWrapper(name = "invoices")
    @XmlElement(name = "invoice")
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
