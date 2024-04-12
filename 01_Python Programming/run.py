# run.py에서 my_module의 함수를 사용
import my_module as mm
from my_package import calculator as c

print("__name__:", __name__)

print("덧셈:", c.plus(100, 200))

txt = mm.greet("홍길동")
print(txt)

p = mm.Person("이순신", 30)
print(p)

txt2 = mm.greet(p.name)
print(txt2)
