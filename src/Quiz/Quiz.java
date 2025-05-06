package Quiz;

import java.util.*;

public class Quiz {

    private String name;
    private List<Question> questionList;
    private String userName;

    public Quiz(String name, String userName) {
        this.name = name;
        this.questionList = new ArrayList<>();
        this.userName = userName;
    }

    public void game() {

        int score = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.userName + ", welcome to " + this.name);
        System.out.println("This quiz has " + this.questionList.size() + " questions.\n");


        char letterStart = 'a';
        char letterEnd = (char) (letterStart + this.questionList.size() - 1);

        for (Question question : this.questionList) {

            String userInput;
            question.print();


            while (true) {

                userInput = scanner.nextLine().toLowerCase();

                if (question.getType() == "single") {

                    if (userInput.length() == 1 && userInput.matches("[" + letterStart + "-" + letterEnd + "]")) {
                        break;
                    } else {
                        System.out.println("Wrong input, try again!");
                    }

                } else if (question.getType() == "multiple") {
                    if (userInput.length() <= questionList.size() && userInput.matches("[" + letterStart + "-" + letterEnd + "]+")) {
                        break;
                    } else {
                        System.out.println("Wrong input, try again!");
                    }
                } else {
                    break;
                }
            }

            if (question.isCorrect(userInput, question.getType())) {
                score++;
            }

        }
        System.out.println("The end");
        System.out.println("You had " + score + "/" + this.questionList.size() + " answers correct");
    }

    public void addQuestion(Question question) {
        this.questionList.add(question);
    }
}
