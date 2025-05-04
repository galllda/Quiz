package Quiz;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Questions {
    private String question;
    private String type;
    private Map<Character, String> options;
    private String correctAnswer;

    public Questions(String question, String type, Map<Character, String> options, String correctAnswer) {
        this.question = question;
        this.type = type;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getType() {
        return type;
    }

    public void printQuestion() {
        System.out.println(this.question + " (" + this.type + " answer)");
        for (Map.Entry<Character, String> option : this.options.entrySet()) {
            System.out.println(option.getKey() + ". " + option.getValue());
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
