package Quiz;

import java.util.*;

public class Quiz {

    private String name;
    private List<Questions> questionsList;
    private String userName;

    public Quiz(String name, String userName) {
        this.name = name;
        this.questionsList = new ArrayList<>();
        this.userName = userName;
    }

    public void game() {

        int score = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.userName + ", welcome to " + this.name);
        System.out.println("This quiz has " + this.questionsList.size() + " questions.\n");

        char letterStart = 'a';
        char letterEnd = (char) (letterStart + this.questionsList.size() - 1);

        for (Questions question : this.questionsList) {

            String userInput;
            question.printQuestion();

            while (true) {

                userInput = scanner.nextLine().toLowerCase();

                if (question.getType() == "single") {

                    if (userInput.length() == 1 && userInput.matches("[" + letterStart + "-" + letterEnd + "]")) {
                        break;
                    } else {
                        System.out.println("Wrong input, try again!");
                    }

                } else if (question.getType() == "multiple") {
                    if (userInput.length() <= questionsList.size() && userInput.matches("[" + letterStart + "-" + letterEnd + "]+")) {
                        break;
                    } else {
                        System.out.println("Wrong input, try again!");
                    }
                }
                else{
                    break;
                }
            }

            if (question.isCorrect(userInput, question.getType())) {
                score++;
            }
        }
        System.out.println("The end");
        System.out.println("You had " + score + "/" + this.questionsList.size() + " answers correct");
    }


    public void addQuestion(Questions question) {
        this.questionsList.add(question);
    }


}
