package se.magnus.api.core.review;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReviewService {
    @GetMapping("/review")
    Flux<Review> getReviews(@RequestParam int productId);

    @PostMapping( "/review")
    Mono<Review> createReview(@RequestBody Review body);

    @DeleteMapping( "/review")
    Mono<Void> deleteReviews(@RequestParam("productId")  int productId);
}
