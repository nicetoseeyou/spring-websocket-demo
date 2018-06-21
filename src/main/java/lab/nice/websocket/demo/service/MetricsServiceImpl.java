package lab.nice.websocket.demo.service;

import lab.nice.websocket.demo.model.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

@Service(value = "metricsService")
public class MetricsServiceImpl implements MetricsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MetricsServiceImpl.class);

    @Override
    public Metrics status() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Instant now = Instant.now();
        return new Metrics(random.nextInt(0, Integer.MAX_VALUE), random.nextInt(0, Integer.MAX_VALUE), new Timestamp(now.toEpochMilli()));
    }
}
