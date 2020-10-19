package sample.datamodel;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TeacherController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField notesField;

    public Teacher getNewTeacher() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String subject = subjectField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String notes = notesField.getText();

        Teacher newTeacher = new Teacher(firstName,lastName,subject,phoneNumber,email,notes);
        return newTeacher;
    }

    public void editTeacher (Teacher teacher) {
        firstNameField.setText(teacher.getFirstName());
        lastNameField.setText(teacher.getLastName());
        subjectField.setText(teacher.getSubject());
        phoneNumberField.setText(teacher.getPhoneNumber());
        emailField.setText(teacher.geteMail());
        notesField.setText(teacher.getNotes());
    }

    public void updateTeacher (Teacher teacher ) {
        teacher.setFirstName(firstNameField.getText());
        teacher.setLastName(lastNameField.getText());
        teacher.setSubject(subjectField.getText());
        teacher.setPhoneNumber(phoneNumberField.getText());
        teacher.seteMail(emailField.getText());
        teacher.setNotes(notesField.getText());
    }
}
