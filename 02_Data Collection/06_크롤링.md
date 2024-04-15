### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 6 일차
크롤링

`BeautifulSoup`, `requests`

## 목차

- [BeautifulSoup](#beautifulsoup)
- [Tag 객체](#tag-객체)
- [request](#request)
- [response 객체](#response-객체)

## [BeautifulSoup](#목차)

- Markup 언어 parsing 라이브러리
    - HTML(XML) 문서에서 원하는 정보를 가져오기 위한 파이썬 라이브러리

### BeautifulSoup 객체 생성
- `BeautifulSoup(html str [, 파서])`
- 매개변수
    1. 정보를 조회할 html을 string으로 전달
    2. 파서
        - html.parser: 기본파서
        - lxml: 매우 빠르다. html, lxml 파싱 가능

```py
with open("example.html", "rt", encoding="utf-8") as fr:
    html = fr.read()
# print(html) # 데이터를 가져올 html 문서의 내용을 str으로 정의

# import bs4
from bs4 import BeautifulSoup

soup = BeautifulSoup(html, 'lxml')
print(soup.prettify())

> """
<html>
 <head>
  <title>
   example.html 테스트
  </title>
  <meta charset="utf-8"/>
  <style>
   #animal1{color:red}
             .count {color:skyblue}
  </style>
 </head>
...
> """
```

```py
result = soup.find("div", attrs={"class", "count"}) # Tag 객체

print(result)
> <div class="count">3마리</div>

print(result.get_text())
> 3마리
```

## [Tag 객체](#목차)
- 하나의 태그(element)에 대한 정보를 다루는 객체
    - BeautifulSoup 조회 메소드들의 **조회결과의 반환타입.**
    - Tag 객체는 찾은 정보를 제공하는 메소드와 Attribute를 가지고 있다.
- 주요 속성/메소드
    - **태그의 속성값 조회**
        - tag객체.get('속성명'), tag객체\['속성명'\]
        - ex) tag.get('href') 또는 tag\['href'\]
    - **태그내 text값 조회**
        - tag객체.get_text(), tag객체.text
        - ex) tag.get_text() 또는 tag.text
    - **contents 속성**
        - 조회한 태그의 모든 자식 요소들을 리스트로 반환
        - ex) child_list = tag.contents
    - **태그의 이름으로 조회**
        - find_all(), find()
        - ex) find_all(name=태그명, attrs={속성명:속성값, ..})
    - **css selector를 이용해 조회**
        - css 셀렉터와 일치하는 tag들을 반환한다.
        - select(), select_one()

```py
# 태그 이름으로 찾기
result = soup.select("a") # a 태그들
result = soup.select("a, span") # a와 b 태그들. selector1, selector2

# 클래스 이름으로 찾기
result = soup.select(".count") # *.count => 모든 태그 중 class=count인 것들
result = soup.select("div.count") # div 태그 중 class가 count

# id로 조회
result = soup.select_one("#animal1") # *#animal1 -> 모든 태그들 중 id=animal1

result = soup.select("ul > li > a")
```

## [request](#목차)

- **HTTP 요청을 처리하는 파이썬 패키지**
- get/post 방식 모두 지원
- 쿠키, 헤더 정보 등 HTTP의 다양한 요청처리를 지원한다.

```py
import requests
response = requests.get("https://www.daum.net")
response.status_code
> 200

response.encoding = "utf-8"
print(response.text)
> """
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="utf-8">
  <title>Daum</title>
  <meta http-equiv="x-ua-compatible" content="IE=edge">
  ...
 </head>
 <body>
...
 </body>
</html>
> """
```

### requests 코딩 패턴
1. requests의 get/post 함수를 이용해 url을 넣어 서버를 요청한다.
2. 응답받은 내용을 처리
    - text(HTML)은 BeautifulSoup에 넣어 parsing
    - binary 파일의 경우, 파일 출력을 이용해 local에 저장

### requests.get(URL)
- **주요 매개변수**
    - params: 요청 파라미터를 dictionary로 전달
    - headers: HTTP 요청 header를 dictionary로 전달
        - 'User-Agent', 'Referer' 등 헤더 설정
    - cookies: 쿠키 정보를 전달
- **반환값(Return Value)**: Response 응답결과

### requests.post(URL)
- **주요 매개변수**
    - datas: 요청 파라미터를 dictionary로 전달
    - files: 업로드 할 파일을 dictionary로 전달
        - key: 이름, value: 파일과 연결된 InputStream(TextIOWrapper)
    - headers: HTTP 요청 header를 dictionary로 전달
        - 'User-Agent', 'Referer' 등 헤더 설정
    - cookies: 쿠키 정보를 전달
- **반환값(Return Value)**: Response 응답결과

> ### 요청 파라미터
> - 서버가 일하기 위해 클라이언트로 부터 받아야 하는 값들
> - `name=value` 형태이며 여러 개일 경우 `&`로 연결해서 전송됨
> - Get 요청시 queryString 으로 전달
>     - querystring: URL 뒤에 붙여서 전송한다.
>         1. url 뒤에 querystring으로 붙여서 전송
>         2. dictionary 에 name=value 형태로 만들어 매개변수 params에 전달
> - Post 요청시 요청정보의 body에 넣어 전달

## [Response 객체](#목차)
- get/post의 요청에 대한 서버의 응답 결과를 Response에 담아 반환
- 주요 속성(Attribut)
    - **url**
        - 응답 받은(요청한) url 
    - **status_code**
        - HTTP 응답 상태코드
    - **headers**
        - 응답 header 정보를 dictionary로 반환
- **응답 결과 조회**
    - **text**
        - 응답내용(html을 str로 반환)
    - **content**
        - 응답내용(binary-image, 동영상일 경우 bytes로 반환)
    - **json()**
        - 응답 결과가 JSON인 경우 dictionary로 변환해서 반환

> ### JSON(JavaScript Object Notation)
> key-value 형태의 text  
> 자바스크립트 언어에서 Object와 array를 생성하는 문법을 이용해 만듦
> - json.loads(json문자열)
>    - JSON 형식 문자열을 dictionary로 변환
> - json.dumps(dictionary)
>    - dictionary를 JSON 형식 문자열로 변환

### HTTP 응답 상태코드
- 2XX: 성공
    - 200: OK
- 3XX: 다른 주소로 이동
    - 300번대이면 자동으로 이동해 준다.
- 4XX: 클라이언트 오류 (사용자가 잘못한 것)
  - 404: 존재하지 않는 주소
- 5XX: 서버 오류 (서버에서 문제 생긴 것)
  - 500: 서버가 처리 방법을 모르는 오류
  - 503: 서버가 다운 등의 문제로 서비스 불가 상태

```py
base_url = "https://httpbin.org/{}"
url = base_url.format("get")
print(url)
> https://httpbin.org/get

# header에 user-agent 등록
user_agent = 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0'

header = {
    "user_agent":user_agent,
    "my-name":"Lee"
}

# 요청파라미터 전송
# 1. URL 뒤에 붙인다. (GET)
# 2. params 파라미터에 dictionary로 전달

param = {
    "id":"123",
    "page":30,
    "key":"test"
}

res = requests.get(url, # 요청 url
                   headers=header, # 요청 header 정보
                   params=param
                   )

# res = requests.get(url+"?id=123&page=100&key=my_test")

print("응답코드:", res.status_code)
> 응답코드: 200

if res.status_code == 200:
    # txt = res.text
    txt = res.json() # json 형식의 응답 -> 딕셔너리로 변환해서 반환
    print(txt)
> """
{'args': {'id': '123', 'key': 'my_test', 'page': '100'},
 'headers': {'Accept': '*/*', 'Accept-Encoding': 'gzip, deflate, br',
             'Host': 'httpbin.org',
             'User-Agent': 'python-requests/2.31.0',
             'X-Amzn-Trace-Id': 'Root=1-659cdf1a-643531593b84f16d682cce20'},
 'origin': '112.220.17.226',
 'url': 'https://httpbin.org/get?id=123&page=100&key=my_test'}
> """
```

### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
