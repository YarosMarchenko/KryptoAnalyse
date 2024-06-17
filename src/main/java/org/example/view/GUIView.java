package org.example.view;


import org.example.entity.Result;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Objects;

import static org.example.constants.ApplicationCompletionConstants.EXCEPTION;
import static org.example.constants.ApplicationCompletionConstants.SUCCESS;

public class GUIView implements View{
    private JFrame frame;
    private JButton button;
    private final String[] parameters=new String[4];

    public GUIView() {
        initComponents();
        //addActionButton();
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
    private void initComponents(){
        frame = new JFrame("CryptoAnalys");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        String[] action = new String[]{"Encode", "Decode", "BruteForce"};
        JComboBox<String> box = new JComboBox<>(action);
        box.setBounds(150, 10, 500, 20);



        JLabel path = new JLabel("Path to file:");
        path.setBounds(20, 60, 100, 20);
        JLabel key = new JLabel("Key:");
        key.setBounds(30, 90, 100, 20);

        JTextField path_text = new JTextField();
        path_text.setBounds(180, 60, 400, 20);
        JTextField key_text = new JTextField();
        key_text.setBounds(180, 90, 400, 20);

        button = new JButton("ok");
        button.setSize(55, 20);
        button.setLocation(380, 130);

        path_text.addActionListener(e -> {parameters[1]=path_text.getText();});
        key_text.addActionListener(e ->{parameters[2]=key_text.getText();});


        //frame.add(button);

        frame.add(key);
        frame.add(path);

        frame.add(path_text);
        frame.add(key_text);

        frame.add(box);

        frame.setSize(800, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    private void addActionButton(){
        button.addActionListener(e -> {
            getParameters();
        });
    }
}

