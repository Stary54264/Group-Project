package data_access;

import app.Serializer;
import entity.Test;

import use_cases.createOwnQuestions.CreateOwnQuestionsDataAccessInterface;
import use_cases.getApiQuestions.GetApiQuestionsDataAccessInterface;
import use_cases.getDailyQuiz.GetDailyQuizDataAccessInterface;
import use_cases.getResult.GetResultDataAccessInterface;
import use_cases.manageQuiz.manageQuizDataAccessInterface;
import use_cases.takeQuiz.takeQuizDataAccessInterface;
import use_cases.uploadQuestions.UploadQuestionsDataAccessInterface;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class FileTestDataAccessObject implements
        takeQuizDataAccessInterface,
        manageQuizDataAccessInterface,
        GetApiQuestionsDataAccessInterface,
        GetDailyQuizDataAccessInterface,
        CreateOwnQuestionsDataAccessInterface,
        UploadQuestionsDataAccessInterface,
        GetResultDataAccessInterface {

    private final Map<String, Test> tests = new HashMap<>();

    public FileTestDataAccessObject() {
        refresh();
    }

    @Override
    public Test getTest(String name) {
        return tests.get(name);
    }

    @Override
    public Test readTest(String testName, String txtPath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(txtPath));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append(' ');
            }
            return Serializer.DecodeTest(content.toString(), testName);
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public void save(Test test) {
        try {
            String path = "Quizzes/"+test.getName()+".txt";
            File file = new File(path);
            if (file.createNewFile()) System.out.println("new file made!");
            FileWriter myWriter = new FileWriter(file);

            myWriter.write(Serializer.EncodeTest(test));
            myWriter.close();

        } catch (Exception e) {
            System.out.println("File thing went wrong (save)");
        }
        refresh();
    }

    @Override
    public boolean existsByName(String name) {
        return tests.containsKey(name);
    }

    @Override
    public List<Test> getTests() {
        return tests.values().stream().toList();
    }

    @Override
    public void deleteTest(String name) {
        String path = "Quizzes/"+name+".txt";
        File file = new File(path);
        if (!file.delete()) System.out.println("bruh no file to delete");
        refresh();
    }

    //re-reads all the files and stores them in memory
    @Override
    public void refresh() {
        List<File> files = Stream.of(Objects.requireNonNull(new File("Quizzes/").listFiles()))
                .filter(file -> !file.isDirectory())
                .toList();
        tests.clear();
        for (File test: files) {
            try {
                Scanner reader = new Scanner(test);
                String data = reader.nextLine();
                String testName = test.getName().replace(".txt", "");
                tests.put(testName, Serializer.DecodeTest(data, testName));
                reader.close();
            } catch (Exception e) {
                System.out.println("failed to read file: " + test.getName());
            }
        }
    }
}
