package org.example.services;

import org.example.entity.Result;
import org.example.exception.ApplicationException;

import static org.example.repository.ResultCode.ERROR;

public class UnsupportedFunction implements Function{
    @Override
    public Result execute(String[] parameters) {
        return new Result(ERROR,new ApplicationException("Unsupported function"));
    }
}
