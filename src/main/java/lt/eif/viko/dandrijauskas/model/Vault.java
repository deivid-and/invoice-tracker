package lt.eif.viko.dandrijauskas;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "vault")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Vault {
    private String name;
    private String owner;
    private Character tier;
    private Boolean encrypted;
    private List<PasswordEntry> entries;

    public Vault() {
    }

    public Vault(String name, String owner, Character tier, Boolean encrypted, List<PasswordEntry> entries) {
        this.name = name;
        this.owner = owner;
        this.tier = tier;
        this.encrypted = encrypted;
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Character getTier() {
        return tier;
    }

    public void setTier(Character tier) {
        this.tier = tier;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    @XmlElementWrapper(name = "entries")
    @XmlElement(name = "entry")
    public List<PasswordEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<PasswordEntry> entries) {
        this.entries = entries;
    }
}
