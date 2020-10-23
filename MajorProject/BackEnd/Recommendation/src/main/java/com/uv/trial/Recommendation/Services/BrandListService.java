package com.uv.trial.Recommendation.Services;

import com.uv.trial.Recommendation.Exception.UnexpectedException;
import com.uv.trial.Recommendation.Model.BrandListIP;
import com.uv.trial.Recommendation.Model.BrandListOP;
import com.uv.trial.Recommendation.Model.Dimension;
import com.uv.trial.Recommendation.Model.UserDTO;
import com.uv.trial.Recommendation.Repository.CategoryRepository;
import com.uv.trial.Recommendation.Repository.SizeRepository;
import com.uv.trial.Recommendation.Repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandListService
{
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    UserHistoryRepository userHistoryRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    InputCheckService inputCheckService;


    public List<BrandListOP> showListService(UserDTO userDTO, BrandListIP brandListIP) {
        int CategoryId = categoryRepository.getCategoryId(brandListIP.getCategoryName());
        String gender;
        if(brandListIP.getGender()== null)
            gender = userDTO.getGender();
        else
            gender = brandListIP.getGender();
            switch (CategoryId) {
                case 1:
                    inputCheckService.BrandListIpCheck(brandListIP.getHeight(), brandListIP.getChest(), brandListIP.getSleeves());
                    if (gender.equals("M"))
                        return sizeRepository.getMaleShirtBrandList(CategoryId, brandListIP.getChest(), brandListIP.getHeight(), brandListIP.getSleeves());
                    else
                        return sizeRepository.getFemaleShirtBrandList(CategoryId, brandListIP.getChest(), brandListIP.getHeight(), brandListIP.getSleeves());

                case 2:
                    inputCheckService.BrandListIpCheck(brandListIP.getWaist());
                    if (gender.equals("M"))
                        return sizeRepository.getMaleJeanBrandList(CategoryId, brandListIP.getWaist());
                    else
                        return sizeRepository.getFemaleJeanBrandList(CategoryId, brandListIP.getWaist());
                case 3:
                    inputCheckService.BrandListIpCheck(brandListIP.getShoeSize());
                    if (gender.equals("M"))
                        return sizeRepository.getMaleShoeBrandList(CategoryId, brandListIP.getShoeSize());
                    else
                        return sizeRepository.getFemaleShoeBrandList(CategoryId, brandListIP.getShoeSize());
                default:
                    throw new UnexpectedException();
            }
        }


    public List<BrandListOP> showAutoListService(UserDTO userDTO, BrandListIP brandListIP){
        int CategoryId = categoryRepository.getCategoryId(brandListIP.getCategoryName());
        int sizeId = userHistoryRepository.getHistory(userDTO.getUserId(),CategoryId);
        String gender;
        if(brandListIP.getGender() == null)
            gender = userDTO.getGender();
        else
            gender = brandListIP.getGender();
            switch (CategoryId) {
                case 1:
                    if (gender.equals("M")) {
                        Dimension dimension = sizeRepository.getMaleShirtDimension(sizeId);
                        return sizeRepository.getMaleShirtBrandList(CategoryId, dimension.getChest(), dimension.getHeight(), dimension.getSleeves());
                    } else {
                        Dimension dimension = sizeRepository.getFemaleShirtDimension(sizeId);
                        return sizeRepository.getFemaleShirtBrandList(CategoryId, dimension.getChest(), dimension.getHeight(), dimension.getSleeves());
                    }

                case 2:
                    if (gender.equals("M")) {
                        int Waist = sizeRepository.getMaleJeanDimension(sizeId);
                        return sizeRepository.getMaleJeanBrandList(CategoryId, Waist);
                    } else {
                        int Waist = sizeRepository.getFemaleJeanDimension(sizeId);
                        return sizeRepository.getFemaleJeanBrandList(CategoryId, Waist);
                    }

                case 3:
                    if (gender.equals("M")) {
                        int ShoeSize = sizeRepository.getMaleShoeDimension(sizeId);
                        return sizeRepository.getMaleShoeBrandList(CategoryId, ShoeSize);
                    } else {
                        int ShoeSize = sizeRepository.getFemaleShoeDimension(sizeId);
                        return sizeRepository.getFemaleShoeBrandList(CategoryId, ShoeSize);
                    }

                default:
                    throw new UnexpectedException();
            }

    }
}

