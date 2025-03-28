package lt.eif.viko.dandrijauskas.service;

import jakarta.xml.bind.*;
import lt.eif.viko.dandrijauskas.model.Client;
import lt.eif.viko.dandrijauskas.model.Invoice;

import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XMLTransformer {

    public String transformToXML(Object object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Client.class, Invoice.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);
            String xmlContent = writer.toString();

            Path outputPath = Paths.get("src/main/resources/xml/invoices.xml");
            Files.createDirectories(outputPath.getParent());
            Files.writeString(outputPath, xmlContent, StandardCharsets.UTF_8);

            return xmlContent;
        } catch (Exception e) {
            throw new RuntimeException("Error during marshaling: " + e.getMessage(), e);
        }
    }

    public <T> T transformToPOJO(InputStream xml, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            throw new RuntimeException("Error during unmarshaling: " + e.getMessage(), e);
        }
    }
}
