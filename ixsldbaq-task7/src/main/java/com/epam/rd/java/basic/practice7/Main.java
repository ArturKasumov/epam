package com.epam.rd.java.basic.practice7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class Main {

    public static void main(final String[] args) throws Exception {
        Main main = new Main();

        List<Student> students = new ArrayList<>();
        main.parseWithDom("input.xml", students);
        System.out.println("Dom");
        for (Student s : students)
            System.out.println(s);

        List<Student> students1 = new ArrayList<>();
        main.parseWithStax("input.xml", students1);

        System.out.println("Stax");
        for (Student s : students1)
            System.out.println(s);

        main.writeWithDom("output.dom.xml", students);
        main.writeWithStax("output.stax.xml", students);

        List<Student> students2 = new ArrayList<>();
        main.parseWithSax("input.xml", students2);

        System.out.println("Sax");
        for (Student s : students2)
            System.out.println(s);

        main.writeWithDom("output.dom.xml", students);
        main.writeWithStax("output.stax.xml", students1);
        main.writeWithDom("output.sax.xml", students2);
    }

    public void parseWithDom(String file, List<Student> students) throws Exception {
        Student student;
        String text;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(file));
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); ++i) {
            if (nodeList.item(i) instanceof Element) {
                student = new Student();
                text = ((Element) nodeList.item(i)).getAttribute("id");
                student.setId(Integer.parseInt(text));
                if (nodeList.item(i).hasChildNodes()) {
                    NodeList nodeChilds = nodeList.item(i).getChildNodes();
                    for (int j = 0; j < nodeChilds.getLength(); ++j) {
                        if (nodeChilds.item(j) instanceof Element) {
                            if (((Element) nodeChilds.item(j)).getTagName().equals("firstname")) {
                                student.setFirstName(nodeChilds.item(j).getTextContent());
                            }
                            if (((Element) nodeChilds.item(j)).getTagName().equals("lastname")) {
                                student.setSecondName(nodeChilds.item(j).getTextContent());
                            }
                            if (((Element) nodeChilds.item(j)).getTagName().equals("initials")) {
                                student.setInitials(nodeChilds.item(j).getTextContent());
                            }
                            if (((Element) nodeChilds.item(j)).getTagName().equals("age")) {
                                student.setAge(Integer.parseInt(nodeChilds.item(j).getTextContent()));
                            }
                            if (((Element) nodeChilds.item(j)).getTagName().equals("group")) {
                                student.setGroup(Integer.parseInt(nodeChilds.item(j).getTextContent()));
                            }
                            if (((Element) nodeChilds.item(j)).getTagName().equals("city")) {
                                student.setCity(nodeChilds.item(j).getTextContent());
                            }
                        }
                    }
                }
                students.add(student);
            }
        }
    }

    public void writeWithDom(String file, List<Student> students) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Text text;
        Element rootElement = document.createElement("students");
        for (int i = 0; i < students.size(); ++i) {
            Element student = document.createElement("student");
            student.setAttribute("id", String.valueOf(students.get(i).getId()));
            Element firstname = document.createElement("firstname");
            text = document.createTextNode(students.get(i).getFirstName());
            firstname.appendChild(text);
            Element lastname = document.createElement("lastname");
            text = document.createTextNode(students.get(i).getSecondName());
            lastname.appendChild(text);
            Element initials = document.createElement("initials");
            text = document.createTextNode(students.get(i).getInitials());
            initials.appendChild(text);
            Element age = document.createElement("age");
            text = document.createTextNode(String.valueOf(students.get(i).getAge()));
            age.appendChild(text);
            Element group = document.createElement("group");
            text = document.createTextNode(String.valueOf(students.get(i).getGroup()));
            group.appendChild(text);
            Element city = document.createElement("city");
            text = document.createTextNode(students.get(i).getCity());
            city.appendChild(text);
            student.appendChild(firstname);
            student.appendChild(lastname);
            student.appendChild(initials);
            student.appendChild(age);
            student.appendChild(group);
            student.appendChild(city);
            rootElement.appendChild(student);
        }
        document.appendChild(rootElement);
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(document), new StreamResult(new FileWriter(file)));
    }

    public void parseWithSax(String file, List<Student> students) throws Exception {
        DefaultHandler handler = new DefaultHandler() {
            Student student;
            String name = "";

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                name = qName;
                if (name.equals("student")) {
                    student = new Student();
                    String s = attributes.getValue("id");
                    student.setId(Integer.parseInt(s));
                }
                if (name.equals("firstname")) {
                    name = "firstname";
                }
                if (name.equals("lastname")) {
                    name = "lastname";
                }
                if (name.equals("initials")) {
                    name = "initials";
                }
                if (name.equals("age")) {
                    name = "age";
                }
                if (name.equals("group")) {
                    name = "group";
                }
                if (name.equals("city")) {
                    name = "city";
                    students.add(student);
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String s = new String(ch, start, length);
                if (name.equals("firstname"))
                    student.setFirstName(s);
                if (name.equals("lastname"))
                    student.setSecondName(s);
                if (name.equals("initials"))
                    student.setInitials(s);
                if (name.equals("age"))
                    student.setAge(Integer.parseInt(s));
                if (name.equals("group"))
                    student.setGroup(Integer.parseInt(s));
                if (name.equals("city"))
                    student.setCity(s);
                name = "";
            }
        };
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(file), handler);
    }

    public void parseWithStax(String file, List<Student> students) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(new FileReader(file));
        Student student = null;
        String text;
        while (parser.hasNext()) {
            if (student == null)
                student = new Student();
            int event = parser.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                if (parser.getLocalName().equals("student")) {
                    student = new Student();
                    student.setId(Integer.parseInt(parser.getAttributeValue(0)));
                }
                if (parser.getLocalName().equals("firstname")) {
                    student.setFirstName(parser.getElementText());
                }
                if (parser.getLocalName().equals("lastname")) {
                    student.setSecondName(parser.getElementText());
                }
                if (parser.getLocalName().equals("initials")) {
                    student.setInitials(parser.getElementText());
                }
                if (parser.getLocalName().equals("age")) {
                    student.setAge(Integer.parseInt(parser.getElementText()));
                }
                if (parser.getLocalName().equals("group")) {
                    student.setGroup(Integer.parseInt(parser.getElementText()));
                }
                if (parser.getLocalName().equals("city")) {
                    student.setCity(parser.getElementText());
                    students.add(student);
                    student = null;
                }
            }
        }
    }

    public void writeWithStax(String file, List<Student> students) throws Exception {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(file));
        writer.writeStartDocument();
        writer.writeStartElement("students");
        for (int i = 0; i < students.size(); ++i) {
            writer.writeStartElement("student");
            writer.writeAttribute("id", String.valueOf(students.get(i).getId()));
            writer.writeStartElement("firstname");
            writer.writeCharacters(students.get(i).getFirstName());
            writer.writeEndElement();
            writer.writeStartElement("lastname");
            writer.writeCharacters(students.get(i).getSecondName());
            writer.writeEndElement();
            writer.writeStartElement("initials");
            writer.writeCharacters(students.get(i).getInitials());
            writer.writeEndElement();
            writer.writeStartElement("age");
            writer.writeCharacters(String.valueOf(students.get(i).getAge()));
            writer.writeEndElement();
            writer.writeStartElement("group");
            writer.writeCharacters(String.valueOf(students.get(i).getGroup()));
            writer.writeEndElement();
            writer.writeStartElement("city");
            writer.writeCharacters(students.get(i).getCity());
            writer.writeEndElement();
            writer.writeEndElement();
        }
        writer.writeEndElement();
        writer.writeEndDocument();

    }

}