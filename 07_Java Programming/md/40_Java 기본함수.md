### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 40 일차

Java 기본 함수: `print`, `Math`, `Random`

## 목차

- [print](#print)
- [Math](#math)
- [Random](#random)

## [print](#목차)

```java
// sout + 텝!!
System.out.println("Hello World"); // 문자열 표현 
System.out.println(30 * 30); // 간단한 연산 가능 

// %s: 문자열 
// %d: 정수 
// %f: 실수 
// \n: 줄바꿈 
System.out.printf("저는 %s입니다. 나이는 %d살이고요, 키는 %fcm입니다.\n", "홍길동", 20, 180.5f);

String str2 = String.format("저는 %s입니다. 나이는 %d살이고요, 키는 %fcm입니다.\n", "신사임당", 20, 180.5f); 
System.out.println(str2);
```

## [Math](#목차)

```java
System.out.println(Math.max(10,30)); // 큰 숫자 표시 
System.out.println(Math.min(10, 30)); // 작은 숫자 표시 
System.out.println(Math.abs(-30)); // 절대값 표시 

// 올림 
System.out.println(Math.ceil(10.1));      // 11.0

// 내림 
System.out.println(Math.floor(10.9));     // 10.0

// 반올림 
System.out.println(Math.round(10.4));     // 10
System.out.println(Math.round(10.5));     // 11
```

## [Random](#목차)

```java 
Random random = new Random();

// 0 ~ 9에서 램덤한 숫자 추출 
int rand = random.nextInt(10); 
System.out.println(rand);

// 5 ~ 9에서 램덤한 숫자 추출 
// 0+5 ~ 4+5 -> 0 ~ 4 & + 5
int rand2 = random.nextInt(5) + 5;
System.out.println(rand2);
```


### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)