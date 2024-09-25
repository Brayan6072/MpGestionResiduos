package mcsvs.login.Auth;

import mcsvs.login.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class IndexController {

    @GetMapping("/index")
    public String Index(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/Signout")
    public String signout (Model token){

        token.addAttribute("useractivo", null);

        return "index";


    }
}
