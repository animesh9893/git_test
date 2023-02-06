console.log("JS Load")

const delay = ms => new Promise(res => setTimeout(res, ms));


const yourFunction = async () => {
    await delay(5000);
    console.log("Waited 5s");
  
    var link = document.createElement("link");
    link.href = "style1.css";
    link.type = "text/css";
    link.rel = "stylesheet";
    document.head.appendChild(link);
};

// yourFunction();