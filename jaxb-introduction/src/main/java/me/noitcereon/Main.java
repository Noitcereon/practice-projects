package me.noitcereon;

import me.noitcereon.models.Person;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person person = new Person("Thomas", "Andersen", 1998);

        JAXBJavaToXml.convertPersonToXmlAndLogInfo(person);
    }
}