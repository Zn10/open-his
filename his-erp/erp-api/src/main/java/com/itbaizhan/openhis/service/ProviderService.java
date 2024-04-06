package com.itbaizhan.openhis;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itbaizhan.openhis.domain.Provider;
import com.itbaizhan.openhis.dto.ProviderDto;
import com.itbaizhan.openhis.vo.DataGridView;

import java.util.List;

/**
* @author a
* @description 针对表【stock_provider(供应商信息表)】的数据库操作Service
*/
public interface ProviderService extends IService<Provider> {

    DataGridView listProviderForPage(ProviderDto providerDto);

    int addProvider(ProviderDto providerDto);

    int updateProvider(ProviderDto providerDto);

    Provider getOne(Long providerId);

    int deleteProviderByIds(Long[] providerIds);

    /**
     * 查询所有可用供应商
     */
    List<Provider> selectAllProvider();
}
