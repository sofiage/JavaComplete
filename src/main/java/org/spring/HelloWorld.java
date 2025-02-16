package org.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloWorld {

    @GetMapping( "/")
    public String getCurrentTimeAndDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd MM yyyy");

        LocalDateTime now  = LocalDateTime.now();

        return formatter.format(now);


    }

}

