/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.concretes;

import com.HRMSProject.HRMSProject.business.abstracts.VerificationCodeService;
import com.HRMSProject.HRMSProject.core.utilities.results.ErrorResult;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessResult;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.VerificationCodeDao;
import com.HRMSProject.HRMSProject.entities.concretes.User;
import com.HRMSProject.HRMSProject.entities.concretes.VerificationCodes;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class VerificationCodeManager implements VerificationCodeService {

    @Autowired
    private VerificationCodeDao verificationCodeDao;

    @Override
    public void createCode(VerificationCodes code, User user) {
        Random rand = new Random();
        int upperBound = 27654849;

        code.getUser().setId(user.getId());
        code.setVerificationType(String.valueOf(rand.nextInt(upperBound)));

        verificationCodeDao.save(code);

    }

    @Override
    public Result verifyCode(String code, int id) {
        if (verificationCodeDao.findByUserId(id).isVerified()) {
            return new ErrorResult("E-posta zaten doğrulanmış");
        } else if (verificationCodeDao.getByUserId(id).getVerificationType().equals(code) && !verificationCodeDao.findByUserId(id).isVerified()) {
            return new SuccessResult("E-posta Doğrulandı");
        }
        return new ErrorResult("Doğrulama geçersiz");
    }

    @Override
    public void sendEmail(String email) {
        System.out.println("Doğrulama Kodu Şu E-Maile Gönderildi : " + email);
    }

}
