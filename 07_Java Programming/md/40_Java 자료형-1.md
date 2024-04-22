### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 40 일차


## 목차

- [변수 & 상수](#변수--상수)
- [자료형](#자료형)
    - 정수형, 실수형, 불리언형, 문자형
- [형변환](#형변환)

## [변수 & 상수](#목차)

```java
// 변수: 변하는 수 
int x = 30;
x = 40;
System.out.println(x);

// 상수: 변할 수 없는 수 
final int y = 30;
y = 40; // 오류 발생 
System.out.println(y);
```

## [자료형](#목차)

```java
// 정수형 (long, int, short, byte)
long l = 30L;
int x = 30;
short s = 30; // 잘 사용하지 않음 
byte b = 30; // 잘 사용하지 않음 

int i = (int) 30L; // 형변환을 해야 함!!
long ll = 30; // long이 int보다 큰 범위를 표현할 수 있으므로 형변환을 할 필요 없음
// (자동 형변환)

// 실수형 (double > float)
double dd = 30.0;
float ff = 30.0f; // f를 빼면 double로 인식!!

dd = ff; // 자동 형변환 
ff = (float) dd; // 형변환 필요!! 

// 불리언형  
boolean bool = true; 
bool = false; 

// 문자형 
char c = '한';
c = 'a'; 
String str = "여러 글자";
```

## [형변환](#목차)

```java
String str = "100";
int i = Integer.parseInt(str); // 문자열 -> 숫자열 
long l = Long.parseLong(str); 
Double dd = Double.parseDouble(str); 

System.out.println(i);

String str2 = String.valueOf(i); // 숫자열 -> 문자열 
System.out.println(str2);
```












### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
