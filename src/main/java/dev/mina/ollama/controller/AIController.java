package dev.mina.ollama.controller;

import dev.mina.ollama.service.LlamaAiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AIController {

  private final LlamaAiService aiService;

  public AIController(LlamaAiService aiService) {
    this.aiService = aiService;
  }

  @GetMapping("/api/v1/generate")
  public String generate(@RequestParam(value = "prompt") String prompt) {
    return aiService.generateResult(prompt);
  }
}
