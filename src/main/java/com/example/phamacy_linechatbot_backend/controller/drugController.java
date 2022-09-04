package com.example.phamacy_linechatbot_backend.controller;

import com.example.phamacy_linechatbot_backend.entities.drug;
import com.example.phamacy_linechatbot_backend.service.drugService;
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
public class drugController {
    @Autowired
    drugService drugService;

    @GetMapping("drugs")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page, @RequestParam(value = "name", required = false) String name) {
        perPage = perPage == null ? 10 : perPage;
        page = page == null ? 1 : page;
        Page<drug> pageOutput;
        if (name == null) {
            pageOutput = drugService.getEvents(perPage, page);
        } else {
            pageOutput = drugService.getEvent(name, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getDrugDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);

    }

    @GetMapping("drugs/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {

        drug output = drugService.getEvent(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getDrugDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/drugs")
    public ResponseEntity<?> addEvent(@RequestBody drug event) {
        drug output = drugService.save(event);
        return ResponseEntity.ok(LabMapper.INSTANCE.getDrugDTO(output));

    }

    @DeleteMapping("/drugs/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        drug event = drugService.getEvent(id);
        drugService.delete(event);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @PutMapping("/drugs/{id}")
    public ResponseEntity<?> updateDrug(@PathVariable(value = "id") Long id, @RequestBody drug drugDetail) {
        drug Drug = drugService.getEvent(id);

        if (drugDetail.getName() == null){
            drugDetail.setName(Drug.getName());
        }
        if (drugDetail.getDescription() == null){
            drugDetail.setDescription(Drug.getDescription());
        }
        if (drugDetail.getShortDesc() == null){
            drugDetail.setShortDesc(Drug.getShortDesc());
        }
        if (drugDetail.getHowToTake() == null){
            drugDetail.setHowToTake(Drug.getShortDesc());
        }

        Drug.setName(drugDetail.getName());
        Drug.setDescription(drugDetail.getDescription());
        Drug.setShortDesc(drugDetail.getShortDesc());
        Drug.setHowToTake(drugDetail.getHowToTake());
        final drug updatedDrug = drugService.save(Drug);
        return ResponseEntity.ok(updatedDrug);
    }


}
