//-------------------------------------sidepanel--------------------------------

const toggle = document.getElementById('navbar_toggle');
const sidebar = document.getElementById("sidebar");
toggle.addEventListener("click", function() {
    sidebar.classList.toggle("show");
});



// ------ Select Module ------
const selectModule = document.getElementById('selectModule');
const moduleSelects = document.querySelectorAll('.moduleSelect');
selectModule.addEventListener('change',function(){
    moduleSelects.forEach(moduleSelector =>{
        moduleSelector.textContent =  selectModule.value ;
    })

});

// -----------Announcement---------
const post = document.getElementById('post');
const submitBtn = document.getElementById('submitBtn');

submitBtn.addEventListener('click',function(){
    const postValue = post.value;
//    fetch('http://localhost:8080', { // staff input announcement
//            method: 'POST',
//            headers: {
//                'Content-Type': 'application/json'
//            },
//            body: JSON.stringify({
//                module:selectModule,
//                post:postValue })
//        })
//        .then(response => {
//            if (!response.ok) {
//                alert("Send this data unsuccessfully!")
//                throw new Error('Network response was not ok');
//            }
//            alert('Send successfully');
//            return response.json();
//        })
//        .catch(error => {
//            console.error('Error posting data:', error);
//
//        });
});


// --------upload docuemnts------

// reference link: https://developer.mozilla.org/zh-CN/docs/Web/API/Fetch_API/Using_Fetch

const uploadFile = document.getElementById('uploadFile');
uploadFile.addEventListener('change',function(){
    const nameList = document.getElementById('nameList');
    const fileData = new FormData();
    let fileName;
    const file = uploadFile.files[0];
    fileData.append('uploadMaterials',file);
    fileName = file.name;

    // display file name
     const list = document.createElement('li');
     list.textContent = "+" + " "+fileName;
     nameList.appendChild(list);
    
    let moduleCode = selectModule.value;
    // send files to back end
    fetch(`http://localhost:8080/file/uploadMaterials?moduleCode=${moduleCode}`, { // staff upload files
        method: "POST",
        body: fileData
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

//  ------------ upload recap-------------
const uploadVideo = document.getElementById('uploadVideo');
uploadVideo.addEventListener('change',function(){
    const videoList = document.getElementById('videoList');
    const videoData = new FormData();

    for(let i =0;i<uploadVideo.files.length;i++){
        const video = uploadVideo.files[i];
        videoData.append('uploadVideos',video);
        const videoName = video.name;


        // dispaly video name
        const list2 = document.createElement('li');
        list2.textContent = "+" + " "+ videoName;
        videoList.appendChild(list2);

    }
    let moduleCode = selectModule.value;
    // send videos to back end
    fetch(`http://localhost:8080/file/uploadRecaps?moduleCode=${moduleCode}`, { // staff upload videos
        method: "POST",
        body: videoData
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
});



