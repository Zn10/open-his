package com.itbaizhan.openhis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.Patient;
import com.itbaizhan.openhis.domain.PatientFile;
import com.itbaizhan.openhis.dto.PatientDto;
import com.itbaizhan.openhis.vo.DataGridView;

/**
* @author a
* @description 针对表【his_patient(患者信息表)】的数据库操作Service
*/
public interface PatientService extends IService<Patient> {

    DataGridView listPatientForPage(PatientDto patientDto);

    Patient getPatientById(String patientId);

    PatientFile getPatientFileById(String patientId);

    Patient getPatientByIdCard(String idCard);

    Patient addPatient(PatientDto patientDto);
}
