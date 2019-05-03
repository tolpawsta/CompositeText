package by.tolpawsta.text;

import by.tolpawsta.text.entity.builder.Builder;
import by.tolpawsta.text.entity.builder.TextBuilder;
import by.tolpawsta.text.entity.composite.CompositeText;
import by.tolpawsta.text.entity.composite.Text;
import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.visitor.TextVisitor;
import by.tolpawsta.text.entity.visitor.Visitor;
import by.tolpawsta.text.utils.TextAssistant;
import org.apache.log4j.Logger;

import java.io.File;

public class AppText {
    public final static Logger logger=Logger.getLogger(AppText.class);
    public static void main(String[] args){
        TextAssistant assistant=TextAssistant.getInstance();
       StringBuilder pathFile= new StringBuilder();
       pathFile.append(new File("").getAbsolutePath()+"\\src\\main\\resources\\text.txt");
                //"D:\text.txt";
        String inFileText=assistant.loadTextFromFile(pathFile.toString());
        logger.info(inFileText);


        Text text =new TextBuilder().withText(inFileText).withType(TextType.TEXT).withParts(TextType.PARAGRAPH).build();

        text.print();
        Visitor visitor=new TextVisitor();
        text.accept(visitor,TextType.SENTENCE);
    }
}
