### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 40 일차


## 목차

- [Array](#array)


## [Array](#목차)



자바 조건문
if else
int i = 10; 

if (i < 3) {
  System.out.println("True");
} else if (i < 5) {
  System.out.println("False");
} else {
  System.out.println("None");
}
3항 연산자
조건 ? 조건이 참일 때 : 조건이 거짓일 때

boolean isMarried = true; 
String str = isMarried ? "Yes" : "No";
System.out.println(str);

// 3항 다항식을 if else문으로 변경 
if (isMarried) {
  str = "Yes";
} else {
  str = "No";
}
System.out.println(str);
조건
and 조건: &&
or 조건: ||
not 조건: !
boolean isMarried = true; 
boolean isOld = false;
String str; 

if (isMarried && isOld) { // 결혼을 했으면서, 나이가 많음 
  str = "1";
} else if (isMarried || isOld) { // 결혼을 했거나 나이가 많거나 
  str = "2";
} else if (!isMarried) { // 결혼을 하지 않음 
  str = "3";
} else { // 그외...
  str = "0";
}

System.out.println(str);
switch/case
int month = 3;
String monthString = "";
switch (month) {  // 입력 변수의 자료형은 byte, short, char, int, enum, String만 가능하다.
  case 1:  monthString = "January";
    break;
  case 2:  monthString = "February";
    break;
  case 3:  monthString = "March";
    break;
  default: monthString = "Invalid month";
    break;
}
System.out.println(monthString);





반복문
for
for (int i=0; i<10; i++) {
  System.out.println(i);
}
while
int x = 0;

while (x<10) {
  System.out.println(x);
  x++;
}
for each
int[] score = { 78, 70, 65, 98, 58 };
int sum = 0;

for (int i : score) {
  sum += i; // sum = sum + i;
}
System.out.println("점수 합계 : " + sum); // 결과 : 369
ArrayList<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three"));

for (String number : numbers) {
    System.out.println(number);
}
break: 만나는 즉시 반복문 전체 탈출
for (int i=0; i<10; i++) {
  if (i == 6) {
    break;
  }
  System.out.println(i);
}
continue: 만나면 해당 반복부분 탈출 후 다음반복실행
for (int i=0; i<10; i++) {
  if (i == 6) {
    continue; // 6만 출력이 안됨 
  }
  System.out.println(i);
}



### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
