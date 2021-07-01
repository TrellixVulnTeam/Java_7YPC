package Task5;

public class Ukulele extends MusicalInstrument{
    public Ukulele() {
        this.setName("Ukulele");
        this.setDesc("Ukulele");
        this.setSound("Ukulele");
        this.setHistory("Ukulele");
    }
    public Ukulele(String name, String sound, String desc, String history) {
        super(name, sound, desc, history);
    }
}
