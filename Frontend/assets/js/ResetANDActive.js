// Sent new data to server,using Fetch API
const form = document.getElementById('form');
form.addEventListener('submit',function(e){
    e.preventDefault();
    console.log('start');
    const dataForm = new FormData(form);
     fetch('url',{
        method:'POST',
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(dataForm)
     })
     
    //  message from backend
     .then(Response=>{
        if(!Response.ok){
            throw new Error("Wrong request" + Response.statusText);
        }else{
            alert("Send successfully")
             // Parse the data returned by the server
            return Response.json(); 
        }
     })
     .then(data=>{
        console.log("receive data successfully:",data); // data just a variable, it can be any names

        // ------- send email to users and tell them reset successfully------(how to code?????)

        // Automatically return to login page,after reset password successfully
        setTimeout(function(){
            window.location.href="DysonLogin.html";
        },3000)
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    })
});

// ----------------------------- Active account === Add new data into dataBase -------------------------

const activeForm = document.getElementById('activeForm');
activeForm.addEventListener('submit',function(e){
    e.preventDefault();
    console.log('start');
    const dataForm = new FormData(activeForm);
    
    fetch('url',{
        method:'POST',
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(dataForm)
     })
     .then(Response=>{
        if(!Response.ok){
            throw new Error("Wrong request" + Response.statusText);
        }else{
            alert("Send successfully")
             // Parse the data returned by the server
            return Response.json(); 
        }
     })
     .then(data=>{
        console.log("receive data successfully:",data); // data just a variable, it can be any names

        // ------- send email to users and tell them active successfully------(how to code?????)

    })
    .catch(error =>{
        console.error("Error is:" ,error);
    })
});




