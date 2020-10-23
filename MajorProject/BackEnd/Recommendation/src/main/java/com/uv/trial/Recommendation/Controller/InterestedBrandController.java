package com.uv.trial.Recommendation.Controller;

import com.uv.trial.Recommendation.Exception.DataNotFoundException;
import com.uv.trial.Recommendation.Model.InterestedBrandIP;
import com.uv.trial.Recommendation.Model.InterestedBrandOP;
import com.uv.trial.Recommendation.Model.UserDTO;
import com.uv.trial.Recommendation.Services.InputCheckService;
import com.uv.trial.Recommendation.Services.InterestedBrandService;
import com.uv.trial.Recommendation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/interested")
public class InterestedBrandController {
    @Autowired
    LoginService loginService;
    @Autowired
    InterestedBrandService interestedBrandService;
    @Autowired
    InputCheckService inputCheckService;

    @PostMapping("/show")
    public InterestedBrandOP showInterested(@RequestHeader(value = "Authorization") String code, @RequestBody InterestedBrandIP interestedBrandIP){
        inputCheckService.CategoryCheck(interestedBrandIP.getCategoryName());
        inputCheckService.SizeCheck(interestedBrandIP.getReferenceSize());
        UserDTO userDTO = loginService.verifyUser(code);
        InterestedBrandOP interestedBrandOP = interestedBrandService.showInterestedService(userDTO, interestedBrandIP);
        if(interestedBrandOP == null)
            throw new DataNotFoundException();
        else
            return interestedBrandOP;
    }
}

