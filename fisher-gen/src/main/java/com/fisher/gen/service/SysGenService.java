package com.fisher.gen.service;


import com.fisher.gen.model.dto.BuildConfigDTO;

public interface SysGenService {

    /**
     * 根据表名生成代码
     * @param buildConfigDTO
     * @return
     */
    byte[] genCodeByTableName(BuildConfigDTO buildConfigDTO);

}
