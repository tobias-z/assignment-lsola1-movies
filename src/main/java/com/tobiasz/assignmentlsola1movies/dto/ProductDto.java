package com.tobiasz.assignmentlsola1movies.dto;

import com.tobiasz.assignmentlsola1movies.model.Product;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String title;
    private String category;

    public static ProductDto productToDto(Product product) {
        return ProductDto.builder()
                            .id(product.getId())
                            .title(product.getTitle())
                            .category(product.getCategory()) .build();
    }
}
