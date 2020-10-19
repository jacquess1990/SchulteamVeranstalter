package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import sample.datamodel.Teacher;
import sample.datamodel.TeacherController;
import sample.datamodel.TeacherData;

import java.io.IOException;
import java.util.Optional;

public class Controller {


    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView<Teacher> teachersTable;

    private TeacherData data;


        public void initialize () {
            data = new TeacherData();
//            data.loadTeacherData();
            // without this correction, software doesn't start, have to see why
            teachersTable.setItems(data.getTeachers());

        }



        @FXML
        public void showAddTeacherDialog () {
            Dialog<ButtonType> dialog = new Dialog<ButtonType>();
            dialog.initOwner(mainPanel.getScene().getWindow());
            dialog.setTitle("Neuer Lehrer");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("dialog.fxml"));

            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (Exception e) {
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }

            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            Optional<ButtonType> result = dialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                TeacherController teacherController = fxmlLoader.getController();
                Teacher newTeacher = teacherController.getNewTeacher();
                data.addTeacher(newTeacher);
                data.saveTeachers();
            }
        }

        @FXML
        public void showEditTeacherDialog () {
            Teacher selectedTeacher = teachersTable.getSelectionModel().getSelectedItem();
            if (selectedTeacher == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Kein Lehrer ist ausgewählt");
                alert.setHeaderText(null);
                alert.setContentText("Bitte aswählen den Lehrer, den Sie bearbeiten möchten");
                alert.showAndWait();
                return;
            }

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainPanel.getScene().getWindow());
            dialog.setTitle("Lehrer bearbeiten");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("dialog.fxml"));

            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());

            } catch (IOException e) {
                System.out.println("Couldn't load the dialog");
                e.printStackTrace();
                return;
            }

            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            TeacherController teacherController = fxmlLoader.getController();
            teacherController.editTeacher(selectedTeacher);

            Optional<ButtonType> result = dialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                teacherController.updateTeacher(selectedTeacher);
                data.saveTeachers();
            }
        }
    }
