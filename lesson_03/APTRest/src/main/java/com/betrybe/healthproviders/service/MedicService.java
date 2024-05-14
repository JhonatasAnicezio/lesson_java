package com.betrybe.healthproviders.service;

import com.betrybe.healthproviders.repository.MedicFakeRepository;

public class MedicService {
    private final MedicFakeRepository medicFakeRepository;

    public MedicService(MedicFakeRepository medicFakeRepository) {
        this.medicFakeRepository = medicFakeRepository;
    }
}
