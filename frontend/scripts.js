document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const doctor = {
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/api/doctor/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(doctor)
    })
    .then(res => res.text())
    .then(data => {
        document.getElementById('response').innerText = data;
    })
    .catch(err => console.error(err));
});
