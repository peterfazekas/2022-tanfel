package hu.course;

import hu.course.controller.CourseService;
import hu.course.model.service.*;

import java.util.Scanner;

public class App {

    private final CourseService courseService;
    private final Console console;
    private final DataWriter dataWriter;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        courseService = new CourseService(dataApi.getData("beosztas.txt"));
        console = new Console(new Scanner(System.in));
        dataWriter = new DataWriter("of.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("2. feladat:");
    }
}
