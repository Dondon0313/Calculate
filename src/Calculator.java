import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
    public static int getNumberFromUser(Scanner scanner, String prompt) {

        boolean validInput = false;
        int number = 0;

        while (!validInput) {
            System.out.println(prompt);
            try {
                number = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("輸入錯誤:輸入的不是數字");
                scanner.nextLine();
            }
        }
        return number;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {

            int num1 = getNumberFromUser(scanner, "請輸入第一個數字");
            int num2 = getNumberFromUser(scanner, "請輸入第二個數字");

            System.out.println("選擇運算(+, -, *. /):");
            String operator = scanner.next();
            int result = 0;
            boolean hasError = false;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("錯誤:不能除以零");
                        hasError = true;

                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("無效符號");
                    hasError = true;
            }

            if (!hasError) {
                System.out.println("結果是: " + result);
            }

            System.out.println("要繼續計算嗎?(y/n):");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("n")) {
                keepRunning = false;
            }

        }
    }
}


//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
////        System.out.println("輸入數字:");
//
//        boolean validInput1 = false;
//        int number1 = 0;
//
//        while (!validInput1) {
//            System.out.println("請輸入第一個數字:");
//            try {
//                number1 = scanner.nextInt();
//                validInput1 = true;;
//
//            } catch (InputMismatchException e) {
//                System.out.println("輸入錯誤:輸入的不是數字");
//                scanner.nextLine();
//            }
//        }
//
//        boolean validInput2 = false;
//        int number2 = 0;
//
//        while (!validInput2) {
//            System.out.println("請輸入第二個數字:");
//            try {
//                number2 = scanner.nextInt();
//                validInput2 = true;;
//
//            } catch (InputMismatchException e) {
//                System.out.println("輸入錯誤:輸入的不是數字");
//                scanner.nextLine();
//            }
//        }
//
//        int num3 = number1 + number2;
//        System.out.println("兩數相加是:" + num3);
//    }




//public class Calculator {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
////        System.out.println("輸入數字:");
//
//        boolean validInput = false;
//        int number = 0;
//
//        while (!validInput) {
//            System.out.println("輸入數字:");
//            try {
//                number = scanner.nextInt();
//                validInput = true;;
//
//            } catch (InputMismatchException e) {
//                System.out.println("輸入錯誤:輸入的不是數字");
//                scanner.nextLine();
//            }
//        }
//    }
//}
