package by.tolpawsta.text.entity.builder;

import by.tolpawsta.text.utils.TextAssistant;
import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.composite.CompositeText;
import by.tolpawsta.text.entity.composite.LeafText;
import by.tolpawsta.text.entity.composite.Text;

import java.util.ArrayList;
import java.util.List;

public class TextBuilder implements Builder {
    public String value;
    public TextType type;
    public String punctuation;
    public String whiteSpace = "";
    public List<Text> parts = new ArrayList<Text>();
    private int indexType;
    TextAssistant assistant;

    public TextBuilder() {
        assistant = TextAssistant.getInstance();
    }

    public Builder withText(String value) {
        indexType = type.ordinal();
        this.value = (indexType > 1 && indexType < 4) ? assistant.getValue(value) : value;
        return this;
    }

    public Builder withPunctuation(String value) {
        this.punctuation = assistant.getPuntuation(value);
        return this;
    }

    public Builder withWhiteSpace() {
        this.whiteSpace = assistant.getWhiteSpace(this.type);
        return this;
    }

    public Builder withType(TextType type) {
        this.type = type;
        return this;
    }

    public Builder withParts(TextType type) {
        String pattern = assistant.getPatternByTextType(type);
        int indexTypeParts = type.ordinal();
        TextType partType = TextType.getType(indexTypeParts + 1);
        List<String> values = assistant.parseText(pattern, this.value);
        if (this.type.equals(TextType.WORD)) {
            for (String value : values) {
                Text text = new TextBuilder().withType(type).withText(value).build();
                this.parts.add(text);
            }
        } else {
            if (indexTypeParts > 1 && indexTypeParts < 4) {
                for (int i = 0; i < values.size() - 1; i++) {
                    String value = values.get(i);
                    this.parts.add(new TextBuilder()
                            .withType(type)
                            .withPunctuation(value)
                            .withText(value)
                            .withWhiteSpace()
                            .withParts(partType)
                            .build());
                }
                String lastValue = values.get(values.size() - 1);
                if (partType.equals("Word")) {
                    lastValue = values.get(values.size() - 2);
                }
                this.parts.add(new TextBuilder()
                        .withType(type)
                        .withPunctuation(lastValue)
                        .withText(lastValue)
                        .withParts(partType)
                        .build());

            } else {
                for (int i = 0; i < values.size() - 2; i++) {
                    this.parts.add(new TextBuilder()
                            .withType(type)
                            .withText(value)
                            .withParts(partType)
                            .build());
                }


            }
        }
        return this;
    }


    public Text build() {
        if (this.type.equals(TextType.LETTER)) {
            return new LeafText(this);
        }
        return new CompositeText(this);

    }

}
