package by.tolpawsta.text.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private static TextParser ourInstance = new TextParser();

    public static TextParser getInstance() {
        return ourInstance;
    }

    private TextParser() {
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
}
