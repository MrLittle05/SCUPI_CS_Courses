import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CS0445A3Test {
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
    void getMainOutputExercise2() {
        String[] args = {"A. N. Other"};
        CS0445A3.main(args);
		switch (getOS()) {
		case WINDOWS:
			assertEquals("[]\r\n[A. N. Other]\r\n", outContent.toString());
			break;
		case LINUX:
			assertEquals("[]\n[A. N. Other]\n", outContent.toString());
			break;
		case MAC:
			assertEquals("[]\n[A. N. Other]\n", outContent.toString());
			break;
		}
    }

    @Test
    void getMainOutputExercise3() {
        String[] args = {"A. N. Other", "J. Doe"};
        CS0445A3.main(args);
		switch (getOS()) {
		case WINDOWS:
			assertEquals("[]\r\n[A. N. Other]\r\n[A. N. Other, J. Doe]\r\n[J. Doe]\r\n", outContent.toString());
			break;
		case LINUX:
			assertEquals("[]\n[A. N. Other]\n[A. N. Other, J. Doe]\n[J. Doe]\n", outContent.toString());
			break;
		case MAC:
			assertEquals("[]\n[A. N. Other]\n[A. N. Other, J. Doe]\n[J. Doe]\n", outContent.toString());
			break;
		}
    }
}
