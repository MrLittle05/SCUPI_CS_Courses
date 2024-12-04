import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import stores.*;

public class BinaryTreeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orgOut = System.out;
    private BinaryTree<String> myBinaryTree = new BinaryTree<>();

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

    @BeforeEach
    public void resetBinaryTree() {
        myBinaryTree = new BinaryTree<>();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(orgOut);
        System.out.println(outContent.toString());
    }

    @Test
    void testAddRoot() {
        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\r\n"
			));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\n"
			));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\n"
			));
			break;
		}
    }

    @Test
    void testAddLeft() {
        myBinaryTree.add("hotel");
        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\r\n" + 
				"Adding foxtrot to left sub-tree of hotel\r\n"
			));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\n" + 
				"Adding foxtrot to left sub-tree of hotel\n"
			));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\n" + 
				"Adding foxtrot to left sub-tree of hotel\n"
			));
			break;
		}
    }

    @Test
    void testAddRight() {
        myBinaryTree.add("hotel");
        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\r\n" + 
				"Adding tango to right sub-tree of hotel\r\n"
			));
			break;
		case LINUX:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\n" + 
				"Adding tango to right sub-tree of hotel\n"
			));
			break;
		case MAC:
			assertTrue(outContent.toString().equals("" + 
				"Adding hotel to root.\n" + 
				"Adding tango to right sub-tree of hotel\n"
			));
			break;
		}
    }

    @Test
    void testAddLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		}
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding tango to right sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		}
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("delta");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding delta to left sub-tree of hotel\r\n" +
				"Adding delta to left sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
				"Adding delta to left sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
				"Adding delta to left sub-tree of foxtrot\n";
			break;
		}
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("golf");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding golf to left sub-tree of hotel\r\n" + 
				"Adding golf to right sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding golf to left sub-tree of hotel\n" + 
				"Adding golf to right sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding golf to left sub-tree of hotel\n" + 
				"Adding golf to right sub-tree of foxtrot\n";
			break;
		}
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("lema");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding lema to right sub-tree of hotel\r\n" +
				"Adding lema to left sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
				"Adding lema to left sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
				"Adding lema to left sub-tree of tango\n";
			break;
		}
        assertTrue(outContent.toString().equals(currentOutput));

        myBinaryTree.add("xray");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding xray to right sub-tree of hotel\r\n" +
				"Adding xray to right sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
				"Adding xray to right sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
				"Adding xray to right sub-tree of tango\n";
			break;
		}
        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderRoot() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.traversalInOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Inorder traversal: \"hotel\" \r\n";
			break;
		case LINUX:
			currentOutput += "Inorder traversal: \"hotel\" \n";
			break;
		case MAC:
			currentOutput += "Inorder traversal: \"hotel\" \n";
			break;
		}
        
        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderLeft() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		}

        myBinaryTree.traversalInOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Inorder traversal: \"foxtrot\" \"hotel\" \r\n";
			break;
		case LINUX:
			currentOutput += "Inorder traversal: \"foxtrot\" \"hotel\" \n";
			break;
		case MAC:
			currentOutput += "Inorder traversal: \"foxtrot\" \"hotel\" \n";
			break;
		}
        
        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderRight() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
	        currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
	        currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
	        currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding tango to right sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		}

        myBinaryTree.traversalInOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Inorder traversal: \"hotel\" \"tango\" \r\n";
			break;
		case LINUX:
			currentOutput += "Inorder traversal: \"hotel\" \"tango\" \n";
			break;
		case MAC:
			currentOutput += "Inorder traversal: \"hotel\" \"tango\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalInOrderLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		}

        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding tango to right sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		}

        myBinaryTree.add("delta");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding delta to left sub-tree of hotel\r\n" +
					"Adding delta to left sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
					"Adding delta to left sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
					"Adding delta to left sub-tree of foxtrot\n";
			break;
		}

        myBinaryTree.add("golf");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding golf to left sub-tree of hotel\r\n" +
					"Adding golf to right sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding golf to left sub-tree of hotel\n" +
					"Adding golf to right sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding golf to left sub-tree of hotel\n" +
					"Adding golf to right sub-tree of foxtrot\n";
			break;
		}

        myBinaryTree.add("lema");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding lema to right sub-tree of hotel\r\n" +
					"Adding lema to left sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
					"Adding lema to left sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
					"Adding lema to left sub-tree of tango\n";
			break;
		}

        myBinaryTree.add("xray");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding xray to right sub-tree of hotel\r\n" +
					"Adding xray to right sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
					"Adding xray to right sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
					"Adding xray to right sub-tree of tango\n";
			break;
		}

        myBinaryTree.traversalInOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Inorder traversal: \"delta\" \"foxtrot\" \"golf\" \"hotel\" \"lema\" \"tango\" \"xray\" \r\n";
			break;
		case LINUX:
			currentOutput += "Inorder traversal: \"delta\" \"foxtrot\" \"golf\" \"hotel\" \"lema\" \"tango\" \"xray\" \n";
			break;
		case MAC:
			currentOutput += "Inorder traversal: \"delta\" \"foxtrot\" \"golf\" \"hotel\" \"lema\" \"tango\" \"xray\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderRoot() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.traversalPreOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Preorder traversal: \"hotel\" \r\n";
			break;
		case LINUX:
			currentOutput += "Preorder traversal: \"hotel\" \n";
			break;
		case MAC:
			currentOutput += "Preorder traversal: \"hotel\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderLeft() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		}

        myBinaryTree.traversalPreOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \r\n";
			break;
		case LINUX:
			currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \n";
			break;
		case MAC:
			currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderRight() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding tango to right sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		}

        myBinaryTree.traversalPreOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Preorder traversal: \"hotel\" \"tango\" \r\n";
			break;
		case LINUX:
			currentOutput += "Preorder traversal: \"hotel\" \"tango\" \n";
			break;
		case MAC:
			currentOutput += "Preorder traversal: \"hotel\" \"tango\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPreOrderLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		}

        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding tango to right sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		}

        myBinaryTree.add("delta");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding delta to left sub-tree of hotel\r\n" +
					"Adding delta to left sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
					"Adding delta to left sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
					"Adding delta to left sub-tree of foxtrot\n";
			break;
		}

        myBinaryTree.add("golf");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding golf to left sub-tree of hotel\r\n" +
					"Adding golf to right sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding golf to left sub-tree of hotel\n" +
					"Adding golf to right sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding golf to left sub-tree of hotel\n" +
					"Adding golf to right sub-tree of foxtrot\n";
			break;
		}

        myBinaryTree.add("lema");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding lema to right sub-tree of hotel\r\n" +
					"Adding lema to left sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
					"Adding lema to left sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
					"Adding lema to left sub-tree of tango\n";
			break;
		}

        myBinaryTree.add("xray");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding xray to right sub-tree of hotel\r\n" +
					"Adding xray to right sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
					"Adding xray to right sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
					"Adding xray to right sub-tree of tango\n";
			break;
		}

        myBinaryTree.traversalPreOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \"delta\" \"golf\" \"tango\" \"lema\" \"xray\" \r\n";
			break;
		case LINUX:
			currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \"delta\" \"golf\" \"tango\" \"lema\" \"xray\" \n";
			break;
		case MAC:
			currentOutput += "Preorder traversal: \"hotel\" \"foxtrot\" \"delta\" \"golf\" \"tango\" \"lema\" \"xray\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderRoot() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.traversalPostOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Postorder traversal: \"hotel\" \r\n";
			break;
		case LINUX:
			currentOutput += "Postorder traversal: \"hotel\" \n";
			break;
		case MAC:
			currentOutput += "Postorder traversal: \"hotel\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderLeft() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		}

        myBinaryTree.traversalPostOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Postorder traversal: \"foxtrot\" \"hotel\" \r\n";
			break;
		case LINUX:
			currentOutput += "Postorder traversal: \"foxtrot\" \"hotel\" \n";
			break;
		case MAC:
			currentOutput += "Postorder traversal: \"foxtrot\" \"hotel\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderRight() {
        String currentOutput = "";

        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding tango to right sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		}

        myBinaryTree.traversalPostOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Postorder traversal: \"tango\" \"hotel\" \r\n";
			break;
		case LINUX:
			currentOutput += "Postorder traversal: \"tango\" \"hotel\" \n";
			break;
		case MAC:
			currentOutput += "Postorder traversal: \"tango\" \"hotel\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }

    @Test
    void testTraversalPostOrderLots() {
        String currentOutput = "";
        myBinaryTree.add("hotel");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding hotel to root.\r\n";
			break;
		case LINUX:
			currentOutput += "Adding hotel to root.\n";
			break;
		case MAC:
			currentOutput += "Adding hotel to root.\n";
			break;
		}

        myBinaryTree.add("foxtrot");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding foxtrot to left sub-tree of hotel\n";
			break;
		}

        myBinaryTree.add("tango");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding tango to right sub-tree of hotel\r\n";
			break;
		case LINUX:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		case MAC:
			currentOutput += "Adding tango to right sub-tree of hotel\n";
			break;
		}

        myBinaryTree.add("delta");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding delta to left sub-tree of hotel\r\n" +
					"Adding delta to left sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
					"Adding delta to left sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding delta to left sub-tree of hotel\n" +
					"Adding delta to left sub-tree of foxtrot\n";
			break;
		}

        myBinaryTree.add("golf");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding golf to left sub-tree of hotel\r\n" +
					"Adding golf to right sub-tree of foxtrot\r\n";
			break;
		case LINUX:
			currentOutput += "Adding golf to left sub-tree of hotel\n" +
					"Adding golf to right sub-tree of foxtrot\n";
			break;
		case MAC:
			currentOutput += "Adding golf to left sub-tree of hotel\n" +
					"Adding golf to right sub-tree of foxtrot\n";
			break;
		}

        myBinaryTree.add("lema");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding lema to right sub-tree of hotel\r\n" +
					"Adding lema to left sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
					"Adding lema to left sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding lema to right sub-tree of hotel\n" +
					"Adding lema to left sub-tree of tango\n";
			break;
		}

        myBinaryTree.add("xray");
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Adding xray to right sub-tree of hotel\r\n" +
					"Adding xray to right sub-tree of tango\r\n";
			break;
		case LINUX:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
					"Adding xray to right sub-tree of tango\n";
			break;
		case MAC:
			currentOutput += "Adding xray to right sub-tree of hotel\n" +
					"Adding xray to right sub-tree of tango\n";
			break;
		}

        myBinaryTree.traversalPostOrder();
		switch (getOS()) {
		case WINDOWS:
			currentOutput += "Postorder traversal: \"delta\" \"golf\" \"foxtrot\" \"lema\" \"xray\" \"tango\" \"hotel\" \r\n";
			break;
		case LINUX:
			currentOutput += "Postorder traversal: \"delta\" \"golf\" \"foxtrot\" \"lema\" \"xray\" \"tango\" \"hotel\" \n";
			break;
		case MAC:
			currentOutput += "Postorder traversal: \"delta\" \"golf\" \"foxtrot\" \"lema\" \"xray\" \"tango\" \"hotel\" \n";
			break;
		}

        assertTrue(outContent.toString().equals(currentOutput));
    }
}
