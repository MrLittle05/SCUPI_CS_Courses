package utils;

public class Coder {
    private static String code[] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", 
            "...", "-", "..-", "...-", ".--", "-..-", 
            "-.--", "--.."};

    public static String encode(char c) {
        String str="?";
        
        if ((c>='a')&&((c<='z'))) {
            // TODO: lookup string from the table
            str = code[c-'a'];
        } else if( c ==' ' || c == '\t' ) {
            str = c+"";
        }
        return str;
    }
}
