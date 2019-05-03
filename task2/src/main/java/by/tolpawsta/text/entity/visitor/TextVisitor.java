package by.tolpawsta.text.entity.visitor;

import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.composite.Text;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextVisitor implements Visitor {
    public final Logger logger = Logger.getLogger(TextVisitor.class);

    public void visit(Text text, TextType type) {
        if (text.getType().equals(type) && text.getParts().size() > 1) {
            Text cloneText = text;
            int size = cloneText.getParts().size();
            Text firstTextPart = cloneText.getParts().get(0);
            Text lastTextPart = cloneText.getPart(size - 1);
            String buffer = firstTextPart.getPunctuation();
            firstTextPart.setPunctuation(lastTextPart.getPunctuation());
            lastTextPart.setPunctuation(buffer);
            String baf = firstTextPart.getWhiteSpace();
            firstTextPart.setWhiteSpace(lastTextPart.getWhiteSpace());
            lastTextPart.setWhiteSpace(baf);
            cloneText.getParts().set(0, lastTextPart);
            cloneText.getParts().set(size - 1, firstTextPart);
            cloneText.print();

        }
    }

}
