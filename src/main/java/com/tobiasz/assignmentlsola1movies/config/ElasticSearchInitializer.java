package com.tobiasz.assignmentlsola1movies.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tobiasz.assignmentlsola1movies.model.Product;
import com.tobiasz.assignmentlsola1movies.repository.ProductRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ElasticSearchInitializer {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    @Value("classpath:products.json")
    private Resource resourceFile;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeProducts() throws IOException {
        this.productRepository.deleteAll();
        this.productRepository.saveAll(this.getProductsToInitialize());
    }

    private List<Product> getProductsToInitialize() throws IOException {
        return this.objectMapper.readValue(this.resourceFile.getFile(), ProductWrapper.class).getProducts();
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    static class ProductWrapper {
        private List<Product> products;
    }
}
