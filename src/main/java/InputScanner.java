import java.util.Arrays;
import java.util.Scanner;

public class InputScanner {
    public void userInput() {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true) {
            try {
                String inputWord = scanner.nextLine();

                String[] inputOperators = inputWord.split("[0-9]+");

                inputOperators = Arrays.stream(inputOperators)
                        .filter(temp -> !temp.isEmpty())
                        .toArray(String[]::new);

                Command.commandInspect(inputOperators);

                String[] inputNumbers = inputWord.split("[^0-9]+");
                inputNumbers = Arrays.stream(inputNumbers)
                        .filter(temp -> !temp.isEmpty())
                        .toArray(String[]::new);

                calculator.calculate(inputOperators, inputNumbers);
            }catch (IllegalArgumentException inputError) {
                System.out.println("Invalid format!");
            } catch (CommandLoopException commandEorD) {
            } catch (ArrayIndexOutOfBoundsException enterError){
                System.out.println("Invalid format!2");
            }
        }
    }
}

