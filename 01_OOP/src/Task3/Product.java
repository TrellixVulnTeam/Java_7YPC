package Task3;

public class Product extends Money{
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public Product(MoneyType moneyType, int wholePart, float penny, String name) {
        super(moneyType, wholePart, penny);
        this.name = name;
    }

    public void ReducePrice(int money){
        int price = this.getWholePart();
        this.setWholePart(price-money);
    }

}
