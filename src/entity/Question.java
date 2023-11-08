package entity;

public class Question {
    private final int id; // generate random id to differentiate questions
    private String question;
    private String correctAnswer;
    private String[] incorrectAnswers;

    public Question(int id, String question, String correctAnswer, String[] incorrectAnswers) {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
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
