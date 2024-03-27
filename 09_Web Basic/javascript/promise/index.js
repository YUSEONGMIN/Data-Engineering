// 함수는 가능하면 상수로 만드는 것을 추천
// 비동기 함수
const asyncFnc = () => {
    alert("[비동기] 첫번째")

    setTimeout(() => {
        alert("[비동기] 두번째")
    }, 2000)

    alert("[비동기] 세번째")
}

// asyncFnc();
// 첫번째 - 세번째 - 두번째 순서로 알람창 출력 -> 자바는 순서대로 안하고 바로 실행

/*
Promise(A함수): Promise 함수를 input으로 받는다.
A함수: resolve, reject 함수를 input으로 받는다.
*/

function someAsyncTask() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log("Hi"); // 이 함수가 성공하면 resolve
            resolve("[동기] 두번째"); // Promise는 동기화 함수
        }, 2000);
    })
        .then((result) => {
            alert(result);
            return "[동기] 세번째";
        })
        .then((result) => {
            alert(result);
            return "[동기] 네번째";
        })
}
// Promise는 함수를 인자로 받음 (resolve와 reject는 함수명)
// 통신이 성공하면 resolve 함수 실행 <-> 실패하면 reject

async function main() {
    alert("[동기] 첫번째");
    const result = await someAsyncTask();
    alert(result);
}

main();
// 비동기화: 첫번째 -> 2초를 기다리지 않고 두번째 생략
// 동기화: resolve는 성공하면 then 뒤의 함수 실행
// resolve는 "[동기] 두번째"를 result에 할당 -> then 함수 실행 -> 알람 출력 -> return "세번째" -> result = "세번째"
// 두번째 then이 실행되면 "세번째" 알람 출력 -> return "네번째" -> main 함수의 마지막 alert에서 "네번째" 출력