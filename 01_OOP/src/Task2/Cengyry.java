package Task2;

public class Cengyry extends Enimal{
    private float Jump_height;

    public Cengyry() {
    }

    public Cengyry(String name, String gender, String type, String mass, int years_old, float jump_height) {
        super(name, gender, type, mass, years_old);
        Jump_height = jump_height;
    }
}
