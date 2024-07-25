package com.example.chatgptbasedcookingingredients.model;
/**
 * {
 *  *             "message": {
 *  *                 "role": "assistant",
 *  *                 "content": "\n\nThis is a test!"
 *  *             }
 *  *         }
 */
public record OpenAiChoice(OpenAiAnswer message) {
}
