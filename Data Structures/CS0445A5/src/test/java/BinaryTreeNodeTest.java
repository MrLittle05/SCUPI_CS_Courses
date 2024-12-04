import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import stores.*;

public class BinaryTreeNodeTest {
    BinaryTreeNode<String> myBinaryTreeNode = new BinaryTreeNode<>("hotel");

    @BeforeEach
    public void setupBinraryTreeNode() {
        myBinaryTreeNode = new BinaryTreeNode<>("hotel");
    }

    @Test
    void testGetValue() {
        assertTrue(myBinaryTreeNode.getValue().equals("hotel"));
    }

    @Test
    void testGetLeftDefault() {
        assertTrue(myBinaryTreeNode.getLeft() == null);
    }

    @Test
    void testGetRightDefault() {
        assertTrue(myBinaryTreeNode.getRight() == null);
    }

    @Test
    void testSetLeftViaGet() {
        BinaryTreeNode<String> left = new BinaryTreeNode<>("foxtrot");
        myBinaryTreeNode.setLeft(left);
        assertTrue(myBinaryTreeNode.getLeft().equals(left));
    }

    @Test
    void testSetRightViaGet() {
        BinaryTreeNode<String> right = new BinaryTreeNode<>("tango");
        myBinaryTreeNode.setRight(right);
        assertTrue(myBinaryTreeNode.getRight().equals(right));
    }
}
