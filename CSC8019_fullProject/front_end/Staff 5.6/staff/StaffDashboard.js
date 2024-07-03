
//-------------------------------------sidepanel--------------------------------

const toggle = document.getElementById('navbar_toggle');
const sidebar = document.getElementById("sidebar");
toggle.addEventListener("click", function() {
    sidebar.classList.toggle("show");
});
let username = sessionStorage.getItem('username');
// ------------------  display staff Name and ID  ----------------------

fetch(`http://localhost:8080/staff/getStaffInfo?username=${username}`,{   // get staff name and id
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
    document.getElementById('name').textContent = data.fName+" "+data.lName;
    document.getElementById('ID').textContent = data.userID;
    
})
.catch(error =>{
    console.error("Error is:" ,error);
});

//----------meeting---------
const popBox = document.getElementById('popBox');
const meetingBtn = document.getElementById('meetingBtn');
const cancelBtn = document.getElementById('cancelBtn');
const meetingForm = document.getElementById('meetingForm');
meetingBtn.addEventListener('click',function(){
    popBox.style.display = 'block';
})
cancelBtn.addEventListener('click',function(){
    popBox.style.display = 'none';
})

const submitBtn = document.getElementById('submitBtn');
meetingForm.addEventListener('submit',function(){
    popBox.style.display = 'none'
    const stuEmail = document.getElementById('stuEmail').value;
    const date = document.getElementById('datetime').value;

    // Send email to students...
//    fetch ("http://localhost:8080" ,{
//    method:"POST",
//    headers:{
//        "Content-Type":"application/json"
//    },
//    body:JSON.stringify({
//        StuEmail: stuEmail,
//        Date: date
//    })
//})
//    .then(response=>{
//        if(!response.ok){
//            alert('Unsuccessfully!!')
//            throw new Error("Wrong request" + response.statusText);
//        }else{
//            alert('Send successfully')
//            return response.json(); // Parse the data returned by the server
//        }
//    })
//
//    .catch(error =>{
//        console.error("Error is:" ,error);
//    })

});


// ------------------------Assigned Stu Part-----------------------------

    fetch(`http://localhost:8080/staff/getAssignedStuInfo?username=${username}`,{
        method:'GET',
        headers:{
            "Content-Type":"application/json"
        },
    })
        .then(Response=>{
            if(!Response.ok){
                alert("Cannot get the data");
                throw new Error("Network response is not working")
            }
            return Response.json();
        })
        .then(data=>{
            for(let i =0; i<data.length;i++){
                    const row = document.createElement('tr');
                    row.innerHTML =
                    `<td>${data[i].userID}</td>
                     <td>${data[i].fName+" "+data[i].lName}</td>
                     <td>${data[i].email}</td>
                     <td>${data[i].programmeCode}</td>`

                     assignedTbody.appendChild(row);
                     assignedTable.appendChild(assignedTbody);
                }

        })
        .catch(error =>{
            alert("Error fetching data:",error);
        })


// below data is for testing, ideally get data in array from backend
const assignedStuDetail =[
    {StuID:'0001',StuName:'Vanya',StuEmail:'Vanya@gmail.com',Major:'computer science'},
    {StuID:'0002',StuName:'Ben',StuEmail:'Ben@gmail.com',Major:'computer science'},
    {StuID:'0003',StuName:'Dan',StuEmail:'Dan@gmail.com',Major:'computer science'},
    {StuID:'0004',StuName:'John',StuEmail:'John@gmail.com',Major:'computer science'},
    {StuID:'0005',StuName:'Him',StuEmail:'Him@gmail.com',Major:'computer science'},
    {StuID:'0006',StuName:'Leo',StuEmail:'Leo@gmail.com',Major:'computer science'},
    {StuID:'0007',StuName:'Wendy',StuEmail:'Wendy@gmail.com',Major:'computer science'},
    {StuID:'0008',StuName:'James',StuEmail:'James@gmail.com',Major:'computer science'},
    {StuID:'0009',StuName:'Lucas',StuEmail:'Lucas@gmail.com',Major:'computer science'},
    {StuID:'00010',StuName:'Leo',StuEmail:'Leo@gmail.com',Major:'computer science'},
    {StuID:'00011',StuName:'Yvette',StuEmail:'Yvette@gmail.com',Major:'computer science'},
    {StuID:'00012',StuName:'Lisa',StuEmail:'Lisa@gmail.com',Major:'computer science'},
    {StuID:'00013',StuName:'Jennie',StuEmail:'Jennie@gmail.com',Major:'computer science'},
    {StuID:'00014',StuName:'Rose',StuEmail:'Rose@gmail.com',Major:'computer science'},
    {StuID:'00015',StuName:'Jisoo',StuEmail:'Jisoo@gmail.com',Major:'computer science'}

]

const assignedTbody = document.getElementById('assignedTbody');
const assignedTable = document.getElementById('assignedTable');
// const row = document.createElement('tr');
// delete later
//StuDetaildata(assignedStuDetail);


function StuDetaildata(assignedStuDetail){
    for(let i =0; i<assignedStuDetail.length;i++){
        const row = document.createElement('tr');
        row.innerHTML = 
        `<td>${assignedStuDetail[i].StuID}</td>
         <td>${assignedStuDetail[i].StuName}</td>
         <td>${assignedStuDetail[i].StuEmail}</td>
         <td>${assignedStuDetail[i].Major}</td>`

         assignedTbody.appendChild(row);
         assignedTable.appendChild(assignedTbody);
    }

}

// --------------clock-----------------
const clock = document.getElementById('clock');
const date = document.getElementById('date');
const day = document.getElementById('day');
function addzero(num){
    if(num>=10){
        return num;
    }else{
        return `0${num}`;
    }
}
function updateTime(){
    const now = new Date();
    const time = addzero(now.getHours()) + ":" + addzero(now.getMinutes())+":"+addzero(now.getSeconds());
    clock.innerText =time;
}
function setDate(){
    const today = new Date();
    const todayDate = today.getFullYear() + "/" + (today.getMonth()+1) + "/" + today.getDate();
    date.innerText = todayDate;
}
function setDay(){
    const setDay = new Date();
    const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    const currentDayIndex = setDay.getDay();
    const currentDay = days[currentDayIndex];
    day.innerText = currentDay;
}
updateTime();
setDate();
setDay();
setInterval(updateTime,1000);



