const apiUrl = "http://localhost:8081/api/employees";

const employeeForm = document.getElementById("employeeForm");
const employeeList = document.getElementById("employeeList");

employeeForm.addEventListener("submit", async (e) => {
  e.preventDefault();

  const employee = {
    name: document.getElementById("name").value,
    email: document.getElementById("email").value,
    role: document.getElementById("role").value
  };

  await fetch(apiUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(employee)
  });

  employeeForm.reset();
  loadEmployees();
});

async function loadEmployees() {
  const res = await fetch(apiUrl);
  const employees = await res.json();

  employeeList.innerHTML = "";
  employees.forEach((emp) => {
    const li = document.createElement("li");
    li.innerHTML = `${emp.name} (${emp.role}) — ${emp.email}
      <button onclick="deleteEmployee(${emp.id})">❌ Delete</button>`;
    employeeList.appendChild(li);
  });
}

async function deleteEmployee(id) {
  await fetch(`${apiUrl}/${id}`, { method: "DELETE" });
  loadEmployees();
}

loadEmployees();
