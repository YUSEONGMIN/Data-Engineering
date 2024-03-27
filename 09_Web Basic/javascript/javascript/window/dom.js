// dom 객체의 body에는 style이 있음 -> 문서 배경 색 등
document.body.style.backgroundColor = 'lightgreen';

setTimeout(() => {
    document.body.style.backgroundColor = "lightblue";
}, 2000);