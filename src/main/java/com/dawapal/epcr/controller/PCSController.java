package com.dawapal.epcr.controller;

import com.dawapal.epcr.DawapalECprHapiFhirClientApplication;
import com.dawapal.epcr.model.ParamedicineCareSummary;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;
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
    public ResponseEntity<String> createPCS(ParamedicineCareSummary pcs){
        // Create Patient Resource
        Patient patient = new Patient();
        // TODO: populate patient

        Reference patientRef = new Reference();
        patientRef.setReference("Patient/" + patient.getId());
        patientRef.setType("Patient");

        // Create Encounter Resource
        Encounter encounter = new Encounter();
        // TODO: populate encounter

        Reference encounterRef = new Reference();
        encounterRef.setReference("Encounter/" + encounter.getId());
        encounterRef.setType("Encounter");

        // Create Observation resources for vital signs
        // and link them to encounter & patient

        // Set all vital signs to this category
        CodeableConcept vital_cat = new CodeableConcept();
        vital_cat.addCoding().setCode("vital-signs").setSystem("http://terminology.hl7.org/CodeSystem/observation-category");
        
        // Set all vital signs to this effective dateTime
        DateTimeType vitals_dt = new DateTimeType(pcs.getVital_dateTime());
        
        // Systolic Blood Pressure
        if (!pcs.getVital_sbp().isEmpty()) {
            Observation ob_sbp = new Observation();
            ob_sbp.setStatus(ObservationStatus.FINAL);
            ob_sbp.addCategory(vital_cat);
            CodeableConcept sbp_code = new CodeableConcept();
            sbp_code.addCoding().setCode("8480-6").setDisplay("Systolic blood pressure").setSystem("http://loinc.org");
            ob_sbp.setCode(sbp_code);
            ob_sbp.setValue(new StringType(pcs.getVital_sbp()));
            ob_sbp.setEffective(vitals_dt);
            
            ob_sbp.setSubject(patientRef);
            ob_sbp.setEncounter(encounterRef);
        }

        // Systolic Blood Pressure
        if (!pcs.getVital_sbp().isEmpty()) {
            Observation ob_sbp = new Observation();
            ob_sbp.setStatus(ObservationStatus.FINAL);
            ob_sbp.addCategory(vital_cat);
            CodeableConcept sbp_code = new CodeableConcept();
            sbp_code.addCoding().setCode("8480-6").setDisplay("Systolic blood pressure").setSystem("http://loinc.org");
            ob_sbp.setCode(sbp_code);
            ob_sbp.setValue(new StringType(pcs.getVital_sbp()));
            ob_sbp.setEffective(vitals_dt);
            
            ob_sbp.setSubject(patientRef);
            ob_sbp.setEncounter(encounterRef);
        }

        // Diastolic Blood Pressure
        if (!pcs.getVital_dbp().isEmpty()) {
            Observation ob_dbp = new Observation();
            ob_dbp.setStatus(ObservationStatus.FINAL);
            ob_dbp.addCategory(vital_cat);
            CodeableConcept dbp_code = new CodeableConcept();
            dbp_code.addCoding().setCode("8462-4").setDisplay("Diastolic blood pressure").setSystem("http://loinc.org");
            ob_dbp.setCode(dbp_code);
            ob_dbp.setValue(new StringType(pcs.getVital_dbp()));
            ob_dbp.setEffective(vitals_dt);
            
            ob_dbp.setSubject(patientRef);
            ob_dbp.setEncounter(encounterRef);
        }

        return new ResponseEntity<>("Work in progress: ", HttpStatus.OK);
    }
}
