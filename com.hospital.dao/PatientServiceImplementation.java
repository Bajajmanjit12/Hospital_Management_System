package com.hospital.dao;

// importing modules
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.Patient;
import com.hospital.service.PatientService;
import com.hospital.util.DBConnection;
public class PatientServiceImplementation {

	// use of collection framework
	
	// Fetch all patient record
	public List<Patient> findAll()
	{
		List<Patient> patients = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// use of exception handling
		try {
			con = DBConnection.getDBConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from patient");
			
			while(rs.next())
			{
				Patient p = new Patient(
						rs.getInt("patient_id"), rs.getString("patient_name"), rs.getInt("age"), rs.getString("disease"), rs.getInt("doctor_id")
			);
				patients.add(p);
						
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return patients;
	}
	
	// Fetch patient using id
	public Patient find(int id) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Patient patient = null;

        try {
            con = DBConnection.getDBConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "select * from patient where patient_id = " + id);

            if (rs.next()) {
                patient = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("patient_name"),
                        rs.getInt("age"),
                        rs.getString("disease"),
                        rs.getInt("doctor_id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return patient;
    }

    // Delete patient using id

    public void delete(int id) {

        Connection con = null;
        Statement stmt = null;

        try {
            con = DBConnection.getDBConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(
                    "delete from patient where patient_id = " + id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add new Patient
    public boolean add(Patient patient) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement(
                    "insert into patient (patient_name, age, disease, doctor_id) values (?,?,?,?)");

            pstmt.setString(1, patient.getPatientName());
            pstmt.setInt(2, patient.getAge());
            pstmt.setString(3, patient.getDisease());
            pstmt.setInt(4, patient.getDoctorId());

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
        	System.out.println("Invalid! Doctor Id dosen't Exist");
            e.printStackTrace();
        }
		return false;
    }

    // Update Patient record
    
		public void update(Patient p1) {

		    Connection con = null;
		    PreparedStatement pstmt = null;

		    try {
		        con = DBConnection.getDBConnection();
		        pstmt = con.prepareStatement(
		            "update patient set patient_name = ?, age = ?, disease = ?, doctor_id = ? where patient_id = ?"
		        );

		        pstmt.setString(1, p1.getPatientName());
		        pstmt.setInt(2, p1.getAge());
		        pstmt.setString(3, p1.getDisease());
		        pstmt.setInt(4, p1.getDoctorId());
		        pstmt.setInt(5, p1.getPatientId());

		        pstmt.executeUpdate();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		

		
	}
}
