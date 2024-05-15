package vn.tuanflutte.services.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.tuanflutte.entities.Blog;
import vn.tuanflutte.repositories.BlogRepository;

import java.util.*;

@Service
public class BlogService implements IBlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "blogId"));
    }

    @Override
    public List<Blog> findByTitle(String key) {
        return blogRepository.findByBlogTitle(key);
    }

    @Override
    public Optional<Blog> findById(Integer blogId) {
        return blogRepository.findById(blogId);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public boolean existsById(Integer blogId) {
        return blogRepository.existsById(blogId);
    }

    @Override
    public void deleteById(Integer blogId) {
        blogRepository.deleteById(blogId);
    }
}
