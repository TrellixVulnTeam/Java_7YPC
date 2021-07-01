package Task1;

public class Builder extends Human{

    private float Power;

    public Builder(float power) {
        Power = power;
    }

    public Builder(String name, String gender, int age, float power) {
        super(name, gender, age);
        Power = power;
    }

    public float getPower() {
        return Power;
    }

    public void setPower(float power) {
        Power = power;
    }
}
