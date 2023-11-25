package data_access;

import app.Category;
import app.QuestionType;
import app.QuestionDifficulty;
import entity.Question;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import app.QuizFactory;

import static app.Category.AnyCategory;
import static app.QuestionDifficulty.ALL;
import static app.QuestionType.BOOL;

public class APIDataAccessObject {
    public static List<Question> RetrieveQuestions(int numberOfQuestions, Category category, QuestionDifficulty difficulty,
                                                   QuestionType questionType) throws IOException, InterruptedException {
        String query = String.format("https://opentdb.com/api.php?amount=%d", numberOfQuestions);

        if (category.value != 0) {
            query += String.format("&category=%d", category.value);
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
        return QuizFactory.Parse(response.body());
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        RetrieveQuestions(10, AnyCategory, ALL, BOOL);
    }
}
