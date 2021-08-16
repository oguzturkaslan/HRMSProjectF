
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.concretes;

import com.HRMSProject.HRMSProject.business.abstracts.LookingForJobsService;
import com.HRMSProject.HRMSProject.business.abstracts.VerificationCodeService;
import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.ErrorDataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.ErrorResult;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessDataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessResult;
import com.HRMSProject.HRMSProject.core.verifications.abstracts.MernisCheckService;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.LookingForJobsDao;
import com.HRMSProject.HRMSProject.entities.concretes.LookingForJobs;
import com.HRMSProject.HRMSProject.entities.concretes.VerificationCodes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class LookingForJobManager implements LookingForJobsService {

    private LookingForJobsDao lookingForJobsDao;
    private MernisCheckService mernisCheckService;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public LookingForJobManager(LookingForJobsDao lookingForJobsDao, MernisCheckService mernisCheckService, VerificationCodeService verificationCodeService) {
        super();
        this.lookingForJobsDao = lookingForJobsDao;
        this.mernisCheckService = mernisCheckService;
        this.verificationCodeService = verificationCodeService;
    }

    @Override
    public DataResult<List<LookingForJobs>> getAll() {
        return new SuccessDataResult<>(this.lookingForJobsDao.findAll(), "İş Arayanlar Listelendi");
    }

    @Override
    public Result add(LookingForJobs lookingForJobs, String passwordRepeat) {
        if (lookingForJobsDao.findByNationalityId(lookingForJobs.getNationalityId()) != null || lookingForJobsDao.findByEmail(lookingForJobs.getEmail()) != null) {
            return new ErrorResult("Bu bilgiler ile kullanıcı mevcut!!");
        } else if (lookingForJobs.getFirstName().isEmpty() || lookingForJobs.getLastName().isEmpty() || lookingForJobs.getNationalityId().isEmpty() || lookingForJobs.getDateOfBirth().equals(null) || lookingForJobs.getEmail().isEmpty() || lookingForJobs.getPassword().isEmpty()) {
            return new ErrorDataResult("Eksik Bilgilerinizi Tamamlayınız.");
        } else if (!isPasswordRepeatTrue(lookingForJobs.getPassword(), passwordRepeat)) {
            return new ErrorDataResult("Å?ifreleriniz Uyuşmuyor.");
        } else if (mernisCheckService.mernisVerify(lookingForJobs)) {
            lookingForJobsDao.save(lookingForJobs);
            verificationCodeService.sendEmail(lookingForJobs.getEmail());
            verificationCodeService.createCode(new VerificationCodes(), lookingForJobs);
            return new SuccessResult("Kayıt Başarılı");
        } else {
            return new ErrorResult("Mernis Doğrulaması Yapılamadı !");
        }
    }

    @Override
    public boolean checkEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isPasswordRepeatTrue(String password, String passwordRepeat) {
        if (password.equals(passwordRepeat)) {
            return true;
        } else {
            return false;
        }
    }

}