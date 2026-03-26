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
    displayResult(data);
});

function displayResult(data) {
    const result = document.getElementById('result');
    const isApproved = data.status === 'APPROVED';

    result.className = isApproved ? 'result-box approved' : 'result-box denied';

    result.innerHTML = `
        <p class="result-label">RESULT</p>
        <p class="result-status ${isApproved ? 'status-approved' : 'status-denied'}">${data.status}</p>
        ${isApproved ? `
        <div class="result-details">
            <div class="result-detail">
                <p class="detail-label">APPROVED AMOUNT</p>
                <p class="detail-value">€${data.approvedAmount}</p>
            </div>
            <div class="result-detail">
                <p class="detail-label">PERIOD</p>
                <p class="detail-value">${data.approvedPeriod} mo</p>
            </div>
        </div>` : ''}
    `;
}
