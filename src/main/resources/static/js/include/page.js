const test = document.querySelector("#test");

$.ajax({
    method: "get",
    url: "api/v1/user/page",
    dataType:"json",
    success: (response) => {
        test.innerHTML = response.data.name;
    },
    error: (request, status, response) => {
        alert("로그인후 이용해 주세요");
        console.log(request);
        console.log(request.status);
        console.log(response);
    }
})