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
            // 입력문자 e -> 정상 종료
            if(operator.equals("e")){
                System.exit(0);

            //입력문자 r -> 계산 결과 리스트 출력
            }else if(operator.equals("r")){
                System.out.println(Calculator.getResult());
                throw new CommandLoopException();

            //입력 문자 d -> 가장 앞의 계산결과 삭제
            }else if(operator.equals("d")){
                Calculator.deleteResult();
                throw new CommandLoopException();
            }

            // 입력문자 유효성 검사
            boolean isValid = Arrays.stream(Command.values())
                    .anyMatch(command -> command.getSymbol().equals(operator));

            // ENUM 상수가 아니면 에러던지기
            if (!isValid) {
                throw new IllegalArgumentException("Invalid command " + operator);

            }
        }
    }
}
