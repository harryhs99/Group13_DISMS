
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
 const tab_nav = document.querySelector('.tab-nav')
 const pane = document.querySelectorAll('.pane')

 tab_nav.addEventListener('click', function (e) {
   if (e.target.tagName === 'A') {
     // remove "active" 
     tab_nav.querySelector('.active').classList.remove('active')
     // add "active" to that element that click
     e.target.classList.add('active')

     // remove all the displayed element
     for (let i = 0; i < pane.length; i++) {
     // remove all the displayed element
       pane[i].style.display = 'none'
     }
     // and then add the one which really click
     pane[e.target.dataset.id].style.display = 'block'
   }
 })




// click button and submit forms


// ------send data function------
function sendData(data){
  const data1 =  new FormData(data);
   fetch('url',{
     method:'POST',
     body: JSON.stringify(data1),
     hearders:{'Content-Type': 'application/x-www-form-urlencoded'}
   })
   .then(Response=>{
     if(Response.ok){
       alert("submit successfully")
       return Response.json()}
     else{
       alert("submit unsuccessfully,please try again")
       throw new Error('Error response:' + Response.status);
     }
  
   })
  }

//---------- attendece part-----------

  const attendance = document.getElementById('attendance');
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
    

    //  submit form to back end
    attendance.addEventListener('submit',function(e){
    e.preventDefault();
    sendData(attendance);
  })



//-----------meeting part--------------

const meeting = document.getElementById('meeting');
meeting.addEventListener('submit',function(e){
  e.preventDefault();
  sendData(meeting);

})



