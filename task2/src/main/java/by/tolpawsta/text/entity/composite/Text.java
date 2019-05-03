package by.tolpawsta.text.entity.composite;

import by.tolpawsta.text.entity.builder.Builder;
import by.tolpawsta.text.entity.visitor.Visitor;

import java.util.List;

public abstract class Text {
  protected TextType type;
  protected String value;
   Text(Builder builder){

   }
    public TextType getType() {
        return type;
    }


    public String getValue() {
        return value;
    }
    public abstract void addPart(Text text);
    public abstract void removePart(Text text);
    public abstract List<Text> getParts();
    public abstract Text getPart(int index);
    public abstract void print();
    public abstract void accept(Visitor visitor, TextType type);
}
