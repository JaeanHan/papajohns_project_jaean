const sideBar = document.querySelector(".side_remote");

sideBar.innerHTML = `
    <div class="side_remote_here"><img src="/static/img/icon_quick_2_off.png" alt="" />멤버십</div>
    <div><img src="/static/img/icon_quick_4_off.png" alt="" />주문 내역</div>
    <div><img src="/static/img/icon_quick_5_off.png" alt="" />쿠폰함</div>
`;


// const sideBatController = document.querySelector(".side_remote_here::before");
//
// sideBatController.onclick = () => {
//     sideBar.style.width =
//         sideBar.style.width !== "0px" ? "0px" : "100px";
// };