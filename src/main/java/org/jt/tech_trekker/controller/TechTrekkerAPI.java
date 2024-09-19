package org.jt.tech_trekker.controller;

import org.jt.tech_trekker.service.TechTrekkerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TechTrekkerAPI {
    private final TechTrekkerService service;

    @GetMapping(path = "/blog/image/{blogId}", produces = { "image/jpg", "image/png" })
    public byte[] blogBanner(@PathVariable String blogId) {
        return service.getBanner(blogId);
    }
}
