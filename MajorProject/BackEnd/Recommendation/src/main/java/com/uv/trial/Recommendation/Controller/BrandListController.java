package com.uv.trial.Recommendation.Controller;

import com.uv.trial.Recommendation.Exception.DataNotFoundException;
import com.uv.trial.Recommendation.Model.BrandListIP;
import com.uv.trial.Recommendation.Model.BrandListOP;
import com.uv.trial.Recommendation.Model.UserDTO;
import com.uv.trial.Recommendation.Services.BrandListService;
import com.uv.trial.Recommendation.Services.InputCheckService;
import com.uv.trial.Recommendation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brandlist")
public class BrandListController
{
    @Autowired
    BrandListService brandListService;
    @Autowired
    LoginService loginService;
    @Autowired
    InputCheckService inputCheckService;

    @PostMapping("/show")
    public List<BrandListOP> showList(@RequestHeader(value = "Authorization") String code, @RequestBody BrandListIP brandListIP){
        inputCheckService.CategoryCheck(brandListIP.getCategoryName());
        inputCheckService.GenderCheck(brandListIP.getGender());
        UserDTO userDTO = loginService.verifyUser(code);
        List<BrandListOP> brandListOPS = brandListService.showListService(userDTO,brandListIP);
        if(brandListOPS.isEmpty())
            throw new DataNotFoundException();
        else
            return brandListOPS;
    }

    @PostMapping("/show/auto")
    public List<BrandListOP> showAutoList(@RequestHeader(value = "Authorization") String code,@RequestBody BrandListIP brandListIP){
        inputCheckService.CategoryCheck(brandListIP.getCategoryName());
        inputCheckService.GenderCheck(brandListIP.getGender());
        UserDTO userDTO = loginService.verifyUser(code);
        List<BrandListOP> brandListOPS = brandListService.showAutoListService(userDTO,brandListIP);
        if(brandListOPS.isEmpty())
            throw new DataNotFoundException();
        else
            return brandListOPS;
    }
}
