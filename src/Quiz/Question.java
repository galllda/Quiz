package Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Question {
    private String question;
    private String type;
    private String correctAnswer;
    private List<Answer> answers;


    public Question(String question, String type, String correctAnswer) {
        this.question = question;
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.answers = new ArrayList<>();

    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);

    }

    public String getType() {
        return type;
    }

    public void print() {
        System.out.println(this.question + " (" + this.type + " answer)");
        for (Answer answer : this.answers) {
            answer.print();
        }
    }

    public boolean isCorrect(String userChoice, String type) {
        if (type.contains("single") || type.contains("open")) {
            return (userChoice.contains(this.correctAnswer));
        } else {
            char[] sort = userChoice.toCharArray();
            Arrays.sort(sort);
            String sorted = new String(sort);
            return (sorted.contains(this.correctAnswer));
        }
    }
}
