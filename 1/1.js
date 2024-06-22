const images = document.querySelectorAll(".image");

images.forEach(elements =>{
    elements.addEventListener("click", () => {
        removeactive();
        elements.classList.add("active");
    })
})

function removeactive(){
    images.forEach(elements =>{
            elements.classList.remove("active");
        })
}