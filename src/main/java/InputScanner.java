import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputScanner {
    private int firstNumber;
    private char operator;
    private int secondNumber;

    private static String translateInputWord ;

    public void userInput() {
        System.out.println("Write math expression and press Enter\n     " +
                "Command" + "\n" +
                "exit: close calculator\n" +
                "results: call calcuted list\n" +
                "delete: delete the frontest result");

        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator(firstNumber,operator,secondNumber);

        while (true) {
            try{
                translateInputWord = scanner.nextLine();

                //숫자 판별 정규식
                Pattern NumberFinder = Pattern.compile("\\d+");

                Matcher NumberMatcher = NumberFinder.matcher(translateInputWord);
                NumberMatcher.find();
                this.firstNumber = Integer.parseInt(NumberMatcher.group());
                NumberMatcher.find();
                this.secondNumber = Integer.parseInt(NumberMatcher.group());

                //연산자 판별 정규식
                Pattern operatorFinder = Pattern.compile("\\W");
                Matcher operatorMacher = operatorFinder.matcher(translateInputWord);
                operatorMacher.find();
                this.operator = operatorMacher.group().charAt(0);


                calculator.setA(this.firstNumber);
                calculator.setOperator(this.operator);
                calculator.setB(this.secondNumber);

                long calulateResult = calculator.calculating();
                System.out.println(calulateResult);

                calculator.saveResult(calulateResult);


            }catch (IllegalStateException inputError) {
                //String comandCatcher = scanner.nextLine();
                if(translateInputWord.equals("exit")) {
                    break;
                }else if(translateInputWord.equals("delete")){
                    calculator.deleteResult();
                }else if(translateInputWord.equals("results")){
                        System.out.println(calculator.getResult());
                }else {
                    System.out.println("invalid format!");
                }
            }catch (ArithmeticException divideError) {
                if (secondNumber == 0) {
                    System.out.println("Can't divide to 0"); //
                } else {
                    System.out.println("invalid format!");
                }
            }catch (IllegalArgumentException iDontKnowThat) {
                System.out.println("invalid operation");

            }catch (IndexOutOfBoundsException getResultError) {
                System.out.println("There's no result");

            }catch (NoSuchElementException deleteError) {
                System.out.println("There's no result");
            }
        }
    }
}