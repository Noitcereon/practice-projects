package me.noitcereon;

import me.noitcereon.exceptions.InternalApplicationException;
import me.noitcereon.models.Person;

import javax.xml.bind.*;
import java.io.StringReader;

public class JAXBXmlToJava {
    private JAXBXmlToJava(){
        // Hide default public constructor.
    }

    public static Person convertXmlToPerson(String personXml) {
        try {
            StringReader stringReader = new StringReader(personXml);
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Person)unmarshaller.unmarshal(stringReader);
        } catch (JAXBException | ClassCastException e) {
            throw new InternalApplicationException(e);
        }
    }
}
