const taxList = document.getElementById('tax-list');
const form = document.getElementById('tax-form');
const API_URL = 'http://localhost:8081/api/taxes';

function loadTaxes() {
  fetch(API_URL)
    .then(res => res.json())
    .then(data => {
      taxList.innerHTML = '';
      data.forEach(tax => {
        const li = document.createElement('li');
        li.innerHTML = `
          ${tax.taxType} - ${tax.percentage}%
          <button onclick="deleteTax(${tax.id})">Delete</button>
        `;
        taxList.appendChild(li);
      });
    });
}

form.addEventListener('submit', e => {
  e.preventDefault();
  const newTax = {
    taxType: document.getElementById('taxType').value,
    percentage: parseFloat(document.getElementById('percentage').value)
  };

  fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(newTax)
  })
  .then(() => {
    form.reset();
    loadTaxes();
  });
});

function deleteTax(id) {
  fetch(`${API_URL}/${id}`, { method: 'DELETE' })
    .then(loadTaxes);
}

loadTaxes();
