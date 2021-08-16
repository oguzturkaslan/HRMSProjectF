/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.core.verifications.abstracts;

import com.HRMSProject.HRMSProject.entities.concretes.User;

/**
 *
 * @author oguz.turkaslan
 */
public interface MernisCheckService {

    boolean mernisVerify(User user);
}
