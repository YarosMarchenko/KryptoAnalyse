package org.example.services;

import org.example.entity.Result;
import org.example.exception.ApplicationException;
import org.example.repository.ResultCode;

import java.util.ArrayList;
import java.util.List;



public class Encode implements Function {
    private final FileService fileService=FileService.getInstance();

    @Override
    public Result execute(String[] parameters) {
        try {
            fileService.readFile(parameters[1]);
            List<String> text = fileService.getText(parameters[1]);
            List<String> encodeText = new ArrayList<>();
            int key = Integer.parseInt(parameters[2]);
            Caeser caeser=DefinitionLanguage.Language(text);
            for(String str:text){
                StringBuilder stringBuilder=new StringBuilder(str);
                for (int i = 0; i < str.length(); i++) {
                    stringBuilder.setCharAt(i, caeser.symbolEncode(stringBuilder.charAt(i),key));
                }
                encodeText.add(stringBuilder.toString());
            }
            text.clear();
            text.addAll(encodeText);
            String pathForWrite=fileService.newFilePath(parameters[1],"Encode");
            fileService.writeFile(parameters[1],pathForWrite);
        }catch (Exception e){
            return new Result(ResultCode.ERROR,new ApplicationException("Text encoding error",e));
        }
        return new Result(ResultCode.OK);
    }
}
