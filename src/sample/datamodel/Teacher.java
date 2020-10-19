package sample.datamodel;

import javafx.beans.property.SimpleStringProperty;

public class Teacher {

    private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty lastName = new SimpleStringProperty("");
    private SimpleStringProperty subject = new SimpleStringProperty("");
    private SimpleStringProperty phoneNumber = new SimpleStringProperty("");
    private SimpleStringProperty eMail = new SimpleStringProperty("");
    private SimpleStringProperty notes  = new SimpleStringProperty("");

    public Teacher () {

    }

    public Teacher (String firstName, String lastName, String subject, String phoneNumber, String email, String notes) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNumber.set(phoneNumber);
        this.eMail.set(email);
        this.subject.set(subject);
        this.notes.set(notes);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getSubject() {
        return subject.get();
    }

    public SimpleStringProperty subjectProperty() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject.set(subject);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String geteMail() {
        return eMail.get();
    }

    public SimpleStringProperty eMailProperty() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail.set(eMail);
    }

    public String getNotes() {
        return notes.get();
    }

    public SimpleStringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", subject=" + subject +
                ", phoneNumber=" + phoneNumber +
                ", eMail=" + eMail +
                ", notes=" + notes +
                '}';
    }
}
