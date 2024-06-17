package org.example.repository;

import org.example.services.*;

public enum FunctionCode {
    ENCODE(new Encode()),DECODE(new Decode()),BRUTE_FORCE(new BruteForce()),UNSUPPORTED_FUNCTION(new UnsupportedFunction());
    private final Function function;
    FunctionCode(Function function) {
        this.function=function;
    }

    public Function getFunction() {
        return function;
    }
}
