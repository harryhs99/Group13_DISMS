// ---------------------------------- Side Panel Toggle -----------------------------------
const body = document.querySelector("body");
const toggle = body.querySelector(".toggle");
const sidebar = body.querySelector(".sidebar");
const subNav = body.querySelector(".subjectNav");

toggle.addEventListener("click", function() {
    sidebar.classList.toggle("close");
    subNav.classList.toggle("open")
});


// ---------------------------------- Subject Navigation -----------------------------------

document.addEventListener('DOMContentLoaded', function () {
//    document.getElementById('myTextarea').value = '';
});




// ---------------------------------- Subject Navigation -----------------------------------

document.addEventListener("DOMContentLoaded", function() {
    const navLinks = document.querySelectorAll('.nav-link a'); // Select all navigation links
    const sections = document.querySelectorAll('section');

    // Function to close all sections
    function closeAllSections() {
        sections.forEach(section => {
            section.classList.add('close');
        });
    }

    // Open announcement by default
    const announcementSection = document.getElementById('announcement');
    announcementSection.classList.remove('close');


    // Event listeners for navigation links
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            const targetSection = document.querySelector(this.getAttribute('href'));
            closeAllSections(); // Close all sections
            targetSection.classList.remove('close'); // Open the targeted section
        });
    });
});

//  ------ Get coursework's announcement ------
// Get coursework announcement

// Get fileList
const moduleCode = "CSC8014";
//var files = ["Lecture Slide 1.ppt", "Lecture Slide 2.ppt", "Lecture Slide 3.ppt","Lecture Slide 4.ppt"];

// 获取文件列表的HTML元素
var fileList = document.getElementById("fileList");
let files=[];
fetch(`http://localhost:8080/file/getMaterials?moduleCode=${moduleCode}`,{
  method: 'GET',
  headers: {'Content-Type': 'application/json',}
})
    .then(response => response.json())
    .then(data => {
    files = data;
    // 遍历文件列表
    for (var i = 0; i < files.length; i++) {
        //console.log(i);
        // 创建一个新的列表项
        var li = document.createElement("li");

        // 创建文件信息的div
        var div = document.createElement("div");

        // 创建并设置文件图标的img
        var imgFile = document.createElement("img");
        imgFile.src = "IMG/PPTLogo.png";

        // 创建并设置文件名的span
        var span = document.createElement("span");
        span.textContent = files[i];

        // 将文件图标和文件名添加到文件信息的div
        div.appendChild(imgFile);
        div.appendChild(span);

        // 创建并设置下载图标的img
        var imgDownload = document.createElement("img");
        imgDownload.className = "download";
        imgDownload.src = "IMG/download.png";

        // 为下载图标添加点击事件监听器
        imgDownload.addEventListener("click", function() {
                var filename = this.parentNode.querySelector("span").textContent;
//                   console.log(filename);
                // 发送 GET 请求到服务器获取文件
                fetch(`http://localhost:8080/file/downloadMaterials?filename=${filename}&moduleCode=${moduleCode}`,{
                  method: 'GET',
                  headers: {'Content-Type': 'application/json',}
                })
                  .then(response => response.blob())  // 将响应数据转换为 Blob 对象
                  .then(blob => {
                    // 将 Blob 对象保存到前端缓存中
                    // 这里我们使用 sessionStorage 作为示例，您也可以使用其他存储方式
                    let reader = new FileReader();
                    reader.onload = function() {
                      sessionStorage.setItem('file', this.result);
                    }
                    reader.readAsDataURL(blob);

                    // 创建一个指向 Blob 对象的 URL
                    let url = URL.createObjectURL(blob);
                    var a = document.createElement("a");
                    a.href = url;
                    a.download = filename;
                    a.style.display = 'none';
                    document.body.appendChild(a);
                    a.click();
                    document.body.removeChild(a);
                  })
                  .catch(error => console.error(error));
            });

        // 将文件信息的div和下载图标添加到列表项
        li.appendChild(div);
        li.appendChild(imgDownload);

        // 将列表项添加到文件列表
        fileList.appendChild(li);
    }
    //console.log(files.length);
})
    .catch((error) => {
        console.error('Error:', error);
    });
//
var recapList = document.getElementById("recapList");
let recapFiles=[];
fetch(`http://localhost:8080/file/getRecaps?moduleCode=${moduleCode}`,{
  method: 'GET',
  headers: {'Content-Type': 'application/json',}
})
    .then(response => response.json())
    .then(data => {
    recapFiles = data;
    // 遍历文件列表
    for (var i = 0; i < recapFiles.length; i++) {
        //console.log(i);
        // 创建一个新的列表项
        var li = document.createElement("li");

        // 创建文件信息的div
        var div = document.createElement("div");

        // 创建并设置文件图标的img
        var imgFile = document.createElement("img");
        imgFile.src = "IMG/recordIcon.png";

        // 创建并设置文件名的span
        var span = document.createElement("span");
        span.textContent = recapFiles[i];

        // 将文件图标和文件名添加到文件信息的div
        div.appendChild(imgFile);
        div.appendChild(span);

        // 创建并设置下载图标的img
        var imgDownload = document.createElement("img");
        imgDownload.className = "download";
        imgDownload.src = "IMG/download.png";

        // 为下载图标添加点击事件监听器
        imgDownload.addEventListener("click", function() {
                var filename = this.parentNode.querySelector("span").textContent;
                // 发送 GET 请求到服务器获取文件
                fetch(`http://localhost:8080/file/downloadRecaps?filename=${filename}&moduleCode=${moduleCode}`,{
                  method: 'GET',
                  headers: {'Content-Type': 'application/json',}
                })
                  .then(response => response.blob())  // 将响应数据转换为 Blob 对象
                  .then(blob => {
                    // 将 Blob 对象保存到前端缓存中
                    // 这里我们使用 sessionStorage 作为示例，您也可以使用其他存储方式
                    let reader = new FileReader();
                    reader.onload = function() {
                      sessionStorage.setItem('file', this.result);
                    }
                    reader.readAsDataURL(blob);

                    // 创建一个指向 Blob 对象的 URL
                    let url = URL.createObjectURL(blob);
                    var a = document.createElement("a");
                    a.href = url;
                    a.download = filename;
                    a.style.display = 'none';
                    document.body.appendChild(a);
                    a.click();
                    document.body.removeChild(a);
                  })
                  .catch(error => console.error(error));
            });

        // 将文件信息的div和下载图标添加到列表项
        li.appendChild(div);
        li.appendChild(imgDownload);

        // 将列表项添加到文件列表
        recapList.appendChild(li);
    }
})
    .catch((error) => {
        console.error('Error:', error);
    });
//----  Get files from backend -----

//fetch('http://localhost:8080/download?moduleCode=${moduleCode}')
//  .then(response => response.blob())  // 将响应数据转换为 Blob 对象
//  .then(blob => {
//    // 将 Blob 对象保存到前端缓存中
//    // 这里我们使用 sessionStorage 作为示例，您也可以使用其他存储方式
//    let reader = new FileReader();
//    reader.onload = function() {
//      sessionStorage.setItem('file', this.result);
//    }
//    reader.readAsDataURL(blob);
//
//    // 创建一个指向 Blob 对象的 URL
//    let url = URL.createObjectURL(blob);
//    downloadLink.href = url;
//    downloadLink.download = filename;
//  })
//  .catch(error => console.error(error));




