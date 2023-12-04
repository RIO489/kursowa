package ISFTAOMAMPMA.resource;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DefaultController {

    @GetMapping("/index")
    public String index() {
        return "index";  // This refers to the index.html file in the static directory
    }

    @GetMapping("/signin")
    public String signup() {
        return "signin";  // This refers to the signin.html file in the static directory
    }

    @GetMapping("/userinterface")
    public String userinterface() {
        return "userinterface";  // This refers to the userinterface.html file in the static directory
    }
    @GetMapping("client/order")
    public String order() {
        return "order";  // This refers to the userinterface.html file in the static directory
    }
}
