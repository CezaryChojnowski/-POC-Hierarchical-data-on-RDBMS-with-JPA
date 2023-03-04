package com.cchojnowski.nestedsetmodel.repository;

import com.cchojnowski.nestedsetmodel.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 * @author cchojnowski
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Query(nativeQuery = true, value = "SELECT c.lft FROM category c WHERE c.id = (:parent)")
    Long findLftOfParentById(@Param("parent") Long parent);

    @Query(nativeQuery = true, value = "SELECT c.rgt FROM category c WHERE c.id = (:parent)")
    Long findRgtOfParentById(@Param("parent") Long parent);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE category SET rgt = rgt + 2 WHERE rgt > (:parent)")
    void updateCategoryRgt(@Param("parent") Long parent);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE category SET lft = lft + 2 WHERE lft > (:parent)")
    void updateCategoryLft(@Param("parent") Long parent);

    @Query(nativeQuery = true, value = "SELECT c.rgt FROM category c WHERE c.lft = (:lft)")
    Long findRgtOfLft(@Param("lft") Long lft);
}
