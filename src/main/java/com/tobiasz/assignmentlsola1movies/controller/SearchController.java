package com.tobiasz.assignmentlsola1movies.controller;

import com.tobiasz.assignmentlsola1movies.dto.ProductDto;
import com.tobiasz.assignmentlsola1movies.dto.SearchResultsDto;
import com.tobiasz.assignmentlsola1movies.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final ProductService productService;

    @GetMapping
    public SearchResultsDto searchForProduct(@RequestParam("q") String query) {
        List<ProductDto> productDtos = this.productService.searchForProduct(query);
        return new SearchResultsDto(productDtos);
    }
}
