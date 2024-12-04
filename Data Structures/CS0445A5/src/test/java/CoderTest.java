import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import utils.*;

public class CoderTest {
    Coder myCoder = new Coder();

    @BeforeEach
    public void setupCoder() {
        myCoder = new Coder();
    }

    @Test
    void testEncodeA() {
        assertTrue(myCoder.encode('a').equals(".-"));
    }

    @Test
    void testEncodeB() {
        assertTrue(myCoder.encode('b').equals("-..."));
    }

    @Test
    void testEncodeC() {
        assertTrue(myCoder.encode('c').equals("-.-."));
    }

    @Test
    void testEncodeD() {
        assertTrue(myCoder.encode('d').equals("-.."));
    }

    @Test
    void testEncodeE() {
        assertTrue(myCoder.encode('e').equals("."));
    }

    @Test
    void testEncodeF() {
        assertTrue(myCoder.encode('f').equals("..-."));
    }

    @Test
    void testEncodeG() {
        assertTrue(myCoder.encode('g').equals("--."));
    }

    @Test
    void testEncodeH() {
        assertTrue(myCoder.encode('h').equals("...."));
    }

    @Test
    void testEncodeI() {
        assertTrue(myCoder.encode('i').equals(".."));
    }

    @Test
    void testEncodeJ() {
        assertTrue(myCoder.encode('j').equals(".---"));
    }

    @Test
    void testEncodeK() {
        assertTrue(myCoder.encode('k').equals("-.-"));
    }

    @Test
    void testEncodeL() {
        assertTrue(myCoder.encode('l').equals(".-.."));
    }

    @Test
    void testEncodeM() {
        assertTrue(myCoder.encode('m').equals("--"));
    }

    @Test
    void testEncodeN() {
        assertTrue(myCoder.encode('n').equals("-."));
    }

    @Test
    void testEncodeO() {
        assertTrue(myCoder.encode('o').equals("---"));
    }

    @Test
    void testEncodeP() {
        assertTrue(myCoder.encode('p').equals(".--."));
    }

    @Test
    void testEncodeQ() {
        assertTrue(myCoder.encode('q').equals("--.-"));
    }

    @Test
    void testEncodeR() {
        assertTrue(myCoder.encode('r').equals(".-."));
    }

    @Test
    void testEncodeS() {
        assertTrue(myCoder.encode('s').equals("..."));
    }
    
    @Test
    void testEncodeT() {
        assertTrue(myCoder.encode('t').equals("-"));
    }
    
    @Test
    void testEncodeU() {
        assertTrue(myCoder.encode('u').equals("..-"));
    }
    
    @Test
    void testEncodeV() {
        assertTrue(myCoder.encode('v').equals("...-"));
    }
    
    @Test
    void testEncodeW() {
        assertTrue(myCoder.encode('w').equals(".--"));
    }
    
    @Test
    void testEncodeX() {
        assertTrue(myCoder.encode('x').equals("-..-"));
    }
    
    @Test
    void testEncodeY() {
        assertTrue(myCoder.encode('y').equals("-.--"));
    }
    
    @Test
    void testEncodeZ() {
        assertTrue(myCoder.encode('z').equals("--.."));
    }

    @Test
    void testEncodeSpace() {
        assertTrue(myCoder.encode(' ').equals(" "));
    }
    
    @Test
    void testEncodeTab() {
        assertTrue(myCoder.encode('\t').equals("\t"));
    }

    @Test
    void testEncodeUnknown() {
        assertTrue(myCoder.encode('.').equals("?"));
    }

}
