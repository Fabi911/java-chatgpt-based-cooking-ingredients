package com.example.chatgptbasedcookingingredients.model;
/**
 * {
 * "role": "user",
 * "content": "Say this is a test!"
 *  }
 */
public record OpenAiAnswer(String role, String content) {
}
