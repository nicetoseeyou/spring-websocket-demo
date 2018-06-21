package lab.nice.websocket.demo.model;

public class Input {
    private Integer first;
    private Integer second;

    public Input() {
        super();
    }

    public Input(Integer first, Integer second) {
        super();
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Input input = (Input) o;

        if (first != null ? !first.equals(input.first) : input.first != null) return false;
        return second != null ? second.equals(input.second) : input.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Input{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
