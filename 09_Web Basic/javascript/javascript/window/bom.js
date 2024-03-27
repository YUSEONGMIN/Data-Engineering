// url 주소
document.write("<h3> location </h3>");
document.write("현재 문서의 주소: " + location.href + "<br>");
document.write("현재 문서의 호스트: " + location.hostname + "<br>");
document.write("현재 문서의 path: " + location.pathname + "<br>");

// 상수 만들기
const openDocument = () => {
    location.assign("sub.html");
}

setTimeout(openDocument, 5000);
