const body = document.querySelector("body");
      toggle = body.querySelector(".toggle");
      sidebar = body.querySelector(".sidebar");

toggle.addEventListener("click", function() {
    sidebar.classList.toggle("close");
});

// ------Enroll Btn -------
const m1Btn = document.getElementById('m1Btn');
m1Btn.addEventListener('click',function(){
    //this.disabled = true; // each button can only click once....
    const messageM1 = " Enroll Module1";

    fetch('http://localhost:8080',{ // send enroll data to backend
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(messageM1)
        })
        .then(Response=>{
          if(!Response.ok){
            alert("Cannot enroll this module");
            throw new Error("Wrong request" + Response.statusText);
          }else{
            alert("Enroll Successfully");
            return Response.json();
          }
        })  
})

const m2Btn = document.getElementById('m2Btn');
m2Btn.addEventListener('click',function(){
    //this.disabled = true; // each button can only click once....
    const messageM2 = " Enroll Module2";

    fetch('http://localhost:8080',{ // send enroll data to backend
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(messageM2)
        })
        .then(Response=>{
          if(!Response.ok){
            alert("Cannot enroll this module");
            throw new Error("Wrong request" + Response.statusText);
          }else{
            alert("Enroll Successfully");
            return Response.json();
          }
        })  
})

const m3Btn = document.getElementById('m3Btn');
m2Btn.addEventListener('click',function(){
    //this.disabled = true; // each button can only click once....
    const messageM3 = " Enroll Module3";

    fetch('http://localhost:8080',{ // send enroll data to backend
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(messageM3)
        })
        .then(Response=>{
          if(!Response.ok){
            alert("Cannot enroll this module");
            throw new Error("Wrong request" + Response.statusText);
          }else{
            alert("Enroll Successfully");
            return Response.json();
          }
        })  
})

const m4Btn = document.getElementById('m4Btn');
m2Btn.addEventListener('click',function(){
    //this.disabled = true; // each button can only click once....
    const messageM4 = " Enroll Module4";

    fetch('http://localhost:8080',{ // send enroll data to backend
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(messageM4)
        })
        .then(Response=>{
          if(!Response.ok){
            alert("Cannot enroll this module");
            throw new Error("Wrong request" + Response.statusText);
          }else{
            alert("Enroll Successfully");
            return Response.json();
          }
        })  
})