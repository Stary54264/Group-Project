package use_cases.takeQuiz;

import entity.Question;
import src.entity.Result;
import src.entity.Test;

import java.util.*;
import java.util.stream.IntStream;

public class takeQuizInteractor implements takeQuizInputBoundary {
    private Test activeTest;
    private int[] testOrder;
    private int currentQuestionIndex;
    private final ArrayList<Question> wrongAnswers;
    private final takeQuizOutputBoundary outputBoundary;
    private final takeQuizDataAccessInterface dataAccessInterface;

    public takeQuizInteractor(takeQuizOutputBoundary outputBoundary, takeQuizDataAccessInterface dataAccessInterface) {
        this.outputBoundary = outputBoundary;
        this.dataAccessInterface = dataAccessInterface;
        wrongAnswers = new ArrayList<>();
    }

    @Override
    public void startTest(String name) {
        Test t =  dataAccessInterface.getTest(name);
        activeTest = t;
        currentQuestionIndex = 0;
        testOrder = IntStream.range(0, t.getQuestions().size()).toArray();
        Collections.shuffle(Arrays.asList(testOrder));
        Question currentQuestion = t.getQuestions().get(testOrder[currentQuestionIndex]);

        takeQuizOutputData out = new takeQuizOutputData(currentQuestion.getQuestion(), currentQuestion.getAnswers());
        outputBoundary.prepareNextQuestion(out);
    }

    @Override
    public void nextQuestion(takeQuizInputData inputData) {
        ArrayList<Question> questions = activeTest.getQuestions();
        int currentIndex = testOrder[currentQuestionIndex];
        Question currentQuestion = questions.get(currentIndex);

        if (Objects.equals(currentQuestion.getCorrectAnswer(), inputData.getUserAnswer())) {
            wrongAnswers.add(null);
        } else {
            wrongAnswers.add(currentQuestion);
        }
        currentQuestionIndex ++;

        if (currentQuestionIndex-1 > testOrder.length) {

            Result newResult = prepareResult();

            activeTest.addResult(newResult);
            outputBoundary.prepareResultView(activeTest, newResult);
            clearState();
        } else {
            currentIndex = testOrder[currentQuestionIndex];
            currentQuestion = questions.get(currentIndex);
            takeQuizOutputData out = new takeQuizOutputData(currentQuestion.getQuestion(), currentQuestion.getAnswers());
            outputBoundary.prepareNextQuestion(out);
        }
    }

    private Result prepareResult() {
        HashMap<Integer, Question> qs = new HashMap<>();
        for (int i = 0; i < testOrder.length; i++) {
            qs.put(i, wrongAnswers.get(testOrder[i])) ;
        }
        return new Result(new Date(), qs);
    }

    private void clearState() {
        wrongAnswers.clear();
        activeTest = null;
    }
}
