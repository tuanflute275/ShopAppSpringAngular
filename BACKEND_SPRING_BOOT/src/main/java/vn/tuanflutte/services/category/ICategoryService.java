package vn.tuanflutte.services.category;

import vn.tuanflutte.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    public List<Category> findAll();
    public List<Category> findAllNoSort();
    public List<Category> findByName(String key);
    public Optional<Category> findById(Integer categoryId);
    public Category save(Category category);
    public boolean existsById(Integer categoryId);
    public void deleteById(Integer categoryId);
}
