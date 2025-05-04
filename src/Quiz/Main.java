package Quiz;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        QuizGame();
    }

    private static void QuizGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, write your name:");
        String name = scanner.nextLine();
        boolean next;

        while (next) {
            System.out.println(name + ", please choose the Quiz: 1-Math, 2-Geography");
            int theme;
            while (true) {
                try {
                    theme = scanner.nextInt();
                    if (theme == 1 || theme == 2) {
                        break;
                    } else {
                        System.out.println("Write option 1 or 2!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Write option 1 or 2!");
                    scanner.nextLine();
                }
            }
            switch (theme) {
                case 1:
                    Quiz mathQuiz = new Quiz("Math quiz", name);
                    Map<Character, String> question1 = new HashMap<>();
                    question1.put('a', "5");
                    question1.put('b', "4");
                    question1.put('c', "10");

                    mathQuiz.addQuestion(new Questions("Kolik je 2+2?", "single", question1, "b"));

                    Map<Character, String> question2 = new HashMap<>();
                    question2.put('a', "4");
                    question2.put('b', "7");
                    question2.put('c', "1");

                    mathQuiz.addQuestion(new Questions("Kolik je 2+5?", "single", question2, "b"));

                    Map<Character, String> question3 = new HashMap<>();
                    question3.put('a', "2^2");
                    question3.put('b', "-2^2");
                    question3.put('c', "1+3");

                    mathQuiz.addQuestion(new Questions("4=?", "multiple", question3, "abc"));
                    mathQuiz.game();
                    break;
                case 2:
                    Quiz mathQuiz2 = new Quiz("Geography quiz", name);
                    Map<Character, String> question4 = new HashMap<>();

                    question4.put('a', "Pariz");
                    question4.put('b', "Praha");
                    question4.put('c', "Berlin");

                    mathQuiz2.addQuestion(new Questions("Hlavni mesto Francie je", "single", question4, "a"));

                    Map<Character, String> question5 = new HashMap<>();
                    question5.put('a', "Baltské moře");
                    question5.put('b', "Jaderské moře");
                    question5.put('c', "Středozemní moře");

                    mathQuiz2.addQuestion(new Questions("Které moře leží mezi Itálií a Chorvatskem?", "single", question5, "b"));

                    Map<Character, String> question6 = new HashMap<>();

                    mathQuiz2.addQuestion(new Questions("Na kterém kontinentu leží Australie?", "open", question6, "australie"));
                    mathQuiz2.game();
                    break;
                default:
                    System.out.println("Write option 1 or 2");
                    scanner.nextLine();
            }

            System.out.println("Do you want to repeat the quiz? (1-yes, 2-no)");
            try {
                if (scanner.nextInt() == 1) {
                    next = true;
                } else {
                    next = false;
                    System.out.println("Goodbye "+name);
                }
            } catch (InputMismatchException e) {
                System.out.println("Write option 1 or 2!");
                scanner.nextInt();
            }
        }
    }
}