import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Calculator {
    private int a;
    private int b;
    private char operator;

    public Calculator(int a, char operator, int b) {
        this.a = a;
        this.operator = operator;
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }


    public long calculating() {

        long calculateResult = switch (operator) {

            case '+' -> add();

            case '-' -> subtract();

            case '/' -> divide();

            case '*' -> multiply();

            default -> throw new IllegalArgumentException();
        };
        return (calculateResult);
    }

    public int add() {
        return this.a + this.b;
    }

    public int subtract() {
        return this.a - this.b;
    }

    public int multiply() {
        return this.a * this.b;
    }

    public int divide() {
        if (this.b == 0) {
            throw new ArithmeticException();
        } else {
            return this.a / this.b;
        }
    }

    private ArrayList<Long> result = new ArrayList<>();

    public void saveResult(long calculateResult) {
        result.add(calculateResult);
    }

    public ArrayList<Long> getResult(){
        /*if(result.isEmpty()){
            System.out.println(
        }else {*/
            return result;
    }

    public void deleteResult(){
        try{
            result.removeFirst();
            System.out.println("delete complete");
        }catch (NoSuchElementException deleteErrer){
            System.out.println("There's no result");
        }
    }
}
