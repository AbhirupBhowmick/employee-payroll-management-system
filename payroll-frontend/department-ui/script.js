const API_URL = "http://localhost:8081/api/departments";

// Handle form submission to add a department
document.getElementById("departmentForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const name = document.getElementById("name").value.trim();

  if (!name) return alert("Please enter a department name.");

  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ name })
  })
    .then(res => res.json())
    .then(data => {
      console.log("Created:", data);
      document.getElementById("name").value = ""; // Clear input
      loadDepartments(); // Refresh list
    })
    .catch(err => console.error("Error adding department:", err));
});

// Function to load departments and display them
function loadDepartments() {
  fetch(API_URL)
    .then(res => res.json())
    .then(data => {
      const list = document.getElementById("deptList");
      list.innerHTML = "";

      data.forEach(dept => {
        const li = document.createElement("li");
        li.textContent = `${dept.id} - ${dept.name}`;

        const delBtn = document.createElement("button");
        delBtn.textContent = "Delete";
        delBtn.style.marginLeft = "10px";
        delBtn.style.backgroundColor = "#e74c3c";
        delBtn.style.color = "white";
        delBtn.style.border = "none";
        delBtn.style.padding = "5px 10px";
        delBtn.style.cursor = "pointer";

        delBtn.onclick = () => {
          if (confirm(`Delete department "${dept.name}"?`)) {
            fetch(`${API_URL}/${dept.id}`, {
              method: "DELETE"
            })
              .then(() => loadDepartments()) // Refresh list
              .catch(err => console.error("Delete failed", err));
          }
        };

        li.appendChild(delBtn);
        list.appendChild(li);
      });
    })
    .catch(err => console.error("Error loading departments:", err));
}

// ✅ Load departments when page loads
window.onload = loadDepartments;
