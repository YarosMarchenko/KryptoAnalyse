package org.example.app;

import org.example.controller.MainController;
import org.example.entity.Result;
import org.example.services.DefinitionFunction;
import org.example.services.Function;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run() {
        String[] parameters = mainController.getView().getParameters();
        String mode = parameters[0];
        Function function = DefinitionFunction.getFunction(mode);
        return function.execute(parameters);
    }

    public void printResult(Result result) {
        mainController.getView().printResult(result);
    }
}
