package com.saraco.edgeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
class WelcomeController {

    @GetMapping("welcome")
    Mono<Welcome> getWelcome() {
        return Mono.just(new Welcome("Welcome to Literary Haven Bookshop!"));
    }

}
