package com.itbaizhan.openhis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itbaizhan.openhis.domain.PatientFile;
import com.itbaizhan.openhis.mapper.PatientFileMapper;
import com.itbaizhan.openhis.service.PatientFileService;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【his_patient_file】的数据库操作Service实现
*/
@Service
public class PatientFileServiceImpl extends ServiceImpl<PatientFileMapper, PatientFile>
    implements PatientFileService{

}




