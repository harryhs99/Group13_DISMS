
//-------------------------------------sidepanel--------------------------------

const toggle = document.getElementById('navbar_toggle');
const sidebar = document.getElementById("sidebar");
toggle.addEventListener("click", function() {
    sidebar.classList.toggle("show");
});

// ------------------------main part-----------------------------

const searchDetail = document.getElementById('searchDetail');
const submitBtn = document.getElementById('submitBtn');


// submit form to backend to get student's info
searchDetail.addEventListener('submit',function(e){
    e.preventDefault();

    const searchID = document.getElementById('searchID').value;
    //console.log(`Search ID is ${searchID}`);
    const endpoint = `http://localhost:8080/staff/getStuDetail?SearchID=${searchID}`;
    // get id
    fetch(endpoint,{ // use student id to get data
        method:'GET',
        headers: {
            'Content-Type': 'application/json'
        },
        //body: JSON.stringify({ SearchID:searchID }) // As a keyword
    })
    .then(response=>{
       if(!response.ok){
        alert('Cannot get the data');
        throw new Error('Fail');
       }
       return response.json();
    })
    .then(data=>{// if stuid exist then display the data
            for(let i =0; i<data.length;i++){
                    const row = document.createElement('tr');
                    row.innerHTML =
                    `<td>${data[i].moduleCode}</td>
                     <td>${data[i].assessmentType}</td>
                     <td>${data[i].title}</td>
                     <td>${data[i].assessmentGrade}</td>`;

                     Detailtbody.appendChild(row);
                }
//        if(data.exists){
//        console.log(data);
//            //StuDetaildata(data);
//
//            //StuPersonalInfo(data);
//        }else{
//            console.log(data);
//            alert("the student doesn't exist");
//        }
    })
    .catch(error=>{
        console.log('cannot get any info:', error)
    });
    fetch(`http://localhost:8080/staff/getStuInfo?SearchID=${searchID}`,{  // get student name and email...
        method:'GET',
        headers: {
            'Content-Type': 'application/json'
        },
        //body: JSON.stringify({ SearchID:searchID }) // As a keyword
    })
    .then(response=>{
       if(!response.ok){
        alert('Cannot get the data');
        throw new Error('Fail');
       }
       return response.json();
    })
    .then(data=>{
        document.getElementById('displayName').textContent = data.fName+" "+data.lName;
        document.getElementById('displayEmail').textContent = data.email;
        const row = document.createElement('tr');
        row.innerHTML = `<td>${data.academicHistory}</td>`;
        Infotbody.appendChild(row);
    })
    .catch(error=>{
        console.log('cannot get any info:', error)
    });
});






// below data is for testing, ideally get data in array from backend
const stuAllDetail =[
    {moduleCode:'0001',assessmentType:'Coursewrok',title:'Dyson01_TeamProject',assessmentGrade:70,AcademicHistory:'No related BG' }
];

const Detailtbody = document.getElementById('Detailtbody');
const Infotbody = document.getElementById('Infotbody');
const Detailtable = document.getElementById('Detailtable');
const Infotable = document.getElementById('Infotable');
const row = document.createElement('tr');

// ----delete later-----
//StuDetaildata(stuAllDetail);
//StuPersonalInfo(stuAllDetail);

function StuDetaildata(stuAllDetail){
    for(let i =0; i<stuAllDetail.length;i++){
        const row = document.createElement('tr');
        row.innerHTML = 
        `<td>${stuAllDetail[i].moduleCode}</td>
         <td>${stuAllDetail[i].assessmentType}</td>
         <td>${stuAllDetail[i].title}</td>
         <td>${stuAllDetail[i].assessmentGrade}</td>`;

         Detailtbody.appendChild(row);
    }

}

function StuPersonalInfo(stuAllDetail){
    for(let i =0; i<stuAllDetail.length;i++){
        const row = document.createElement('tr');
        row.innerHTML = 
        // `<td>${stuDetail[i].StuID}</td>
        //  <td>${stuDetail[i].StuName}</td>
        //  <td>${stuDetail[i].StuEmail}</td>
         `<td>${stuAllDetail[i].AcademicHistory}</td>`

         Infotbody.appendChild(row);

    }
}

