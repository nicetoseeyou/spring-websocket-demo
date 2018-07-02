package lab.nice.websocket.demo.service;

import lab.nice.websocket.demo.model.Metrics;

public interface MetricsService {
    Metrics status();

    void save(Metrics metrics);
}
