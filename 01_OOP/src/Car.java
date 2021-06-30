public class Car {
    public String Name;
    public String Fabric;
    public int Year;
    public float Engine;

    public Car(String name, String fabric, int year, float engine) {
        Name = name;
        Fabric = fabric;
        Year = year;
        Engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Name='" + Name + '\'' +
                ", Fabric='" + Fabric + '\'' +
                ", Year=" + Year +
                ", Engine=" + Engine +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFabric() {
        return Fabric;
    }

    public void setFabric(String fabric) {
        Fabric = fabric;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public float getEngine() {
        return Engine;
    }

    public void setEngine(float engine) {
        Engine = engine;
    }
}
