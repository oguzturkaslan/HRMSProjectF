/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.abstracts;

import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.entities.concretes.User;
import com.HRMSProject.HRMSProject.entities.concretes.VerificationCodes;

/**
 *
 * @author oguz.turkaslan
 */
public interface VerificationCodeService {

    void createCode(VerificationCodes code, User user);

    Result verifyCode(String code, int id);

    void sendEmail(String email);
}
