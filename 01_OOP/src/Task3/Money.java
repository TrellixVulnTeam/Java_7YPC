package Task3;

public class Money {
    private MoneyType moneyType;
    private int wholePart;
    private float penny;

    public Money() {
    }

    public Money(MoneyType moneyType, int wholePart, float penny) {
        this.moneyType = moneyType;
        this.wholePart = wholePart;
        this.penny = penny;
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(MoneyType moneyType) {
        this.moneyType = moneyType;
    }

    public int getWholePart() {
        return wholePart;
    }

    public void setWholePart(int wholePart) {
        this.wholePart = wholePart;
    }

    public float getPenny() {
        return penny;
    }

    public void setPenny(float penny) {
        this.penny = penny;
    }

    @Override
    public String toString() {
        return "Money{" +
                "moneyType=" + moneyType +
                ", wholePart=" + wholePart +
                ", penny=" + penny +
                '}';
    }
}
