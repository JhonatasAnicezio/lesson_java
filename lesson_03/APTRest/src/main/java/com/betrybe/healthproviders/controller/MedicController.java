package com.betrybe.healthproviders.controller;

import com.betrybe.healthproviders.service.MedicService;

public class MedicController {
    private final MedicService medicService;

    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }
}
