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
    document.getElementById('myTextarea').value = '';
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

