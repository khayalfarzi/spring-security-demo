package az.iktlab.springsecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {

    @RequestMapping({"/hello"})
    @PreAuthorize(value = "ROLE_ADMIN")
    public String hello() {
        System.out.printf("Security context holder from hello method : %s%n",
                SecurityContextHolder.getContext().getAuthentication().getName());
        return "Hello World";
    }

}
