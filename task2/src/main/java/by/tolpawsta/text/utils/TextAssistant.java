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
    public final Logger logger = Logger.getLogger(TextAssistant.class);
    private static TextAssistant ourInstance = new TextAssistant();
    String[] puntuations = new String[]{",", ".", "!", "?", ";", ":"};

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
            foundvalues.add(matcher.group().trim());
        }
        return foundvalues;
    }

    public String loadTextFromFile(String puthfile) {

        String text = null;
        StringBuilder fulltext = new StringBuilder();
        try {
            FileInputStream file = new FileInputStream(puthfile);
            byte[] infile = new byte[file.available()];
            file.read(infile);
            text = new String(infile);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
        return text;
        //return fulltext.toString();
    }

    public String getPuntuation(String value) {
        if (value.equals("")) return value;
        int index = value.length() - 1;
        String punct = value.substring(index);
        for (String punctuation : puntuations) {
            if (punctuation.equals(punct)) {
                return punct;
            }

        }

        return "";
    }

    public String getWhiteSpace(TextType type) {
        String whiteSpace;
        switch (type) {
            case PARAGRAPH:
                whiteSpace = "\\r\\n";
                break;
            case SENTENCE:
                whiteSpace = " ";
                break;
            case WORD:
                whiteSpace = " ";
                break;
            default:
                whiteSpace = "";
                break;
        }
        return whiteSpace;
    }

    public String getValue(String value) {
        if (value.equals("")) return value;
        int index = value.length() - 1;
        String punct = value.substring(index);
        for (String punctuation : puntuations) {
            if (punctuation.equals(punct)) {
                return value.substring(0, index);
            }

        }

        return value;
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
                        pattern = "([^\\.!?\\r\\n]+[\\r\\n])";
                        break;
                    case SENTENCE:
                        pattern = "([^\\.!?\\r\\n]+[\\.!?])";

                        break;
                    case WORD:
                        pattern = "([^(\\s)]*)[^\\s*]";
                        break;
                    case LETTER:
                        pattern = ".{1}";
                        break;

                }

            }
        } catch (TextTypeException e) {
            logger.warn(e.getMessage(), e);
        }
        return pattern;
    }

}
