const body = document.querySelector("body");
      toggle = body.querySelector(".toggle");
      sidebar = body.querySelector(".sidebar");

toggle.addEventListener("click", function() {
    sidebar.classList.toggle("close");
});


//-------------------------- clock --------------------------


const hrs = document.getElementById("hrs");
const min = document.getElementById("min");
const sec = document.getElementById("sec");

const dayName = document.getElementById("dayName");
const month = document.getElementById("month");
const dayNum = document.getElementById("dayNum");
const year = document.getElementById("year");
const username = sessionStorage.getItem('username');


setInterval(()=>{
    const currentTime = new Date();
    const daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    
    dayName.innerHTML=daysOfWeek[currentTime.getUTCDay()]; 
    month.innerHTML = currentTime.getMonth()+1;
    dayNum.innerHTML = currentTime.getUTCDate();
    year.innerHTML = currentTime.getFullYear();

    hrs.innerHTML = ('0' + currentTime.getHours()).slice(-2); // Pad with leading zero if necessary
    min.innerHTML = ('0' + currentTime.getMinutes()).slice(-2); // Pad with leading zero if necessary
    sec.innerHTML = ('0' + currentTime.getSeconds()).slice(-2); // Pad with leading zero if necessary
},1000)

// ----- Get stu info from DB-----

// Fetch API

    fetch(`http://localhost:8080/student/getStuInfo?studentID=${username}`,{
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
        document.getElementById('getName').textContent =" Name:" + data.fName+" "+data.lName;
        document.getElementById('getId').textContent =" ID:" + data.userID;
        document.getElementById('getEmail').textContent = "Email:"+ data.email;
        document.getElementById('getMajor').textContent = "Programme:"+ data.programmeCode;
//        document.querySelector('.feedContent').textContent = data.feedback;
    })
    .catch(error =>{
        console.error("Error is:" ,error);
    });




