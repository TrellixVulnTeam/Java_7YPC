package Task2;

public class Tiger extends Enimal{

    private float Speed;

    public Tiger() {
    }

    public Tiger(String name, String gender, String type, String mass, int years_old, float speed) {
        super(name, gender, type, mass, years_old);
        Speed = speed;
    }
}
