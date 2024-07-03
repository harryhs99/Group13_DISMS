// Fetch API
const loginForm = document.getElementById('loginForm');
loginForm.addEventListener('submit',function(e){
    e.preventDefault();
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;

    fetch('http://localhost:8080/student/active',{ // send email...
        method:'POST',
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            userID: username,
            email: email
        })
    })
    .then(Response => {
        if (!Response.ok) {
            return Response.text().then(text => {
                alert('Activation failed: ' + text);  // 使用从后端返回的消息作为警告信息
                throw new Error("Activation failed with status " + Response.status + ": " + text);
            });
        }
        return Response.text();
    })

    .then(text => {
        // data 现在是一个文本字符串，包含了从后端返回的消息
        console.log(text); // 打印后端返回的消息，用于调试
        if (text === "successfully") {
            alert("You have activated your account");
            window.location.href = "DysonLogin.html"; // 成功后跳转
        }
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    });
});