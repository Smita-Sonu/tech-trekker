package org.jt.tech_trekker.service;

import java.util.List;

import org.jt.tech_trekker.constant.BlogCategory;
import org.jt.tech_trekker.model.Blog;
import org.jt.tech_trekker.model.WriterInfo;
import org.springframework.web.multipart.MultipartFile;

public interface TechTrekkerService {
    void createWritter(WriterInfo info);

    void createBlog(Blog blog, MultipartFile file);

    List<Blog> getBlogs();

    Blog getBlogById(String id);

    byte[] getBanner(String blogId);

    List<Blog> getTop5Blogs();

    List<Blog> limitedBlogOfCategory(BlogCategory category, int limit, int page);

    List<Blog> limitedBlogOfCategory(BlogCategory category, int limit);

    int countBlogs(BlogCategory blogCategory);

    List<Blog> blogOfCategoryAndTitle(BlogCategory category, int page, String title, int limit);

    int countBlogsOfTitle(BlogCategory blogCategory, String title);

}
