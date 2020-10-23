package com.uv.trial.Recommendation.Controller;

import com.uv.trial.Recommendation.Model.BrandDTO;
import com.uv.trial.Recommendation.Repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brands")
public class BrandController
{
    @Autowired
    private BrandRepository brandRepository;

    @PostMapping("/new")
    public BrandDTO newBrand(@RequestBody BrandDTO brandDTO)
    {
        return brandRepository.save(brandDTO);
    }

    @GetMapping("/showAll")
    public List<BrandDTO> showBrands()
    {
        return (List<BrandDTO>) brandRepository.findAll();
    }

    @GetMapping("/show/{id}")
    public Optional<BrandDTO> showBrand(@PathVariable int id)
    {
        return brandRepository.findById(id);
    }

}
