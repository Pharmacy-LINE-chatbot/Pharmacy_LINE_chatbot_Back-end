package com.example.phamacy_linechatbot_backend.controller;


import com.example.phamacy_linechatbot_backend.entities.purchasingDetail;
import com.example.phamacy_linechatbot_backend.service.purchasingDetailService;
import com.example.phamacy_linechatbot_backend.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class purchasingDetailController {
    @Autowired
    purchasingDetailService purchasingDetailService;

    @GetMapping("purchasingDetails")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page, @RequestParam(value = "name", required = false) String name) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<purchasingDetail> pageOutput;
        if (name == null) {
            pageOutput = purchasingDetailService.getEvents(perPage, page);
        } else {
            pageOutput = purchasingDetailService.getEvent(name, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPurchasingDetailDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);

    }

    @GetMapping("purchasingDetails/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {

        purchasingDetail output = purchasingDetailService.getEvent(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getPurchasingDetailDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/purchasingDetails")
    public ResponseEntity<?> addEvent(@RequestBody purchasingDetail event) {
        purchasingDetail output = purchasingDetailService.save(event);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPurchasingDetailDTO(output));

    }
}
