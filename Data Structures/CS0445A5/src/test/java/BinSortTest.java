import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinSortTest {
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
    void testBinSort() {
        BinSort.main(null);
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("" + 
				"Adding 2 to root.\r\n" + 
				"Adding 4 to right sub-tree of 2\r\n" + 
				"Adding 1 to left sub-tree of 2\r\n" + 
				"Adding 5 to right sub-tree of 2\r\n" + 
				"Adding 5 to right sub-tree of 4\r\n" + 
				"Adding 3 to right sub-tree of 2\r\n" + 
				"Adding 3 to left sub-tree of 4\r\n" + 
				"----- In Order -----\r\n" +
				"Inorder traversal: \"1\" \"2\" \"3\" \"4\" \"5\" \r\n" +
				"----- Pre Order -----\r\n" +
				"Preorder traversal: \"2\" \"1\" \"4\" \"3\" \"5\" \r\n"+
				"----- Post Order -----\r\n" + 
				"Postorder traversal: \"1\" \"3\" \"5\" \"4\" \"2\" \r\n"
			));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("" + 
				"Adding 2 to root.\n" + 
				"Adding 4 to right sub-tree of 2\n" + 
				"Adding 1 to left sub-tree of 2\n" + 
				"Adding 5 to right sub-tree of 2\n" + 
				"Adding 5 to right sub-tree of 4\n" + 
				"Adding 3 to right sub-tree of 2\n" + 
				"Adding 3 to left sub-tree of 4\n" + 
				"----- In Order -----\n" +
				"Inorder traversal: \"1\" \"2\" \"3\" \"4\" \"5\" \n" +
				"----- Pre Order -----\n" +
				"Preorder traversal: \"2\" \"1\" \"4\" \"3\" \"5\" \n"+
				"----- Post Order -----\n" + 
				"Postorder traversal: \"1\" \"3\" \"5\" \"4\" \"2\" \n"
			));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("" + 
				"Adding 2 to root.\n" + 
				"Adding 4 to right sub-tree of 2\n" + 
				"Adding 1 to left sub-tree of 2\n" + 
				"Adding 5 to right sub-tree of 2\n" + 
				"Adding 5 to right sub-tree of 4\n" + 
				"Adding 3 to right sub-tree of 2\n" + 
				"Adding 3 to left sub-tree of 4\n" + 
				"----- In Order -----\n" +
				"Inorder traversal: \"1\" \"2\" \"3\" \"4\" \"5\" \n" +
				"----- Pre Order -----\n" +
				"Preorder traversal: \"2\" \"1\" \"4\" \"3\" \"5\" \n"+
				"----- Post Order -----\n" + 
				"Postorder traversal: \"1\" \"3\" \"5\" \"4\" \"2\" \n"
			));
			break;
		}
    }
}
