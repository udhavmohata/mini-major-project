package com.uv.trial.Recommendation.Controller;

import com.uv.trial.Recommendation.Services.LoginService;
import com.uv.trial.Recommendation.Model.Login;
import com.uv.trial.Recommendation.Model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    private LoginService loginService;

    @PostMapping("/signin")
    public UserDTO getUser(@RequestBody Login login){
        return loginService.getUserService(login);
    }
}
