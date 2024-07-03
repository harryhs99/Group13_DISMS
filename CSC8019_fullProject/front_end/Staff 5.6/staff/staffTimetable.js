//-------------------------------------sidepanel--------------------------------

const toggle = document.getElementById('navbar_toggle');
const sidebar = document.getElementById("sidebar");
toggle.addEventListener("click", function() {
    sidebar.classList.toggle("show");
});


// ----------- timetable part---------

const tds = document.querySelectorAll('.content .td');
const popBox = document.getElementById('popBox');
const selectRoom = document.getElementById('selectRoom');
const selectModule = document.getElementById('selectModule');
const selectLecturer = document.getElementById('selectLecturer');

const subBtn = document.getElementById('subBtn');
const deleteBtn = document.getElementById('deleteBtn');
const cancelBtn = document.getElementById('cancelBtn');
const SearchModuleID = document.getElementById('ID');
//const cells = document.getElementsByClassName('ts');

// submit timetable button
const submit = document.getElementById('submit');
const content = document.querySelector('.content');
const show = document.getElementById('show');
const selectDate = document.getElementById('selectDate');

//get current date, calculate the date of Monday this week
//set the date for the head of the table
var curSelectDate = new Date();
setDate(getMonday(curSelectDate));
//

let check;
function handle(e){
    check = e.target
    //console.log(check.id);
    if (check.classList.contains('td')) {

        popBox.style.display = 'block';
        popBox.style.left = e.clientX +'px';
        popBox.style.top = e.clientY +'px';


        subBtn.addEventListener('click', subBtnClick);
        deleteBtn.addEventListener('click',deleteBtnClick);
        cancelBtn.addEventListener('click',cancelBtnCLick);

    }
}
content.addEventListener('click', handle);

function subBtnClick(){
    //  display data on the table
    check.textContent =
    `${selectModule.value}\n${selectRoom.value}\n${selectLecturer.value}`;
    //console.log(check.textContent.split("\n"));
    // hidden popBox
    popBox.style.display = 'none';
    subBtn.removeEventListener('click', subBtnClick);
}
function deleteBtnClick(){
    check.textContent = ' ';
    popBox.style.display = 'none';
    deleteBtn.removeEventListener('click',deleteBtnClick);
    subBtn.removeEventListener('click', subBtnClick);
}
function cancelBtnCLick(){
    popBox.style.display = 'none';
    cancelBtn.removeEventListener('click',cancelBtnCLick);
    deleteBtn.removeEventListener('click',deleteBtnClick);
    subBtn.removeEventListener('click', subBtnClick);
}
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

//let selectYear = 2024;
//let selectMonth = 4;
//let selectDay = 1;
//var TestDate = new Date(selectYear, selectMonth, selectDay);
//var mondayDate = getMonday(TestDate);
//console.log(mondayDate.getMonth());
//setDate(mondayDate);

//get timetable from back end

//let year = mondayDate.getYear();
//let month = mondayDate.getMonth()+1;
//let day = mondayDate.getDate();



//document.getElementById('selectDate').addEventListener('change', function() {
//  var selectedDateTest = this.value;
//  console.log(selectedDateTest);
//});

// show timetable
show.addEventListener('click',function(e){
    e.preventDefault();
    clearTable();
    curSelectDate = new Date(selectDate.value);
    let mondayDate = getMonday(curSelectDate);
    let year = mondayDate.getFullYear();
    let month = mondayDate.getMonth()+1;
    let day = mondayDate.getDate();
    //set the date for the head of the table
    setDate(mondayDate);
    const endpoint = "http://localhost:8080/timetable/getTimetableTest";
    let moduleCode = SearchModuleID.value;
    fetch(endpoint + `?moduleCode=${moduleCode}&year=${year}&month=${month}&day=${day}`, {
  method: 'GET',
  headers: {'Content-Type': 'application/json',}
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
    //console.log(DateTest.toString());
})



// ------ sumbit to database ------

submit.addEventListener('click',function(e){
    e.preventDefault();

let moduleCode = SearchModuleID.value;
curSelectDate = new Date(selectDate.value);
let mondayDate = getMonday(curSelectDate);
var eventList = [];
alert("test");
let i = 0;
tds.forEach(td => {
        if (td.innerText.trim() !== '') {
        eventList[i] = {
                    slotID: td.ID,
                    content: td.innerText
                };
                                        i++;
            }
        });
fetch('http://localhost:8080/timetable/timetableTest', {
                                method: 'POST',
                                headers: {
                                    "Content-Type": "application/json"
                                },
                                body: JSON.stringify({
                                                  eventList:eventList,
                                                  moduleCode:moduleCode,
                                                  mondayDate:mondayDate
                                              })
                            })
                                .then(response=>{
                                            if(!response.ok){
                                                throw new Error('No response');
                                            }
                                            return response.json();
                                        })
                                        .then((data) => {
                                            console.log("Success:", data);
                                        })
                                        .catch((error) => {
                                            console.error("Error:", error);
                                        });
})
     

    




