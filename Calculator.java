import java.util.ArrayList;
import java.util.InputMismatchException;

public class Calculator {
    private ArrayList<Integer> result = new ArrayList<>();

    private int a;
    private int b;
    private char operator;


    public Calculator(int a, char operator ,int b){
        this.a = a;
        this.operator = operator;
        this.b = b;
    }

    public void setA(int a){
        this.a = a;
    }
    public void setB(int b){
        this.b = b;
    }
    public void setOperator(char operator){
            this.operator = operator;
    }

    public int getA(int a){
        return  a;
    }
    public  int getB(int b){
        return b;
    }


    public int calculating(){

        return switch (operator) {
            case '+' -> add();

            case '-' -> subtract();

            case '/' -> divide();

            case '*' -> multiply();

            default -> throw new IllegalArgumentException();
        };
    }

    public int add(){
            return this.a + this.b;
        }

    public int subtract() {
        return this.a - this.b;
    }

    public int multiply() {
        return this.a * this.b;
    }

    public int divide() {
        return this.a / this.b;
    }

}
