/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.concretes;

import com.HRMSProject.HRMSProject.business.abstracts.EmployersService;
import com.HRMSProject.HRMSProject.business.abstracts.VerificationCodeService;
import com.HRMSProject.HRMSProject.core.utilities.results.DataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.ErrorDataResult;
import com.HRMSProject.HRMSProject.core.utilities.results.ErrorResult;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessDataResult;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.EmployeeConfirmEmployersDao;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.EmployersDao;
import com.HRMSProject.HRMSProject.entities.concretes.EmployeeConfirmEmployers;
import com.HRMSProject.HRMSProject.entities.concretes.Employers;
import com.HRMSProject.HRMSProject.entities.concretes.VerificationCodes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class EmployersManager implements EmployersService {

    private EmployersDao employersDao;
    private EmployeeConfirmEmployersDao employeeConfirmEmployersDao;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public EmployersManager(EmployersDao employersDao, EmployeeConfirmEmployersDao employeeConfirmEmployersDao, VerificationCodeService verificationCodeService) {
        this.employersDao = employersDao;
        this.employeeConfirmEmployersDao = employeeConfirmEmployersDao;
        this.verificationCodeService = verificationCodeService;
    }

    @Override
    public Result add(Employers employers, String passwordRepeat) {
        if (employersDao.findById(employers.getId()) != null || employersDao.findByEmail(employers.getEmail()) != null) {
            return new ErrorResult("Bu bilgiler ile kullanıcı mevcut!!");
        } else if (employers.getCompanyName().isEmpty() || employers.getWebsite().isEmpty() || employers.getPhoneNumber().isEmpty() || employers.getEmail().isEmpty() || employers.getPassword().isEmpty() || passwordRepeat.isEmpty()) {
            return new ErrorDataResult("Bilgilerinizi Kontrol Ediniz.");
        } else if (checkEmailDomain(employers.getEmail(), employers.getWebsite())) {
            return new ErrorDataResult("Lütfen Şirketinize ait geçerli bir e-mail giriniz !");
        } else if (!employers.getPassword().equals(passwordRepeat)) {
            return new ErrorDataResult("Şifreleriniz Uyuşmuyor.");
        } else {
            employersDao.save(employers);
            EmployeeConfirmEmployers employeeConfirmEmployers = new EmployeeConfirmEmployers();
            employeeConfirmEmployers.setEmployers(employers);
            employeeConfirmEmployers.setConfirmed(false);
            employeeConfirmEmployers.setUser(null);
            employeeConfirmEmployersDao.save(employeeConfirmEmployers);
            verificationCodeService.createCode(new VerificationCodes(), employers);
            verificationCodeService.sendEmail(employers.getEmail());
            return new SuccessDataResult("Çalışan Kaydı Başarılı !");
        }

    }

    @Override
    public DataResult<List<Employers>> getAll() {
        return new SuccessDataResult<>(this.employersDao.findAll(), "İş Verenler Listelendi");
    }

    private boolean checkEmailDomain(String email, String website) {
        String websiteCheck = website.substring(website.indexOf(".") + 1, website.length());
        String emailCheck = email.substring(website.indexOf("@") + 1, website.length());
        if (emailCheck.equals(websiteCheck)) {
            return true;
        } else {
            return false;
        }
    }
}
