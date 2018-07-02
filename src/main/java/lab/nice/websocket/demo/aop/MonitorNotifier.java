package lab.nice.websocket.demo.aop;

import lab.nice.websocket.demo.model.Metrics;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorNotifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorNotifier.class);

    private static final String KAFKA_METRICS_TOPIC = "/topic/kafkaMetrics";

    @Autowired
    private SimpMessagingTemplate template;

    @After(value = "execution(* lab.nice.websocket.demo.service.impl..*Metrics*.*save(..))")
    public void kafka(JoinPoint joinPoint){
        LOGGER.info("After {}.{} {}, copy and notify to Kafka metrics topic: {}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), joinPoint.getKind(), KAFKA_METRICS_TOPIC);
        Metrics metrics = (Metrics) joinPoint.getArgs()[0];
        template.convertAndSend(KAFKA_METRICS_TOPIC, metrics);
    }
}
