// -------------------------------------TopNav----------------------------------


//-------------------------------------sidepanel--------------------------------

const toggle = document.getElementById('navbar_toggle');
const sidebar = document.getElementById("sidebar");
toggle.addEventListener("click", function() {
    sidebar.classList.toggle("show");
});

// ------------------------main part-----------------------------

// submit form to backend to get student's info
const searchDetail = document.getElementById('searchDetail');
const submitBtn = document.getElementById('submitBtn');

searchDetail.addEventListener('submit',function(e){
    e.preventDefault();

    const searchID = document.getElementById('searchID').value;
    let gradeData;
    // get id
    fetch(`http://localhost:8080/staff/getStuModule?searchID=${searchID}`,{ // use student id to get data
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
    gradeData = data;
    // if stuid exist then display the data
    //console.log(data)
            for(let i =0; i<UndertakenDetail.length;i++){
                    const row = document.createElement('tr');
                    row.innerHTML =
                    `<td>${data[i].studentID}</td>
                     <td>${data[i].moduleCode}</td>
                     <td>${data[i].Grade}</td>`

                     Undertakentbody.appendChild(row);
                }
    })
    .catch(error=>{
        console.log('cannot get any info:', error)
    });
});



// below data is for testing, ideally get data in array from backend
const UndertakenDetail =[
    {StuID:'0001',StuName:'Vanya',ModuleCode:'Dyson01',ModuleName:'Advanced Programming'}
]

const Undertakentbody = document.getElementById('Undertakentbody');
const Undertakentable = document.getElementById('Undertakentable');
const row = document.createElement('tr');

// ----delete later-----
//StuDetaildata(UndertakenDetail);


function StuDetaildata(UndertakenDetail){
    for(let i =0; i<UndertakenDetail.length;i++){
        const row = document.createElement('tr');
        row.innerHTML = 
        `<td>${UndertakenDetail[i].StuID}</td>
         <td>${UndertakenDetail[i].StuName}</td>
         <td>${UndertakenDetail[i].ModuleCode}</td>
         <td>${UndertakenDetail[i].ModuleName}</td>`

         Undertakentbody.appendChild(row);
    }

}

    

