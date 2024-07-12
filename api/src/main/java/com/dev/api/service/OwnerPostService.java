package com.dev.api.service;

import com.dev.api.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwner(OwnerPostDto ownerPostDto);
}
