package ISFTAOMAMPMA.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DefaultController {

    @GetMapping("/index")
    public String index() {
        return "index";  // This refers to the index.html file in the static directory
    }

    @GetMapping("/home")
    public String index2() {
        return "home";  // This refers to the home.html file in the static directory
    }


    @GetMapping("/signin")
    public String signin() {
        return "signin";  // This refers to the signin.html file in the static directory
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";  // This refers to the signup.html file in the static directory
    }

    @GetMapping("/userinterface")
    public String userinterface() {
        return "userinterface";  // This refers to the userinterface.html file in the static directory
    }
    @GetMapping("/client/order")
    public String order() {
        return "order";  // This refers to the order.html file in the static directory
    }

}
