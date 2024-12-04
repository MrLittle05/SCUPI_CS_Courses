import java.io.*;

import utils.*;

/**
 * This class takes in characters from standard in, and 
 * writes their morse code equivalents to standard out.
 * The actual conversion code is located in the Coder 
 * @author Richard Warburton
 */
public class Morse {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        while((inputLine=console.readLine())!=null) {
            for(int i = 0;i<inputLine.length();i++) {
                System.out.print(Coder.encode(inputLine.charAt(i)));
            }
            System.out.println();
        }
    }
}
