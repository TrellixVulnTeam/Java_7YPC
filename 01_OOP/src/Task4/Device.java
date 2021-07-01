package Task4;

public class Device {
    private String name;
    private String sound;
    private String desc;

    public void Sound(){
        System.out.println(this.sound);
    };
    public void Show(){
        System.out.println(this.name);
    };
    public void Desc(){
        System.out.println(this.desc);
    };

    public Device() {
    }

    public Device(String name, String sound, String desc) {
        this.name = name;
        this.sound = sound;
        this.desc = desc;
    }


}
