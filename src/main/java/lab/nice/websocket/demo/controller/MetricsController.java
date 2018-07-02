package lab.nice.websocket.demo.controller;

import lab.nice.websocket.demo.service.MetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/metrics")
public class MetricsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetricsController.class);

    @Autowired
    private MetricsService metricsService;

    @RequestMapping("/metrics")
    public String start() {
        return "metrics/metrics";
    }

    @RequestMapping(value = "/mock")
    public void mockMetrics() {
        LOGGER.info("Mock metrics data");
        metricsService.save(metricsService.status());
    }
}
