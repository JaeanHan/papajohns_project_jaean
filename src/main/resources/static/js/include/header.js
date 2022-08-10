const header = document.querySelector("header");

const form1 = `
    <div>
      <label for="login-username">아이디</label>
      <input id="login-username" name="username" type="text" />
    </div>
    <div>
      <label for="login-password">비밀번호</label>
      <input id="login-password" name="password" type="password" />
    </div>
    <div class="login-button-container">
      <input id="login-save" type="checkbox" name="saveId" checked />
      <label for="login-save">아이디 저장</label>
      <input id="login-remember" type="checkbox" name="rememberMe" checked />
      <label for="login-remember">자동 로그인</label>
    </div>
    <button id="login-button">로그인</button>
`;

const form2 = `
    <div>
      <label for="non-member-name">이름</label>
      <input id="non-member-name" type="text" />
    </div>
    <div>
      <label for="non-member-phone">연락처</label>
      <input id="non-member-phone" type="text" />
    </div>
    <div id="non-member-phone-check">
    <label for="non-member-send-code"></label>
    <input id="non-member-send-code" type="button" value="인증번호 발송"/>
    </div>
    <div id="non-member-type-code">
      <label for="non-member-check-code">인증번호</label>
      <input id="non-member-check-code" type="text" />
    </div>
`;

const afterForm1 = `
  <div class="auth-login-container">
    <h2>간편 로그인</h2>
    <ul>
      <li></li>
      <li><a href="/oauth2/authorization/naver">네이버</a></li>
      <li></li>
      <li></li>
    </ul>
    <div class="login-help">
      <span>아이디/비번 찾기</span><span>회원가입</span>
    </div>
    <p id="ment">*회원 주문 시 할인 혜택을 받을 수 있습니다.</p>
  </div>
`;

const afterForm2 = `
<div id="non-member-agreement">
  <div>
    <input type="checkbox" id="agreement-info" />
    <label for="agreement-info">개인정보 수집/이용 동의(필수)</label>
  </div>
  <p>*비회원 주문 시 할인 혜택을 받을 수 없습니다.</p>
</div>
`;

let form = form1;
let afterForm = afterForm1;

const loginPopup = `
  <div class="quick-login-popup">
    <div class="login-form">
      <div class="popup-close-button">
        <img src="/static/img/icon_pop_close.png" alt="" />
      </div>
      <h1>로그인</h1>
      <p>주문하려면 로그인이 필요합니다.</p>
      <div class="select-order">
        <div class="button-container">
          <div class="member order-selected">회원 주문</div>
          <div class="non-member">비회원 주문</div>
        </div>
        <form id="quick-login-form" action="/api/v1/user/login" method="post">
        ${form}
        </form>
        ${afterForm}
      </div>
    </div>
  </div>
`;

let headerLoginState = false;

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
        <li><button class="client_wrap__list__signin">로그인</button></li>
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
    ${loginPopup}
    </header>
`;

onload();

const navBtn = document.querySelector("#btn1");
const navList = document.querySelector(".header__nav");
const navBtnImg = document.querySelector("#btn1 img");

const quickLogin = document.querySelector(".quick-login-popup");
const quickLoginCloseButton = document.querySelector(".popup-close-button");
const quickLoginOpenButton = document.querySelector(
  ".client_wrap__list__signin"
);

const orderTypeMember = document.querySelector(".member");
const orderTypeNonMember = document.querySelector(".non-member");

const loginForm = document.querySelector("#quick-login-form");
const loginAfterForm = document.querySelector(".select-order");

const ment = document.querySelector("#ment");

const loginButton = document.querySelector("#login-button");

orderTypeMember.onclick = () => {
  orderTypeNonMember.classList.remove("order-selected");
  orderTypeMember.classList.add("order-selected");
  loginForm.innerHTML = "";
  loginForm.innerHTML = form1;
  ment.innerText = "*회원 주문 시 할인 혜택을 받을 수 있습니다.";
};

orderTypeNonMember.onclick = () => {
  orderTypeMember.classList.remove("order-selected");
  orderTypeNonMember.classList.add("order-selected");
  loginForm.innerHTML = "";
  loginForm.innerHTML = form2;
  ment.innerText = "*비회원 주문 시 할인 혜택을 받을 수 없습니다.";
};

navBtn.onclick = () => {
  navList.style.height = navList.style.height !== "220px" ? "220px" : "0px";
  navBtnImg.src =
    navList.style.height !== "0px"
      ? "/static/img/icon_lnb_menu_on.png"
      : "/static/img/icon_lnb_menu.png";
};

quickLoginOpenButton.onclick = () => {
  quickLogin.style.display = "flex";
};

quickLoginCloseButton.onclick = () => {
  quickLogin.style.display = "none";
  orderTypeMember.classList.remove("order-selected");
  orderTypeNonMember.classList.remove("order-selected");
  orderTypeMember.classList.add("order-selected");
};

function onload() {
  const headmasters = document.querySelectorAll(".client_wrap__list li");
  const authenticated1 = `<a href="/page" class="client_wrap__list__signup">마이페이지</a>`;
  const authenticated2 = `<button class="client_wrap__list__signout">로그아웃</button>`;
  $.ajax({
    method: "get",
    url: "api/v1/user/check",
    dataType: "text",
    success: response => {
      if(response !== "null") {
        console.log(response);
        console.log(typeof response);
        headerLoginState = true;
        headmasters[0].innerHTML = authenticated1;
        headmasters[1].innerHTML = authenticated2;

        const signOutButton = document.querySelector(".client_wrap__list__signout");
        signOutButton.onclick = () => {
          $.ajax({
            method: "post",
            url: "api/v1/user/logout",
            success: location.href="/",
            error: (request, status, response) => {
              console.log(request);
              console.log(request.status);
              console.log(response);
            }
          })
        }
      }
    },
    error: (request, status, response) => {
      console.log(request);
      console.log(request.status);
      console.log(response);
    }
  })
}
