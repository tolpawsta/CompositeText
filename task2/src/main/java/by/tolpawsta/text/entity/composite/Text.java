package by.tolpawsta.text.entity.composite;

import by.tolpawsta.text.entity.builder.Builder;
import by.tolpawsta.text.entity.visitor.Visitor;

import java.util.List;

public abstract class Text {
    protected TextType type;
    protected String value;

    protected String punctuation;
    protected String whiteSpace;

    Text(Builder builder) {

    }

    public TextType getType() {
        return type;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    public String getWhiteSpace() {
        return whiteSpace;
    }

    public void setWhiteSpace(String whiteSpace) {
        this.whiteSpace = whiteSpace;
    }

    public abstract void addPart(Text text);

    public abstract void removePart(Text text);

    public abstract List<Text> getParts();

    public abstract Text getPart(int index);

    public abstract void print();

    public abstract void accept(Visitor visitor, TextType type);
}
