package Quiz;

public class Answer {

    private String answerMark;
    private String answer;
    private boolean isCorrect;

    public Answer(String answerMark, String answer, boolean isCorrect) {
        this.answerMark = answerMark;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public void print() {
        System.out.println(this.answerMark + ". " + this.answer);
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getAnswerMark() {
        return answerMark;
    }
}
