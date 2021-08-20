/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.entities.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "jobtitle_id")
    private JobTitles jobTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "numberofpositions")
    private int numberOfPositions;

    @Column(name = "lastdateofapplicate")
    private Date lastDateOfApplicate;

    @Column(name = "is_active")
    private boolean is_active;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employers employers;

}
