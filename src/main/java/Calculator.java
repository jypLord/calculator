import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Calculator {
    private static final ArrayList<Long> calculateResults = new ArrayList<>();

    public void calculate(String[] inputOperators,String[] inputNumbers ){
        long[] inputLong = new long[inputNumbers.length];

        for(int j=0; j<inputNumbers.length; j++){
            inputLong[j] = Long.parseLong(inputNumbers[j]);
        }

        for(int i=0; i<inputOperators.length; i++){

            switch (inputOperators[i]) {
                case "+" -> {
                    long result = add(inputLong[i], inputLong[i + 1]);
                    inputLong[i + 1] = result;
                }

                case "-" -> {
                    long result = subtract(inputLong[i], inputLong[i + 1]);
                    inputLong[i + 1] = result;
                }
                case "*" -> {
                    long result = multiply(inputLong[i], inputLong[i + 1]);
                    inputLong[i + 1] = result;
                }
                case "/" -> {
                    long result = divide(inputLong[i], inputLong[i + 1]);
                    inputLong[i + 1] = result;
                }
            }

        }
        calculateResults.add(inputLong[inputLong.length-1]);
        System.out.println(inputLong[inputLong.length-1]);
    }
    public long add(long inputLong1, long inputLong2) {
        return  inputLong1+ inputLong2;
    }

    public long subtract(long inputLong1, long inputLong2) {
        return  inputLong1 - inputLong2;
    }

    public long multiply(long inputLong1, long inputLong2) {
        return  inputLong1 * inputLong2;
    }

    public long divide(long inputLong1, long inputLong2) {
        if (inputLong2 == 0) {
            throw new ArithmeticException("Can't divide to 0");
        } else {
            return  inputLong1/inputLong2;
        }
    }

    public static ArrayList<Long> getResult() {
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
