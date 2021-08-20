/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.entities.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author oguz.turkaslan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobsWithEmployerDto {

    private int id;
    private String companyName;
    private int numberOfPositions;
    private String title;
    private Date lastDateOfApplicate;
}
