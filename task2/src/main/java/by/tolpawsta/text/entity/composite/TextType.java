package by.tolpawsta.text.entity.composite;

public enum TextType {
   TEXT, PARAGRAPH, SENTENCE, WORD, LETTER;

   public static TextType getType(int index){
    switch (index){
       case 0:return TextType.TEXT;
       case 1:return TextType.PARAGRAPH;
       case 2:return TextType.SENTENCE;
       case 3:return TextType.WORD;
       case 4:return TextType.LETTER;

    }
    return null;
   }
   public static boolean isExist(String text){
       for (TextType type:TextType.values()) {
           if (type.equals(text)) return true;
       }
       return false;
   }
}
