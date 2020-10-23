package com.uv.trial.Recommendation.Services;

import com.uv.trial.Recommendation.Exception.InvalidBrandException;
import com.uv.trial.Recommendation.Exception.InvalidCategoryException;
import com.uv.trial.Recommendation.Exception.InvalidGenderException;
import com.uv.trial.Recommendation.Exception.InvalidInputException;
import com.uv.trial.Recommendation.Repository.BrandRepository;
import com.uv.trial.Recommendation.Repository.CategoryRepository;
import com.uv.trial.Recommendation.Repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputCheckService
{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    SizeRepository sizeRepository;

    public void CategoryCheck(String CategoryName)
    {
        if(categoryRepository.getCategoryId(CategoryName)==null)
            throw new InvalidCategoryException();
    }

    public void GenderCheck(String gender)
    {
        if(!gender.equals("M") && !gender.equals("F"))
            throw new InvalidGenderException();
    }
    public void BrandListIpCheck(int height,int chest,int sleeves)
    {
        if(height==0)
            throw new InvalidInputException("height");
        if(chest==0)
            throw new InvalidInputException("Chest");
        if(sleeves==0)
            throw new InvalidInputException("sleeves");

    }
    public void BrandListIpCheck(int size)
    {
        if(size==0)
            throw new InvalidInputException("Dimension");
    }
    public void InterestedBrandIpCheck(String ReferenceBrand,String InterestedBrand,String Gender)
    {
        if(brandRepository.getBrandId(ReferenceBrand)==null)
            throw new InvalidBrandException(ReferenceBrand);
        InterestedBrandIpCheck(InterestedBrand,Gender);

    }
    public void InterestedBrandIpCheck(String InterestedBrand,String Gender)
    {
        if(brandRepository.getBrandId(InterestedBrand)==null)
            throw new InvalidBrandException(InterestedBrand);
        GenderCheck(Gender);
    }
    public void SizeCheck(String size)
    {
        if(sizeRepository.getSizeId(size)==0)
            throw new InvalidInputException("size");
    }
}
