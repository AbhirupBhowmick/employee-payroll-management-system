const payrollList = document.getElementById('payroll-list');
const form = document.getElementById('payroll-form');
const BASE_URL = 'http://localhost:8081/api/payrolls';

function loadPayrolls() {
  fetch(BASE_URL)
    .then(res => res.json())
    .then(data => {
      payrollList.innerHTML = '';
      data.forEach(payroll => {
        const li = document.createElement('li');
        li.innerHTML = `
          Employee ID: ${payroll.employee.id}<br>
          Basic Salary: ₹${payroll.basicSalary}<br>
          Tax Deducted: ₹${payroll.taxAmount}<br>
          Net Salary: ₹${payroll.netSalary}<br>
          Date: ${payroll.generatedDate}
          <button onclick="deletePayroll(${payroll.id})">Delete</button>
        `;
        payrollList.appendChild(li);
      });
    });
}

form.addEventListener('submit', e => {
  e.preventDefault();
  const employeeId = document.getElementById('employeeId').value;
  fetch(`${BASE_URL}/generate/${employeeId}`, { method: 'POST' })
    .then(() => {
      form.reset();
      loadPayrolls();
    });
});

function deletePayroll(id) {
  fetch(`${BASE_URL}/${id}`, { method: 'DELETE' })
    .then(loadPayrolls);
}

loadPayrolls();
