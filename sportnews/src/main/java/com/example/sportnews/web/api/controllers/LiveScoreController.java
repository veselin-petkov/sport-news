package com.example.sportnews.web.api.controllers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/livescore")
@Controller
public class LiveScoreController {

    @GetMapping
    public String getResponse() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.sofascore.com/api/v1/sport/football/events/live")
                .get()
                .addHeader("authority", "api.sofascore.com")
                .addHeader("accept", "*/*")
                .addHeader("accept-language", "en-US,en;q=0.9")
                .addHeader("cache-control", "max-age=0")
                .addHeader("if-none-match", "W/^\\^b4e1eda016^^")
                .addHeader("origin", "https://www.sofascore.com")
                .addHeader("referer", "https://www.sofascore.com/")
                .addHeader("sec-ch-ua", "^\\^")
                .build();

        try {
            return Objects.requireNonNull(client.newCall(request).execute().body()).string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
