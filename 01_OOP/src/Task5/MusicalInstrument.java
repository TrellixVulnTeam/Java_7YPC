package Task5;

public class MusicalInstrument {
    private String name;
    private String sound;
    private String desc;
    private String history;

    public MusicalInstrument(String name, String sound, String desc, String history) {
        this.name = name;
        this.sound = sound;
        this.desc = desc;
        this.history = history;
    }

    public MusicalInstrument() {
    }

    public void Sound(){
        System.out.println(this.sound);
    }
    public void Show(){
        System.out.println(this.desc);
    }
    public void Desc(){
        System.out.println(this.desc);
    }
    public void History(){
        System.out.println(this.history);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
