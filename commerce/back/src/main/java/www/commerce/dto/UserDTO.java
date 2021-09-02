package www.commerce.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
