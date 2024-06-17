package org.example.services;

import org.example.entity.Result;
import org.example.exception.ApplicationException;
import org.example.repository.ResultCode;

import java.util.ArrayList;
import java.util.List;

public class Decode implements Function{
    private final FileService fileService=FileService.getInstance();

    @Override
    public Result execute(String[] parameters) {
        try{
        fileService.readFile(parameters[1]);
        List<String> text=fileService.getText(parameters[1]);
        int key=Integer.parseInt(parameters[2]);
        Caeser caeser=DefinitionLanguage.Language(text);
        List<String> decodeText=new ArrayList<>();
            for(String str:text){
                StringBuilder stringBuilder=new StringBuilder(str);
                for (int i = 0; i < str.length(); i++) {
                    stringBuilder.setCharAt(i, caeser.symbolDecode(stringBuilder.charAt(i),key));
                }
                decodeText.add(stringBuilder.toString());
            }
            text.clear();
            text.addAll(decodeText);
            String pathForWrite=fileService.newFilePath(parameters[1],"Decode");
            fileService.writeFile(parameters[1],pathForWrite);
        }catch (Exception e){
            return new Result(ResultCode.ERROR,new ApplicationException("Text decoding error",e));
        }
        return new Result(ResultCode.OK);
    }
}
