import java.util.Arrays;
import java.util.Scanner;

public class InputScanner {
    public void userInput() {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            try {
                String inputWord = scanner.nextLine();

                //숫자를 기준으로 기호 찾기
                String[] inputOperators = inputWord.split("[0-9]+");

                //왠지 공백이 생겨서 스트림으로 지우기
                inputOperators = Arrays.stream(inputOperators)
                        .filter(temp -> !temp.isEmpty())
                        .toArray(String[]::new);

                //입력기호 유효성검증
                Command.commandInspect(inputOperators);

                //기호를 기준으로 숫자찾기
                String[] inputNumbers = inputWord.split("[^0-9]+");
                //왠지 공백이 생겨서 스트림으로 지우기
                inputNumbers = Arrays.stream(inputNumbers)
                        .filter(temp -> !temp.isEmpty())
                        .toArray(String[]::new);

                //입력받아 정제한 배열을 계산하기
                calculator.calculate(inputOperators, inputNumbers);

            }catch (IllegalArgumentException inputError) {
                System.out.println("Invalid format!");
            } catch (CommandLoopException commandEorD) {
                // r, d 커맨드 받았을 시에 해당 while 루프를 종료하기 위한 예외

            } catch (ArrayIndexOutOfBoundsException enterError){
                System.out.println("Invalid format!2");
            }
        }
    }
}

