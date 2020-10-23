package com.uv.trial.Recommendation.Controller;

import com.uv.trial.Recommendation.Model.UserDTO;
import com.uv.trial.Recommendation.Repository.UserRepository;
import com.uv.trial.Recommendation.Services.RegistrationService;
import com.uv.trial.Recommendation.Services.InputCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class RegistrationController
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    InputCheckService inputCheckService;

    @PostMapping("/create")
    public UserDTO SignUp(@RequestBody UserDTO userDTO)
    {
        inputCheckService.GenderCheck(userDTO.getGender());
        UserDTO userDTO1 = registrationService.newUser(userDTO);
        return userRepository.save(userDTO1);
    }

    @DeleteMapping("/delete/{id}")
    public void Delete(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

}
