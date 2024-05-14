package com.betrybe.healthproviders.service;

import com.betrybe.healthproviders.repository.MedicFakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicService {
    private final MedicFakeRepository medicFakeRepository;

    @Autowired
    public MedicService(MedicFakeRepository medicFakeRepository) {
        this.medicFakeRepository = medicFakeRepository;
    }
}
