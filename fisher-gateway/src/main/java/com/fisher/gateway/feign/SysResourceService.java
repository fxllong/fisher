package com.fisher.gateway.feign;

import com.fisher.common.constants.PandaServiceNameConstants;
import com.fisher.common.vo.SysResourceVO;
import com.fisher.gateway.feign.fallback.SysResourceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(value = PandaServiceNameConstants.FISHER_USER_SERVICE, fallback = SysResourceFallback.class)
public interface SysResourceService {

    /**
     * 根据角色查询资源信息
     * @param roleCode
     * @return
     */
    @GetMapping("/resource/role/{roleCode}")
    Set<SysResourceVO> listResourceByRole(@PathVariable("roleCode") String roleCode);

}
