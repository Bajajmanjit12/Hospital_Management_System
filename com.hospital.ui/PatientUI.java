package com.hospital.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

import com.hospital.dao.PatientServiceImplementation;
import com.hospital.model.Patient;

public class PatientUI extends JFrame implements ActionListener {

    // Service layer
    PatientServiceImplementation service = new PatientServiceImplementation();

    // UI Components
    JTextField txtId, txtName, txtAge, txtDisease, txtDoctorId;
    JTextArea textArea;

    JButton btnAdd, btnUpdate, btnDelete, btnFind, btnFindAll, btnClear;

    public PatientUI() {

        // Frame settings
        setTitle("Patient Management System");
        setSize(500, 500);
        setLayout(null); // simple absolute positioning
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel lblId = new JLabel("Patient ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblAge = new JLabel("Age:");
        JLabel lblDisease = new JLabel("Disease:");
        JLabel lblDoctorId = new JLabel("Doctor ID:");

        // Set label positions
        lblId.setBounds(20, 20, 100, 25);
        lblName.setBounds(20, 60, 100, 25);
        lblAge.setBounds(20, 100, 100, 25);
        lblDisease.setBounds(20, 140, 100, 25);
        lblDoctorId.setBounds(20, 180, 100, 25);

        // Text fields
        txtId = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();
        txtDisease = new JTextField();
        txtDoctorId = new JTextField();

        // Set text field positions
        txtId.setBounds(130, 20, 150, 25);
        txtName.setBounds(130, 60, 150, 25);
        txtAge.setBounds(130, 100, 150, 25);
        txtDisease.setBounds(130, 140, 150, 25);
        txtDoctorId.setBounds(130, 180, 150, 25);

        // Buttons
        btnAdd = new JButton("Add");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnFind = new JButton("Find By ID");
        btnFindAll = new JButton("Find All");
        btnClear = new JButton("Clear");

        // Button positions
        btnAdd.setBounds(300, 20, 150, 25);
        btnUpdate.setBounds(300, 60, 150, 25);
        btnDelete.setBounds(300, 100, 150, 25);
        btnFind.setBounds(300, 140, 150, 25);
        btnFindAll.setBounds(300, 180, 150, 25);
        btnClear.setBounds(300, 220, 150, 25);

        // Text area for output
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 260, 430, 180);

        // Add action listeners
        btnAdd.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnFind.addActionListener(this);
        btnFindAll.addActionListener(this);
        btnClear.addActionListener(this);

        // Add components to frame
        add(lblId);
        add(lblName);
        add(lblAge);
        add(lblDisease);
        add(lblDoctorId);

        add(txtId);
        add(txtName);
        add(txtAge);
        add(txtDisease);
        add(txtDoctorId);

        add(btnAdd);
        add(btnUpdate);
        add(btnDelete);
        add(btnFind);
        add(btnFindAll);
        add(btnClear);

        add(scrollPane);

        setVisible(true);
    }

    // Button click handling
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            // Add patient
            if (e.getSource() == btnAdd) {
                Patient p = new Patient();
                p.setPatientName(txtName.getText());
                p.setAge(Integer.parseInt(txtAge.getText()));
                p.setDisease(txtDisease.getText());
                p.setDoctorId(Integer.parseInt(txtDoctorId.getText()));

                service.add(p);
                textArea.setText("Patient added successfully.");
            }

            // Update Patient
            else if (e.getSource() == btnUpdate) {
                Patient p = new Patient();
                p.setPatientId(Integer.parseInt(txtId.getText()));
                p.setPatientName(txtName.getText());
                p.setAge(Integer.parseInt(txtAge.getText()));
                p.setDisease(txtDisease.getText());
                p.setDoctorId(Integer.parseInt(txtDoctorId.getText()));

                service.update(p);
                textArea.setText("Patient updated successfully.");
            }

            // Delete Patient
            else if (e.getSource() == btnDelete) {
                int id = Integer.parseInt(txtId.getText());
                service.delete(id);
                textArea.setText("Patient deleted successfully.");
            }

            // Fetch records By Id
            else if (e.getSource() == btnFind) {
                int id = Integer.parseInt(txtId.getText());
                Patient p = service.find(id);

                if (p != null) {
                    textArea.setText(p.toString());
                } else {
                    textArea.setText("Patient not found.");
                }
            }

            // Fetch All records
            else if (e.getSource() == btnFindAll) {
                List<Patient> list = service.findAll();
                textArea.setText("");

                for (Patient p : list) {
                    textArea.append(p.toString() + "\n");
                }
            }

            // Clear fields
            else if (e.getSource() == btnClear) {
                txtId.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtDisease.setText("");
                txtDoctorId.setText("");
                textArea.setText("");
            }

        } catch (Exception ex) {
            textArea.setText("Error: " + ex.getMessage());
        }
    }

    // Main method 
    public static void main(String[] args) {
        new PatientUI();
    }
}
