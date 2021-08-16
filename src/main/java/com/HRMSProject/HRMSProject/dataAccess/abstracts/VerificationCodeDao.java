/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.dataAccess.abstracts;

import com.HRMSProject.HRMSProject.entities.concretes.VerificationCodes;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author oguz.turkaslan
 */
@EnableJpaRepositories
public interface VerificationCodeDao extends JpaRepository<VerificationCodes, Integer> {

    VerificationCodes findByUserId(int userId);

    VerificationCodes getByUserId(int userId);

    @Modifying
    @Transactional
    @Query("UPDATE VerificationCodes vc SET vc.isVerified=true WHERE vc.id in :id")
    void activateUser(@Param("id") int id);
}
