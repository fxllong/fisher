package com.fisher.gen.model.config;

import lombok.Data;

@Data
public class BaseConfig {

    /**
     * 包名
     */
    private String packageName;

    /**
     * query类的包名
     */
    private String queryPackageName;

    /**
     * mapper类包名
     */
    private String mapperPackageName;

    /**
     * controller类包名
     */
    private String controllerPackageName;

    /**
     * service类包名
     */
    private String servicePackageName;

    /**
     * serviceApi类包名
     */
    private String serviceApiPackageName;

    /**
     * dao的包名
     */
    private String daoPackageName;

    /**
     * 作者名称
     */
    private String authorName;

}
