# Employee Payroll Management System 💼

A full-stack Java-based web application to manage employees, departments, taxes, and payrolls.

## 🔧 Technologies Used

- **Backend:** Java 17, Spring Boot, JPA, H2 Database
- **Frontend:** HTML, CSS, JavaScript (Vanilla)
- **Database:** In-memory H2 Console
- **Tools:** Postman, Git, GitHub

---

## 📁 Project Structure

employee-payroll-system/
├── backend/ # Spring Boot Application
├── payroll-frontend/ # HTML, CSS, JS UI
│ ├── index.html
│ ├── department-ui/
│ ├── tax-ui/
│ └── payroll-ui/


---

## ✅ Features

- Employee CRUD operations
- Department management
- Tax percentage configuration
- Payroll calculation with tax deduction
- H2 Console integration
- Fully working frontend connected via `fetch()`

## 📦 Run the Project

### 🔙 Backend

```bash
cd backend
./mvnw spring-boot:run

How Payroll Works
Admin selects employee → system generates payroll.

Calculates: Net Salary = Basic - Tax

Tax rates configured via Tax Module.

👨‍💻 Author
Abhirup Bhowmick

https://www.linkedin.com/in/abhirup111/


