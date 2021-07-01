package Task1;

public class Sailor extends Human{
    private float Width;

    public Sailor(float width) {
        Width = width;
    }

    public Sailor(String name, String gender, int age, float width) {
        super(name, gender, age);
        Width = width;
    }

    public float getWidth() {
        return Width;
    }

    public void setWidth(float width) {
        Width = width;
    }
}
