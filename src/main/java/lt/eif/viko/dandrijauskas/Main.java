package lt.eif.viko.dandrijauskas;

import lt.eif.viko.dandrijauskas.model.PasswordEntry;
import lt.eif.viko.dandrijauskas.model.Vault;
import lt.eif.viko.dandrijauskas.service.XMLTransformer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PasswordEntry> entries = new ArrayList<>();
        entries.add(new PasswordEntry("gmail.com", "justin", 6.5f, "123abc", true));
        entries.add(new PasswordEntry("netflix.com", "tomtomas", 7.2f, "tomas1122", true));
        entries.add(new PasswordEntry("protonmail.com", "useris", 9.0f, "secure!", false));
        entries.add(new PasswordEntry("spotify.com", "vibeon", 6.0f, "mymusic", true));
        entries.add(new PasswordEntry("reddit.com", "scrolllord", 5.8f, "funny123", false));

        Vault vault = new Vault("LazyVault", "Chill Dev", 'B', true, entries);

        XMLTransformer transformer = new XMLTransformer();
        String xmlOutput = transformer.transformToXML(vault);

        System.out.println(xmlOutput);
    }
}
