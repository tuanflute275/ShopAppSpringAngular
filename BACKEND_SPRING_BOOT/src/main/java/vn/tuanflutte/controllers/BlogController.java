package vn.tuanflutte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.tuanflutte.entities.Blog;
import vn.tuanflutte.exception.ResponseObject;
import vn.tuanflutte.services.blog.IBlogService;
import vn.tuanflutte.services.uploadFile.IUploadFileService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    ResponseEntity<ResponseObject> getAllBlog(@RequestParam(defaultValue = "") String key){
        List<Blog> list = null;
        if (key.equals("")){
             list = blogService.findAll();
        }else {
            list = blogService.findByTitle(key);
            if(list.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "No Data", "")
                );
            }
        }

        if(!list.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query blog successfully", list)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "No Data", "")
            );
        }
    }

    @GetMapping("/{blogId}")
        //let's return an object with : data, message, status
    ResponseEntity<ResponseObject> findById(@PathVariable int blogId){
        Optional<Blog> foundCategory = blogService.findById(blogId);
        if(foundCategory.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "Query blog successfully", foundCategory)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "cannot find blog with id = "+blogId, "")
            );
        }
    }

    @PostMapping("")
    ResponseEntity<ResponseObject> insertBlog(@RequestBody Blog newBlog){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Insert data successfully", blogService.save(newBlog))
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("error", "Insert data failed", "")
            );
        }
    }

    @PutMapping("/{blogId}")
    ResponseEntity<ResponseObject> updateBlog(@RequestBody Blog newBlog, @PathVariable int blogId){
        Blog updateBlog = blogService.findById(blogId)
                .map(blog -> {
                    blog.setBlogTitle(newBlog.getBlogTitle());
                    blog.setBlogImage(newBlog.getBlogImage());
                    blog.setBlogDescription(newBlog.getBlogDescription());
                    return blogService.save(blog);
                }).orElseGet(()->{
                    newBlog.setBlogId(blogId);
                    return blogService.save(newBlog);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "Update data successfuly", updateBlog)
        );
    }

    @DeleteMapping("/{blogId}")
    ResponseEntity<ResponseObject> deleteBlog(@PathVariable int blogId){
        boolean exits = blogService.existsById(blogId);
        if(exits){
            blogService.deleteById(blogId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete data successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find data to delete", "")
        );
    }

}
