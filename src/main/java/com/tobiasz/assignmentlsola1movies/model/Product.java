package com.tobiasz.assignmentlsola1movies.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = Product.PRODUCT_INDEX)
public class Product {

    public static final String PRODUCT_INDEX = "productindex";

    @Id
    private Integer id;

    @Field(type = FieldType.Text, name = "title")
    private String title;

    @Field(type = FieldType.Text, name = "category")
    private String category;
}
