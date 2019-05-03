package by.tolpawsta.text.entity.visitor;

import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.composite.CompositeText;
import by.tolpawsta.text.entity.composite.LeafText;

public interface Visitor {
    void visitComposite(CompositeText compositeText, TextType type);
    void visitLeaf(LeafText leafText, TextType type);
}
