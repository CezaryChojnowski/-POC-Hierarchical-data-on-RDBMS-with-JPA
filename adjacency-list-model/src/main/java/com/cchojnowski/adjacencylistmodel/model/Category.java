/**
 * 11 lut 2023 16:29:09
 */
package com.cchojnowski.adjacencylistmodel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cchojnowski
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy="category")
    private List<Category> subCategory;

}

