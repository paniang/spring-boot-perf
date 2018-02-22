package com.example.demo;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(1);

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.get(),
                String.format(template, name));
    }

    @RequestMapping(value = "/persistAge", method = RequestMethod.POST)
    public ResponseEntity<String> persistPerson(@RequestBody String age) {
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}