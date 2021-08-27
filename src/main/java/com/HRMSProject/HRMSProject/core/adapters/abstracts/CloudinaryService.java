/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.HRMSProject.HRMSProject.core.adapters.abstracts;

import java.io.File;
import java.util.Map;

/**
 *
 * @author oguz.turkaslan
 */
public interface CloudinaryService {

    public Map<String, Object> uploadImage(File file);
}
