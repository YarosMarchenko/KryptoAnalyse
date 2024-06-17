package org.example.services;

import org.example.entity.Result;
import org.example.exception.ApplicationException;
import org.example.repository.ResultCode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BruteForce implements Function {
    private final FileService fileService = FileService.getInstance();

    @Override
    public Result execute(String[] parameters) {
        try {
            fileService.readFile(parameters[1]);
            List<String> text = fileService.getText(parameters[1]);
            Caeser caeser=DefinitionLanguage.Language(text);
            String strText = notEmptyString(text);
            int key = Find_Key(strText,caeser);
            List<String> decodeText = new ArrayList<>();
            for (String str : text) {
                StringBuilder stringBuilder1 = new StringBuilder(str);
                for (int i = 0; i < str.length(); i++) {
                    stringBuilder1.setCharAt(i, caeser.symbolDecode(stringBuilder1.charAt(i), key));
                }
                decodeText.add(stringBuilder1.toString());
            }
            text.clear();
            text.addAll(decodeText);
            String pathForWrite = fileService.newFilePath(parameters[1], "BruteForce");
            fileService.writeFile(parameters[1], pathForWrite);
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Error BruteForce action"));
        }
        return new Result(ResultCode.OK);
    }

    private int Find_Key(String strText,Caeser caeser) {
        int key = 0;
        for (int i = 0; i < caeser.getAlphabet().length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(strText);
            for (int j = 0; j < stringBuilder.length(); j++) {
                stringBuilder.setCharAt(j, caeser.symbolDecode(stringBuilder.charAt(j), i));
            }
            if (gradeText(stringBuilder.toString())) {
                key = i ;
                return key;
            }
        }
        return key;
    }

    private String notEmptyString(List<String> text) {
        String strText = "";
        for (String str : text) {
            if (!str.isEmpty()) {
                strText = str;
                break;
            }
        }
        return strText;
    }

    private boolean gradeText(String text) {
        String[] patterns = new String[]{"if", "and", "but", "be", "to", "is", "of", "now", "then", "it", "all", "then"};
        for (String s : patterns) {
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
}
