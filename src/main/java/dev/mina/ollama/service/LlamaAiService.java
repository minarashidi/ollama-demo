package dev.mina.ollama.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;


@Service
public class LlamaAiService {

  private final OllamaChatModel chatModel;

  public LlamaAiService(OllamaChatModel chatModel) {
    this.chatModel = chatModel;
  }

  public String generateResult(String prompt) {
    ChatResponse response = chatModel.call(
        new Prompt(
            prompt,
            OllamaOptions.builder()
                .withModel(OllamaModel.LLAMA3)
                .build()
        ));
    return response.getResult().getOutput().getContent();
  }

}

