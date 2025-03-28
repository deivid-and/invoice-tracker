package lt.eif.viko.dandrijauskas.model;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.PROPERTY) // .FIELDS - use fields directly ; .PROPERTY use getters/setters (SOLID)
public class PasswordEntry {
    private String site;
    private String username;
    private String password;
    private Float score;
    private Boolean status;

    public PasswordEntry() {
    }

    public PasswordEntry(String site, String username, Float score, String password, Boolean status) {
        this.site = site;
        this.username = username;
        this.score = score;
        this.password = password;
        this.status = status;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
