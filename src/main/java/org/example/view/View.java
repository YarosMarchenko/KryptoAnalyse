package org.example.view;

import org.example.entity.Result;

public interface View {
    String[] getParameters();
    void printResult(Result result);
}
