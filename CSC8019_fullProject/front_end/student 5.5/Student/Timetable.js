// ---------------------------------- Side Panel Toggle -----------------------------------

const body = document.querySelector("body");
const toggle = body.querySelector(".toggle");
const sidebar = body.querySelector(".sidebar");
const examNav = body.querySelector(".examNav");

toggle.addEventListener("click", function() {
    sidebar.classList.toggle("close");
    examNav.classList.toggle("open")
});


