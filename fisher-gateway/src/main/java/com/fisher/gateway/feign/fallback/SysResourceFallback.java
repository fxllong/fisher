package com.fisher.gateway.feign.fallback;

import com.fisher.common.vo.SysResourceVO;
import com.fisher.gateway.feign.SysResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Slf4j
@Service
public class SysResourceFallback implements SysResourceService{
    @Override
    public Set<SysResourceVO> listResourceByRole(String roleCode) {
        log.error("调用【fisher-back-service】服务接口【/resource/role/{}】异常", roleCode);
        return Collections.emptySet();
    }
}
