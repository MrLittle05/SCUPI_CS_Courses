import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ThreadLocalRandom;

public class CalculatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream orgOut = System.out;
    private Calculator calc = new Calculator();
    
    @BeforeEach
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    public void resetCalculator() {
        calc = new Calculator();
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(orgOut);
        System.out.println(outContent.toString());
    }

    @Test
    void testDigit0() {
        assertTrue(calc.newValueToken(0) == 0);
    }

    @Test
    void testDigit1() {
        assertTrue(calc.newValueToken(1) == 1);
    }

    @Test
    void testDigit2() {
        assertTrue(calc.newValueToken(2) == 2);
    }

    @Test
    void testDigit3() {
        assertTrue(calc.newValueToken(3) == 3);
    }

        @Test
    void testDigit4() {
        assertTrue(calc.newValueToken(4) == 4);
    }

    @Test
    void testDigit5() {
        assertTrue(calc.newValueToken(5) == 5);
    }

    @Test
    void testDigit6() {
        assertTrue(calc.newValueToken(6) == 6);
    }

    @Test
    void testDigit7() {
        assertTrue(calc.newValueToken(7) == 7);
    }

    @Test
    void testDigit8() {
        assertTrue(calc.newValueToken(8) == 8);
    }

    @Test
    void testDigit9() {
        assertTrue(calc.newValueToken(9) == 9);
    }

    @Test
    void testPlusPosPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(0, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newPlus() == (rand1 + rand2));
    }

    @Test
    void testPlusPosNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 1);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newPlus() == (rand1 + rand2));
    }

    @Test
    void testPlusNegPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(0, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newPlus() == (rand1 + rand2));
    }

    @Test
    void testPlusNegNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 1);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newPlus() == (rand1 + rand2));
    }

    @Test
    void testMinusPosPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(0, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMinus() == (rand1 - rand2));
    }

    @Test
    void testMinusPosNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 1);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMinus() == (rand1 - rand2));
    }

    @Test
    void testMinusNegPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(0, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMinus() == (rand1 - rand2));
    }

    @Test
    void testMinusNegNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 1);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMinus() == (rand1 - rand2));
    }

    @Test
    void testMultiplyPosPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(0, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMultiply() == (rand1 * rand2));
    }

    @Test
    void testMultiplyPosNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 1);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMultiply() == (rand1 * rand2));
    }

    @Test
    void testMultiplyNegPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(0, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMultiply() == (rand1 * rand2));
    }

    @Test
    void testMultiplyNegNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 1);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newMultiply() == (rand1 * rand2));
    }

    @Test
    void testDividePosPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(1, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newDivide() == (rand1 / rand2));
    }

    @Test
    void testDividePosNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(0, 10);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 0);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newDivide() == (rand1 / rand2));
    }

    @Test
    void testDivideNegPos() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(1, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newDivide() == (rand1 / rand2));
    }

    @Test
    void testDivideNegNeg() {        
        int rand1 = ThreadLocalRandom.current().nextInt(-9, 1);
        int rand2 = ThreadLocalRandom.current().nextInt(-9, 0);

        calc.newValueToken(rand1);
        calc.newValueToken(rand2);

        assertTrue(calc.newDivide() == (rand1 / rand2));
    }

    @Test
    void testDivideBy0() {
        int rand1 = ThreadLocalRandom.current().nextInt(1, 10);

        calc.newValueToken(rand1);
        calc.newValueToken(0);

        assertThrows(IllegalArgumentException.class, () -> {calc.newDivide();});
    }

    @Test
    void testPlusPlus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'+', '+'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }


    @Test
    void testPlusMinus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'+', '-'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testPlusMultiply() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'+', '*'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testPlusDivide() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i == 2) {
                nums[i] = ThreadLocalRandom.current().nextInt(1, 10);
            } else {
                nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        final char[] ops = {'+', '/'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }


    @Test
    void testMinusMinus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'-', '-'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }


    @Test
    void testMinusPlus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'-', '+'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testMinusMultiply() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'-', '*'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    
    @Test
    void testMinusDivide() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i == 2) {
                nums[i] = ThreadLocalRandom.current().nextInt(1, 10);
            } else {
                nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        final char[] ops = {'-', '/'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testMultiplyMultiply() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'*', '*'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testMultiplyMinus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'*', '-'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testMultiplyPlus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        final char[] ops = {'*', '+'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }
    
    @Test
    void testMultiplyDivide() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i == 2) {
                nums[i] = ThreadLocalRandom.current().nextInt(1, 10);
            } else {
                nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        final char[] ops = {'*', '/'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testDivideDivide() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                nums[i] = ThreadLocalRandom.current().nextInt(1, 10);
            } else {
                nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        final char[] ops = {'/', '/'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }


    @Test
    void testDivideMultiply() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i == 1) {
                nums[i] = ThreadLocalRandom.current().nextInt(1, 10);
            } else {
                nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        final char[] ops = {'/', '*'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testDivideMinus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i == 1) {
                nums[i] = ThreadLocalRandom.current().nextInt(1, 10);
            } else {
                nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        final char[] ops = {'/', '-'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }

    @Test
    void testDividePlus() {
        int[] nums = new int[3];
        for (int i = 0; i < nums.length; i++) {
            if (i == 1) {
                nums[i] = ThreadLocalRandom.current().nextInt(1, 10);
            } else {
                nums[i] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        final char[] ops = {'/', '+'};

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }
    
    @Test
    void testRandomOperations() {
        final int numOperations = 20;
        char[] ops = new char[numOperations];
        int[] nums = new int[numOperations+1];

        nums[0] = ThreadLocalRandom.current().nextInt(0, 10);

        for (int i = 0; i < numOperations; i++) {
            switch(ThreadLocalRandom.current().nextInt(0, 3)) {
                case 0: ops[i] = '+';
                    nums[i+1] = ThreadLocalRandom.current().nextInt(-9, 10);
                    break;
                case 1: ops[i] = '-';
                    nums[i+1] = ThreadLocalRandom.current().nextInt(-9, 10);
                    break;
                case 2: ops[i] = '*';
                    nums[i+1] = ThreadLocalRandom.current().nextInt(-9, 10);
                    break;
                case 3: ops[i] = '/';
                    do {
                        nums[i+1] = ThreadLocalRandom.current().nextInt(-9, 10);
                    } while (nums[i+1] != 0);
                    break;
                    
            }
        }

        calc.newValueToken(nums[0]);
        for (int i = 0; i < ops.length; i++) {
            calc.newValueToken(nums[i+1]);
            calc.getToken(ops[i]);
        }

        int verification = nums[0];

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case '+': verification += nums[i+1];
                    break;
                case '-': verification -= nums[i+1];
                    break;
                case '*': verification *= nums[i+1];
                    break;
                case '/': verification /= nums[i+1];
                    break;
                default: System.err.println("Unknown operation: \'" + ops[i] + "\' @ " + i);
            }
        }

        assertTrue(verification == calc.evaluate());
    }
}
