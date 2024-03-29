### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 1 일차
Python 실습 환경 구성과 기본 문법  

`Python은 Interpreter 언어이다.`

## 목차

- [변수이름 관례 종류](#변수이름-관례-종류)
- [값 대입/할당 연산자](#값-대입할당-연산자)
- [Slicing](#slicing)
- [Format string 생성](#format-string-생성)
- [string 주요 메소드](#string-주요-메소드)


### [변수이름 관례 종류](#목차)

- Snake 표기법
    - `user_name`, `bank_account`, `save_data`
- Camel 표기법
    - `userName`, `bankAccount`, `saveData`
- 파스칼 표기법
    - `UserName`, `BankAccount`, `SaveData`

### [값 대입/할당 연산자](#목차)

|연산자|예|동일연산|
|:-|-|-|
|=|x = 1||
|+=|x += 1|x = x + 1|	
|-=|x -= 1|x = x - 1|	
|*=|x *= 1|x = x * 1|	
|/=|x /= 1|x = x / 1|	
|%=|x %= 1|x = x % 1|	
|//=|x //= 1|x = x // 1|	
|\*\*=|x \*\*= 1|x = x \*\* 1|

### [Slicing](#목차)

- **명시적으로 간격을 줄 경우**
    - str_value\[ : : 3 \] => 0, 3, 6, 9.. index의 값 조회
    - str_value\[1 : 9 : 2\] => 1, 3, 5, 7 index의 값 조회
- **시작 index > 종료 index, 간격을 음수로 하면 역으로 반환한다.(Reverse)**
    - str_value\[5: 1: -1\] => 5, 4, 3, 2 index의 값 조회
    - str_value\[: : -1\]  => 마지막 index ~ 0번 index 까지 의미. Reverse 한다.

### [Format string 생성](#목차)

1. format() 함수 이용

```py
name = "이순신"
age = 20
address = "서울"

layout = "이름: {}\n나이: {}\n주소: {}"
result = layout.format(name, age, address)
print(result)
```

2. % value 사용

|% value|설명|
|-|-|
|%s|string|
|%d|int-정수|
|%f (%.2f)|float-실수|
|%%|%|

```py
print("이름: %s\n나이: %d\n주소: %s" % (name, age, address))
```

3. f-string (format string)

```py
print(f"나이: {age}")
```

### [string 주요 메소드](#목차)

|메소드|설명|
|-|-|
|split(구분문자열)|구분 문자열을 기준으로 나눈다.|
|strip(), lstrip(), rstrip()|앞뒤(strip) 앞(lstrip) 뒤(rstrip) 공백 제거|
|replace('바꿀 문자열', '새문자열')|바꿀 문자열을 새문자열로 변경|
|count('세려는 문자열')|string안에 세려는 문자열이 몇개 있는지 반환|
|index(문자열), find(문자열)|문자열이 몇번째 index에 있는지 반환|
|upper(), lower()|모든 글자를 대문자(upper), 소문자(lower)로 변환|
|capitalize()|문자열의 첫글자를 대문자로 변환|
|islower(), isupper()|문자열이 모두 소문자(islower), 대문자(isupper)이면 True 아니면 False를 반환|
|startswith("문자열"),<br> endswith("문자열")|문자열로 시작하는지/끝나는지 여부 반환|


### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
