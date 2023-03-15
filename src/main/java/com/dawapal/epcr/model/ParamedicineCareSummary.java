package com.dawapal.epcr.model;

import jakarta.validation.constraints.NotBlank;

/**
 * 
 * @author Ancentus Makau
 * @version 1.0.0
 * 
 */

public class ParamedicineCareSummary {

    //PATIENT
    @NotBlank(message = "pat_ems_id is mandatory")
    private String pat_ems_id;   // EMS Patient ID
    private String pat_first_name; // Fisrt Name
    private String pat_middle_name; // Middle Name
    private String pat_last_name; // Last Name
    private String pat_address; // Home Address
    private String pat_city; // Home City
    private String pat_country; // Home Country
    private String pat_postal_code; // Home Postal Code
    private String pat_gender;  // Gender
    private String pat_dob; // Date of Birth
    private String pat_phone; // Phone Number
    private String pat_nok_first_name;  // Next of Kin First Name 
    private String pat_nok_middle_name; // Next of Kin Middle Name 
    private String pat_nok_last_name;   // Next of Kin Last Name 
    private String pat_nok_address; // Next of Kin Home Address
    private String pat_nok_city;    // Next of Kin Home City
    private String pat_nok_country; // Next of Kin Home Country
    private String pat_nok_postal_code; // Next of Kin Home Postal Code
    private String pat_nok_phone;   // Next of Kin Phone Number
    private String pat_nok_relationship;    // Next of Kin Relationship

    // VITAL SIGNS
    @NotBlank(message = "DateTime of vitals is mandatory")
    private String vital_dateTime;  // Date/Time Vital Signs Taken 
    private String vital_ecg;   // Cardiac Rhythm / Electrocardiography (ECG)
    private String vital_ecg_type;  // ECG Type
    private String vital_ecg_method;    // Method of ECG Interpretation
    private String vital_sbp;   // SBP (Systolic Blood Pressure)
    private String vital_dbp;   // DBP (Diastolic Blood Pressure)
    private String vital_mean_ap;   // Mean Arterial Pressure
    private String vital_heart_rate;    // Heart Rate
    private String vital_heart_rate_method; // Method of Heart Rate Measurement
    private String vital_pulse_oximetry;    // Pulse Oximetry
    private String vital_pulse_rhythm;  // Pulse Rhythm
    private String vital_respiratory_rate;  // Respiratory Rate 
    private String vital_respiratory_effort;    // Respiratory Effort
    private String vital_etco2; // End Title Carbon Dioxide (ETCO2)
    private String vital_co;    // Carbon Monoxide (CO)
    private String vital_glucose_level; // Blood Glucose Level
    private String vital_temperature;   // Temperature
    private String vital_pain_scale_score;  // Pain Scale Score
    private String vital_pain_scale_type;   // Pain Scale Type
    private String vital_stroke_scale_score;    // Stroke Scale Score
    private String vital_stroke_scale_type; // Stroke Scale Type
    private String vital_coma_score_eye;    // Glasgow Coma Score-Eye
    private String vital_coma_score_verbal; // Glasgow Coma Score-Verbal
    private String vital_coma_score_motor;  // Glasgow Coma Score-Motor
    private String vital_coma_score_qualifier;  // Glasgow Coma Score-Qualifier
    private String vital_coma_score_total;  // Total Glasgow Coma Score
    private String vital_reperfusion_checklist; // Reperfusion Checklist
    private String vital_apgar; // APGAR
    private String vital_revised_trauma_score;  // Revised Trauma Score
    private String vital_body_weight;   // Estimated Body Weight in Kilograms
    
    public ParamedicineCareSummary() {
    }

    public String getVital_dateTime() {
        return vital_dateTime;
    }

    public void setVital_dateTime(String vital_dateTime) {
        this.vital_dateTime = vital_dateTime;
    }

    public String getVital_ecg() {
        return vital_ecg;
    }

    public void setVital_ecg(String vital_ecg) {
        this.vital_ecg = vital_ecg;
    }

    public String getVital_ecg_type() {
        return vital_ecg_type;
    }

    public void setVital_ecg_type(String vital_ecg_type) {
        this.vital_ecg_type = vital_ecg_type;
    }

    public String getVital_ecg_method() {
        return vital_ecg_method;
    }

    public void setVital_ecg_method(String vital_ecg_method) {
        this.vital_ecg_method = vital_ecg_method;
    }

    public String getVital_sbp() {
        return vital_sbp;
    }

    public void setVital_sbp(String vital_sbp) {
        this.vital_sbp = vital_sbp;
    }

    public String getVital_dbp() {
        return vital_dbp;
    }

    public void setVital_dbp(String vital_dbp) {
        this.vital_dbp = vital_dbp;
    }

    public String getVital_mean_ap() {
        return vital_mean_ap;
    }

    public void setVital_mean_ap(String vital_mean_ap) {
        this.vital_mean_ap = vital_mean_ap;
    }

    public String getVital_heart_rate() {
        return vital_heart_rate;
    }

    public void setVital_heart_rate(String vital_heart_rate) {
        this.vital_heart_rate = vital_heart_rate;
    }

    public String getVital_heart_rate_method() {
        return vital_heart_rate_method;
    }

    public void setVital_heart_rate_method(String vital_heart_rate_method) {
        this.vital_heart_rate_method = vital_heart_rate_method;
    }

    public String getVital_pulse_oximetry() {
        return vital_pulse_oximetry;
    }

    public void setVital_pulse_oximetry(String vital_pulse_oximetry) {
        this.vital_pulse_oximetry = vital_pulse_oximetry;
    }

    public String getVital_pulse_rhythm() {
        return vital_pulse_rhythm;
    }

    public void setVital_pulse_rhythm(String vital_pulse_rhythm) {
        this.vital_pulse_rhythm = vital_pulse_rhythm;
    }

    public String getVital_respiratory_rate() {
        return vital_respiratory_rate;
    }

    public void setVital_respiratory_rate(String vital_respiratory_rate) {
        this.vital_respiratory_rate = vital_respiratory_rate;
    }

    public String getVital_respiratory_effort() {
        return vital_respiratory_effort;
    }

    public void setVital_respiratory_effort(String vital_respiratory_effort) {
        this.vital_respiratory_effort = vital_respiratory_effort;
    }

    public String getVital_etco2() {
        return vital_etco2;
    }

    public void setVital_etco2(String vital_etco2) {
        this.vital_etco2 = vital_etco2;
    }

    public String getVital_co() {
        return vital_co;
    }

    public void setVital_co(String vital_co) {
        this.vital_co = vital_co;
    }

    public String getVital_glucose_level() {
        return vital_glucose_level;
    }

    public void setVital_glucose_level(String vital_glucose_level) {
        this.vital_glucose_level = vital_glucose_level;
    }

    public String getVital_temperature() {
        return vital_temperature;
    }

    public void setVital_temperature(String vital_temperature) {
        this.vital_temperature = vital_temperature;
    }

    public String getVital_pain_scale_score() {
        return vital_pain_scale_score;
    }

    public void setVital_pain_scale_score(String vital_pain_scale_score) {
        this.vital_pain_scale_score = vital_pain_scale_score;
    }

    public String getVital_pain_scale_type() {
        return vital_pain_scale_type;
    }

    public void setVital_pain_scale_type(String vital_pain_scale_type) {
        this.vital_pain_scale_type = vital_pain_scale_type;
    }

    public String getVital_stroke_scale_score() {
        return vital_stroke_scale_score;
    }

    public void setVital_stroke_scale_score(String vital_stroke_scale_score) {
        this.vital_stroke_scale_score = vital_stroke_scale_score;
    }

    public String getVital_stroke_scale_type() {
        return vital_stroke_scale_type;
    }

    public void setVital_stroke_scale_type(String vital_stroke_scale_type) {
        this.vital_stroke_scale_type = vital_stroke_scale_type;
    }

    public String getVital_coma_score_eye() {
        return vital_coma_score_eye;
    }

    public void setVital_coma_score_eye(String vital_coma_score_eye) {
        this.vital_coma_score_eye = vital_coma_score_eye;
    }

    public String getVital_coma_score_verbal() {
        return vital_coma_score_verbal;
    }

    public void setVital_coma_score_verbal(String vital_coma_score_verbal) {
        this.vital_coma_score_verbal = vital_coma_score_verbal;
    }

    public String getVital_coma_score_motor() {
        return vital_coma_score_motor;
    }

    public void setVital_coma_score_motor(String vital_coma_score_motor) {
        this.vital_coma_score_motor = vital_coma_score_motor;
    }

    public String getVital_coma_score_qualifier() {
        return vital_coma_score_qualifier;
    }

    public void setVital_coma_score_qualifier(String vital_coma_score_qualifier) {
        this.vital_coma_score_qualifier = vital_coma_score_qualifier;
    }

    public String getVital_coma_score_total() {
        return vital_coma_score_total;
    }

    public void setVital_coma_score_total(String vital_coma_score_total) {
        this.vital_coma_score_total = vital_coma_score_total;
    }

    public String getVital_reperfusion_checklist() {
        return vital_reperfusion_checklist;
    }

    public void setVital_reperfusion_checklist(String vital_reperfusion_checklist) {
        this.vital_reperfusion_checklist = vital_reperfusion_checklist;
    }

    public String getVital_apgar() {
        return vital_apgar;
    }

    public void setVital_apgar(String vital_apgar) {
        this.vital_apgar = vital_apgar;
    }

    public String getVital_revised_trauma_score() {
        return vital_revised_trauma_score;
    }

    public void setVital_revised_trauma_score(String vital_revised_trauma_score) {
        this.vital_revised_trauma_score = vital_revised_trauma_score;
    }

    public String getVital_body_weight() {
        return vital_body_weight;
    }

    public void setVital_body_weight(String vital_body_weight) {
        this.vital_body_weight = vital_body_weight;
    }

    

}
