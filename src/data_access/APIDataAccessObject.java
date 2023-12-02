package data_access;

import app.Category;
import app.QuestionType;
import app.QuestionDifficulty;
import app.Serializer;
import entity.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static app.QuestionDifficulty.ALL;
import static app.QuestionType.BOOL;

public class APIDataAccessObject {
    public static String RetrieveQuestionsTrivia1(int numberOfQuestions, Category category, QuestionDifficulty difficulty,
                                                               QuestionType questionType){
        String query = String.format("https://opentdb.com/api.php?amount=%d", numberOfQuestions);

        if (category != Category.AnyCategory) {
            query += String.format("&category=%d", category.value);
        }

        switch (difficulty) {
            case EASY:
                query += "&difficulty=easy";
                break;
            case MEDIUM:
                query += "&difficulty=medium";
                break;
            case HARD:
                query += "&difficulty=hard";
                break;
        }

        switch (questionType) {
            case BOOL:
                query += "&type=boolean";
                break;
            case MULTI:
                query += "&type=multiple";
                break;
        }
        try {
            System.out.println("API CALL:"+query);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(query))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println("request error (1)");
            return null;
        }
    }

    public static String RetrieveQuestionsTrivia2() {
        try {
            String query = "https://the-trivia-api.com/v2/questions/";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(query))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        //ArrayList<Question> s = RetrieveQuestionsTrivia2();
        String s = RetrieveQuestionsTrivia1(15, Category.Politics, ALL, BOOL);
        Test t = Serializer.DecodeTest(s, "pog");
        System.out.println(t.getName());
        System.out.println(t.getQuestions().size());
    }
}
