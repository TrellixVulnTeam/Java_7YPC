package Task5;

public class Violin extends MusicalInstrument{
    public Violin() {
        this.setName("Violin");
        this.setDesc("Violin");
        this.setSound("Violin");
        this.setHistory("Violin");
    }
    public Violin(String name, String sound, String desc, String history) {
        super(name, sound, desc, history);
    }
}
