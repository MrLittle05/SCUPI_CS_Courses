import stores.MyStack;

public class Calculator {

    public enum NotationMode {POSTFIX, PREFIX};

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();

        char c;
        while ((c = (char) System.in.read()) != 0) {
            calc.getToken(c);
        }
    }

    private MyStack<Integer> stack;
    private NotationMode mode;
    
    public Calculator() {
        stack = new MyStack<>();
        mode = NotationMode.POSTFIX;
    }

    public int passString(String calculation) {
        for (int i = 0; i < calculation.length(); i++) {
            getToken(calculation.charAt(i));
        }

        return evaluate();
    }

    public void setMode(NotationMode mode) {
        this.mode = mode;
    }

    public NotationMode getMode() {
        return mode;
    }

    public int getToken(char c) {
        if ('0' <= c && c <= '9') {
            return newValueToken((int) (c - '0'));
        } else {
            switch (c) {
                case '+':
                    return newPlus();
                case '-':
                    return newMinus();
                case '*':
                    return newMultiply();
                case '/':
                    return newDivide();
                case '=':
                    return evaluate();
                case '\n':
                case '\t':
                case '\r':
                case ' ':
                    return 0;
                default:
                    System.out.println("Error bad input!!! Allowed inputs are: 0-9,+,-,*,/ and =");
                    return 0;
            }
        }
    }

    protected int newValueToken(int d) {
        System.out.println("Digit " + d);
        // INCOMPLETE
        this.stack.push(d);
        return d;
    }

    protected int newPlus() {
        System.out.println("Op +");
        // INCOMPLETE
        int b=this.stack.pop();
        int a=this.stack.pop();
        this.stack.push(a+b);
        return a+b;
    }

    protected int newMinus() {
        System.out.println("Op -");
        // INCOMPLETE
        int b=this.stack.pop();
        int a=this.stack.pop();
        this.stack.push(a-b);
        return a-b;
    }

    protected int newDivide() throws IllegalArgumentException {
        System.out.println("Op /");
        // INCOMPLETE
         int b=this.stack.pop();
        int a=this.stack.pop();
        if(b==0) {
        	throw new IllegalArgumentException("IllegalArgumentException");
        }
        else {
        this.stack.push(a/b);
        return a/b;
        }
    }

    protected int newMultiply() {
        System.out.println("Op *");
        // INCOMPLETE
        int b=this.stack.pop();
        int a=this.stack.pop();
        this.stack.push(a*b);
        return a*b;
    }

    protected int evaluate() {
        System.out.println("Value =");
        // INCOMPLETE
        return stack.pop();
    }

    public String toString() {
        return stack.toString();
    }

}
