package vn.tuanflutte.services.blog;

import org.springframework.web.multipart.MultipartFile;
import vn.tuanflutte.entities.Blog;
import vn.tuanflutte.entities.Category;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    public List<Blog> findAll();
    public List<Blog> findByTitle(String key);
    public Optional<Blog> findById(Integer blogId);
    public Blog save(Blog blog);
    public boolean existsById(Integer blogId);
    public void deleteById(Integer blogId);
}
