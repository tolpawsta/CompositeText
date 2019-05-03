package by.tolpawsta.text.entity.composite;

import by.tolpawsta.text.entity.builder.TextBuilder;
import by.tolpawsta.text.entity.visitor.Visitor;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class CompositeText extends Text {
    private List<Text> parts = new LinkedList<Text>();
    private final Logger logger = Logger.getLogger(CompositeText.class);


    public CompositeText(TextBuilder builder) {
        super(builder);
        value = builder.value;
        type = builder.type;
        parts = builder.parts;
        punctuation = builder.punctuation;
        whiteSpace = builder.whiteSpace;
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
    public List<Text> getParts() {
        return this.parts;
    }

    @Override
    public Text getPart(int index) {
        return this.parts.get(index);
    }

    @Override
    public void print() {
        for (Text part : parts) {
            if (part != null)
                part.print();

        }

        logger.info(punctuation+whiteSpace);

    }

    @Override
    public void accept(Visitor visitor, TextType type) {

        visitor.visit(this, type);
        for (Text text : parts) {
            visitor.visit(text, type);
        }
    }

}
