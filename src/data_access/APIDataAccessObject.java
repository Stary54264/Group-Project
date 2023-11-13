package src.data_access;

import src.entity.Question;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static src.app.QuizFactory.Parse;

public class APIDataAccessObject {
    public static List<Question> RetrieveQuestions(int numberOfQuestions, int category, int difficulty, int questionType) throws IOException, InterruptedException {
        String query = String.format("https://opentdb.com/api.php?amount=%d", numberOfQuestions);

        if (category != 0) {
            query += String.format("&category=%d", category);
        }

        switch (difficulty) {
            case 1:
                query += "&difficulty=easy";
                break;
            case 2:
                query += "&difficulty=medium";
                break;
            case 3:
                query += "&difficulty=hard";
                break;
        }

        switch (questionType) {
            case 1:
                query += "&type=boolean";
                break;
            case 2:
                query += "&type=multiple";
                break;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(query))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return Parse(response.body());
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        RetrieveQuestions(10, 9, 2, 1);
    }
}
