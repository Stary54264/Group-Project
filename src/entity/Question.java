package entity;

public class Question {
    private final int id; // generate random id to differentiate questions
    private String question;
    private String correctAnswer;
    private String[] incorrectAnswers;

    public Question(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }
}
