package org.jt.tech_trekker.dto;

import org.springframework.web.multipart.MultipartFile;

public record WriterRequest(
                String writerName,
                String email,
                String password,
                String writerProfession,
                MultipartFile profilePicture) {

}
