import utils.*;

/**
    Convert Morse to Text using a binary tree
*/
public class Esrom {
    public static void main(String[] args) {
        Decoder d = new Decoder();
        
        // convert each command line argument
        // separately
        for (int i=0;i<args.length;i++) {
            System.out.print(d.decode(args[i]));
        }
        System.out.println();
    }
}
