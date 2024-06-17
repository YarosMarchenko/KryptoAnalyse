package org.example.controller;

import org.example.view.View;

public class MainController {
    private  View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
