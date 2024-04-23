// sumbit form to server
// Fetch API
const loginForm = document.getElementById('loginForm');
loginForm.addEventListener('submit',function(e){
    e.preventDefault();
    console.log('start');
    const dataForm = new FormData(loginForm);
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
            return Response.json(); // Parse the data returned by the server
        }
     })
     .then(data=>{
        console.log("data return from server:",data); // data just a variable, it can be any names
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    })
});