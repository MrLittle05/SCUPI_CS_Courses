/**
 * A vector of Strings program
 */
import java.util.ArrayList;

public class ArrayListProgram {

    public static void main(String args[]) {
        // Initialization of ArrayList, holding String objects
        ArrayList<String> words = new ArrayList<>(); 

        words.add("I");
        words.add("am");
        words.add("the");
        words.add("eggman");
		
		// The three operations
		// Operation 1
        words.add("We");
        words.add("are");
        words.add("the");
        words.add("eggmen");
		// Operation 2
        words.add(7,"middle");
		// Operation 3
        words.remove(1);
        
        System.out.println(words);
    }
}
