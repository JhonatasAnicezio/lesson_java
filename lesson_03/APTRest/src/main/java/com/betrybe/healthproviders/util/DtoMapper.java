package com.betrybe.healthproviders.util;

import com.betrybe.healthproviders.dto.MedicDto;
import com.betrybe.healthproviders.entity.Medic;

public class DtoMapper {
    public static MedicDto entityToDto(Medic medic) {
        return new MedicDto(
                medic.getId(),
                medic.getName(),
                medic.getSpecialty()
        );
    }
}
