package Task1;

public class Human {
    private String Name;
    private String Gender;
    private int Age;


    public Human() {
    }

    public Human(String name, String gender, int age) {
        Name = name;
        Gender = gender;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
