package org.jt.tech_trekker.service.impl;

import java.util.List;

import org.jt.tech_trekker.constant.BlogCategory;
import org.jt.tech_trekker.model.Blog;
import org.jt.tech_trekker.model.WriterInfo;
import org.jt.tech_trekker.repository.BlogRepository;
import org.jt.tech_trekker.repository.WriterInfoRepository;
import org.jt.tech_trekker.service.FileService;
import org.jt.tech_trekker.service.TechTrekkerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechTrekkerServiceImpl implements TechTrekkerService {
    private final WriterInfoRepository writterRepository;
    private final BlogRepository blogRepository;
    private final FileService fileService;
    private final PasswordEncoder encoder;

    @Override
    public void createWritter(WriterInfo info) {
        var bcrypt = encoder.encode(info.getPassword());
        info.setPassword(bcrypt);
        writterRepository.save(info);
    }

    @Override
    public void createBlog(Blog blog, MultipartFile file) {
        String fileName = fileService.uploadBlogBanner(file);
        blog.setBanner(fileName);
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog getBlogById(String id) {
        return blogRepository.findById(id).orElseThrow();
    }

    @Override
    public byte[] getBanner(String blogId) {
        var blog = getBlogById(blogId);
        var banner = blog.getBanner();
        return fileService.getBlogBanner(banner);

    }

    @Override
    public List<Blog> getTop5Blogs() {
        return blogRepository.findTop5ByOrderByTitle();
    }

    @Override
    public List<Blog> limitedBlogOfCategory(BlogCategory category, int limit) {
        return blogRepository.findByCategory(category, PageRequest.of(0, limit));
    }

    @Override
    public List<Blog> limitedBlogOfCategory(BlogCategory category, int limit, int page) {
        return blogRepository.findByCategory(category, PageRequest.of(page - 1, limit));
    }

    @Override
    public int countBlogs(BlogCategory blogCategory) {
        return (int) blogRepository.countByCategory((blogCategory));
    }

    @Override
    public List<Blog> blogOfCategoryAndTitle(BlogCategory category, int page, String title, int limit) {
        return blogRepository.findByCategoryAndTitleContaining(category, title, PageRequest.of(page - 1, limit));
    }

    @Override
    public int countBlogsOfTitle(BlogCategory blogCategory, String title) {
        return (int) blogRepository.countByCategoryAndTitleContaining(blogCategory, title);
    }
}
