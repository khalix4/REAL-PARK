const observer=new IntersectionObserver((entries)=>{
    entries.forEach((entry)=>{
        if(entry.isIntersecting){
            entry.target.classList.add("showPage");
        }else{
            entry.target.classList.remove("showPage");
        }
    })
});

const observer2=new IntersectionObserver((entries)=>{
    entries.forEach((entry)=>{
        console.log(entry);
        if(entry.isIntersecting){
            entry.target.classList.add("showPage2");
        }
        else{
            entry.target.classList.remove("showPage2")
        }
    })
})

const elements=document.querySelectorAll(".hiddenPage");
elements.forEach((el)=>observer.observe(el));

// const elements2=document.querySelectorAll(".hiddenPage2");
// elements2.forEach((el2)=>observer2.observe(el2));
