package org.example;

import org.example.app.Application;
import org.example.controller.MainController;
import org.example.entity.Result;
import org.example.view.ConsoleView;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.run();
        application.printResult(result);
    }
}