package com.dawapal.epcr.controller;

import com.dawapal.epcr.model.ParamedicineCareSummary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ancentus
 * @version 1.0.0
 */

@RestController
public class PCSController {
    
    /**s
     * @param pcs
     * @return ResponseEntity<String>
     *     gets pcs data from client form and creates a pcs composition resource
     */

    @PostMapping("/pcs/create")
    public ResponseEntity<String> createPCS(ParamedicineCareSummary pcr){
        // TODO

        return new ResponseEntity<>("Work in progress: ", HttpStatus.OK);
    }
}
