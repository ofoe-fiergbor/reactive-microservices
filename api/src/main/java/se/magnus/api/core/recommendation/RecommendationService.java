package se.magnus.api.core.recommendation;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecommendationService {

    @PostMapping( "/recommendation")
    Mono<Recommendation> createRecommendation(@RequestBody Recommendation body);
    @GetMapping("/recommendation")
    Flux<Recommendation> getRecommendations(@RequestParam(name = "productId") int productId);

    @DeleteMapping( "/recommendation")
    Mono<Void> deleteRecommendations(@RequestParam(value = "productId", required = true)  int productId);
}
