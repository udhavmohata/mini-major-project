package com.uv.trial.Recommendation.Services;

import com.uv.trial.Recommendation.Exception.UnexpectedException;
import com.uv.trial.Recommendation.Model.*;
import com.uv.trial.Recommendation.Repository.CategoryRepository;
import com.uv.trial.Recommendation.Repository.SizeRepository;
import com.uv.trial.Recommendation.Repository.UserHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestedBrandService
{
    @Autowired
    UserHistoryRepository userHistoryRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    InputCheckService inputCheckService;


    public InterestedBrandOP showInterestedService(UserDTO userDTO, InterestedBrandIP interestedBrandIP){
        String RefBrand,RefSize;
        int CategoryId = categoryRepository.getCategoryId(interestedBrandIP.getCategoryName());
        int sizeId = userHistoryRepository.getHistory(userDTO.getUserId(),CategoryId);
        if(interestedBrandIP.getReferenceBrand() == null && interestedBrandIP.getReferenceSize() == null) {
            inputCheckService.InterestedBrandIpCheck(interestedBrandIP.getInterestedBrand(),interestedBrandIP.getGender());
            String str = sizeRepository.getRefBrandSize(sizeId);
            String[] str1 = str.split(",");
            RefBrand = str1[0];
            RefSize = str1[1];
        }
        else {
            inputCheckService.InterestedBrandIpCheck(interestedBrandIP.getReferenceBrand(),interestedBrandIP.getInterestedBrand(),interestedBrandIP.getGender());
            RefBrand = interestedBrandIP.getReferenceBrand();
            RefSize = interestedBrandIP.getReferenceSize();
        }
        String gender;
        if(interestedBrandIP.getGender() == null)
            gender = userDTO.getGender();
        else
            gender = interestedBrandIP.getGender();
            switch (CategoryId) {
                case 1:
                    if (gender.equals("M")) {
                        Dimension dimension = sizeRepository.getMaleShirtDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getMaleShirtInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), dimension.getChest(), dimension.getHeight(), dimension.getSleeves());
                    } else {
                        Dimension dimension = sizeRepository.getFemaleShirtDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getFemaleShirtInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), dimension.getChest(), dimension.getHeight(), dimension.getSleeves());
                    }

                case 2:
                    if (gender.equals("M")) {
                        int Waist = sizeRepository.getMaleJeanDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getMaleJeanInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), Waist);
                    } else {
                        int Waist = sizeRepository.getFemaleJeanDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getFemaleJeanInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), Waist);
                    }

                case 3:
                    if (gender.equals("M")) {
                        int ShoeSize = sizeRepository.getMaleShoeDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getMaleShoeInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), ShoeSize);
                    } else {
                        int ShoeSize = sizeRepository.getFemaleShoeDimension(CategoryId, RefSize, RefBrand);
                        return sizeRepository.getFemaleShoeInterestedSize(CategoryId, interestedBrandIP.getInterestedBrand(), ShoeSize);
                    }

                default:
                    throw new UnexpectedException();
            }
    }
}
