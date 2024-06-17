package org.example.services;

import org.example.repository.FunctionCode;


public class DefinitionFunction {
    public static Function getFunction(String mode) {
        return switch (mode) {
            case "1" -> FunctionCode.ENCODE.getFunction();
            case "2" -> FunctionCode.DECODE.getFunction();
            case "3" -> FunctionCode.BRUTE_FORCE.getFunction();
            default -> FunctionCode.UNSUPPORTED_FUNCTION.getFunction();
        };
    }
}


