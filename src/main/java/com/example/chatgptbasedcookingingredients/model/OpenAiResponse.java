package com.example.chatgptbasedcookingingredients.model;

import java.util.List;

/**
 * {
 *
 *     "choices": [
 *         {
 *             "message": {
 *                 "role": "assistant",
 *                 "content": "\n\nThis is a test!"
 *             }
 *         }
 *     ]
 * }
 */
public record OpenAiResponse(
        List <OpenAiChoice> choices
) {
    public String getMessages() {
        return choices().get(0).message().content();
    }
}
