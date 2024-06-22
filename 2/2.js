const prev = document.getElementById("prev")
const next = document.getElementById("next")
const progress = document.getElementById("progress")
const circles = document.querySelectorAll(".circle")

let circleactive = 1
next.addEventListener("click", () => {
    circleactive++;
    if(circleactive >= circles.length){
        circleactive = circles.length;
    }

    miseajour()
})

prev.addEventListener("click", () => {
    circleactive--;
    if(circleactive < 1){
        circleactive = 1;
    }

    miseajour()
})

function miseajour(){
    circles.forEach((circle, idx) => {
        if(idx < circleactive)
        {
            circle.classList.add("active")
        }else{
            circle.classList.remove("active")
        }
    })
    progress.style.width = (circleactive-1)/(circles.length - 1)*100 + "%";

    if(circleactive === 1){
        prev.disabled = true;
    }
    else if(circleactive === circles.length){
        next.disabled = true;
    }else{
        next.disabled = false;
        prev.disabled = false;
    }
}