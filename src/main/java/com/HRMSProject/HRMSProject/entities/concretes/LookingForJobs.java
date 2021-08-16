
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.entities.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author oguz.turkaslan
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "looking_for_jobs")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class LookingForJobs extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Size(min = 11, max = 11, message = "TC Kimlik No 11 hane olmalıdır.")
    @Column(name = "nationality_id")
    private String nationalityId;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

}
