package com.betrybe.healthproviders.repository;

import com.betrybe.healthproviders.entity.Medic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicFakeRepository {
    private static final Map<Long, Medic> MEDICS = new HashMap<>();

    static {
        MEDICS.put(1L, new Medic(1L, "Dra, Maria", "Neurologista", "123456"));
        MEDICS.put(1L, new Medic(2L, "Dr, Jonas", "Cardiologista", "123456"));
    }

    public List<Medic> getAllMedics() {
        return new ArrayList<>(MEDICS.values());
    }

    public Medic getMedic(Long id) {
        return MEDICS.get(id);
    }

    public Medic saveMedic(Medic medic) {
        Long id = medic.getId();

        if (id == null) {
            id = (long) (MEDICS.size() +1);
        }

        Medic savedMedic = new Medic(id, medic.getName(), medic.getSpecialty(), medic.getCpf());

        MEDICS.put(id, savedMedic);

        return savedMedic;
    }
}
