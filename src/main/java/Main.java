public class Main {
    public static void main(String[] args) {
        String textBlock = """
                Write math expression and press Enter
                           commands
                -------------------------------------
                 e | exit calculator 
                 r | call calculated list 
                 d | delete the frontest result
                """;
        System.out.println(textBlock);

        InputScanner run = new InputScanner();
        run.userInput();

    }
}
