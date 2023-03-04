package com.cchojnowski.nestedsetmodel.service;

import com.cchojnowski.nestedsetmodel.model.Category;

/**
 * @author cchojnowski
 */
public interface CategoryService {
    Category createParentCategory(String name);
    Category addChildToNoChildrenParent(String name, Long id);
    Category addChildToParentWithChildren(String name, Long id);
}
