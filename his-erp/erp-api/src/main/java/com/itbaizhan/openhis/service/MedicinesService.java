package com.itbaizhan.openhis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.Medicines;
import com.itbaizhan.openhis.dto.MedicinesDto;
import com.itbaizhan.openhis.vo.DataGridView;

/**
* @author a
* @description 针对表【stock_medicines(药品信息表)】的数据库操作Service
*/
public interface MedicinesService extends IService<Medicines> {

    DataGridView listMedicinesForPage(MedicinesDto medicinesDto);

    int addMedicines(MedicinesDto medicinesDto);

    int updateMedicines(MedicinesDto medicinesDto);

    Medicines getOne(Long medicinesId);

    int deleteMedicinesByIds(Long[] medicinesIds);

    int updateMedicinesStockNum(Long medicinesId, Integer stockNum);

    int deductionMedicinesStorage(Long medicineId, long num);
}
