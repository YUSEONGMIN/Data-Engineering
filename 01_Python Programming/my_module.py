# 모듈 -> 재사용 가능한 전역변수, 함수, 클래스들을 정의한 스크립트 파일

__version__ = 1.0

def greet(name):
    return f"{name}님 안녕하세요"

class Person:

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __str__(self):
        return f"이름: {self.name}, 나이: {self.age}"

print("my_module.__name__:", __name__)

# 메인 모듈로 실행될 때 실행할 코드 (sub 모듈로 실행될 때는 실행 안되야함)
if __name__ == "__main__":
    print("my_module.__name__:", __name__)
    print(greet("이름"))
    p = Person("이영수", 10)
    print(p)