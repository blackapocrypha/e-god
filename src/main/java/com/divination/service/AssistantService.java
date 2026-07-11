package com.divination.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;


@AiService
public interface AssistantService {

    // 🌟 新增的流式输出方法
    @SystemMessage("你是一个专业的四柱八字命理学大师")
    Flux<String> chatStreamWithEightMaster(@UserMessage String userQuestion);
}