package com.dev.api.controller;

import com.dev.api.dto.OwnerPostDto;
import com.dev.api.service.OwnerPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")

public class OwnerPostController {
    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostDto ownerPostDTO) {
        LOG.info("USANDO API REST - Criando Novo Usuário: {}", ownerPostDTO);
        ownerPostService.createOwner(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}