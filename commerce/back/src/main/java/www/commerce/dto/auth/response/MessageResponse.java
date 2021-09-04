package www.commerce.dto.auth.response;

import java.io.Serializable;

public class MessageResponse implements Serializable {

    String message;

    public MessageResponse(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
