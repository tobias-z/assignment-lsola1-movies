package com.tobiasz.assignmentlsola1movies.repository;

import com.tobiasz.assignmentlsola1movies.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

}
