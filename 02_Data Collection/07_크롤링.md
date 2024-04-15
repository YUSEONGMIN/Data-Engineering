### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 7 일차
크롤링

`Selenium`

## 목차

- [Selenium](#selenium)
- [WebDriver 속성/메소드](#webdriver-속성메소드)
    - Element 조회 메소드
- [대기 하기](#대기-하기)
    - Explicit Wait
    - Implicit Wait


## [Selenium](#목차)

- **웹 브라우저 제어 도구**
    - 웹 어플리케이션 자동 테스트를 위한 목적으로 만들어진 프레임워크
    - 웹브라우저를 프로그램을 이용해 제어할 수 있다.
- **requests 모듈의 한계**   
    - Javascript를 이용한 AJAX 기법의 비동기적 요청 처리 페이지 크롤링이 힘들다.
    - 로그인 후 요청이 가능한 페이지들에 대한 크롤링이 번거롭다.    
- **Selenium 단점** 
    - 속도가 느림
- Driver 
    - 웹브라우저를 제어하는 프로그램으로 웹 브라우저 별로 제공된다.
    - Selenium 패키지의 Driver 객체를 이용해 제어하게 된다.

```py
# DriverManager를 이용해 WebDriver 생성
!pip install webdriver-manager

# 다운 받은 Driver 이용해 WebDriver 생성
# 크롬
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service

# 엣지
from webdriver_manager.microsoft import EdgeChromiumDriverManager
from selenium.webdriver.edge.service import Service

from selenium import webdriver

# driver 다운로드
# 크롬
driver = ChromeDriverManager()

# 엣지
driver = EdgeChromiumDriverManager().install() # 다운받은 경로를 반환

service = Service(executable_path=driver) # driver 경로를 넣어서 생성

browser = webdriver.Chrome(service=service)
browser = webdriver.Edge(service=service)

browser.get("https://www.naver.com")
browser.close() # 끄기
```

## [WebDriver 속성/메소드](#목차)

- **page_source** : 현재 페이지의 html 소스를 반환
- **get_screenshot_as_file(파일경로)**
    - 현재 웹브라우저 화면을 지정한 캡처해서 지정한 파일 경로에 저장한다.
- **set_window_size(width, height)**: 웹브라우저 윈도우 크기 조정
- **maximize_window()**: 웹브라우저 화면 최대 크기로 만들기
- **get_window_size()**: 웹브라우저 윈도우 크기 조회
- **execute_script("자바스크립트코드")**:
    - 문자열로 전달한 **javascript 코드**를 실행시킨다.
- **quit()** / **close()**: 웹브라우저를 종료한다.

### Element 조회 메소드
- **find_element()**: 조건을 만족하는 첫번째 요소를 반환한다.
    - **by**: 검색방식
        - **By.ID**
        - **By.CLASS_NAME**
        - **By.TAG_NAME**
        - **By.CSS_SELECTOR**
        - **By.XPATH**
        - **By.LINK_TEXT**
        - **By.PARTIAL_LINK_TEXT**
    - **value**: str - 검색조건
    - 반환타입: **WebElement**
- **find_elements()**: 조건을 만족하는 모든 요소를 찾는다.
    - 반환타입: **list of WebElement**
     
### WebElement (조회결과) 메소드 / 속성
- 메소드
    - **get_attribute('속성명')**: 태그의 속성 값 조회
    - **send_keys("문자열")**: 입력폼에 문자열 값을 입력.
    - **click()**: element를 클릭
    - **submit()**: element가 Form인 경우 폼 전송
    - **clear()**: element가 입력폼인 경우 텍스트를 지운다.
- 속성
    - **text**: 태그 내의 텍스트
    - **tag_name**: 태그 이름

```py
from webdriver_manager.microsoft import EdgeChromiumDriverManager
from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

# web browser(크롬/엣지)을 실행
service = Service(executable_path=driver)
browser = webdriver.Edge(service=service)

# url로 이동 (naver)
browser.get("https://www.naver.com")
# html 소스코드를 조회 -> BeautifulSoup 이용해서 데이터 추출
html = browser.page_source


# 화면 캡쳐
browser.get_screenshot_as_file("naver_main.png")

browser.set_window_size(1000, 500)

textfield = browser.find_element(By.ID, "query")
print(textfield.tag_name, textfield.get_attribute("name"))
> input query

# 키보드 입력 -> 글자들을 입력
textfield.clear()
textfield.send_keys("날씨")
textfield.send_keys(Keys.ENTER)

textfield2 = browser.find_element(By.ID, "nx_query")
textfield2.clear()
textfield2.send_keys("미세먼지")

submit_btn = browser.find_element(By.CLASS_NAME, "bt_search")
submit_btn.click()
browser.close()
```

### 브라우저 headless 모드
- 브라우저의 창을 띄우지 않고 실제 브라우저와 동일하게 동작하도록 하는 방식
- CLI 기반의 OS (리눅스 서버)를 지원하기 위한 브라우저

```py
option = webdriver.ChromeOptions()
option = webdriver.EdgeOptions()
option.add_argument("--headless")

service = Service(executable_path=driver)
browser = webdriver.Edge(service=service, options=option)

browser.get("https://www.naver.com")
browser.get_screenshot_as_file("page_image.png")
browser.close()
```

## [대기 하기](#목차)

### Explicit Wait
- 특정 조건/상황을 만족할 때까지 대기
- `WebDriverWait(driver, 초).until(expected_contition)` 구문 사용
- expected_condition 함수
     - selenium.webdriver.support.expected_conditions 모듈에 정의된 함수 사용.

### Implicit Wait
- 현재 페이지에 없는 element나 elememt들이 loading 되기를 설정한 시간만큼 기다린다. 
- 설정한 시간 이내에 elements가 loading 되면 대기가 종료된다.
- `implicit_wait(초)` 구문 사용
- 한 번 설정하면 설정된 WebDriver가 close 될 때까지 그 설정이 유지된다.

```python
driver.implicitly_wait(5) 
# 페이지 로딩(dom tree 완성)될 때까지 최대 5초간 기다린다.
# (로딩이 되면 5초가 되지 않아도 대기를 끝낸다.)
```

<hr>

```python
from selenium.webdriver.support import expected_conditions as EC

...

try:
    # element가 반환될 때까지 최대 10초 기다린다.
    element = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "myDynamicElement"))
    )
finally:
    driver.quit()
```

## 무한 스크롤

```py
url = "https://www.youtube.com"

driver = EdgeChromiumDriverManager().install()
service = Service(executable_path=driver)
browser = webdriver.Edge(service=service)

browser.maximize_window()
browser.get(url)
# time.sleep(3)
# browser.execute_script("js 코드") -> 자바스크립트 코드가 브라우저에서 실행된다.

# document.documentElement.scrollHeight 세로 스크롤 길이 (페이지의 height 길이)
scroll_pane_height = browser.execute_script(
    "return document.documentElement.scrollHeight")

while True:
    # scroll 이동 - window.scrollTo(가로스크롤 이동할 위치, 세로스크롤 이동할 위치)
    browser.execute_script(
        "window.scrollTo(0, document.documentElement.scrollHeight)")
    time.sleep(1)

    # 이동 후 height 길이 조회
    new_scroll_height = browser.execute_script(
        "return document.documentElement.scrollHeight")

    if scroll_pane_height == new_scroll_height:
        break # 스크롤 이동을 멈춘다.
    scroll_pane_height = new_scroll_height

# 페이지에서 원하는 항목 추출
browser.close()
```

### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
