package by.tolpawsta.text.entity.composite;

import by.tolpawsta.text.entity.builder.TextBuilder;
import by.tolpawsta.text.entity.visitor.Visitor;

import java.util.LinkedList;
import java.util.List;

public class CompositeText extends Text {
    private List<Text> parts=new LinkedList<Text>();


    public CompositeText(TextBuilder builder){
         super(builder);
        value=builder.value;
        type=builder.type;
        parts=builder.parts;
    }
    @Override
    public void addPart(Text text) {
        this.parts.add(text);
    }

    @Override
    public void removePart(Text text) {
        this.parts.remove(text);
    }

@Override
    public List<Text> getParts(){
        return this.parts;
    }
@Override
    public Text getPart(int index) {
        return this.parts.get(index);
    }
@Override
    public void print() {
        for (Text part:parts) {
            part.print();
        }

    }
@Override
public void accept(Visitor visitor, TextType type){ visitor.visitComposite(this,type);
}

}
