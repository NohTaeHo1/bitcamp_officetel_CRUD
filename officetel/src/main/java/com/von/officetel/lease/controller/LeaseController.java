package com.von.officetel.lease.controller;

import com.von.officetel.common.model.Box;
import com.von.officetel.common.model.MessengerVo;
import com.von.officetel.common.service.impl.PageServiceImpl;
import com.von.officetel.lease.model.LeaseDTO;
import com.von.officetel.lease.service.LeaseServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/officetel")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "dd")})
public class LeaseController {
    private final LeaseServiceImpl LeaseService;
    private final LeaseRouter router;
    private final PageServiceImpl pageService;

    @PostMapping( "/insert")
    public ResponseEntity<MessengerVo> insert(@RequestBody LeaseDTO dto) {
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(LeaseService.insert(dto));
    }

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchPlayer(
            @RequestParam(value = "q", required = true) String q,
            @RequestParam(value = "playerName", required = false) String playerName,
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "teamId", required = false) String teamId,
            Pageable pageable
    ) {
        log.info("MY-INFO : Controller searchPlayer q is {}", q);
        log.info("MY-INFO : Controller searchPlayer page is {}", pageable.getPageNumber());
        log.info("MY-INFO : Controller searchPlayer limit is {}", pageable.getPageSize());
        log.info("MY-INFO : Controller searchPlayer sortField is {}", pageable.getSort().toString());

        log.info("Controller searchPlayer q is {}", q);

        long startTime = System.nanoTime();
        List<?> o = router.execute(q, pageable.getPageNumber(), pageable.getPageSize());
        //long totalCount = officeService.countAllPlayer();
        //PageDTO page = pageService.getPageDTO(totalCount, pageable.getPageSize(), pageable.getPageNumber());

        Box box = new Box();
        //box.setPageDTO(page);
        box.setList(o);

        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        return ResponseEntity.ok(box);
    }


}