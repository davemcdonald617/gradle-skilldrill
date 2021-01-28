package edu.isu.cs.cs2263.schedule;

import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.Gson;


public class App extends Application {
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     *
     */

    private ListView<String> studentNames;
    private ListView<String> displayCourses;
    private ListView<String> isaacCourses;
    private ListView<String> bobCourses;
    private ListView<String> sarahCourses;

    public static void main(String[] args){
        Application.launch(args);
    }

    // Gets json string form students.json
    public static List<Student> gsonReadFromFile(String jsonStudents) {
        Gson gson = new Gson();

        Type studentList = new TypeToken<ArrayList<Student>>() {}.getType();
        List<Student> other = gson.fromJson(jsonStudents, studentList);

        return other;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Declaring and initiating a String to use for incoming json string.
        String jsonStudents= "";
        try { jsonStudents = Files.readString(Paths.get("./students.json")); }
        catch (IOException ex) { ex.printStackTrace(); }

        // Declaring and initiating Student list using func
        List<Student> students2 = gsonReadFromFile(jsonStudents);

        // Using a listview
        studentNames = new ListView<>();

        //change this to a loop if time...
        studentNames.getItems().add(students2.get(0).firstName + " " +
                students2.get(0).lastName);
        studentNames.getItems().add(students2.get(1).firstName + " " +
                students2.get(1).lastName);
        studentNames.getItems().add(students2.get(2).firstName + " " +
                students2.get(2).lastName);

        isaacCourses = new ListView<String>();
        bobCourses = new ListView<String>();
        sarahCourses = new ListView<String>();

        displayCourses = new ListView<String>();

        // Find more efficient way if time.
        isaacCourses.getItems().add(students2.get(0).courses.get(0).toString());
        isaacCourses.getItems().add(students2.get(0).courses.get(1).toString());
        isaacCourses.getItems().add(students2.get(0).courses.get(2).toString());

        bobCourses.getItems().add(students2.get(1).courses.get(0).toString());
        bobCourses.getItems().add(students2.get(1).courses.get(1).toString());
        bobCourses.getItems().add(students2.get(1).courses.get(2).toString());

        sarahCourses.getItems().add(students2.get(2).courses.get(0).toString());
        sarahCourses.getItems().add(students2.get(2).courses.get(1).toString());
        sarahCourses.getItems().add(students2.get(2).courses.get(2).toString());

        primaryStage.setTitle("Course View");

        //VBox isTaking = new VBox();
        Label label = new Label("Is Taking");


        studentNames.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable,
                                        String oldValue, String newValue) {
                        System.out.println("Courses changed");
                        displayCourses = updateCourses(newValue);
                    }
                }
        );

        // setting height and width for lists
        studentNames.setPrefWidth(100);
        studentNames.setPrefHeight(100);
        displayCourses.setPrefWidth(100);
        displayCourses.setPrefHeight(100);

        HBox hbox = new HBox(studentNames, label, displayCourses);
        Scene scene = new Scene(hbox, 400,200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public ListView<String> updateCourses(String newValue){
        //if (studentNames.getSelectionModel().getSelectedIndex() == 0) {
        if (newValue.equals("Isaac Griffith")){
            displayCourses = isaacCourses;
            System.out.println(displayCourses.toString());
        } else if (studentNames.getSelectionModel().getSelectedIndex() == 1) {
            displayCourses = bobCourses;
        } else if (studentNames.getSelectionModel().getSelectedIndex() == 2) {
            displayCourses = sarahCourses;
        }
            return displayCourses;
    }
}
