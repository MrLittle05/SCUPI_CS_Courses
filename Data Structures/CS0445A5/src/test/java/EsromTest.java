import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EsromTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orgOut = System.out;

	private static OS os = null;
	
	private enum OS {
		WINDOWS, LINUX, MAC, SOLARIS
	};// Operating systems.

    private static OS getOS() {
        if (os == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                os = OS.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                os = OS.LINUX;
            } else if (operSys.contains("mac")) {
                os = OS.MAC;
            } else if (operSys.contains("sunos")) {
                os = OS.SOLARIS;
            }
        }
        return os;
    }

    @BeforeEach
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(orgOut);
        System.out.println(outContent.toString());
    }

    @Test
    void testEsromDot() {
        String[] esromArgs = {"."};
        Esrom.main(esromArgs);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("e\r\n"));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("e\n"));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("e\n"));
			break;
		}
    }

    @Test
    void testEsromDash() {
        String[] esromArgs = {"-"};
        Esrom.main(esromArgs);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("t\r\n"));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("t\n"));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("t\n"));
			break;
		}
    }

    @Test
    void testEsromDotDot() {
        String[] esromArgs = {".."};
        Esrom.main(esromArgs);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("i\r\n"));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("i\n"));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("i\n"));
			break;
		}
    }

    @Test
    void testEsromDotDash() {
        String[] esromArgs = {".-"};
        Esrom.main(esromArgs);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("a\r\n"));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("a\n"));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("a\n"));
			break;
		}
    }

    @Test
    void testEsromDashDot() {
        String[] esromArgs = {"-."};
        Esrom.main(esromArgs);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("n\r\n"));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("n\n"));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("n\n"));
			break;
		}
    }

    @Test
    void testEsromDashDash() {
        String[] esromArgs = {"--"};
        Esrom.main(esromArgs);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("m\r\n"));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("m\n"));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("m\n"));
			break;
		}
    }

    @Test
    void testEsromMultiple() {
        String[] esromArgs = { ".", "-", ".-", "--", "..", "-."};
        Esrom.main(esromArgs);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("etamin\r\n"));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("etamin\n"));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("etamin\n"));
			break;
		}
    }

    @Test
    void testEsromExercise2() {
        int counter = 0;
        String[] esromArgs = new String[1];
        String[] allCases = {"-...", "-.-.", "-..", "..-.", "--.", "....", ".---", "-.-", ".-..", "---", ".--.", "--.-", ".-.", "...", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] answers = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "o", "p", "q", "r", "s", "u", "v", "w", "x", "y", "z"};



        assertTrue(allCases.length == answers.length);

        for (int i = 0; i < allCases.length; i++) {
            esromArgs[0] = allCases[i];
            
            ByteArrayOutputStream tmpContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(tmpContent));
            Esrom.main(esromArgs);
			switch (getOS()) {
			case WINDOWS:
				if (tmpContent.toString().equals(answers[i]+"\r\n")) {
					counter++;
				}
				break;
			case LINUX:
				if (tmpContent.toString().equals(answers[i]+"\n")) {
					counter++;
				}
				break;
			case MAC:
				if (tmpContent.toString().equals(answers[i]+"\n")) {
					counter++;
				}
				break;
			}
            
            System.setOut(new PrintStream(outContent));
            System.out.print("Input: " + allCases[i] + "\tExpected: " + answers[i] + "\t Found: " + tmpContent);
            if (outContent.toString().charAt(outContent.toString().length()-1) != '\n') {
                System.out.println();
            }
        }

        System.out.println("\nCount correct: " + counter);

        assertTrue(counter > 4);
    }
}
