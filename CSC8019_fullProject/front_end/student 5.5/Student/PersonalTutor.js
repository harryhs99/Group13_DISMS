
//-------------------------------------sidepanel--------------------------------

const body = document.querySelector("body");
const toggle = body.querySelector(".toggle");
const sidebar = body.querySelector(".sidebar");
const subNav = body.querySelector(".subjectNav");

toggle.addEventListener("click", function() {
    sidebar.classList.toggle("close");
    subNav.classList.toggle("open")
});


//----- switch pages------
const tabNav = document.querySelector('.tab-nav');
const panes = document.querySelectorAll('.pane');

const username = sessionStorage.getItem('username');

 tabNav.addEventListener('click', function (e) {
  e.preventDefault();
  if (e.target.tagName === 'A') {
      const activeTab = tabNav.querySelector('.active');
      if (activeTab) {
          activeTab.classList.remove('active');
      }
      e.target.classList.add('active');

      const index = e.target.getAttribute('data-id');
      panes.forEach((pane, idx) => {
          if (idx.toString() === index) {
              pane.style.display = 'block';
          } else {
              pane.style.display = 'none';
          }
      });
  }
});

// Meeting with tutor page
// Get tutor name from DB
fetch(`http://localhost:8080/student/getTutorInfo?studentID=${username}`,{
        method:'GET',
        headers:{
            "Content-Type":"application/json"
        },
    })
.then(Response=>{
  if(!Response.ok){
    alert("Cannot get the data");
    throw new Error("Wrong request" + Response.statusText);
  }else{
    return Response.json();
  }
})
.then(data=>{
  document.getElementById('getName').textContent =  data.fName+" "+data.lName;
  document.getElementById('getEmail').textContent = data.email;
  document.getElementById('getID').textContent =  data.userID;
})

// Meeting with tutors and attendence things may send emails to their tutor...

// send attendence emails to tutors
const attendenceForm = document.getElementById("attendence");
const attendenceBtn = document.getElementById("attendenceBtn");
attendenceBtn.addEventListener("click",function(e){
        e.preventDefault();
      console.log("test")
//      const formdata = new FormData(attendenceForm);
      fetch('http://localhost:8080/email/sendAbsenceReq',{ // send email....
        method:'POST',
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
                    userID: username,
                })
    })
    .then(Response=>{
        if(!Response.ok){
          alert("Fail");
          throw new Error("Wrong request" + Response.statusText);

        }else{
          alert("Send successfully!");
          return Response.json();
        }
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    });
})
attendenceForm.addEventListener('submit',function(e){
  e.preventDefault();
  console.log("test")
  const formdata = new FormData(attendenceForm);
  fetch('http://localhost:8080/email/sendAbsenceReq',{ // send email....
    method:'POST',
    headers:{
        "Content-Type":"application/json"
    },
    body:JSON.stringify({
                userID: username,
            })
})
.then(Response=>{
    if(!Response.ok){
      alert("Fail");
      throw new Error("Wrong request" + Response.statusText);
        
    }else{
      alert("Send successfully!");
      return Response.json();
    }
})
.catch(error =>{
    console.error("Error is:" ,error);
});

})

// send meeting emails to tutors
const meetingForm = document.getElementById("meeting");

const meetingBtn = document.getElementById("meetingBtn");
meetingBtn.addEventListener("click",function(e){
      e.preventDefault();
      console.log("test")

      fetch('http://localhost:8080/email/sendMeetingReq',{ // send email....
        method:'POST',
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
                    userID: username,
                })
    })
    .then(Response=>{
        if(!Response.ok){
          alert("Fail");
          throw new Error("Wrong request" + Response.statusText);

        }else{
          alert("Send successfully!");
          return Response.json();
        }
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    });
})

meetingForm.addEventListener('submit',function(e){
  e.preventDefault();
  const formdata = new FormData(meetingForm);
  fetch('http://localhost:8080',{  // send email...
    method:'POST',
    headers:{
        "Content-Type":"application/json"
    },
//    body:formdata
    body:JSON.stringify({
                studentID: username,
                userPassword: password
            })
})
.then(Response=>{
    if(!Response.ok){
      alert("Fail");
      throw new Error("Wrong request" + Response.statusText);
        
    }else{
      alert("Send successfully!");
      return Response.json();
    }
})
.catch(error =>{
    console.error("Error is:" ,error);
});

})


// send suspend emails to tutors
const suspendForm = document.getElementById("susp");
const suspendBtn = document.getElementById("suspendBtn");
suspendBtn.addEventListener("click",function(e){
      e.preventDefault();
      console.log("test")

      fetch('http://localhost:8080/email/sendSuspendReq',{ // send email....
        method:'POST',
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
                    userID: username,
                })
    })
    .then(Response=>{
        if(!Response.ok){
          alert("Fail");
          throw new Error("Wrong request" + Response.statusText);

        }else{
          alert("Send successfully!");
          return Response.json();
        }
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    });
})

//suspendForm.addEventListener('submit',function(e){
//  e.preventDefault();
//  const formdata = new FormData(suspendForm);
//  fetch('http://localhost:8080',{  // send email...
//    method:'POST',
//    headers:{
//        "Content-Type":"application/json"
//    },
//    body:formdata
//})
//.then(Response=>{
//    if(!Response.ok){
//      alert("Fail");
//      throw new Error("Wrong request" + Response.statusText);
//
//    }else{
//      alert("Send successfully!");
//      return Response.json();
//    }
//})
//.catch(error =>{
//    console.error("Error is:" ,error);
//});
//
//})



