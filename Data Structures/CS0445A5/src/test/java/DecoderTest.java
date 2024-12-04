import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import utils.*;

public class DecoderTest {
    Decoder myDecoder = new Decoder();

    @BeforeEach
    public void setupDecoder() {
        myDecoder = new Decoder();
    }

    @Test
    void testDecodeDot() {
        assertTrue(myDecoder.decode(".").equals("e"));
    }

    @Test
    void testDecodeDash() {
        assertTrue(myDecoder.decode("-").equals("t"));
    }

    @Test
    void testDecodeDotDot() {
        assertTrue(myDecoder.decode("..").equals("i"));
    }
    @Test
    void testDecodeDotDash() {
        assertTrue(myDecoder.decode(".-").equals("a"));
    }

    @Test
    void testDecodeDashDot() {
        assertTrue(myDecoder.decode("-.").equals("n"));
    }

    @Test
    void testDecodeDashDash() {
        assertTrue(myDecoder.decode("--").equals("m"));
    }

    @Test
    void testDecodeExercise2() {
        int counter = 0;
        String[] allCases = {"-...", "-.-.", "-..", "..-.", "--.", "....", ".---", "-.-", ".-..", "---", ".--.", "--.-", ".-.", "...", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] answers = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "o", "p", "q", "r", "s", "u", "v", "w", "x", "y", "z"};

        for (int i = 0; i < allCases.length; i++) {
            String result = myDecoder.decode(allCases[i]);
            if(result.equals(answers[i])) {
                counter++;
            }
            System.out.print("Input: " + allCases[i] + "\tExpected: " + answers[i] + "\t Found: " + result + "\n");
        }

        System.out.println("\nCount correct: " + counter);

        assertTrue(counter > 4);
    }

    @Test
    void testDecode2Dot() {
        assertTrue(myDecoder.decode2(".").equals("e"));
    }

    @Test
    void testDecode2Dash() {
        assertTrue(myDecoder.decode2("-").equals("t"));
    }

    @Test
    void testDecode2DotDot() {
        assertTrue(myDecoder.decode2("..").equals("i"));
    }

    @Test
    void testDecode2DotDash() {
        assertTrue(myDecoder.decode2(".-").equals("a"));
    }

    @Test
    void testDecode2DashDot() {
        assertTrue(myDecoder.decode2("-.").equals("n"));
    }

    @Test
    void testDecode2DashDash() {
        assertTrue(myDecoder.decode2("--").equals("m"));
    }

    @Test
    void testDecode2Exercise2() {
        int counter = 0;
        String[] allCases = {"-...", "-.-.", "-..", "..-.", "--.", "....", ".---", "-.-", ".-..", "---", ".--.", "--.-", ".-.", "...", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        String[] answers = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "o", "p", "q", "r", "s", "u", "v", "w", "x", "y", "z" };

        for (int i = 0; i < allCases.length; i++) {
            String result = myDecoder.decode(allCases[i]);
            if (result.equals(answers[i])) {
                counter++;
            }
            System.out.print("Input: " + allCases[i] + "\tExpected: " + answers[i] + "\t Found: " + result + "\n");
        }

        System.out.println("\nCount correct: " + counter);

        assertTrue(counter > 4);
    }
}
