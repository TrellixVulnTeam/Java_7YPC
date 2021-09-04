package www.commerce.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String secondName;

}
