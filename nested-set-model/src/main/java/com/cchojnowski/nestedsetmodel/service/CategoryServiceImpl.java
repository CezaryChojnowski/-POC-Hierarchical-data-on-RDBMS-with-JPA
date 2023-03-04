/**
 * 12 lut 2023 06:59:44
 */
package com.cchojnowski.nestedsetmodel.service;

import com.cchojnowski.nestedsetmodel.model.Category;
import com.cchojnowski.nestedsetmodel.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cchojnowski
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private static final int LEFT_SHIFT = 1;
    private static final int RIGHT_SHIFT = 2;

    @Override
    public Category createParentCategory(String name) {
        return categoryRepository.save(Category.builder().name(name).build());
    }

    @Override
    public Category addChildToNoChildrenParent(String name, Long id) {
        final Long lft = categoryRepository.findLftOfParentById(id);

        categoryRepository.updateCategoryRgt(lft);

        categoryRepository.updateCategoryLft(lft);

        return categoryRepository.save(
                Category
                        .builder()
                        .name(name)
                        .lft(lft + LEFT_SHIFT)
                        .rgt(lft + RIGHT_SHIFT)
                        .build()
        );
    }

    @Override
    public Category addChildToParentWithChildren(String name, Long id) {

        final Long lft = categoryRepository.findLftOfParentById(id);

        //first children of parent
        final Long rgt = categoryRepository.findRgtOfLft(lft+1);

        categoryRepository.updateCategoryRgt(rgt);

        categoryRepository.updateCategoryLft(rgt);

        return categoryRepository.save(
                Category
                        .builder()
                        .name(name)
                        .lft(rgt + LEFT_SHIFT)
                        .rgt(rgt + RIGHT_SHIFT)
                        .build()
        );
    }
}
