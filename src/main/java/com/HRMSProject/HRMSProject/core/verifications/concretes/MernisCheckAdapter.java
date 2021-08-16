/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.core.verifications.concretes;

import com.HRMSProject.HRMSProject.core.utilities.results.SuccessResult;
import com.HRMSProject.HRMSProject.core.verifications.abstracts.MernisCheckService;
import com.HRMSProject.HRMSProject.entities.concretes.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class MernisCheckAdapter implements MernisCheckService {

    @Override
    public boolean mernisVerify(User user) {
        SuccessResult successResult = new SuccessResult("Mernis Doğrulama Başarılı");
        return successResult.isSuccess();
    }

}
