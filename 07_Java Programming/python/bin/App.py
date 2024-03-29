
# print("Hello, World")

# 변수 선언 (정수)
x = 50
# 변수 재정의
x = 40

# 변수 선언 (실수)
y = 3.14

# 정수 -> 실수
y = float(x)

# 실수 -> 정수
z = int(y)

# bool
x = True

# string
y = "Hello World"

# bool -> int
x1 = int(x)
# 삼항 다항식
x1 = 1 if x else 0

# string -> int
y = "10"
# y = "aa" -> ValueError
y1 = int(y)

# 리스트는 크기를 정의하지 않아도 됨 (동적)
lst = [1,2,3,4,5]

lst = []
lst.append(1)
lst.append(2)

# 딕셔너리
dic = {
    "name" : "홍길동",
    "age" : 11
}

dic = {}
dic["name"] = "홍길동"
dic["age"] = "11" # 11도 가능

# print(x)
# print(y)
# print(x*y)
# print(z)
# print(x1)
# print(y1)
# print(lst)

# for i in lst:
#     print(i)

print(dic['name'])
print(dic['age'])