package Task1;

public class Pilot extends Human{

    private float Height;

    public Pilot() {
    }

    public Pilot(float height) {
        Height = height;
    }

    public Pilot(String name, String gender, int age, float height) {
        super(name, gender, age);
        Height = height;
    }

    public float getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        Height = height;
    }
}
