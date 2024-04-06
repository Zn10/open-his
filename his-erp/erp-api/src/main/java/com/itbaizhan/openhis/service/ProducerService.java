package com.itbaizhan.openhis;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.Producer;
import com.itbaizhan.openhis.dto.ProducerDto;
import com.itbaizhan.openhis.vo.DataGridView;

import java.util.List;

/**
* @author a
* @description 针对表【stock_producer(生产厂家表)】的数据库操作Service
*/
public interface ProducerService extends IService<Producer> {

    DataGridView listProducerForPage(ProducerDto producerDto);

    int addProducer(ProducerDto producerDto);

    int updateProducer(ProducerDto producerDto);

    Producer getOne(Long producerId);

    int deleteProducterByIds(Long[] producerIds);

    /**
     * 查询所有可用生产厂家
     */
    List<Producer> selectAllProducter();

}
