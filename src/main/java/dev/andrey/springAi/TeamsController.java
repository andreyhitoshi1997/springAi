package dev.andrey.springAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsController {

    private final ChatClient chatClient;

    public TeamsController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/teams")
    public String teams(){
        String response = chatClient.prompt()
                .user("Please name all of the teams in NBA.")
                .call()
                .content();
        return response;
    }
}

