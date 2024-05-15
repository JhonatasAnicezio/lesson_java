package com.betrybe.healthproviders.util;

import com.betrybe.healthproviders.dto.MedicDto;
import com.betrybe.healthproviders.entity.Medic;

public class DtoMapper {
    public static MedicDto entityDto(Medic medic) {
        return new MedicDto(
                medic.getId(),
                medic.getName(),
                medic.getSpecialty()
        );
    }
}
