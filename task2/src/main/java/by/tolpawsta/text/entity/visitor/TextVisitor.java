package by.tolpawsta.text.entity.visitor;

import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.composite.CompositeText;
import by.tolpawsta.text.entity.composite.LeafText;
import by.tolpawsta.text.entity.composite.Text;

public class TextVisitor implements Visitor {
    public void visitComposite(CompositeText compositeText, TextType type) {
        if (compositeText.getType()==type){
            int size=compositeText.getParts().size();
            if(size>1){
           Text bufComposite = compositeText.getPart(0);
           compositeText.getParts().set(0,compositeText.getPart(size-1));
           compositeText.getParts().set(size-1,bufComposite);
            }

        }
    }
///TODO: Надо что-то сделать с методом visitLeaf
    public void visitLeaf(LeafText leafText, TextType type) {

        }
}
