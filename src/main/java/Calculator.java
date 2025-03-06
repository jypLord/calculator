import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Calculator {
    private static final ArrayList<Object> calculateResults = new ArrayList<>();
    
    public void calculate(String[] inputOperators,String[] inputNumbers ){

        Number[] numbers = new Number[inputNumbers.length];
        
        boolean whatDataType = true;
        
        for(int j=0; j<inputNumbers.length; j++) {
            whatDataType = inputNumbers[j].contains(".");
            if (whatDataType) {
                numbers[j] = Double.parseDouble((inputNumbers[j]));
            } else {
                numbers[j] = Long.parseLong(inputNumbers[j]);
            }
        }
        for(int i=0; i<inputOperators.length; i++){
            if(whatDataType) {
                switch (inputOperators[i]) {
                    case "+" -> {
                        double result = add(numbers[i], numbers[i + 1]);
                        numbers[i + 1] = result;
                    }

                    case "-" -> {
                        double result = subtract(numbers[i], numbers[i + 1]);
                        numbers[i + 1] = result;
                    }
                    case "*" -> {
                        double result = multiply(numbers[i], numbers[i + 1]);
                        numbers[i + 1] = result;
                    }
                    case "/" -> {
                        double result = divide(numbers[i], numbers[i + 1]);
                        numbers[i + 1] = result;
                    }
                }
            }    
        }
        calculateResults.add(numbers[numbers.length-1]);
        System.out.println(numbers[numbers.length-1]);
    }
    public <T extends Number> double add(T inputNum1, T inputNum2) {
        return  inputNum1.doubleValue() + inputNum2.doubleValue();
    }

    public <T extends Number> double subtract(T inputNum1, T inputNum2) {
        return  inputNum1.doubleValue() - inputNum2.doubleValue();
    }

    public <T extends Number> double multiply(T inputNum1, T inputNum2) {
        return  inputNum1.doubleValue() * inputNum2.doubleValue();
    }

    public <T extends Number> double divide(T inputNum1, T inputNum2) {
        if (inputNum2.doubleValue() == 0) {
            throw new ArithmeticException("Can't divide to 0");
        } else {
            return  inputNum1.doubleValue()/inputNum2.doubleValue();
        }
    }


    public static ArrayList<?> getResult() {
        return calculateResults;
    }

    public static void deleteResult() {
        try {
            calculateResults.removeFirst();
            System.out.println("delete complete");
        } catch (NoSuchElementException deleteError) {
            System.out.println("There's no result");

        }
    }
}
