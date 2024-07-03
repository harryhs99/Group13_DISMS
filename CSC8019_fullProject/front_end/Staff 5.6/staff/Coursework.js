//--------------------------sidepanel---------------------
const toggle = document.getElementById('navbar_toggle');
const sidebar = document.getElementById("sidebar");
toggle.addEventListener("click", function() {
    sidebar.classList.toggle("show");
});

// display
const seleModuleBox = document.getElementById('seleModuleBox');
const saveName = document.getElementById('saveName');
seleModuleBox.addEventListener('change',function(){
    saveName.textContent = seleModuleBox.value + " " ;
});


// ----- Connect to backend-------
const submitBtn = document.getElementById('submitBtn');
submitBtn.addEventListener('click',function(e){
    e.preventDefault();

    const module = seleModuleBox.value;
    const marks = document.getElementById('marksBox').value;
    const stuID = document.getElementById('IDBox').value;
    const feedback = document.getElementById('feedbackBox').value;
    const testID = "CSC8019CW1testUser1";

    fetch('http://localhost:8080/staff/markCoursework',{ // submit students' feedback,marks,id
        method:"POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            moduleName:module,
            assessmentID: testID,
            grade: marks,
            StuID:stuID,
            Feedback:feedback
        })
    })
        .then(Response=>{
            if(!Response.ok){
                alert("Failed");
                throw new Error("Wrong request" + Response.statusText);

            }else{
                alert("Send successfully!!")
                return Response.text();
            }
        })
        .then(data => {
            //console.log(data);
        })
        .catch(error =>{
            console.error("Error is:" ,error);
        })
})

