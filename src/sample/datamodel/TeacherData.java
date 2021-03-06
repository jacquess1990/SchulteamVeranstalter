package sample.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TeacherData {

    public static final String TEACHERS_FILE = "teachers.xml";

    public static final String TEACHER = "teacher";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String SUBJECT = "subject";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String E_MAIL = "email";
    public static final String NOTES = "notes";

    private ObservableList<Teacher> teachers;

    public TeacherData () {
        teachers = FXCollections.observableArrayList();
    }

    public ObservableList<Teacher> getTeachers ()   {
        return teachers;
    }

    public void addTeacher (Teacher item) {
        teachers.add(item);
    }

    public void deleteTeacher (Teacher item) {
        teachers.remove(item);
    }

    public void loadTeacherData () {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            InputStream in = new FileInputStream(TEACHERS_FILE);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            Teacher teacher = null;
            // Teacher = null makes confusion here

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    if (startElement.getName().getLocalPart().equals(TEACHER)) {
                        teacher = new Teacher();
                        continue;
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(FIRST_NAME)) {
                            event = eventReader.nextEvent();
                            teacher.setFirstName(event.asCharacters().getData());
                            continue;
                        }
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(LAST_NAME)) {
                            event = eventReader.nextEvent();
                            teacher.setLastName(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(SUBJECT)) {
                            event = eventReader.nextEvent();
                            teacher.setSubject(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(PHONE_NUMBER)) {
                            event = eventReader.nextEvent();
                            teacher.setPhoneNumber(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(E_MAIL)) {
                            event = eventReader.nextEvent();
                            teacher.seteMail(event.asCharacters().getData());
                            continue;
                        }
                    }
                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(NOTES)) {
                            event = eventReader.nextEvent();
                            teacher.setNotes(event.asCharacters().getData());
                            continue;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void saveTeachers () {

        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

            XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(TEACHERS_FILE));

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");

            StartDocument startDocument = eventFactory.createStartDocument();
            eventWriter.add(startDocument);
            eventWriter.add(end);

            StartElement teachersStartElement = eventFactory.createStartElement("","","teachers");
            eventWriter.add(teachersStartElement);
            eventWriter.add(teachersStartElement);

            for (Teacher teacher: teachers) {
                saveTeacher(eventWriter,eventFactory,teacher);
            }

            eventWriter.add(eventFactory.createEndElement("","","teachers"));
            eventWriter.add(end);
            eventWriter.add(eventFactory.createEndDocument());
            eventWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Problem with Teachers: " + e.getMessage());
            e.printStackTrace();
        }
        catch (XMLStreamException e ) {
            System.out.println("Problem writing teacher in the list: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void saveTeacher (XMLEventWriter eventWriter, XMLEventFactory eventFactory, Teacher teacher) throws FileNotFoundException, XMLStreamException {
        XMLEvent end = eventFactory.createDTD("\n");

        StartElement configStartElement = eventFactory.createStartElement("","",TEACHER);
        eventWriter.add(configStartElement);
        eventWriter.add(end);

        createNode(eventWriter, FIRST_NAME, teacher.getFirstName());
        createNode(eventWriter, LAST_NAME, teacher.getLastName());
        createNode(eventWriter, SUBJECT, teacher.getSubject());
        createNode(eventWriter, PHONE_NUMBER, teacher.getPhoneNumber());
        createNode(eventWriter, E_MAIL, teacher.geteMail());
        createNode(eventWriter, NOTES, teacher.getNotes());

        eventWriter.add(eventFactory.createEndElement("","",TEACHER));
        eventWriter.add(end);
    }

    private void createNode  (XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");

        StartElement sElement = eventFactory.createStartElement("","",name);
        eventWriter.add(tab);
        eventWriter.add(sElement);

        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);

        EndElement eElement = eventFactory.createEndElement("","",name);
        eventWriter.add(eElement);
        eventWriter.add(end);
    }
}
