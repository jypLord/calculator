public class Mathematics {
    private int a;
    private int b;


    public Mathematics(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //@Setter //@Getter
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getB() {
        return a;
    }
    public int getA(){
        return b;
    }



    public int add() {
        return a + b;
    }

    public int subtract() {
        return a - b;
    }

    public int multiply() {
        return a * b;
    }

    public int divide() {
        return a / b;
    }

    public int evaluateExpression(){
        return (a+b)/2;
    }
}

