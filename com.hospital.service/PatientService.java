package com.hospital.service;

import java.util.List;
import com.hospital.model.Patient;

public interface PatientService {

    // Fetch all patients
    List<Patient> findAll();

    // Fetch patient by ID
    Patient find(int id);

    // Delete patient
    void delete(int id);

    // Add new patient
    boolean add(Patient patient);

    // Update patient name
    void update(Patient patient);
}
