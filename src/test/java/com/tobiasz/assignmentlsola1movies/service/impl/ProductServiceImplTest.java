package com.tobiasz.assignmentlsola1movies.service.impl;

import com.tobiasz.assignmentlsola1movies.dto.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    @DisplayName("can find results given a search query")
    void canFindResultsGivenASearchQuery() throws Exception {
        String searchQuery = "How I Met Your Mother";
        List<ProductDto> products = this.productService.searchForProduct(searchQuery);
        assertThat(products)
                .extracting(ProductDto::getTitle)
                .contains(searchQuery);
    }

    @Test
    @DisplayName("can fuzzy find")
    void canFuzzyFind() throws Exception {
        String searchQuery = "Mother Your";
        List<ProductDto> products = this.productService.searchForProduct(searchQuery);
        assertThat(products)
                .extracting(ProductDto::getTitle)
                .contains("How I Met Your Mother");
    }

}