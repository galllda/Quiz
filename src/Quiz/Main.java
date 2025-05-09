package Quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        QuizGame();
    }

    private static void QuizGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, write your name:");
        String name = scanner.nextLine();
        boolean next = true;

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

                    Question question1 = new Question("Kolik je 2+2?", "single");
                    Answer answer1 = new Answer("a", "5", false);
                    question1.addAnswer(answer1);
                    Answer answer2 = new Answer("b", "4", true);
                    question1.addAnswer(answer2);
                    Answer answer3 = new Answer("c", "10", false);
                    question1.addAnswer(answer3);
                    mathQuiz.addQuestion(question1);

                    Question question2 = new Question("Kolik je 2+5?", "single");
                    Answer answer4 = new Answer("a", "4", false);
                    question2.addAnswer(answer4);
                    Answer answer5 = new Answer("b", "7", true);
                    question2.addAnswer(answer5);
                    Answer answer6 = new Answer("c", "1", false);
                    question2.addAnswer(answer6);
                    mathQuiz.addQuestion(question2);

                    Question question3 = new Question("4=?", "multiple");
                    Answer answer7 = new Answer("a", "2^3", false);
                    question3.addAnswer(answer7);
                    Answer answer8 = new Answer("b", "-2^2", true);
                    question3.addAnswer(answer8);
                    Answer answer9 = new Answer("c", "1+3", true);
                    question3.addAnswer(answer9);
                    mathQuiz.addQuestion(question3);

                    mathQuiz.game();
                    break;

                case 2:
                    Quiz mathQuiz2 = new Quiz("Geography quiz", name);

                    Question question4 = new Question("Hlavni mesto Francie je?", "single");
                    Answer answer10 = new Answer("a", "Pariz", true);
                    question4.addAnswer(answer10);
                    Answer answer11 = new Answer("b", "Praha", false);
                    question4.addAnswer(answer11);
                    Answer answer12 = new Answer("c", "Berlin", false);
                    question4.addAnswer(answer12);
                    mathQuiz2.addQuestion(question4);


                    Question question5 = new Question("Které moře leží mezi Itálií a Chorvatskem?", "single");
                    Answer answer13 = new Answer("a", "Baltské moře", false);
                    question5.addAnswer(answer13);
                    Answer answer14 = new Answer("b", "Jaderské moře", true);
                    question5.addAnswer(answer14);
                    Answer answer15 = new Answer("c", "Středozemní moře", false);
                    question5.addAnswer(answer15);
                    mathQuiz2.addQuestion(question5);

                    Question question6 = new Question("Na kterém kontinentu leží Australie?", "open", "australie");

                    mathQuiz2.addQuestion(question6);

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
                    System.out.println("Goodbye " + name);
                }
            } catch (InputMismatchException e) {
                System.out.println("Write option 1 or 2!");
                scanner.nextInt();
            }
        }
    }
}