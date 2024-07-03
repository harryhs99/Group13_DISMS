// sumbit form to server
// Fetch API
const loginForm = document.getElementById('loginForm');
loginForm.addEventListener('submit',function(e){
    e.preventDefault();
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    sessionStorage.setItem("username",username);
    fetch('http://localhost:8080/student/login',{ // student login
        method:'POST',
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            userID: username,
            userPassword: password
        })
    })
    .then(Response=>{
        if(!Response.ok){
            alert("invalid password or username");
            throw new Error("Wrong request" + Response.statusText);

        }else{
        alert("ok")
            window.location.href = "Main.html";
            return Response.json();
        }
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    });
});