package use_cases.takeQuiz;

import entity.TextQuestion;
import entity.Result;
import entity.Test;

import java.util.*;
import java.util.stream.IntStream;

public class takeQuizInteractor implements takeQuizInputBoundary {
    private Test activeTest;
    private Date startTime;
    private TestOrder testOrder;
    private final ArrayList<TextQuestion> wrongAnswers;
    private final takeQuizOutputBoundary outputBoundary;
    private final takeQuizDataAccessInterface dataAccessInterface;

    public takeQuizInteractor(takeQuizOutputBoundary outputBoundary, takeQuizDataAccessInterface dataAccessInterface) {
        this.outputBoundary = outputBoundary;
        this.dataAccessInterface = dataAccessInterface;
        wrongAnswers = new ArrayList<>();
    }

    @Override
    public void startTest(takeQuizInputData inputData) {
        Test t =  dataAccessInterface.getTest(inputData.testName());
        activeTest = t;
        testOrder = new TestOrder(t.getQuestions());

        TextQuestion currentQuestion = testOrder.next();
        startTime = new Date();
        takeQuizOutputData out = new takeQuizOutputData(inputData.testName(), currentQuestion.getQuestion(), currentQuestion.getAnswers(), true, "");
        outputBoundary.prepareNextQuestion(out);
    }

    @Override
    public void nextQuestion(takeQuizInputData inputData) {
        TextQuestion currentQuestion = testOrder.now();

        boolean lastCorrect = Objects.equals(currentQuestion.getCorrectAnswer(), inputData.userAnswer());
        if (lastCorrect) {
            wrongAnswers.add(null);
            System.out.println("YEP!");
        } else {
            wrongAnswers.add(currentQuestion);
            System.out.println("WRONG!");
        }


        if (!testOrder.hasNext()) {
            Result newResult = prepareResult();
            activeTest.addResult(newResult);
            String lastAnswer = currentQuestion.getCorrectAnswer();
            takeQuizOutputData out = new takeQuizOutputData(activeTest.getName(), currentQuestion.getQuestion(), currentQuestion.getAnswers(), lastCorrect, lastAnswer);

            outputBoundary.prepareResultView(out);
            clearState();
        } else {
            String lastAnswer = currentQuestion.getCorrectAnswer();
            currentQuestion = testOrder.next();
            takeQuizOutputData out = new takeQuizOutputData(null, currentQuestion.getQuestion(), currentQuestion.getAnswers(), lastCorrect, lastAnswer);
            outputBoundary.prepareNextQuestion(out);
        }
    }

    private Result prepareResult() {
        int count = activeTest.getQuestions().size();
        boolean[] qs = new boolean[count];
        for (int i = 0; i < count; i++) {
            qs[i] = wrongAnswers.get(i) == null;
        }
        return new Result(new Date((new Date().getTime() - startTime.getTime())), qs);
    }

    private void clearState() {
        wrongAnswers.clear();
        startTime = null;
        activeTest = null;
    }

    private class TestOrder implements Iterator<TextQuestion> {

        private final ArrayList<TextQuestion> questions;
        private final Integer[] order;
        private int index;
        TestOrder(ArrayList<TextQuestion> questions) {
            this.questions = questions;
            this.order = IntStream.range(0, questions.size()).boxed().toArray(Integer[]::new);
            Collections.shuffle(Arrays.asList(testOrder));
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index < order.length-1;
        }

        @Override
        public TextQuestion next() {
            index++;
            return questions.get(index);
        }
        public TextQuestion now() {
            return questions.get(index);
        }
    }
}
