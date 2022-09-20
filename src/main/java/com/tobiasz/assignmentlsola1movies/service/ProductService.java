package com.tobiasz.assignmentlsola1movies.service;

import com.tobiasz.assignmentlsola1movies.dto.ProductDto;
import java.util.List;

public interface ProductService {

    List<ProductDto> searchForProduct(String query);
}
