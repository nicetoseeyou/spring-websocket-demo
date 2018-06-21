package lab.nice.websocket.demo.model;

import java.sql.Timestamp;

public class Metrics {
    private Integer in;
    private Integer out;
    private Timestamp time;

    public Metrics() {
        super();
    }

    public Metrics(Integer in, Integer out, Timestamp time) {
        super();
        this.in = in;
        this.out = out;
        this.time = time;
    }

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metrics metrics = (Metrics) o;

        if (in != null ? !in.equals(metrics.in) : metrics.in != null) return false;
        if (out != null ? !out.equals(metrics.out) : metrics.out != null) return false;
        return time != null ? time.equals(metrics.time) : metrics.time == null;
    }

    @Override
    public int hashCode() {
        int result = in != null ? in.hashCode() : 0;
        result = 31 * result + (out != null ? out.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "in=" + in +
                ", out=" + out +
                ", time=" + time +
                '}';
    }
}
