package com.fisher.gateway.refresh;

import com.fisher.gateway.event.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 刷新zuul路由
 */
@RestController
public class RefreshController {

    @Autowired
    private RefreshRouteService refreshRouteService;

    @GetMapping("/refresh")
    public String refresh() {
        refreshRouteService.refreshRoute();
        return "refresh";
    }

}
