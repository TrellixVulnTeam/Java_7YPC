package www.commerce.dto.auth.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

    private String usernameOrEmail;

    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginRequest( String usernameOrEmail,  String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }
}
