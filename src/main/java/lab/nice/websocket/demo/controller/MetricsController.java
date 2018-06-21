package lab.nice.websocket.demo.controller;

import lab.nice.websocket.demo.model.Input;
import lab.nice.websocket.demo.service.MetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MetricsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetricsController.class);
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private MetricsService metricsService;

    @RequestMapping("/metrics")
    public String start() {
        return "metrics/metrics";
    }

    @MessageMapping(value = "/hello")
    public void status(Input input) throws InterruptedException {
        LOGGER.info("Request input: {}", input);
        for(int i =0; i<5; i++){
            Thread.sleep(2000);
            template.convertAndSend("/topic/real", metricsService.status());
        }
    }
}
