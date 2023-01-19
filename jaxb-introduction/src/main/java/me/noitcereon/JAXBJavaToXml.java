package me.noitcereon;

import me.noitcereon.models.Person;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class JAXBJavaToXml {
    private JAXBJavaToXml() {
        // prevent instantiation.
    }

    public static void convertPersonToXmlAndLogInfo(Person person) {
        try {
            System.out.println("generatePersonAsXmlFile called with " + person);
            File personAsFile = File.createTempFile("person", ".xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(person, personAsFile); // converts the java object into an xml representation.
            writeXmlToOutStream(person, marshaller);

            System.out.println("\nFile path of person.xml: " + personAsFile.getAbsolutePath());
        } catch (IOException | JAXBException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void writeXmlToOutStream(Person person, Marshaller marshaller) throws JAXBException {
        System.out.println("\n--- With jaxbContext.createMarshaller() ---");
        System.out.println();
        marshaller.marshal(person, System.out);
        System.out.println("\n\n--- With static JAXB.marshal() --- \n");

        JAXB.marshal(person, System.out);
    }
}
