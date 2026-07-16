package com.divination.config;

import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AiConfig {

    @Value("${langchain4j.open-ai.chat-model.api-key}")
    private String openaiApiKey;

    @Value("${langchain4j.open-ai.chat-model.model-name}")
    private String modelName;

    @Value("${langchain4j.open-ai.chat-model.base-url}")
    private String baseurl;

    /**
     * 定义一个 StreamingChatModel Bean，这是解决 null 异常的关键。
     * LangChain4j 会自动将这个 Bean 注入到返回 Flux 的 AI Service 方法中。
     */
    @Bean
    public StreamingChatModel streamingChatModel() {
        return OpenAiStreamingChatModel.builder()
                .baseUrl(baseurl)
                .apiKey(openaiApiKey)
                .modelName(modelName)
                .customParameters(Map.of("thinking", Map.of("type", "disabled")))
                .build();
    }
}