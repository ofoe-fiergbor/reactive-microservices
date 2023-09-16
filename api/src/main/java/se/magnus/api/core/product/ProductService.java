package se.magnus.api.core.product;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

public interface ProductService {
    @PostMapping("/product")
    Mono<Product> createProduct(@RequestBody Product body);

    @DeleteMapping("/product/{productId}")
    Mono<Void> deleteProduct(@PathVariable int productId);

    @GetMapping("/product/{productId}")
    Mono<Product> getProduct(@PathVariable int productId);

}
