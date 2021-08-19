package www.commerce.controllers.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    @RequestMapping("/dashboard")
    public String index() {
        return "success";
    }

}
