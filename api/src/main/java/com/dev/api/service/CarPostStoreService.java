package com.dev.api.service;

import com.dev.api.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDto> getCarForSale();

    void changeCarForSale(CarPostDto carPost, String id);

    void removeCarForSale(String id);


}
