package com.tobiasz.assignmentlsola1movies.service.impl;

import static com.tobiasz.assignmentlsola1movies.model.Product.PRODUCT_INDEX;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import com.tobiasz.assignmentlsola1movies.dto.ProductDto;
import com.tobiasz.assignmentlsola1movies.model.Product;
import com.tobiasz.assignmentlsola1movies.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.common.unit.Fuzziness;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<ProductDto> searchForProduct(String query) {
        Query searchQuery = new NativeSearchQueryBuilder()
            .withQuery(matchQuery("title", query)
                .fuzziness(Fuzziness.AUTO)
                .minimumShouldMatch("50%"))
            .build();

        return this.elasticsearchOperations
            .search(searchQuery, Product.class, IndexCoordinates.of(PRODUCT_INDEX))
            .getSearchHits()
            .stream()
            .map(SearchHit::getContent)
            .map(ProductDto::productToDto)
            .collect(Collectors.toList());
    }
}
