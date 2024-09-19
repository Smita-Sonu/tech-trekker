package org.jt.tech_trekker.dto;

import org.jt.tech_trekker.constant.BlogCategory;
import org.springframework.web.multipart.MultipartFile;

public record BlogRequest(
                String title,
                String description,
                BlogCategory category,
                MultipartFile banner) {

}
