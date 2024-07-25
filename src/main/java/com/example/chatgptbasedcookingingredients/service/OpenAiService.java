package com.example.chatgptbasedcookingingredients.service;

import com.example.chatgptbasedcookingingredients.model.OpenAiAnswer;
import com.example.chatgptbasedcookingingredients.model.OpenAiRequest;
import com.example.chatgptbasedcookingingredients.model.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OpenAiService {

    private final RestClient rc;

    public OpenAiService(@Value("${openai.api-key}") String apiKey,
                         @Value("${openai.api-url}") String apiUrl) {
        rc= RestClient.builder()
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .baseUrl(apiUrl)
                .build();
    }

    public String getIngredientCategory(String ingredient) {
        OpenAiRequest request = new OpenAiRequest("gpt-4o-mini", List.of(new OpenAiAnswer("user","ich möchte nur als Antwort folgende drei begriffe: vegan, vegetarian oder regular : " +ingredient)), 0.2);

        OpenAiResponse response = rc.post()
                .body(request)
                .retrieve()
                .body(OpenAiResponse.class);
        return response.getMessages();
    }
}
