import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    private int firstNumber;
    private char operator;
    private int secondNumber;


    public void userInput() {
        System.out.println("수식을 입력 후 엔터를 눌러주세요. ");
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator(firstNumber,operator,secondNumber);

        while (true) {
            try{
                firstNumber = scanner.nextInt();
                operator = scanner.next().charAt(0);
                secondNumber = scanner.nextInt();

                calculator.setA(firstNumber);
                calculator.setOperator(operator);
                calculator.setB(secondNumber);

                calculator.calculating();

            } catch (InputMismatchException inputError) {
                String exitCatcher = scanner.next();

                if(exitCatcher.equals("exit")){
                    break;
                }else {
                    System.out.println("유효하지 않은 입력 형식입니다.");

                }
            }  catch (ArithmeticException divideError) {
                if (secondNumber == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    System.out.println("유효하지 않은 입력 형식입니다.");
                }

            }   catch (IllegalArgumentException iDontKnowThat) {
                    System.out.println("그런 기능이 없습니다");
            }
        }

    }
}