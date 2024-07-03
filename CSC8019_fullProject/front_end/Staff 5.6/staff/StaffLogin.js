// Fetch API
const loginForm = document.getElementById('loginForm');
loginForm.addEventListener('submit', function(e) {
    e.preventDefault();
    console.log('start');

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    fetch('http://localhost:8080/staff/login', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userID: username,
            userPassword: password
        })
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    alert('Login failed: ' + text);
                    throw new Error("Login failed with status " + response.status + ": " + text);
                });
            }
            else{
                sessionStorage.setItem("username",username);
                alert("Login successfully!");
                window.location.href = "StaffDashboard.html";
                return Response.json();

            }
            return response.text(); // Assuming the server responds with JSON on successful login
        })
        .catch(error => {
            console.error("Error is:", error);
            // alert("Invalid username or password. Please try again."); // Providing user feedback on error
        });
});