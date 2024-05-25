package com.von.officetel.common.service;


import com.von.officetel.common.model.PageDTO;

public interface PageService {
    PageDTO getPageDTO(long totalCount, int pageSize, int pageNum);
}
