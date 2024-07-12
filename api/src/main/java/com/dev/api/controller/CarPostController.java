package com.dev.api.controller;

import com.dev.api.dto.CarPostDto;
import com.dev.api.message.KafkaProducerMessage;
import com.dev.api.service.CarPostStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {
    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDto carPostDTO) {
        LOG.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Car Post information: {}", carPostDTO);
        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDto>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSale());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDto carPostDTO, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSale(carPostDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        carPostStoreService.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
