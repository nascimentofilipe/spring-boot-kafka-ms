package com.dev.api.service;

import com.dev.api.client.CarPostStoreClient;
import com.dev.api.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwner(OwnerPostDto ownerPostDto) {
        carPostStoreClient.ownerPostsClient(ownerPostDto);

    }
}
