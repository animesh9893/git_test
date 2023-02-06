1.
The answer is like SSR. We have chance do it but major problem we get is like Reading or debug thing. Because every thing is in same file. 

*** But plus point is the time. It take less time than normal one. The wating queue of browser and Server is less. The transfer time got reduce. And Engine get all thing in one file so plus point.


2. We can not use block property in inline element. If we want to do so we need to make it inline-block. So we can access it.


4. What is the difference between visibility hidden, display none and opacity 0?

In hidden the element will not acessable form viewport but it present in tree.
In Display none the element got deleted from the render tree.
In opacity the element is accessable from viewport.

5. What is the difference between overflow scroll and auto? What is its impact on Mac and Windows?

For that we use prefix vendor because the scroll is dependent of OS and its theme. So by prefix vendors we can reduce the 
state of problem

6. Normalize vs reset

Reset CSS: The purpose of a reset CSS is to remove all the default styling applied by different browsers. It sets a common baseline for all elements, making it easier to create a consistent look across different browsers. Reset CSS files typically include styles such as setting margin and padding to 0, font-size to a default value, and so on.

Normalize CSS: The purpose of normalize CSS is to make default styles consistent across different browsers, while preserving useful defaults. Unlike reset CSS, normalize CSS does not set all elements to the same default values. Instead, it makes sure that all elements have a consistent and reasonable default style, while preserving useful defaults like link underlines or heading sizes.




Q -> Load CSS async.

Yes we will load CSS async but not like Js we have option through JavaScript. By adding child of head element.
This is also imporve the performance. because the queue waiting will be less and we load thing when needed.

The delay load code look like-

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

We will apply different condition for that also like. On Scroll load the CSS or on any event.

wqeqwe