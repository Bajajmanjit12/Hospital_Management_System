
# 🏥 Hospital Management System (Patient)

A simple **Patient Management System** developed using **Java Swing (AWT)**.  
This project demonstrates basic **CRUD operations** (Create, Read, Update, Delete) with a clean and beginner-friendly graphical user interface.

---

## 📌 Features

- ➕ Add Patient  
- ✏️ Update Patient  
- ❌ Delete Patient  
- 🔍 Find Patient by ID  
- 📋 View All Patients  
- 🖥️ Simple Swing-based UI  

---

## 🛠️ Technologies Used

- Java (JDK 8 or above)
- Swing & AWT (GUI)
- JDBC (if database is connected)
- Eclipse / IntelliJ / VS Code

---

## 📂 Project Structure

```

Patient-Management-System/
│
├── src/
│   ├── com.acc.ui
│   │   └── PatientUI.java
│   │
│   ├── com.hospital.dao
│   │   └── PatientServiceImplementation.java
│   │
│   ├── com.hospital.model
│   │   └── Patient.java
│
├── README.md

````

---

## 🧑‍⚕️ Patient Entity Fields

| Field Name   | Data Type |
|-------------|-----------|
| patientId   | int       |
| patientName | String    |
| age         | int       |
| disease     | String    |
| doctorId    | int       |

---

## ▶️ How to Run the Application

### Step 1: Clone the Repository
```bash
git clone https://github.com/your-username/Patient-Management-System.git
````

### Step 2: Open in IDE

* Open the project in Eclipse / IntelliJ
* Make sure JDK is configured properly

### Step 3: Run the UI

* Go to:

  ```
  com.acc.ui.PatientUI
  ```
* Run the `main()` method

---

## 🖼️ UI Description

* Uses `JFrame` as main window
* `JLabel` and `JTextField` for inputs
* `JButton` for operations
* `JTextArea` for displaying results
* Absolute layout (`setLayout(null)`) for simplicity

---

## 🧪 Example Usage

* **Add Patient**
  Enter Name, Age, Disease, Doctor ID → Click **Add**

* **Update Patient**
  Enter Patient ID + new details → Click **Update**

* **Delete Patient**
  Enter Patient ID → Click **Delete**

* **Find Patient**
  Enter Patient ID → Click **Find By ID**

* **Find All Patients**
  Click **Find All**

---

## ⚠️ Notes

* Designed for **learning and academic purposes**
* Simple validation and exception handling
* Database logic depends on `PatientServiceImplementation`

---

## 🚀 Future Enhancements

* Input validation
* Improved UI using layouts
* Search by name/disease
* Login authentication
* Database optimization

---

## 👨‍💻 Java Developer

**Auti Arti | Bajaj Manjit | Bhosale Snehal | Dabhade Unnati**


---

## 📜 License

This project is free to use for educational purposes.


