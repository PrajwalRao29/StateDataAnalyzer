import com.opencsv.bean.CsvBindByPosition;

public class StateCode {
    @CsvBindByPosition(position = 0)
    private int sl;

    @CsvBindByPosition(position = 1)
    private String state;

    @CsvBindByPosition(position = 2)
    private String TIN;

    @CsvBindByPosition(position = 3)
    private String code;

    @Override
    public String toString() {
        return "StateCode{" +
                "sl=" + sl +
                ", state='" + state + '\'' +
                ", TIN='" + TIN + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public void setCode(String code) {
        this.code = code;
    }
}