package com.pro.pro.controller;

import com.pro.pro.model.DTO.OutputDTO;
import com.pro.pro.model.DTO.ProDTO;
import com.pro.pro.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pros")
public class ProController {

    @Autowired
    ProService proService;

    @PostMapping
    public ResponseEntity<OutputDTO> createPro(@RequestBody ProDTO proDTO) {
        OutputDTO outputDTO = proService.createOutput(proDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.OK);
    }
}
