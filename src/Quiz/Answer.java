package Quiz;

public class Answer {

    private String answerMark;
    private String answer;

    public Answer(String answerMark, String answer) {
        this.answerMark = answerMark;
        this.answer = answer;
    }

    public void print() {
        System.out.println(this.answerMark + ". " + this.answer);
    }
}
