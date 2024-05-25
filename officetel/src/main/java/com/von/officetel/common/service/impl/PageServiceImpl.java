package com.von.officetel.common.service.impl;

import com.von.officetel.common.model.PageDTO;
import com.von.officetel.common.service.PageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {


    public PageDTO getPageDTO(long totalCount, int pageSize, int pageNum){

        long BLOCK_SIZE = 10;
        long blockNum = (pageNum-1)/pageSize+1;

        long pageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
        long blockCount = (pageCount % BLOCK_SIZE == 0) ? pageCount / BLOCK_SIZE : pageCount / BLOCK_SIZE + 1;

        long startRow = (long) (pageNum - 1) * pageSize;
        long endRow = (((pageNum - 1) * pageSize + pageSize - 1) > totalCount) ? totalCount : (pageNum - 1) * pageSize + (pageSize - 1);

        long startPage = (blockNum - 1) * BLOCK_SIZE + 1;
        long endPage = ((blockNum - 1) * BLOCK_SIZE + 1 + (BLOCK_SIZE - 1) > pageCount) ? pageCount : (blockNum - 1) * BLOCK_SIZE + 1 + (BLOCK_SIZE - 1);

        boolean existPrev = (blockNum != 1) ? true : false;
        boolean existNext = (blockNum != (blockCount)) ? true : false;

        long prevBlock = blockNum - 1;
        long nextBlock = blockNum + 1;

        return PageDTO.builder()
                .totalCount(totalCount)
                .pageCount(pageCount)
                .blockCount(blockCount)
                .startRow(startRow)
                .endRow(endRow)
                .startPage(startPage)
                .endPage(endPage)
                .existPrev(existPrev)
                .existNext(existNext)
                .prevBlock(prevBlock)
                .nextBlock(nextBlock)
                .build();
    }

    List<String> a = new ArrayList<>();
}
