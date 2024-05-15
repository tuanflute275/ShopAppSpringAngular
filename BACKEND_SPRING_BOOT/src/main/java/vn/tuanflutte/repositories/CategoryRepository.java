package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tuanflutte.entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByCategoryName(String key);
}
