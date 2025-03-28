package lt.eif.viko.dandrijauskas.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "clients")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClientList {
    private List<Client> clients;

    public ClientList() {
    }

    public ClientList(List<Client> clients) {
        this.clients = clients;
    }

    @XmlElement(name = "client")
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
