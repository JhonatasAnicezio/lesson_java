package com.betrybe.healthproviders.controller;

import com.betrybe.healthproviders.entity.Medic;
import com.betrybe.healthproviders.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medics")
public class MedicController {
    private final MedicService medicService;

    @Autowired
    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @GetMapping
    public ResponseEntity<List<Medic>> getMedics() {
        List<Medic> medics = medicService.getAllMedics();
        return ResponseEntity.ok(medics);
    }
}
