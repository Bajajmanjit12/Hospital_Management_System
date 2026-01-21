package com.hospital.model;

public class Patient {

	  int patientId;
	  String patientName;
	  int age;
	  String disease;
	  int doctorId;
	  
	  
	public Patient(int patientId, String patientName, int age, String disease, int doctorId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.disease = disease;
		this.doctorId = doctorId;
	}
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", disease="
				+ disease + ", doctorId=" + doctorId + "]";
	}
	  
	  
}
