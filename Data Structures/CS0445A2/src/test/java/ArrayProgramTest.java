import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayProgramTest {
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
    void getMainOutput() {
        ArrayProgram.main(null);
		switch (getOS()) {
		case WINDOWS:
			assertEquals("I\r\nam\r\nthe\r\neggman\r\n", outContent.toString());
			break;
		case LINUX:
			assertEquals("I\nam\nthe\neggman\n", outContent.toString());
			break;
		case MAC:
			assertEquals("I\ram\rthe\reggman\r", outContent.toString());
			break;
		}
    }
}
