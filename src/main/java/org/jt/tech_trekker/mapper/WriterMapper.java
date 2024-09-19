package org.jt.tech_trekker.mapper;

import org.jt.tech_trekker.dto.WriterRequest;
import org.jt.tech_trekker.model.WriterInfo;
import org.springframework.beans.BeanUtils;

public class WriterMapper {
    public static WriterInfo convertRequest(WriterRequest request) {
        var writerInfo = new WriterInfo();
        BeanUtils.copyProperties(request, writerInfo);
        return writerInfo;
    }
}
