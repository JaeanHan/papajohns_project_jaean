const header = document.querySelector("header");

header.innerHTML = `
  <header class="header">
    <div class="menu_wrap">
      <ul class="menu_wrap__list">
        <li><a href="">메뉴</a></li>
        <li><a href="">이벤트/할인</a></li>
        <li><a href="">E-쿠폰주문</a></li>
      </ul>
    </div>
    <a href="/" class="logo">
      <img src="/static/img/220301_icon_logo.png" alt="logo" />
    </a>
    <div class="client_wrap">
      <ul class="client_wrap__list">
        <li><a href="/join" class="client_wrap__list__signup">회원가입</a></li>
        <li><a href="" class="client_wrap__list__signin">로그인</a></li>
        <li>
          <a href="">
            <img src="/static/img/icon_cart.png" alt="" />
          </a>
        </li>
        <li>
          <div id="btn1">
            <img src="/static/img/icon_lnb_menu.png" alt="" />
          </div>
        </li>
      </ul>
    </div>
    <div class="header__nav">
      <ul class="header__nav__list">
        <li>
          <a href="">주문</a>
          <a href="">메뉴</a>
          <a href="">E-쿠폰주문</a>
          <a href="">매장찾기</a>
        </li>
        <li>
          <a href="">이벤트/할인</a>
          <a href="">진행중 이벤트</a>
          <a href="">지난 이벤트</a>
          <a href="">제휴 할인</a>
          <a href="">쿠폰발급</a>
        </li>
        <li>
          <a href="">고객센터</a>
          <a href="">공지사항</a>
          <a href="">Q&A</a>
          <a href="">직접문의</a>
        </li>
        <li>
          <a href="">회사소개</a>
          <a href="">가맹점 모집</a>
        </li>
      </ul>
    </div>
  </header>
`;

const navBtn = document.querySelector("#btn1");
const navList = document.querySelector(".header__nav");
const navBtnImg = document.querySelector("#btn1 img");

navBtn.onclick = () => {
  navList.style.height = navList.style.height !== "220px" ? "220px" : "0px";
  navBtnImg.src =
    navList.style.height !== "0px"
      ? "/static/img/icon_lnb_menu_on.png"
      : "/static/img/icon_lnb_menu.png";
};
