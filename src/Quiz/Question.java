package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Question {
    private String question;
    private String type;
    private String correctOpenAnswer;
    private List<Answer> answers;


    public Question(String question, String type) {
        this.question = question;
        this.type = type;
        this.answers = new ArrayList<>();
    }

    public Question(String question, String type, String correctOpenAnswer) {
        this.question = question;
        this.type = type;
        this.correctOpenAnswer = correctOpenAnswer;
    }


    public void addAnswer(Answer answer) {
        this.answers.add(answer);


    }

    public String getType() {
        return type;
    }

    public void print() {

        System.out.println(this.question + " (" + this.type + " answer)");
        if (!Objects.equals(this.type, "open")) {
            for (Answer answer : this.answers) {
                answer.print();
            }
        }
    }

    public boolean isCorrect(String userChoice, String type) {
        if (type.contains("open")) {
            return (userChoice.contains(this.correctOpenAnswer));
        } else if (type.contains("single")) {
            for (Answer answer : this.answers) {
                if (answer.isCorrect() && Objects.equals(userChoice, answer.getAnswerMark())) {
                    return true;
                }
            }
            return false;
        } else {
            for (Answer answer : this.answers) {
                if (answer.isCorrect()) {
                    if (!userChoice.contains(answer.getAnswerMark())) {
                        return false;
                    }
                } else {
                    if (userChoice.contains(answer.getAnswerMark())) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

