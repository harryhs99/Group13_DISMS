//-------------------------------------sidepanel--------------------------------

const toggle = document.getElementById('navbar_toggle');
const sidebar = document.getElementById("sidebar");
toggle.addEventListener("click", function() {
    sidebar.classList.toggle("show");
});


// ----------- timetable part---------

const tds = document.querySelectorAll('.content .td');
// const popBox = document.getElementById('popBox');
// const selectRoom = document.getElementById('selectRoom');
// const selectModule = document.getElementById('selectModule');
// const selectLecturer = document.getElementById('selectLecturer');

// const subBtn = document.getElementById('subBtn');
// const deleteBtn = document.getElementById('deleteBtn');
// const cancelBtn = document.getElementById('cancelBtn');
// // submit timetable button
// const submit = document.getElementById('submit');
// const content = document.querySelector('.content');
const show = document.getElementById('show');

//get current date, calculate the date of Monday this week
//set the date for the head of the table
var curSelectDate = new Date();
setDate(getMonday(curSelectDate));
//

function getMonday(d) {
  d = new Date(d);
  var day = d.getDay(),
      diff = d.getDate() - day + (day == 0 ? -6:1); // adjust when day is Sunday
  return new Date(d.setDate(diff));
}
//
function setDate(d){
d = new Date(d);
let month = d.getMonth() + 1;
let day = d.getDate();
//console.log(d.toDateString());
for (let i = 1; i <= 5; i++) {
    // 获取id为"day"+i的元素
    let dayCell = document.getElementById("day" + i);

    // 给这个元素赋值
    dayCell.innerText = `${month}.${day}`;
    //please notice month in javascript start from 0
    //therefore May is 4
    d.setDate(d.getDate()+1);
    day = d.getDate();
    month = d.getMonth() + 1;
    }
}
function clearTable(){
    tds.forEach(function(td) {
     td.innerText = "";
    });
    }
////please notice month in javascript start from 0
////therefore May is 4
//let selectYear = 2024;
//let selectMonth = 4;
//let selectDay = 1;
//var selectDate = new Date(selectYear, selectMonth, selectDay);
//var mondayDate = getMonday(selectDate);
////console.log(mondayDate.getMonth());
//setDate(mondayDate);






// ------ sumbit to database ------

// submit.addEventListener('click',function(e){
// let timetableString ="";
// alert("test");
//     e.preventDefault();
//     tds.forEach(td=>{
//         td.addEventListener('click',function(){
//             const slotID = this.getAttribute('id');
//             timetableString = timetableString + slotID+",";
//             const inputData = this.textContent;
//             timetableString = timetableString + inputData+",";
//             const getID = document.getElementById('ID').value;
//             timetableString = timetableString +getID +"#"
//     const selectWeek = document.getElementById('selectWeek').value;
//     const selectMonth = document.getElementById('selectMonth').value;
//     const timetableStringTest = timetableString;

//     fetch('http://localhost:8080/timetable/timetableTest',{  // send timetable from backend
//         method:'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify({ 
//             ID:getID,
//             Week: selectWeek,
//             Month:selectMonth,
//             slotID:slotID,   
//             timeTableData:inputData,
//             timetableString:timetableStringTest
//  }) 
//     })
//     .then(response=>{
//        if(!response.ok){
//         alert('Failed');
//         throw new Error('Fail');
//        }
//        alert('Send successfully');
//        return response.json();

//     })
//     .catch(error=>{
//         console.log('cannot get any info:', error)
//     })
    
// })
//         })
//     })
     
// ----- click btn to show timetable

show.addEventListener("click",function(e){
    e.preventDefault();
    const selectDate = document.getElementById("selectDate").value;
    console.log(selectDate);
    clearTable();
    curSelectDate = new Date(selectDate);
    let mondayDate = getMonday(curSelectDate);
        //set the date for the head of the table
    setDate(mondayDate);
    //get timetable from back end
    const moduleCode = "CSC8019";
    let year = mondayDate.getYear();
    let month = mondayDate.getMonth()+1;
    let day = mondayDate.getDate();
    const endpoint = "http://localhost:8080/timetable/getTimetableTest";
    fetch( endpoint + `?moduleCode=${moduleCode}&year=${year}&month=${month}&day=${day}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      }
    })
    .then(response => response.json())
    .then(data => {
        data.forEach(function(element){
        curSlot = document.getElementById(element.slotID);
        curSlot.innerText = element.content;
        })
        //console.log(data[0].slotID);
        //console.log(data[0].content);
        //console.log(curSlot)
    })
    .catch((error) => {
      console.error('Error:', error);
    });

})




