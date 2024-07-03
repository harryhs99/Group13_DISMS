loginForm.addEventListener('submit', function(e) {
    e.preventDefault();
    //console.log('start');
    console.log(username.value)
    fetch('http://localhost:8080/student/forget', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            userID: username.value,
            email: email.value,
            userPassword: resetpwd.value
        })
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    alert('Activation failed: ' + text);
                    throw new Error("Activation failed with status " + response.status + ": " + text);
                });
            }

            return response.text();
        })
        .then(text => {
            console.log(text);
            if (text === "successfully") {
                alert("ReSet successfully");
                window.location.href = "DysonLogin.html";
            } else {
                alert(text);
            }
        })
        .catch(error => {
            console.error("Error is:", error);
        });
});