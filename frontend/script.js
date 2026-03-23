document.getElementById('loan-form').addEventListener('submit', async function(e) {
    e.preventDefault();

    const requestBody = {
        personalCode: document.getElementById('personal-code').value,
        loanAmount: parseInt(document.getElementById('loan-amount').value),
        loanPeriod: parseInt(document.getElementById('loan-period').value)
    };

    const response = await fetch('http://localhost:8080/api/loan/decision', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(requestBody)
    });

    const data = await response.json();
    document.getElementById('result').innerText = JSON.stringify(data);
});