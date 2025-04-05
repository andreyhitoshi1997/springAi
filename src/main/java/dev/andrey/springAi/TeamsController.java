package dev.andrey.springAi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
public class TeamsController {

    private final ChatClient chatClient;

    public TeamsController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/teams")
    public List<NBATeam> teams(){
        return chatClient.prompt()
                .user("Please name all of the teams in NBA.")
                .call()
                .entity(new ParameterizedTypeReference<List<NBATeam>>() {});
    }
}

