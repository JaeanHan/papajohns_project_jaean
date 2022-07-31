// 보통 입력창
const userInputs = document.querySelectorAll(".for-req1 input");
// userInputs.forEach((input) => console.log(input.value));

const nameInput = userInputs[0];
const usernameInput = userInputs[1];
const passwordInput = userInputs[2];
const passwordCheckInput = userInputs[3];
const emailInput = userInputs[4];

// 집전화
const houseCall1 = document.querySelector(".contact-home-input select");
// console.log(houseCall1.value);

const contactHome1 = houseCall1;

const houseCall23 = document.querySelectorAll(".contact-home-input input");
// houseCall23.forEach((input) => console.log(input.value));

const contactHome2 = houseCall23[0];
const contactHome3 = houseCall23[1];

// 휴대폰
const phone1 = document.querySelector(".contact-phone-input select");
// console.log(phone1.value);

const contactPhone1 = phone1;

const phone23 = document.querySelectorAll(".contact-phone-input input");
// phone23.forEach((input) => console.log(input.value));

const contactPhone2 = phone23[0];
const contactPhone3 = phone23[1];

// 생일
const birthdayType = Array.from(document.getElementsByName("birthday")).find(
  (radio) => radio.checked
);
// console.log(birthdayType.value);

const birthdayDate = document.getElementsByName("birth-select");
// Array.from(birthdayDate).forEach((i) => console.log(i.value));

const birthdayDateYear = birthdayDate[0];
const birthdayDateMonth = birthdayDate[1];
const birthdayDateDay = birthdayDate[2];

// 성별
const gender = Array.from(document.getElementsByName("gender")).find(
  (radio) => radio.checked
);
// console.log(gender.value);

// radio

// 수신 여부
const agreeAll = document.querySelector("#agreeAll");
// console.log(agreeAll.value);

const whether = document.querySelectorAll(".whetherOK");
// whether.forEach((a) => console.log(a.value));
// whether.forEach((a) => console.log(a.checked));
// const whetherOrNot = Array.from(whether).find((checkbox) => checkbox.checked);

// 가입 버튼
const submitButton = document.querySelector("#submit-btn");

// events

const validationCheckBtn = document.querySelector("#phone-validation");
const validationInput = document.querySelector("#valid");

const houseCall = document.querySelector("#contact-home1");

houseCall.onchange = () => {
  if (houseCall.value === "0") {
    houseCall23.forEach((input) => (input.style.display = "none"));
    return;
  }
  houseCall23.forEach((input) => (input.style.display = "flex"));
};

validationCheckBtn.onclick = () => {
  if (
    contactPhone2.value !== "" &&
    contactPhone2.value !== null &&
    contactPhone3.value !== "" &&
    contactPhone3.value !== null
  ) {
    validationInput.disabled = false;
    contactPhone2.onchange = () => (validationInput.disabled = true);
    contactPhone3.onchange = () => (validationInput.disabled = true);

    let secret;
    const contactPhone =
        contactPhone1.value + contactPhone2.value + contactPhone3.value;

    $.ajax({
      type:"get",
      url: "/api/v1/authentication/cool",
      data : {
        "phoneNumber" : contactPhone
      },
      dataType : "text",
      success: (response) => {
        if (response != null && response !== "false") {
          alert("인증번호 전송이 완료되었습니다!");
          secret = response;
        }
      },
      error: (response) => {
        if (response != null) alert("실패했습니다.");
      },
    });

    validationInput.onblur = () => {
      if (validationInput.value === secret) {
        alert("인증되었습니다!");
      } else {
        alert("인증번호가 일치하지 않습니다.")
      }
    };
  } else validationInput.disabled = true;
};

passwordCheckInput.onblur = () => {
  if (passwordInput.value !== passwordCheckInput.value)
    alert("비밀번호를 다시 확인해주세요.");
  else alert("비밀번호가 일치합니다!");
};



const now = new Date();

for (let i = 1950; i < now.getFullYear() + 1; i++) {
  birthdayDateYear.innerHTML += `<option name="yy${i}" value="${i}">${i}년</option>`;
}

for (let i = 1; i < 13; i++) {
  birthdayDateMonth.innerHTML += `<option name="mm${i}" value="${i}">${i}월</option>`;
}

for (let i = 1; i < 32; i++) {
  birthdayDateDay.innerHTML += `<option name="dd${i}" value="${i}">${i}일</option>`;
}

submitButton.onclick = () => {
  const name = nameInput.value;
  const username = usernameInput.value;
  const password = passwordInput.value;
  const email = emailInput.value;
  const contactHome =
    contactHome1.value + contactHome2.value + contactHome3.value;
  const contactPhone =
    contactPhone1.value + contactPhone2.value + contactPhone3.value;
  const validationPhone = validationInput.value;
  const birthday = new Date(
    birthdayDateYear.value +
      ", " +
      birthdayDateMonth.value +
      ", " +
      birthdayDateDay.value
  );
  const getEmail = whether[0].checked ? 1 : 0;
  const getSMS = whether[1].checked ? 1 : 0;
  const getPost = whether[2].checked ? 1 : 0;
  const reward = whether[3].checked ? 1 : 0;
  const drink = whether[4].checked ? 1 : 0;
  const noti = whether[5].checked ? 1 : 0;

  if (checkNull(name)) return;
  if (checkNull(username)) return;
  if (checkNull(password)) return;
  if (checkNull(email)) return;
  if (checkNull(contactPhone)) return;
  if (checkNull(validationPhone)) return;

  let jsonData;
  if (agreeAll.checked === "on")
    jsonData = JSON.stringify({
      name: name,
      username: username,
      password: password,
      email: email,
      contactHome: contactHome,
      contactPhone: contactPhone,
      birthday: birthday,
      gender: gender.value === "M" ? 1 : 0,
      getEmail: 1,
      getSMS: 1,
      getPost: 1,
      reward: 1,
      getDrinkRec: 1,
      getPagePopup: 1,
    })
  else
    jsonData = JSON.stringify({
      name: name,
      username: username,
      password: password,
      email: email,
      contactHome: contactHome,
      contactPhone: contactPhone,
      birthday: birthday,
      gender: gender.value === "M" ? 1 : 0,
      getEmail: getEmail,
      getSMS: getSMS,
      getPost: getPost,
      reward: reward,
      getDrinkRec: drink,
      getPagePopup: noti,
    })

    $.ajax({
      type: "post",
      url: "/api/v1/user/join",
      contentType: "application/json; charset=utf-8",
      dataType: "text",
      data: jsonData,
      success: (response) => {
        if (response != null) alert("축하합니다!");
      },
      error: (response) => {
        if (response != null) alert("실패했습니다.");
      },
    });
};

function checkNull(string) {
  if (string !== "" && string !== null) return false;
  alert("필수 입력창을 채워주세요.");
  return true;
}
