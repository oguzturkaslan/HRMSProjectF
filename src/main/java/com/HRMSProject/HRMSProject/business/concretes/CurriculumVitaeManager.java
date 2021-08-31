/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.business.concretes;

import com.HRMSProject.HRMSProject.business.abstracts.CurriculumVitaeService;
import com.HRMSProject.HRMSProject.core.utilities.results.Result;
import com.HRMSProject.HRMSProject.core.utilities.results.SuccessDataResult;
import com.HRMSProject.HRMSProject.dataAccess.abstracts.CurriculumVitaeDao;
import com.HRMSProject.HRMSProject.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oguz.turkaslan
 */
@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return new SuccessDataResult("CV Başarılı Bir Şekilde Eklendi !");
    }

}
