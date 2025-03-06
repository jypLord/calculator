import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Calculator {
    private static final ArrayList<Object> calculateResults = new ArrayList<>();

    private boolean whatDataType = true;

    public void calculate(String[] inputOperators,String[] inputNumbers ){

        long[] inputLong = new long[inputNumbers.length];
        double[] inputDouble = new double[inputNumbers.length];

        for(int j=0; j<inputNumbers.length; j++){
            // 입력된 숫자에 소수점이 있는지 검증
            whatDataType = inputNumbers[j].contains(".");

            if(whatDataType){
                inputDouble[j] = Double.parseDouble((inputNumbers[j]));
            }else {
                inputLong[j] = Long.parseLong(inputNumbers[j]);
            }
        }

        for(int i=0; i<inputOperators.length; i++){
            if(whatDataType){
                switch (inputOperators[i]) {
                    case "+" -> {
                        double result = add(inputDouble[i], inputDouble[i + 1]);
                        inputDouble[i + 1] = result;
                    }

                    case "-" -> {
                        double result = subtract(inputDouble[i], inputDouble[i + 1]);
                        inputDouble[i + 1] = result;
                    }
                    case "*" -> {
                        double result = multiply(inputDouble[i], inputDouble[i + 1]);
                        inputDouble[i + 1] = result;
                    }
                    case "/" -> {
                        double result = divide(inputDouble[i], inputDouble[i + 1]);
                        inputDouble[i + 1] = result;
                    }
                }
            }else {
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
        }
        calculateResults.add(inputLong[inputLong.length-1]);
        System.out.println(inputLong[inputLong.length-1]);
    }
    public long add(long inputLong1, long inputLong2) {
        return  inputLong1+ inputLong2;
    }
    public double add(double inputDouble1, double inputDouble2) {
        return  inputDouble1+ inputDouble2;
    }


    public long subtract(long inputLong1, long inputLong2) {
        return  inputLong1 - inputLong2;
    }
    public double subtract(double inputDouble1, double inputDouble2) {
        return  inputDouble1 - inputDouble2;
    }

    public long multiply(long inputLong1, long inputLong2) {
        return  inputLong1 * inputLong2;
    }
    public double multiply(double inputDouble1, double inputDouble2) {
        return inputDouble1 * inputDouble2;
    }


    public long divide(long inputLong1, long inputLong2) {
        if (inputLong2 == 0) {
            throw new ArithmeticException("Can't divide to 0");
        } else {
            return  inputLong1/inputLong2;
        }
    }
    public double divide(double inputDouble1, double inputDouble2) {
        if (inputDouble2 == 0) {
            throw new ArithmeticException("Can't divide to 0");
        } else {
            return  inputDouble1/inputDouble2;
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
