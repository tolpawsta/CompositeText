package by.tolpawsta.text.entity.builder;

import by.tolpawsta.text.entity.composite.TextType;
import by.tolpawsta.text.entity.composite.Text;

public interface Builder {
    public Text build();
    public Builder withText(String value);
    public Builder withType(TextType type);
    public Builder withParts(TextType type);
    public Builder withLetter();


}
