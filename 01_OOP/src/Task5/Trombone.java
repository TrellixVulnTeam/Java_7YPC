package Task5;

public class Trombone extends MusicalInstrument{
    public Trombone() {
        this.setName("Trombone");
        this.setDesc("Trombone");
        this.setSound("Trombone");
        this.setHistory("Trombone");
    }

    public Trombone(String name, String sound, String desc, String history) {
        super(name, sound, desc, history);
    }

}
