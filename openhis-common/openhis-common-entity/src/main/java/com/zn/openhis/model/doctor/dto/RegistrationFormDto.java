package com.zn.openhis.model.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationFormDto implements Serializable {

    private PatientDto patientDto;

    private RegistrationDto registrationDto;
}
