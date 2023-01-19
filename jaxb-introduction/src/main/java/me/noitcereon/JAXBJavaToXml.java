package me.noitcereon;

import me.noitcereon.exceptions.InternalApplicationException;
import me.noitcereon.models.Person;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class JAXBJavaToXml {
    private JAXBJavaToXml() {
        // prevent instantiation.
    }

    public static void convertPersonToXmlAndLogInfo(Person person) {
        try {
            System.out.println("convertPersonToXmlAndLogInfo called with " + person);
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

    /**
     * Converts a Person java object into XML and returns it.
     * @param person The person to convert to XML.
     * @return The given Person object as an XML string representation.
     */
    public static String convertPersonToXml(Person person) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(person, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new InternalApplicationException(e);
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
