package vn.tuanflutte.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BlogId")
    private int blogId;
    @Column(name = "BlogImage")
    private String blogImage;
    @Column(name = "BlogTitle")
    private String blogTitle;
    @Column(name = "BlogDescription")
    private  String blogDescription;


    public Blog() {
    }

    public Blog(String blogImage, String blogTitle, String blogDescription) {
        this.blogImage = blogImage;
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(String blogImage) {
        this.blogImage = blogImage;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }
}
