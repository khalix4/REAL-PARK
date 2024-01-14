const prevtns = document.querySelectorAll(".btn-prev")
const nextBtns = document.querySelectorAll(".btn-next")
const progress = document.getElementById("progress")
const formSteps = document.querySelectorAll(".form-step")
const progressSteps = document.querySelectorAll(".progress-step")

let formStepsNum =0;
nextBtns.forEach(btn =>{
    btn.addEventListener('click', ()=>{
        formStepsNum++;
        updateFormSteps();
        updateProgressBar();
    })
})

prevtns.forEach(btn =>{
    btn.addEventListener('click', ()=>{
        formStepsNum--;
        updateFormSteps();
        updateProgressBar();
    })
})

function updateFormSteps(){

    formSteps.forEach((formsteps) =>{
        formsteps.classList.contains("form-step-active")
        formsteps.classList.remove("form-step-active");
    });

    formSteps[formStepsNum].classList.add("form-step-active")
}

function updateProgressBar(){
    progressSteps.forEach((progressStep, idx) =>{
        if(idx < formStepsNum + 1){
            progressStep.classList.add('progress-step-active')
    }else{
            progressStep.classList.remove('progress-step-active')
    }
    });

    const progressActive = document.querySelectorAll(".progress-step-active");


    progress.style.width = ((progressActive.length-1)/ (progressSteps.length-1)) * 100 + "%";
}





var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

let sub = document.getElementById('submit');

function showDown(){
    document.getElementById('id01').style.display='block';
}

sub.addEventListener("click", showDown);


$("button").click(function () {
    $(".check-icon").hide();
    setTimeout(function () {
        $(".check-icon").show();
    }, 10);
});
