package com.dawapal.epcr.controller;

import com.dawapal.epcr.DawapalECprHapiFhirClientApplication;
import com.dawapal.epcr.model.ParamedicineCareSummary;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;

/**
 * @author ancentus
 * @version 1.0.0
 */

@RestController
public class PCSController {
    // Create a context
    FhirContext ctx = DawapalECprHapiFhirClientApplication.getFhirContext();

    // Create a client
    IGenericClient client = ctx.newRestfulGenericClient("https://hapi.fhir.org/baseR4");
    
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
