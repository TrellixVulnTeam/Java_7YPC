
public class Admin extends Person{
    private String role;
    private String email;
    private String password;

    public Admin(String name, int age, String role, String email, String password) {
        super(name, age);
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public Admin(String role, String email, String password) {
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public Admin(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
