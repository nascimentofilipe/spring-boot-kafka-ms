package com.dev.api.service;

import com.dev.api.client.CarPostStoreClient;
import com.dev.api.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<CarPostDto> getCarForSale() {
        return carPostStoreClient.carForSaleClient();
    }

    @Override
    public void changeCarForSale(CarPostDto carPost, String id) {
        carPostStoreClient.changeCarForSaleClient(carPost, id);

    }

    @Override
    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }
}
