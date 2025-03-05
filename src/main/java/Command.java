import java.util.Arrays;

public enum Command {
    ADD("+"),
    SUBTRACT("-"),
    DIVIDE("/"),
    MULTIPLY("*"),
    EXIT("e"),
    DELETE("d"),
    RESULTS("r");

    private final String symbol;

    private static Command commands;


    Command(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static void commandInspect(String[] inputOperators) {
        for (String operator : inputOperators){
            if(operator.equals("e")){
                System.exit(0);
            }else if(operator.equals("r")){
                System.out.println(Calculator.getResult());
                throw new CommandLoopException();
            }else if(operator.equals("d")){
                Calculator.deleteResult();
                throw new CommandLoopException();
            }

            boolean isValid = Arrays.stream(Command.values())
                    .anyMatch(command -> command.getSymbol().equals(operator));

            if (!isValid) {
                throw new IllegalArgumentException("Invalid command " + operator);

            }
        }
    }
}
