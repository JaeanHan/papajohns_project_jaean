const footer = document.querySelector("footer");

footer.innerHTML = `
  <footer class="footer">
    <div class="footer__info">
      <div class="footer__info__icons">
        <img src="/static/img/220301_icon_logo.png" alt="" />
        <div class="footer__icons">
          <i class="fa-brands fa-facebook-square"></i>
          <i class="fa-brands fa-twitter-square"></i>
          <i class="fa-solid fa-blog"></i>
          <i class="fa-brands fa-instagram-square"></i>
          <i class="fa-solid fa-p"></i>
        </div>
      </div>
      <div class="footer__info__address">
        <div class="footer__link__container">
          <a href="#">고객센터</a>
          <a href="#">회사소개</a>
          <a href="#">가맹점 모집</a>
          <a href="#">개인정보처리방침</a>
          <a href="#">위치기반 서비스</a>
          <a href="#">이용약관</a>
          <a href="#">채용안내</a>
        </div>
        <div class="footer__name__container">한국파파존스(주)</div>
        <div class="footer__desc__dontainer">
          <p>
            서울시 강남구 압구정로 210 융기빌딩 4층 우)06022 <br />
            Tel:1577-8080Fax:02-515-8448 대표이사: 서창우개인정보관리 <br />
            책임자: 전용관 <br />
            통신판매신고:강남11495호사업자등록번호:211-87-25621 <br />
          </p>
          <p>
            <br />
            콜센터주문 <strong>1577-8080</strong> <br />
            온라인이용문의 <strong>1566-0889</strong> <br />
            고객센터 <strong>1577-8142</strong> <br />
          </p>
        </div>
      </div>
    </div>
    <div class="footer__end">
      COPYRIGHT © 2020 PAPAJOHNS.ALL RIGHTS RESERVED
    </div>
  </footer>
`;