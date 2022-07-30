// 보통 입력창
const userInputs1 = document.querySelectorAll(".for-req1 input");
userInputs1.forEach((input) => console.log(input.value));

// 집전화
const houseCall1 = document.querySelector(".contact-home-input select");
console.log(houseCall1.value);

const houseCall23 = document.querySelectorAll(".contact-home-input input");
houseCall23.forEach((input) => console.log(input.value));

// 휴대폰
const phone1 = document.querySelector(".contact-phone-input select");
console.log(phone1.value);

const phone23 = document.querySelectorAll(".contact-phone-input input");
phone23.forEach((input) => console.log(input.value));

// 생일
const birthdayType = Array.from(document.getElementsByName("birthday")).find(
  (radio) => radio.checked
);

// 성별
const gender = Array.from(document.getElementsByName("gender")).find(
  (radio) => radio.checked
);
console.log(gender.value);

// 수신 여부
const agreeAll = document.querySelector("#agreeAll");
console.log(agreeAll.value);

const whetherOrNot = document.querySelectorAll(".whetherOK");
whetherOrNot.forEach((a) => console.log(a.value));

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
  if (phone23.forEach((input) => input.value !== "" && input.value !== null))
    validationInput.disabled = false;
  else console.log("test");
};
