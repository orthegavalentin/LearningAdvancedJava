package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadXMLFileJava {
    public static void main(String[] args) {
        System.out.println("It is a godamn marathon baby");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("people.xml");
            NodeList persons = doc.getElementsByTagName("person");

            ArrayList<Person> listPersons = new ArrayList<>();
            for (int i = 0; i < persons.getLength(); i++) {

                listPersons.add(getPerson(persons.item(i)));
            }

            for(Person p:listPersons){
                System.out.println(p.toString());

            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Person getPerson(Node item) {
        Person p = new Person();
        if (item.getNodeType() == Node.ELEMENT_NODE) {
            Element value = (Element) item;
            p.setId(Integer.parseInt(value.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue()));
            p.setFirstName(value.getElementsByTagName("firstname").item(0).getChildNodes().item(0).getNodeValue());
            p.setSecondName(value.getElementsByTagName("secondname").item(0).getChildNodes().item(0).getNodeValue());


        }
        return p;


    }
}
