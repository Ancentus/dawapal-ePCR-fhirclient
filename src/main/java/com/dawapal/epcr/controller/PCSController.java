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

    /**
     * s
     * 
     * @param pcs
     * @return ResponseEntity<String>
     *         gets pcs data from client form and creates a pcs composition resource
     */

    @PostMapping("/pcs/create")
    public ResponseEntity<String> createPCS(ParamedicineCareSummary pcs) {
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
        vital_cat.addCoding().setCode("vital-signs")
                .setSystem("http://terminology.hl7.org/CodeSystem/observation-category");

        // Set all vital signs to this effective dateTime
        DateTimeType vitals_dt = new DateTimeType(pcs.getVital_dateTime());

        // Cardiac Rhythm
        if (!pcs.getVital_ecg().isEmpty()) {
            Observation ob_ecg = new Observation();
            ob_ecg.setStatus(ObservationStatus.FINAL);
            ob_ecg.addCategory(vital_cat);
            CodeableConcept ecg_code = new CodeableConcept();
            ecg_code.addCoding().setDisplay("Cardiac Rhythm / Electrocardiography (ECG)");
            ob_ecg.setCode(ecg_code);
            ob_ecg.setValue(new StringType(pcs.getVital_ecg()));
            ob_ecg.setEffective(vitals_dt);

            ob_ecg.setSubject(patientRef);
            ob_ecg.setEncounter(encounterRef);
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

        // Mean Arterial Pressure
        if (!pcs.getVital_mean_ap().isEmpty()) {
            Observation ob_mean_ap = new Observation();
            ob_mean_ap.setStatus(ObservationStatus.FINAL);
            ob_mean_ap.addCategory(vital_cat);
            CodeableConcept mean_ap_code = new CodeableConcept();
            mean_ap_code.addCoding().setDisplay("Mean Arterial Pressure");
            ob_mean_ap.setCode(mean_ap_code);
            ob_mean_ap.setValue(new StringType(pcs.getVital_mean_ap()));
            ob_mean_ap.setEffective(vitals_dt);

            ob_mean_ap.setSubject(patientRef);
            ob_mean_ap.setEncounter(encounterRef);
        }

        // Heart Rate
        if (!pcs.getVital_heart_rate().isEmpty()) {
            Observation ob_heart_rate = new Observation();
            ob_heart_rate.setStatus(ObservationStatus.FINAL);
            ob_heart_rate.addCategory(vital_cat);
            CodeableConcept heart_rate_code = new CodeableConcept();
            heart_rate_code.addCoding().setDisplay("Heart rate");
            ob_heart_rate.setCode(heart_rate_code);
            ob_heart_rate.setValue(new StringType(pcs.getVital_heart_rate()));
            ob_heart_rate.setEffective(vitals_dt);

            ob_heart_rate.setSubject(patientRef);
            ob_heart_rate.setEncounter(encounterRef);
        }

        // Pulse Oximetry
        if (!pcs.getVital_pulse_oximetry().isEmpty()) {
            Observation ob_pulse_oximetry = new Observation();
            ob_pulse_oximetry.setStatus(ObservationStatus.FINAL);
            ob_pulse_oximetry.addCategory(vital_cat);
            CodeableConcept pulse_oximetry_code = new CodeableConcept();
            pulse_oximetry_code.addCoding().setDisplay("Pulse Oximetry");
            ob_pulse_oximetry.setCode(pulse_oximetry_code);
            ob_pulse_oximetry.setValue(new StringType(pcs.getVital_pulse_oximetry()));
            ob_pulse_oximetry.setEffective(vitals_dt);

            ob_pulse_oximetry.setSubject(patientRef);
            ob_pulse_oximetry.setEncounter(encounterRef);
        }

        // Pulse Rhythm
        if (!pcs.getVital_pulse_rhythm().isEmpty()) {
            Observation ob_pulse_rhythm = new Observation();
            ob_pulse_rhythm.setStatus(ObservationStatus.FINAL);
            ob_pulse_rhythm.addCategory(vital_cat);
            CodeableConcept pulse_rhythm_code = new CodeableConcept();
            pulse_rhythm_code.addCoding().setDisplay("Pulse Rhythm");
            ob_pulse_rhythm.setCode(pulse_rhythm_code);
            ob_pulse_rhythm.setValue(new StringType(pcs.getVital_pulse_rhythm()));
            ob_pulse_rhythm.setEffective(vitals_dt);

            ob_pulse_rhythm.setSubject(patientRef);
            ob_pulse_rhythm.setEncounter(encounterRef);
        }

        // Respiratory Rate
        if (!pcs.getVital_respiratory_rate().isEmpty()) {
            Observation ob_respiratory_rate = new Observation();
            ob_respiratory_rate.setStatus(ObservationStatus.FINAL);
            ob_respiratory_rate.addCategory(vital_cat);
            CodeableConcept respiratory_rate_code = new CodeableConcept();
            respiratory_rate_code.addCoding().setDisplay("Respiratory Rate");
            ob_respiratory_rate.setCode(respiratory_rate_code);
            ob_respiratory_rate.setValue(new StringType(pcs.getVital_respiratory_rate()));
            ob_respiratory_rate.setEffective(vitals_dt);

            ob_respiratory_rate.setSubject(patientRef);
            ob_respiratory_rate.setEncounter(encounterRef);
        }

        // Respiratory Effort
        if (!pcs.getVital_respiratory_effort().isEmpty()) {
            Observation ob_respiratory_effort = new Observation();
            ob_respiratory_effort.setStatus(ObservationStatus.FINAL);
            ob_respiratory_effort.addCategory(vital_cat);
            CodeableConcept respiratory_effort_code = new CodeableConcept();
            respiratory_effort_code.addCoding().setDisplay("Respiratory Effort");
            ob_respiratory_effort.setCode(respiratory_effort_code);
            ob_respiratory_effort.setValue(new StringType(pcs.getVital_respiratory_effort()));
            ob_respiratory_effort.setEffective(vitals_dt);

            ob_respiratory_effort.setSubject(patientRef);
            ob_respiratory_effort.setEncounter(encounterRef);
        }

        // End Title Carbon Dioxide (ETCO2)
        if (!pcs.getVital_etco2().isEmpty()) {
            Observation ob_etco2 = new Observation();
            ob_etco2.setStatus(ObservationStatus.FINAL);
            ob_etco2.addCategory(vital_cat);
            CodeableConcept etco2_code = new CodeableConcept();
            etco2_code.addCoding().setDisplay("End Title Carbon Dioxide (ETCO2)");
            ob_etco2.setCode(etco2_code);
            ob_etco2.setValue(new StringType(pcs.getVital_etco2()));
            ob_etco2.setEffective(vitals_dt);

            ob_etco2.setSubject(patientRef);
            ob_etco2.setEncounter(encounterRef);
        }

        // Carbon Monoxide (CO)
        if (!pcs.getVital_co().isEmpty()) {
            Observation ob_co = new Observation();
            ob_co.setStatus(ObservationStatus.FINAL);
            ob_co.addCategory(vital_cat);
            CodeableConcept co_code = new CodeableConcept();
            co_code.addCoding().setDisplay("Carbon Monoxide (CO)");
            ob_co.setCode(co_code);
            ob_co.setValue(new StringType(pcs.getVital_co()));
            ob_co.setEffective(vitals_dt);

            ob_co.setSubject(patientRef);
            ob_co.setEncounter(encounterRef);
        }

        // Blood Glucose Level
        if (!pcs.getVital_glucose_level().isEmpty()) {
            Observation ob_glucose_level = new Observation();
            ob_glucose_level.setStatus(ObservationStatus.FINAL);
            ob_glucose_level.addCategory(vital_cat);
            CodeableConcept glucose_level_code = new CodeableConcept();
            glucose_level_code.addCoding().setDisplay("Blood Glucose Level");
            ob_glucose_level.setCode(glucose_level_code);
            ob_glucose_level.setValue(new StringType(pcs.getVital_glucose_level()));
            ob_glucose_level.setEffective(vitals_dt);

            ob_glucose_level.setSubject(patientRef);
            ob_glucose_level.setEncounter(encounterRef);
        }

        // Temperature
        if (!pcs.getVital_temperature().isEmpty()) {
            Observation ob_temperature = new Observation();
            ob_temperature.setStatus(ObservationStatus.FINAL);
            ob_temperature.addCategory(vital_cat);
            CodeableConcept temperature_code = new CodeableConcept();
            temperature_code.addCoding().setDisplay("Temperature");
            ob_temperature.setCode(temperature_code);
            ob_temperature.setValue(new StringType(pcs.getVital_temperature()));
            ob_temperature.setEffective(vitals_dt);

            ob_temperature.setSubject(patientRef);
            ob_temperature.setEncounter(encounterRef);
        }

        // Pain Scale Score
        if (!pcs.getVital_pain_scale_score().isEmpty()) {
            Observation ob_pain_scale_score = new Observation();
            ob_pain_scale_score.setStatus(ObservationStatus.FINAL);
            ob_pain_scale_score.addCategory(vital_cat);
            CodeableConcept pain_scale_score_code = new CodeableConcept();
            pain_scale_score_code.addCoding().setDisplay("Pain Scale Score");
            ob_pain_scale_score.setCode(pain_scale_score_code);
            ob_pain_scale_score.setValue(new StringType(pcs.getVital_pain_scale_score()));
            ob_pain_scale_score.setEffective(vitals_dt);

            ob_pain_scale_score.setSubject(patientRef);
            ob_pain_scale_score.setEncounter(encounterRef);
        }

        // Stroke Scale Score
        if (!pcs.getVital_stroke_scale_score().isEmpty()) {
            Observation ob_stroke_scale_score = new Observation();
            ob_stroke_scale_score.setStatus(ObservationStatus.FINAL);
            ob_stroke_scale_score.addCategory(vital_cat);
            CodeableConcept stroke_scale_score_code = new CodeableConcept();
            stroke_scale_score_code.addCoding().setDisplay("Stroke Scale Score");
            ob_stroke_scale_score.setCode(stroke_scale_score_code);
            ob_stroke_scale_score.setValue(new StringType(pcs.getVital_stroke_scale_score()));
            ob_stroke_scale_score.setEffective(vitals_dt);

            ob_stroke_scale_score.setSubject(patientRef);
            ob_stroke_scale_score.setEncounter(encounterRef);
        }

        // Glasgow Coma Score-Eye
        if (!pcs.getVital_coma_score_eye().isEmpty()) {
            Observation ob_coma_score_eye = new Observation();
            ob_coma_score_eye.setStatus(ObservationStatus.FINAL);
            ob_coma_score_eye.addCategory(vital_cat);
            CodeableConcept coma_score_eye_code = new CodeableConcept();
            coma_score_eye_code.addCoding().setDisplay("Glasgow Coma Score-Eye");
            ob_coma_score_eye.setCode(coma_score_eye_code);
            ob_coma_score_eye.setValue(new StringType(pcs.getVital_coma_score_eye()));
            ob_coma_score_eye.setEffective(vitals_dt);

            ob_coma_score_eye.setSubject(patientRef);
            ob_coma_score_eye.setEncounter(encounterRef);
        }

        // Glasgow Coma Score-Verbal
        if (!pcs.getVital_coma_score_verbal().isEmpty()) {
            Observation ob_coma_score_verbal = new Observation();
            ob_coma_score_verbal.setStatus(ObservationStatus.FINAL);
            ob_coma_score_verbal.addCategory(vital_cat);
            CodeableConcept coma_score_verbal_code = new CodeableConcept();
            coma_score_verbal_code.addCoding().setDisplay("Glasgow Coma Score-Verbal");
            ob_coma_score_verbal.setCode(coma_score_verbal_code);
            ob_coma_score_verbal.setValue(new StringType(pcs.getVital_coma_score_verbal()));
            ob_coma_score_verbal.setEffective(vitals_dt);

            ob_coma_score_verbal.setSubject(patientRef);
            ob_coma_score_verbal.setEncounter(encounterRef);
        }

        // Glasgow Coma Score-Motor
        if (!pcs.getVital_coma_score_motor().isEmpty()) {
            Observation ob_coma_score_motor = new Observation();
            ob_coma_score_motor.setStatus(ObservationStatus.FINAL);
            ob_coma_score_motor.addCategory(vital_cat);
            CodeableConcept coma_score_motor_code = new CodeableConcept();
            coma_score_motor_code.addCoding().setDisplay("Glasgow Coma Score-Motor");
            ob_coma_score_motor.setCode(coma_score_motor_code);
            ob_coma_score_motor.setValue(new StringType(pcs.getVital_coma_score_motor()));
            ob_coma_score_motor.setEffective(vitals_dt);

            ob_coma_score_motor.setSubject(patientRef);
            ob_coma_score_motor.setEncounter(encounterRef);
        }

        // Glasgow Coma Score-Qualifier
        if (!pcs.getVital_coma_score_qualifier().isEmpty()) {
            Observation ob_coma_score_qualifier = new Observation();
            ob_coma_score_qualifier.setStatus(ObservationStatus.FINAL);
            ob_coma_score_qualifier.addCategory(vital_cat);
            CodeableConcept coma_score_qualifier_code = new CodeableConcept();
            coma_score_qualifier_code.addCoding().setDisplay("Glasgow Coma Score-Qualifier");
            ob_coma_score_qualifier.setCode(coma_score_qualifier_code);
            ob_coma_score_qualifier.setValue(new StringType(pcs.getVital_coma_score_qualifier()));
            ob_coma_score_qualifier.setEffective(vitals_dt);

            ob_coma_score_qualifier.setSubject(patientRef);
            ob_coma_score_qualifier.setEncounter(encounterRef);
        }

        // Total Glasgow Coma Score
        if (!pcs.getVital_coma_score_total().isEmpty()) {
            Observation ob_coma_score_total = new Observation();
            ob_coma_score_total.setStatus(ObservationStatus.FINAL);
            ob_coma_score_total.addCategory(vital_cat);
            CodeableConcept coma_score_total_code = new CodeableConcept();
            coma_score_total_code.addCoding().setDisplay("Total Glasgow Coma Score");
            ob_coma_score_total.setCode(coma_score_total_code);
            ob_coma_score_total.setValue(new StringType(pcs.getVital_coma_score_total()));
            ob_coma_score_total.setEffective(vitals_dt);

            ob_coma_score_total.setSubject(patientRef);
            ob_coma_score_total.setEncounter(encounterRef);
        }

        // Reperfusion Checklist
        if (!pcs.getVital_reperfusion_checklist().isEmpty()) {
            Observation ob_reperfusion_checklist = new Observation();
            ob_reperfusion_checklist.setStatus(ObservationStatus.FINAL);
            ob_reperfusion_checklist.addCategory(vital_cat);
            CodeableConcept reperfusion_checklist_code = new CodeableConcept();
            reperfusion_checklist_code.addCoding().setDisplay("Reperfusion Checklist");
            ob_reperfusion_checklist.setCode(reperfusion_checklist_code);
            ob_reperfusion_checklist.setValue(new StringType(pcs.getVital_reperfusion_checklist()));
            ob_reperfusion_checklist.setEffective(vitals_dt);

            ob_reperfusion_checklist.setSubject(patientRef);
            ob_reperfusion_checklist.setEncounter(encounterRef);
        }

        // APGAR
        if (!pcs.getVital_apgar().isEmpty()) {
            Observation ob_apgar = new Observation();
            ob_apgar.setStatus(ObservationStatus.FINAL);
            ob_apgar.addCategory(vital_cat);
            CodeableConcept apgar_code = new CodeableConcept();
            apgar_code.addCoding().setDisplay("APGAR");
            ob_apgar.setCode(apgar_code);
            ob_apgar.setValue(new StringType(pcs.getVital_apgar()));
            ob_apgar.setEffective(vitals_dt);

            ob_apgar.setSubject(patientRef);
            ob_apgar.setEncounter(encounterRef);
        }

        // Revised Trauma Score
        if (!pcs.getVital_revised_trauma_score().isEmpty()) {
            Observation ob_revised_trauma_score = new Observation();
            ob_revised_trauma_score.setStatus(ObservationStatus.FINAL);
            ob_revised_trauma_score.addCategory(vital_cat);
            CodeableConcept revised_trauma_score_code = new CodeableConcept();
            revised_trauma_score_code.addCoding().setDisplay("Revised Trauma Score");
            ob_revised_trauma_score.setCode(revised_trauma_score_code);
            ob_revised_trauma_score.setValue(new StringType(pcs.getVital_revised_trauma_score()));
            ob_revised_trauma_score.setEffective(vitals_dt);

            ob_revised_trauma_score.setSubject(patientRef);
            ob_revised_trauma_score.setEncounter(encounterRef);
        }

        // Estimated Body Weight in Kilograms
        if (!pcs.getVital_body_weight().isEmpty()) {
            Observation ob_body_weight = new Observation();
            ob_body_weight.setStatus(ObservationStatus.FINAL);
            ob_body_weight.addCategory(vital_cat);
            CodeableConcept body_weight_code = new CodeableConcept();
            body_weight_code.addCoding().setDisplay("Estimated Body Weight in Kilograms");
            ob_body_weight.setCode(body_weight_code);
            ob_body_weight.setValue(new StringType(pcs.getVital_body_weight()));
            ob_body_weight.setEffective(vitals_dt);

            ob_body_weight.setSubject(patientRef);
            ob_body_weight.setEncounter(encounterRef);

            // Print the Resource
            String string = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(ob_body_weight);
            System.out.println(string);
        }

        return new ResponseEntity<>("Work in progress: ", HttpStatus.OK);
    }
}
