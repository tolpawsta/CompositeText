package by.tolpawsta.text.entity.composite;

import by.tolpawsta.text.entity.builder.TextBuilder;
import by.tolpawsta.text.entity.visitor.Visitor;
import org.apache.log4j.Logger;

import java.util.List;

public class LeafText extends Text {
public final Logger logger=Logger.getLogger(LeafText.class);
    public LeafText(TextBuilder builder) {
         super(builder);
         this.type=builder.type;
         this.value=builder.value;
    }

    public void addPart(Text text) {
        throw new UnsupportedOperationException();
    }

    public void removePart(Text text) {
        throw new UnsupportedOperationException();
    }

    public List<Text> getParts() {
        throw new UnsupportedOperationException();
    }

    public Text getPart(int index) {
        return this;
    }

    public void print() {
         logger.info(value);

    }
    @Override
    public void accept(Visitor visitor, TextType type){
        visitor.visitLeaf(this,type);
    }
}
