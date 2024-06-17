package org.example.view;
import org.example.entity.Result;

import java.util.Scanner;

import static org.example.constants.ApplicationCompletionConstants.*;

public class ConsoleView implements View{
    private final Scanner scanner = new Scanner(System.in);
    private final String[] parameters=new String[4];

    public ConsoleView() {
        ConsoleMenu();
    }

    public void ConsoleMenu(){
        System.out.printf(MENU);
        parameters[0]=scanner.nextLine();
        System.out.printf(PATH_FILE);
        parameters[1]=scanner.nextLine();
        if(parameters[0].equalsIgnoreCase("1")||parameters[0].equalsIgnoreCase("2")) {
            System.out.printf(SET_KEY);
            parameters[2] = scanner.nextLine();
        }
        if(parameters[1]==null || parameters[1].isEmpty()){
            if(parameters[0].equals("1")) {
                parameters[1] = "C:\\Users\\yaros\\IdeaProjects\\KryptoAnalyse\\src\\main\\resources\\EnglishTxt.txt";
            }
            else if(parameters[0].equals("2")){
                parameters[1]="C:\\Users\\yaros\\IdeaProjects\\KryptoAnalyse\\src\\main\\resources\\EnglishTxt[ENCODE].txt";
            } else if (parameters[0].equals("3")) {
                parameters[1]="C:\\Users\\yaros\\IdeaProjects\\KryptoAnalyse\\src\\main\\resources\\EnglishTxt[ENCODE][DECODE].txt";
            }
            parameters[2]="123";
        }
    }
    @Override
    public String[] getParameters() {
        return parameters;
    }

    @Override
    public void printResult(Result result) {
      switch (result.getResultCode()){
          case OK -> System.out.println(SUCCESS);
          case ERROR -> System.out.println(EXCEPTION+result.getApplicationException().getMessage());
      }
    }

}
