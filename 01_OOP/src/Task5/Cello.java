package Task5;

public class Cello extends MusicalInstrument{

    public Cello() {
        this.setName("Cell");
        this.setDesc("Cell");
        this.setSound("Cell");
        this.setHistory("Cell");
    }

    public Cello(String name, String sound, String desc, String history) {
        super(name, sound, desc, history);
    }
}
