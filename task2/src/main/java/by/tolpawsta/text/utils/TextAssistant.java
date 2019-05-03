package by.tolpawsta.text.utils;


import by.tolpawsta.text.TextTypeException;
import by.tolpawsta.text.entity.composite.TextType;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAssistant {
    public final Logger logger=Logger.getLogger(TextAssistant.class);
    private static TextAssistant ourInstance = new TextAssistant();

    public static TextAssistant getInstance() {
        return ourInstance;
    }

    private TextAssistant() {
    }

    public List<String> parseText(String regularexpression, String text) {
        Pattern pattern = Pattern.compile(regularexpression);
        Matcher matcher = pattern.matcher(text);
        List<String> foundvalues = new LinkedList<String>();
        while (matcher.find()) {
            foundvalues.add(matcher.group());
        }
        return foundvalues;
    }

    public String loadTextFromFile(String puthfile) {

        String text=null;
        StringBuilder fulltext=new StringBuilder();
    try {
        FileInputStream file = new FileInputStream(puthfile);
            byte[] infile=new byte[file.available()];
            file.read(infile);
            text=new String(infile);
    }catch (FileNotFoundException e){
        logger.error(e.getMessage(),e);
        }
        catch (IOException ex){
        logger.error(ex.getMessage(),ex);
        }
        return text;
        //return fulltext.toString();
    }

    public String getPatternByTextType(TextType type) {
        String pattern = "";
        try {
            if (TextType.isExist(type.name())) {
                throw new TextTypeException("Type not corrected");
            } else {


                switch (type) {
                    case TEXT:
                        pattern = "\\.*";
                        break;
                    case PARAGRAPH:
                        pattern = "(?:\\r\\n)(\\w+\\W*\\w*\\W*\\s*)*";
                        break;
                    case SENTENCE:
                        pattern = "(\\w+\\s*)+[!?.;]";
                        break;
                    case WORD:
                        pattern = "\\w+";
                        break;
                    case LETTER:
                        pattern = "\\.";
                        break;

                }

            }
        } catch (TextTypeException e) {
           logger.warn(e.getMessage(),e);
        }
        return pattern;
    }

}
