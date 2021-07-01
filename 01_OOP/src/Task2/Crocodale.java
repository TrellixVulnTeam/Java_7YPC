package Task2;

public class Crocodale extends Enimal{

    private int Teeth_count;

    public Crocodale() {
    }

    public Crocodale(String name, String gender, String type, String mass, int years_old, int teeth_count) {
        super(name, gender, type, mass, years_old);
        Teeth_count = teeth_count;
    }
}
