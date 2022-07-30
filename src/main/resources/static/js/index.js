// const navBtn = document.querySelector("#btn1");
// const navList = document.querySelector(".header__nav");
//
// navBtn.onclick = () => {
//     navList.style.height =
//         navList.style.height !== "220px" ? "220px" : "0px";
//     navBtn.style.backgroundImage =
//         navList.style.height !== "220px"
//             ? "../img/icon_lbn_menu_on.png"
//             : "../img/icon_lbn_menu.png";
// };

//
// function textDisplay(element) {
//     const textArray = element.innerText.split("");
//     const special = ["피", "자", "사", "주", "세", "요"];
//     const exception = [" ", "\n", ".", ",", ":", ")"];
//     const randomIntBetween = (min, max) => {
//         return Math.floor(Math.random() * (max - min + 1) + min);
//     };
//
//     const numArray = [];
//     textArray.forEach((_) => {
//         const num = randomIntBetween(5, 40);
//         numArray.push(num);
//     });
//     let newText;
//     let completeCount;
//     const timer = setInterval(() => {
//         completeCount = 0;
//         newText = "";
//         numArray.forEach((num, i) => {
//             if (exception.includes(textArray[i]) || numArray[i] === 0) {
//                 newText += textArray[i];
//                 completeCount += 1;
//             } else {
//                 newText += special[numArray[i] % special.length];
//                 numArray[i] = --num;
//             }
//         });
//         element.innerText = newText;
//         if (completeCount === numArray.length) clearInterval(timer);
//     }, 100);
// }
//
// const p = document.getElementById("sexy_string");
// textDisplay(p);
//
//     function textDisplay(element) {
//     const textArray = element.innerText.split("");
//     const special = ["부", "릉", "왱", "앵"];
//     const exception = [" ", "\n", ".", ",", ":", ")"];
//
//     const randomIntBetween = (min, max) => {
//         return Math.floor(Math.random() * (max - min + 1) + min);
//     };
//
//     const numArray = [];
//     textArray.forEach((_) => {
//     const num = randomIntBetween(5, 40);
//     numArray.push(num);
// });
//     let newText;
//     let completeCount;
//     const timer = setInterval(() => {
//     completeCount = 0;
//     newText = "";
//     numArray.forEach((num, i) => {
//     if (exception.includes(textArray[i]) || numArray[i] === 0) {
//     newText += textArray[i];
//     completeCount += 1;
// } else {
//     newText += special[numArray[i] % special.length];
//     numArray[i] = --num;
// }
// });
//     element.innerText = newText;
//     if (completeCount === numArray.length) clearInterval(timer);
// }, 100);
// }
//
// const q = document.getElementById("sexy_string2");
// textDisplay(q);

