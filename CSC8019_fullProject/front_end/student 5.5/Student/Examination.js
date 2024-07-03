// ---------------------------------- Side Panel Toggle -----------------------------------
const body = document.querySelector("body");
const toggle = body.querySelector(".toggle");
const sidebar = body.querySelector(".sidebar");
const examNav = body.querySelector(".examNav");

toggle.addEventListener("click", function() {
    sidebar.classList.toggle("close");
    examNav.classList.toggle("open")
});


// ---------------------------------- Subject Navigation -----------------------------------

// document.addEventListener('DOMContentLoaded', function () {
//     document.getElementById('myTextarea').value = '';
// });




// ---------------------------------- Exam Navigation -----------------------------------

document.addEventListener("DOMContentLoaded", function() {
    const navLinks = document.querySelectorAll('.nav-link a'); // Select all navigation links
    const sections = document.querySelectorAll('section'); 

    // Function to close all sections
    function closeAllSections() {
        sections.forEach(section => {
            section.classList.add('close');
        });
    }
    
    // Open coursework result by default
    const courseworkSection = document.getElementById('coursework');
    courseworkSection.classList.remove('close');
    

    // Event listeners for navigation links
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            const targetSection = document.querySelector(this.getAttribute('href')); 
            closeAllSections(); // Close all sections
            targetSection.classList.remove('close'); // Open the targeted section
        });
    });
});


//-------------------------------------------- Coursework Result ---------------------------------------------

const links = document.querySelectorAll('.link');
links.forEach(function(e){
    e.addEventListener('click',function(event){
        event.preventDefault();
        const new_window = window.open('http://localhost:63342/student%205.5/Student/Feedback.html?_ijt=v2gftqnniqmgfnmv79ai124gnv&_ij_reload=RELOAD_ON_SAVE','_blank','width=700,height=400,top=100,left=100');
    });

});


const Dyson01 = document.getElementById('Dyson01').textContent;
const coursework1 = document.getElementById('Dyson01C');
const dueDate1 = document.getElementById('Dyson01D');
const result1 = document.getElementById('Dyson01R');

fetch('http://localhost:8080', { // according to the coursename and get relevant info...
    method: 'GET',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ coursename:Dyson01 }) // As a keyword
})
.then(response => {
    if (!response.ok) {
        alert('Cannot get the data')
        throw new Error('fail to connect');
    }
    return response.json();
})
.then(data => {
     
    coursework1.textContent = 'Coursework:'+ data.coursework;
    dueDate1.textContent = 'Due date:' + data.textContent;
    result1.textContent = 'Result:' + data.result;
})
.catch(error => {
    console.error('wrong message:', error);
});



//-------------------------------------------- Submission ---------------------------------------------

// click 'Coursename' and return a coursename on front-end
 const list = document.querySelectorAll('.list');
 const coursename = document.getElementById('courseName');
 list.forEach(item =>{
 item.addEventListener('click',function(event){
    if(event.target.tagName === 'A'){
        const textLink = event.target.textContent;
        coursename.textContent ='CourseName:'+ textLink;
    }
});
 });

//  send file to backend
const fileForm = documrnt.getElementById('fileForm');
fileForm.addEventListener('click',function(e){
    e.preventDefault();

    const fileInput = document.getElementById('file_input');
    const fileSend = fileInput.files[0];

    const formData = new FormData();
    formData.append(coursename); // data format : coursename + file
    formData.append('file',fileSend);
    
    fetch('http://localhost:8080', {  // display coursename due-date...
    method: 'POST',
    headers: {
    'Content-Type': 'application/json'
    },
    body:formData
})
.then(res => {
    if (res.ok) {
        document.getElementById('uploadStatus').textContent = 'Upload Successfully';
        return res.json();
    }
    document.getElementById('uploadStatus').textContent = 'Upload Unsuccessfully';
    throw new Error('Network response was not ok.');
})
.then(data => {
    document.getElementById('dueTime').textContent = 'Due Date: ' + data.deadline;
})
.catch(error => {
    console.error('There was a problem with the fetch operation:', error);
});

});
    


// ---- Click coursename and then show up relevant info-

    // get all the <a>, and display each details to html
    const displayLinks = document.querySelectorAll('#mainPart a');
    displayLinks.forEach(function(link){

        link.addEventListener('click',function(e){
            e.preventDefault();
            //Fetch API
            fetch('http://localhost:8080', {  // display coursename due-date...
                method: 'GET',
                headers: {
                'Content-Type': 'application/json'
                }
            })
            .then(res => {
                if (res.ok) {
                return res.json();
                }
                throw new Error('Network response was not ok.');
            })
            .then(data => {
                document.getElementById('dueTime').textContent = 'Due Date: ' + data.deadline;
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
            
        });
    });

// ----- Pass Year Paper ----



//-------------------------------------------- Extension ---------------------------------------------


// enddate cannot earlier than startdate
const extensionForm = document.getElementById('extensionForm');
const cks = document.querySelectorAll('.ck');
const startDate = document.getElementById('startDate');
const endDate = document.getElementById('endDate');

   // end date cannot earlier than start date
   startDate.addEventListener('input',function(){
    const start = startDate.value;
    if(start<endDate.value && endDate.value!=null){
      console.log("correct");
    }
 
   })
   endDate.addEventListener('input',function(){
    const end = endDate.value;
    if( end<startDate.value ){
      alert('endDate cannot earlier than startDate')
    }
   })


   extensionForm.addEventListener('submit',function (e){
   e.preventDefault();
   console.log("catch the Event");

   let checked = false;
   for(let i =0;i<cks.length;i++){
    if(cks[i].checked){
        checked = true;
        break;
    }
   }

    // Send email to lecturers...
    const formData = new FormData(extensionForm);
    fetch ("http://localhost:8080 " ,{ 
    method:"POST",
    headers:{
        "Content-Type":"application/json"
    },
    body:JSON.stringify(formData)
    })
    .then(response=>{
        if(!response.ok){
            alert('Unsuccessfully!!')
            throw new Error("Wrong request" + response.statusText);
        }else{
            alert('Send successfully')
            return response.json(); // Parse the data returned by the server
        }
    })

    .catch(error =>{
        console.error("Error is:" ,error);
    })

});
