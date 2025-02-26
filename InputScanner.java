import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {
    private int firstNumber;
    private String operator;
    private int secondNumber;

    public void userInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("수식을 입력 후 엔터를 눌러주세요. ");
                firstNumber = scanner.nextInt();
                operator = scanner.next();
                secondNumber = scanner.nextInt();


            } catch (InputMismatchException inputError) {
                String exitCatcher = scanner.next();

                if(exitCatcher.equals("exit")){
                    break;
                }else {
                    System.out.println("유효하지 않은 입력 형식입니다.");
                    inputError.printStackTrace();
                }
            }  catch (ArithmeticException divideError){
                if(secondNumber == 0){
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    System.out.println("유효하지 않은 입력 형식입니다.");
                }

            }
        }

    }
}




        /*String[] ComponentToCalculate = new String[3];

        System.out.println("");

        while (true) {
            System.out.println("정수 입력 후 엔터를 눌러주세요!");
            for (int i = 0; i < 3; i++) {
                String input = scanner.next();
                ComponentToCalculate[i] = input;

                if (input.equals("q")) {
                    break;
                }
            }
        }
    }*/
