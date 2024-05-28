### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 17 일차

Numpy 배열 연산

- 

## 목차

- [인덱싱](#인덱싱)
- [슬라이싱](#슬라이싱)
- [boolean indexing](#boolean-indexing)
    - 비교연산자
    - np.where()



## [인덱싱](#목차)
- index
    - 배열내의 원소의 식별번호
    - 0부터 시작
- indexing 
    – index를 이용해 원소 조회
    - [] 표기법 사용
- 구문 
    - ndarray[index]
    - 양수는 지정한 index의 값을 조회한다. 
    - 음수는 뒤부터 조회한다. 
        - 마지막 index가 -1
    - 2차원배열의 경우 
        - arr[0축 index, 1축 index]
        - 파이썬 리스트와 차이점 
    - N차원 배열의 경우
        - arr[0축 index, 1축 index, ..., n축 index]
- 팬시(fancy) 인덱싱
    - **여러개의 원소를 한번에 조회**할 경우 리스트에 담아 전달한다.
    - 다차원 배열의 경우 각 축별로 list로 지정
    - `arr[[1,2,3,4,5]]`
        - 1차원 배열(vector): 1,2,3,4,5 번 index의 원소들 한번에 조회
    - `arr[[0,3], [1,4]]`
        - [0,3] - 1번축 index list, [1,4] - 2번축 index list
        - 2차원 배열(matrix): [0,1], [3,4] 의 원소들 조회


## [슬라이싱](#목차)

- 배열의 원소들을 범위로 조회한다.
- ndarry[start : stop : step ]
    - start : 시작 인덱스. 기본값 0
    - stop : 끝 index. stop은 포함하지 않는다. 기본값 마지막 index
    - step : 증감 간격. 기본값 1

### 다차원 배열 슬라이싱

- 각 축에 slicing 문법 적용
- 2차원의 경우
    - arr [0축 slicing, 1축 slicing]
        - `arr[:3, :]`
    - `,` 로 축을 구분한 다중 슬라이싱 사용
- 다차원의 경우
    - arr[0축 slicing, 1축 slicing, ..., n축 slicing]
- slicing과 indexing 문법은 같이 쓸 수 있다.

```py
import numpy as np

a = np.random.randint(1, 10, size=(3, 5))
a
a[1][2]
# 2차원 배열
# a[0축 index, 1축 index]
a[1, 2]
a[2, 3]
b = np.random.randint(1, 10, size=(3,2,5))
b
b[0].shape
b[1, 0]
b[1, 1, 4]
# b[0축 idx, 1축 idx, 2축 idx]
b[:,1]
np.random.seed(0)
c = np.random.randint(1, 10, size=10)
c
c[[0,2,5]] # fancy indexing
a
a[[0, 0], [1, 4]]
c = np.arange(10)
c[:]
c[5:] # 5 ~ 끝
c[3:7]
c[1:8:2]
c[-1:2:-1]
b
b[:,0,1]
b[:,:,[1,3]]
```

## [boolean indexing](#목차)

- Index 연산자에 같은 형태(shape)의 Boolean 배열을 넣으면 True인 index의 값만 조회 (False가 있는 index는 조회하지 않는다.)
- ndarray내의 원소 중에서 원하는 조건의 값들만 조회할 때 사용
    - ndarray는 **element-wise 연산**을 지원한다.
- boolean indexing을 masking이라고도 한다.

### 비교연산자

- 파이썬의 and, or, not은 사용할 수 없다.
- `&`: and연산
- `|`: or 연산
- `~`: not 연산
- 피연산자는 `( )`로 묶어야 한다.

```py
flag = np.random.choice([True,False],size=10)
flag
c[flag]
c > 5
c[c>5]
print(a.shape)
(a>5).shape
a[a>5]
# 2 ~ 6
a[(a >= 2) & (a <= 6)]
a[~((a >= 2) & (a <= 6))]
a[(a < 2) | (a > 6)]
```

### np.where()

- **True의 index 조회**
    - np.where(boolean 배열) - True인 index를 반환
        - 반환타입: Tuple . True인 index들을 담은 ndarray를 축별로 Tuple에 묶어서 반환한다.
    - boolean연산과 같이사용하여 배열내에 **특정 조건을 만족하는 값들을 index(위치)를 조회할 때** 사용
- **True와 False를 다른 값으로 변환**
    - np.where(boolean 배열, True를 대체할 값, False를 대체할 값)
        - 배열내의 True를 True를 대체할 값으로 False를 False를 대체할 값 으로 변환한다.

```py
np.where([True,False,True])
r = np.where(c > 5)
print(type(np.where(c > 5)))
r[0]
v = np.where(a > 5)
v
for i in zip(v[0], v[1]):
    print(i)
np.where(b>5)
np.where(c > 5, '참', '거짓')
```

### 기타
- np.any(boolean 배열)
    - 배열에 True가 하나라도 있으면 True 반환
    - 배열내에 특정조건을 만족하는 값이 하나 이상 있는지 확인할 때 사용
- np.all(boolean 배열)
    - 배열의 모든 원소가 True이면 True 반환
    - 배열내의 모든 원소가 특정 조건을 만족하는지 확인 할 때 사용

```py
# c가 모두 양수인지
np.all(c >= 0)
np.all( c >= 2)
# c의 원소 중 양수가 하나라도 있나
np.any(c >= 0)
np.any(c > 20)
- 특정 조건이 True인 값들을 조회 -> boolean indexing
- 특정 조건이 True인 값들의 index -> np.where()
- 특정 조건의 값이 하나라도 있는지 -> np.any()
- 모든 값들이 특정 조건을 만족하는지(True) -> np.all()
```


# 배열의 형태(shape) 변경

- 배열의 **원소의 개수를 유지하는 상태**에서 shape을 변경할 수있다.
    - 예) (16, ) -> (4,4) -> (2,2,4) -> (2,2,2,2), -> (4,4,1) -> (1, 16)
## reshape()을 이용한 차원 변경
- `numpy.reshape(a, newshape)` 또는 `ndarray.reshape(newshape)`
    - a: 형태를 변경할 배열
    - newshape : 변경할 형태 설정. 
        - 원소의 개수를 유지하는 shape으로만 변환 가능하다.
        - 각 axis(축)의 size를 지정할 때 **하나의 축의 size를 -1**로 줄 수있다. 그러면 알아서 축 size를 설정해 준다. (전체 size / 지정한 axis들 size의 곱)

    - 둘다 원본을 바꾸지 않고 reshape한 새로운 배열을 만들어 반환한다.
a = np.arange(100).reshape(2, 50)
a.shape
a
a2 = a.reshape(10, 2, 5)
print(a2.shape)
a2
a3 = a.reshape(5, 2, 2, -1) # -1: size를 알아서 계산해서 넣어라
a3.shape
#a3.reshape(2, 10) # a3.size: 100 -> 20 (size가 변경되도록 바꿀 수 없다.)
print(a.shape)
a4 = a.reshape(2, 50, -1, 1,1,1,1)
a4.shape, a4.ndim
# size가 1인 축 -> dummy 축(axis)
print(a3.shape)
a5 = a3.reshape(2, 50)
print(a5.shape)
## 차원 늘리기(확장)

- Dummy axis(축)을 늘린다.
   > - Dummy axis: size가 1인 axis 를 말한다.

- **reshape() 을 이용해 늘릴 수 있다.**
- **indexer와 np.newaxis 변수를 이용해 늘린다.**
    - ndarray\[..., np.newaxis\] 또는 ndarray\[np.newaxis, ...\]
        - 맨앞 또는 맨 마지막에 dummy axis(축)을 늘릴때 사용한다.
        - 축을 늘리려는 위치에 np.newaxis를 지정하고 `...` 으로 원본 배열의 shape을 유지함을 알려준다.
        
- **np.expand_dims(대상배열, axis=늘릴축)**
    - dummy axis를 원하는 axis에 추가한다.
# (2, 50) -> (1, 2, 50)
b = a.reshape(1, 2, 50)
print(b.shape)
b1 = a[np.newaxis, ...]
print(b1.shape)
# (2, 50, 1)
b2 = a[..., np.newaxis]
b2.shape
b3 = np.expand_dims(a, axis=0)
b3 = np.expand_dims(a, axis=1)
b3 = np.expand_dims(a, axis=[1, 3])
print(a.shape)
print(b3.shape)
## Dummy 축(axis) 줄이기(축소)

### numpy.squeeze(배열, axis=None), 배열객체.squeeze(axis=None)
- 배열에서 지정한 축(axis)을 제거하여 차원(rank)를 줄인다.
- 제거하려는 축의 size는 1이어야 한다.
- 축을 지정하지 않으면 size가 1인 모든 축을 제거한다.
    - (3,1,1,2) => (3,2)
c1 = b.squeeze()
print(b.shape, c1.shape)
print(b3.shape)
c2 = b3.squeeze()
print(c2.shape)
c3 = b3.squeeze(axis=1)
c3.shape
### 배열객체.flatten()
- 다차원 배열을 1차원으로 만든다.
print(a.shape)
d1 = a.flatten()
print(d1.shape)
print(a2.shape)
d2 = a2.flatten()
print(d2.shape)
# 배열 연산

## 벡터화 - 벡터 연산
- 배열과 scalar 간의 연산은 원소단위로 계산한다.
- 배열간의 연산은 같은 index의 원소끼리 계산 한다. 
    - **Element-wise(원소별) 연산** 이라고도 한다.
    - **배열간의 연산시 배열의 형태(shape)가 같아야 한다.**
    - 배열의 형태가 다른 경우 Broadcast 조건을 만족하면 연산이 가능하다.
### 배열과 스칼라간 연산

$$
\begin{align}
10 -
\begin{bmatrix}
1 \\
2 \\
3 \\
\end{bmatrix}
=
\begin{bmatrix}
10 - 1 \\
10 - 2 \\
10 - 3 \\
\end{bmatrix}
=
\begin{bmatrix}
9 \\
8 \\
7 \\
\end{bmatrix}
\end{align}
$$
$$
\begin{align}
10 \times
\begin{bmatrix}
1 & 2 \\
3 & 4
\end{bmatrix}
=
\begin{bmatrix}
10\times1 & 10\times2 \\
10\times3 & 10\times4 \\
\end{bmatrix}
=
\begin{bmatrix}
10 & 20 \\
30 & 40
\end{bmatrix}
\end{align}
$$
### 배열 간의 연산
$$
\begin{align}
\begin{bmatrix}
1 \\
2 \\
3 \\
\end{bmatrix}
+
\begin{bmatrix}
10 \\
20 \\
30 \\
\end{bmatrix}
=
\begin{bmatrix}
1 + 10 \\
2 + 20 \\
3 + 30 \\
\end{bmatrix}
=
\begin{bmatrix}
11 \\
22 \\
33 \\
\end{bmatrix}
\end{align}
$$

$$
\begin{align}
\begin{bmatrix}
1 & 2 \\
3 & 4
\end{bmatrix}
+
\begin{bmatrix}
10 & 20 \\
30 & 40 \\
\end{bmatrix}
=
\begin{bmatrix}
1+10 & 2+20 \\
3+30 & 4+40
\end{bmatrix}
=
\begin{bmatrix}
11 & 22 \\
33 & 44
\end{bmatrix}
\end{align}
$$

import numpy as np
a = np.arange(3)
b = np.arange(10, 13)
c = np.arange(5)

print(a.shape, b.shape, c.shape)
a + 100
a > 5
b
## 내적 (Dot product) 연산

- `@` 연산자 또는 `numpy.dot(벡터/행렬, 벡터/행렬)`  함수 사용
- 같은 index의 원소끼리 곱한뒤 결과를 모두 더한다.
- 벡터간의 내적의 결과는 스칼라가 된다.
- $ x \cdot y $ 또는 $x^T y$로 표현
- 조건
    - 두 벡터의 차원(원소의개수)가 같아야 한다.
    - 앞의 벡터는 행벡터 뒤의 벡터는 열벡터 이어야 한다.
        - numpy 에서는 vector 끼리 연산시 앞의 벡터는 행벡터로 뒤의 벡터는 열벡터로 인식해 처리한다.
$$
\begin{align}
x =
\begin{bmatrix}
1 \\ 2 \\ 3 \\
\end{bmatrix}
,\;\;\;
y = 
\begin{bmatrix}
4 \\ 5 \\ 6 \\
\end{bmatrix} 
\end{align}
$$

$$
\begin{align}
x^T y = 
\begin{bmatrix}
1 & 2 & 3
\end{bmatrix}
\begin{bmatrix}
4 \\ 5 \\ 6 \\
\end{bmatrix} 
= 1 \times 4 + 2 \times 5 + 3 \times 6 = 32
\end{align}
$$
### 행렬 곱
- 같은 index의 앞 행렬의 행과 뒤 행렬의 열간에 내적을 한다.
- 행렬과 행렬을 내적하면 그 결과는 행렬이 된다.
- 앞 행렬의 열수와 뒤 행렬의 행수가 같아야 한다.
- 내적의 결과의 형태(shape)는 앞행렬의 행수와 뒤 행렬의 열의 형태를 가진다.
    - (3 x 2)와 (2 x 5) = (3 x 5)
    - (1 x 5)와 (5 x 1) = (1 x 1)    
   
$$
\begin{align}
A = \begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6 \end{bmatrix}
\end{align}
$$

$$
\begin{align}
B = \begin{bmatrix} 1 & 2 \\ 3 & 4 \\ 5 & 6 \end{bmatrix}
\end{align}
$$

$$
\begin{align}
A\cdot B = \begin{bmatrix} 1\times 1 + 2\times 3 + 3 \times 5 & 1\times 2 + 2\times 4 + 3 \times 6  \\ 4\times 1 + 5\times 3 + 6 \times 5  & 4\times 2 + 5\times 4 + 6 \times 6  \end{bmatrix} = 
\begin{bmatrix} 22 & 28 \\ 49 & 64 \end{bmatrix}
\end{align}
$$    
### 내적의 예
#### 가중합 
가격: 사과 2000, 귤 1000, 수박 10000    
개수: 사과 10, 귤 20, 수박 2    
총가격?    
2000*10 + 1000 * 20 + 10000 * 2
price = np.array([2000, 1000, 10000])
cnt = np.array([10, 20, 2])
# np.sum(price * cnt)
price @ cnt
np.dot(price, cnt)
price = np.array([[2000, 1000, 10000]]) # price[np.newaxis, ...]
cnt_list = [[10,5,20,10],[20,7,15,20],[2,10,10,2]]
cnt = np.array(cnt_list)
price.shape, cnt.shape
result = price @ cnt
result
result.shape
np.sum(result)
np.dot(price, cnt)
## 기술통계함수

- 통계 결과를 계산해 주는 함수들
- 구문
    1. `np.전용함수(배열)`
        - np.sum(x)
    2. 일부는 `배열.전용함수()` 구문 지원
        - x.sum()
    - 공통 매개변수
        - axis=None: 다차원 배열일 때 통계값을 계산할 axis(축)을 지정한다. None(기본값)은 flatten후 계산한다.
        
- 배열의 원소 중 누락된 값(NaN - Not a Number) 있을 경우 연산의 결과는 NaN으로 나온다.        
- **안전모드 함수**
    - 배열내 누락된 값(NaN)을 무시하고 계산
        
- https://docs.scipy.org/doc/numpy-1.15.1/reference/routines.statistics.html
![image.png](attachment:b938bbb3-4460-4b70-b046-f27353384c8d.png)
a = np.array([3,6,9, np.nan])
b = np.array([10,20,30])

np.sum(b)
np.sum(a), np.nansum(a)
np.average(b, weights=[2,3,1])
w = np.array([2,3,1])
(b @ w) / np.sum(w)
# 브로드캐스팅
- 사전적의미 : 퍼트린다. 전파한다. 
- 형태(shape)가 다른 배열 연산시 배열의 형태를 맞춰 연산이 가능하도록 한다.
    - 모든 형태를 다 맞추는 것은 아니고 조건이 맞아야 한다.
- 조건
    1. 두 배열의 축의 개수가 다르면 작은 축의개수를 가진 배열의 형태(shape)의 앞쪽을 1로 채운다.
        - (2, 3)  + (3, ) => (2, 3) + (1, 3)
    2. 두 배열의 차원 수가 같지만 각 차원의 크기가 다른 경우 어느 한 쪽에 1이 있으면 그 1이 다른 배열의 크기와 일치하도록 늘어난다.
         - 1 이외의 나머지 축의 크기는 같아야 한다.
         - 늘리면서 원소는 복사한다.
         - (2, 3) + (1, 3) => (2, 3)+(2, 3)
![image.png](attachment:f4ae146a-0b9b-4860-9c03-7b29e19b4052.png)
x = np.arange(18).reshape(3,2,3)
y = np.arange(18).reshape(3,2,3)
z = np.arange(18).reshape(3,3,2)
x + y
x > y
# x + z
a = np.arange(6).reshape(2,3)
x.shape, a.shape
x + a











### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)