package com.betrybe.healthproviders.controller;

import com.betrybe.healthproviders.dto.MedicDto;
import com.betrybe.healthproviders.entity.Medic;
import com.betrybe.healthproviders.service.MedicService;
import com.betrybe.healthproviders.util.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public ResponseEntity<List<MedicDto>> getAllMedics() {
        List<MedicDto> medicsDto = new ArrayList<>();

        for(Medic medic: medicService.getAllMedics()) {
            medicsDto.add(
                    DtoMapper.entityToDto(medic)
            );
        }
        return ResponseEntity.ok(medicsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDto> getMedic(@PathVariable Long id) {
        Medic medic = medicService.getMedicById(id);

        if (medic == null) {
            return ResponseEntity.notFound().build();
        }

        MedicDto medicDto = DtoMapper.entityToDto(medic);

        return ResponseEntity.ok(medicDto);
    }
}
