package se.magnus.microservices.core.review.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.magnus.api.core.review.Review;
import se.magnus.api.core.review.ReviewService;
import se.magnus.api.event.Event;
import se.magnus.api.exception.EventProcessingException;

import java.util.function.Consumer;

@Configuration
public class MessageProcessorConfig {
    private static final Logger LOG = LoggerFactory.getLogger(MessageProcessorConfig.class);

    private final ReviewService reviewService;

    public MessageProcessorConfig(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Bean
    public Consumer<Event<Integer, Review>> messageProcessor() {
        return event -> {
            switch (event.getEventType()) {
                case CREATE:
                    Review review = event.getData();
                    LOG.info("Create Review with productID: {}", review.getProductId());
                    reviewService.createReview(review).block();
                    break;
                case DELETE:
                    int productId = event.getKey();
                    LOG.info("Delete Review with productId: {}", productId);
                    reviewService.deleteReviews(productId).block();
                    break;
                default:
                    String errorMessage = "Incorrect event type "+ event.getEventType()+" provided";
                    LOG.warn(errorMessage);
                    throw new EventProcessingException(errorMessage);
            }

            LOG.info("Message processing done..!");
        };
    }
}
