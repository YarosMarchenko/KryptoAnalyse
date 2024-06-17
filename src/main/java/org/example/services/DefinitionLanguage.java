package org.example.services;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.language.detect.LanguageResult;
import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.example.constants.AlphabetConstant;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefinitionLanguage {
    public static final String Alphabet_EN= AlphabetConstant.Alphabet_EN;
    public static final String Alphabet_UA = AlphabetConstant.Alphabet_UA;
    public static Caeser Language(List<String> text){
        String str = "";
        for (String s : text) {
            if (!s.isEmpty()) {
                str = s;
                break;
            }
        }
        Pattern pattern = Pattern.compile("["+"A-Za-z" +"]"+".*");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return new Caeser(Alphabet_EN);
        } else {
            return new Caeser(Alphabet_UA);
        }
}


/*
    public static Caeser Language(List<String> text) {
        LanguageDetector detector = new OptimaizeLangDetector().loadModels();
        LanguageResult result = detector.detect(text.toString());
        if (result.getLanguage().equalsIgnoreCase("en"))
            return new Caeser(Alphabet_EN);
        else return new Caeser(Alphabet_UA);
    }
*/
}
