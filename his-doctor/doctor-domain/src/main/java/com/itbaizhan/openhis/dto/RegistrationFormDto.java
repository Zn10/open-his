package com.itbaizhan.openhis.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:
 */
@ApiModel(value="com-itbaizhan-openhis-dto-RegistrationFormDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationFormDto implements Serializable {

    private com.itbaizhan.openhis.dto.PatientDto patientDto;

    private RegistrationDto registrationDto;
}
