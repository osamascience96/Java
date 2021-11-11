/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author osama
 */
public class Appointment {
    private int id;
    private int patient_user_id;
    private int doctor_user_id;
    private String appointmentDetails;
    private String createdAt;

    public Appointment() {
    }

    public Appointment(int id, int patient_user_id, int doctor_user_id, String appointmentDetails, String createdAt) {
        this.id = id;
        this.patient_user_id = patient_user_id;
        this.doctor_user_id = doctor_user_id;
        this.appointmentDetails = appointmentDetails;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_user_id() {
        return patient_user_id;
    }

    public void setPatient_user_id(int patient_user_id) {
        this.patient_user_id = patient_user_id;
    }

    public int getDoctor_user_id() {
        return doctor_user_id;
    }

    public void setDoctor_user_id(int doctor_user_id) {
        this.doctor_user_id = doctor_user_id;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
