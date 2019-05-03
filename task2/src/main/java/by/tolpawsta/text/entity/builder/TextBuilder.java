package by.tolpawsta.text.entity.builder;

import by.tolpawsta.text.utils.TextAssistant;
import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.composite.CompositeText;
import by.tolpawsta.text.entity.composite.LeafText;
import by.tolpawsta.text.entity.composite.Text;

import java.util.List;

public class TextBuilder implements Builder {
   public String value="";
   public TextType type;
   public List<Text> parts;
   TextAssistant assistant;
    public TextBuilder() {
        assistant = TextAssistant.getInstance();
    }

    public Builder withText(String value) {
this.value=value;
        return this;
    }

    public Builder withType(TextType type) {
        this.type=type;
        return this;
    }

    public Builder withParts(TextType type) {
        String pattern=assistant.getPatternByTextType(type);
        TextType partType=TextType.getType(type.ordinal() + 1);
        List<String> values= assistant.parseText(pattern,this.value);
        if (this.type.equals(TextType.WORD))
        {
            for (String value : values) {
                parts.add(new TextBuilder().withType(partType).withText(value).build());
            }
        }else {
            for (String value : values) {
                parts.add(new TextBuilder().withType(type).withText(value).withParts(partType).build());
            }
        }
        return this;
    }

    public Builder withLetter() {

        return this;
    }

    public Text build(){
        if (this.type.equals(TextType.LETTER)) {
           return new LeafText(this);
        }
        return new CompositeText(this);

    }

}
