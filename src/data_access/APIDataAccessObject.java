package data_access;

import app.Category;
import app.QuestionType;
import app.QuestionDifficulty;
import app.Serializer;
import entity.Question;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static app.QuestionDifficulty.ALL;
import static app.QuestionType.BOOL;

public class APIDataAccessObject {
    public static ArrayList<Question> RetrieveQuestionsTrivia1(int numberOfQuestions, Category category, QuestionDifficulty difficulty,
                                                               QuestionType questionType) throws IOException, InterruptedException {
        String query = String.format("https://opentdb.com/api.php?amount=%d", numberOfQuestions);

        if (category != 0) {
            query += String.format("&category=%d", category);
        }

        switch (difficulty) {
            case ALL:
                query += "&difficulty=all";
                break;
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
            case ALL:
                query += "&type=all";
                break;
            case BOOL:
                query += "&type=boolean";
                break;
            case MULTI:
                query += "&type=multiple";
                break;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(query))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return Serializer.ParseTrivia(response.body());
    }

    public static ArrayList<Question> RetrieveQuestionsTrivia2() {
        // TODO fmwof
        return null;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        RetrieveQuestionsTrivia1(10, 9, ALL, BOOL);
    }
}
