const body = document.querySelector("body");
      toggle = body.querySelector(".toggle");
      sidebar = body.querySelector(".sidebar");

toggle.addEventListener("click", function() {
    sidebar.classList.toggle("close");
});