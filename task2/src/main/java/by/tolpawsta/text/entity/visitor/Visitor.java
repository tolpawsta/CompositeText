package by.tolpawsta.text.entity.visitor;

import by.tolpawsta.text.entity.composite.Text;
import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.composite.CompositeText;
import by.tolpawsta.text.entity.composite.LeafText;

public interface Visitor {
    void visit(Text text, TextType type);

}
