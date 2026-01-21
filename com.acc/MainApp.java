package com.acc;

import java.util.List;
import java.util.Scanner;

import com.hospital.dao.PatientServiceImplementation;
import com.hospital.model.Patient;

public class MainApp {

    public static void main(String[] args) {

        PatientServiceImplementation service = new PatientServiceImplementation();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- Patient Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient (All Fields)");
            System.out.println("3. Delete Patient");
            System.out.println("4. Find Patient By ID");
            System.out.println("5. Find All Patients");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

            	// Add the Patient
                case 1: 
                    Patient p = new Patient();

                    System.out.print("Enter Patient Name: ");
                    p.setPatientName(sc.nextLine());

                    System.out.print("Enter Age: ");
                    p.setAge(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Disease: ");
                    p.setDisease(sc.nextLine());

                    System.out.print("Enter Doctor ID: ");
                    p.setDoctorId(sc.nextInt());

                    service.add(p);
                    System.out.println("Patient added successfully.");
                    break;

                 // Update 
                case 2: 
                    Patient p1 = new Patient();

                    System.out.print("Enter Patient ID: ");
                    p1.setPatientId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    p1.setPatientName(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    p1.setAge(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter New Disease: ");
                    p1.setDisease(sc.nextLine());

                    System.out.print("Enter New Doctor ID: ");
                    p1.setDoctorId(sc.nextInt());

                    service.update(p1);
                    System.out.println("Patient updated successfully.");
                    break;

                // delete
                case 3: 
                    System.out.print("Enter Patient ID to delete: ");
                    int delId = sc.nextInt();
                    service.delete(delId);
                    System.out.println("Patient deleted successfully.");
                    break;

                // Find by Id
                case 4: 
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();

                    Patient patient = service.find(id);
                    if (patient != null) {
                        System.out.println(patient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // Find All
                case 5: 
                    List<Patient> patients = service.findAll();
                    for (Patient pt : patients) {
                        System.out.println(pt);
                    }
                    break;

                // Exit Condition
                case 0:
                    System.out.println("Exiting system...");
                    break;

                // Default Case
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

   
    }
}
