function countRabbits() {
    for(let i=1; i<=3; i++) {
        alert(`토끼 ${i}마리`);
        // ' 따옴표가 아닌 ` 역따옴표
    }
}

// document 객체로부터 Id가 hello인 element 객체를 가져옴
let hello = document.getElementById("hello");

// 브라우저 콘솔 창에도 함수를 입력할 수 있음
// hello.onclick = () => {alert("hi");}

hello.onclick = () => {
    alert("Hello World");
}

/*
개발자 도구 - 요소 - 이벤트 수신기
            element - event listener
click // 이벤트에 click이라는 리스너 존재
    input#hello //  input 태그에 id가 hello인 이벤트
        handler: () => {alert("Hello World")} // 핸들러에 등록된 함수
// 핸들러를 삭제하면 아무 이벤트도 발생하지 않음
// 토끼 세기 -> onclick 함수

각 태그 안에 존재하는 수많은 이벤트
click 이벤트 등
*/

// html에서 정의한 onclick과 js에서 정의한 onclick 발동 순서
let who = document.getElementById("who");

// 브라우저 콘솔 창에도 함수를 입력할 수 있음
// hello.onclick = () => {alert("hi");}

who.onclick = () => {
    alert("슈퍼맨");
}
// 렌더링 순서
// html으로 dom 객체 생성 -> js의 함수가 dom 객체 수정 -> 화면 생성
//          배트맨        ->        슈퍼맨             -> 슈퍼맨 출력


let food = document.getElementById("food");
who.onclick = () => {
    alert("족발");
}

food.addEventListener('click',
    () => {
        alert("스테이크");
    }
)