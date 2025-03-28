package lt.eif.viko.dandrijauskas.model;

import jakarta.xml.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@XmlRootElement(name = "invoice")
@XmlAccessorType(XmlAccessType.PROPERTY) // .FIELDS - use fields directly ; .PROPERTY use getters/setters (SOLID)
public class Invoice {
    private String invoiceNumber;

    private String senderName;
    private String senderEmail;

    private String clientName;
    private String clientEmail;

    private String serviceDesc;
    private String currency;
    private String notes;
    private Float totalAmount;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private LocalDateTime lastUpdated;

    private Character status;

    public Invoice() {
    }

    public Invoice(String invoiceNumber, String senderName, String senderEmail, String clientName, String clientEmail, String serviceDesc, String currency, String notes, Float totalAmount, LocalDate issueDate, LocalDate dueDate, LocalDate paymentDate, LocalDateTime lastUpdated, Character status) {
        this.invoiceNumber = invoiceNumber;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.serviceDesc = serviceDesc;
        this.currency = currency;
        this.notes = notes;
        this.totalAmount = totalAmount;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.lastUpdated = lastUpdated;
        this.status = status;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}