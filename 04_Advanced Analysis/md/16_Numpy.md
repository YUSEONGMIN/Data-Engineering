### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 16 일차

Numpy



## 목차

- [Numpy](#numpy)



## [Numpy](#목차)

- Numerical Python
- 벡터, 행렬 연산을 위한 수치해석용 라이브러리
    - 강력한 다차원 배열(array) 지원
    - 빠른 수치 계산을 위한 structured array, 벡터화 연산, 브로드캐스팅 기법 등을 통한  
      다차원 배열과 행렬연산에 필요한 다양한 함수를 제공한다.
    - List 보다 더 많은 데이터를 더 빠르게 처리
- 많은 과학 연산 라이브러리들이 Numpy를 기반으로 한다.
    - scipy, matplotlib, pandas, scikit-learn, statsmodels 등
- 선형대수, 난수 생성, 푸리에 변환 기능 지원

### 데이터 구조

- 스칼라 (Scalar): 값 하나
- 벡터 (Vector)
    - 여러개의 값들을 순서대로 모아놓은 데이터 모음(데이터 레코드)
    - 1D Tensor, 1D Array (1차원 배열)
- 행렬 (Matrix)
    - 벡터들을 모아놓은 데이터 집합. 2개의 방향으로 값들이 관리된다.
    - 2D Tensor, 2D Array (2차원 배열)
- 텐서 (Tensor)
    - 같은 크기의 행렬들(텐서들)을 모아놓은 데이터 집합. N개의 방향으로 값들이 관리된다.
    - ND Tensor, ND Array (다차원 배열)

### 용어
- **축 (axis)**
    - 값들의 나열 방향
    - 하나의 축(axis)는 하나의 범주(분류, Category)이다.
- **랭크 (rank)**
    - 데이터 집합에서 축의 개수. 
    - 차원 (dimension) 이라고도 한다.
- **형태/형상 (shape)**
    - 각 축(axis) 별 데이터의 개수
- **크기 (size)**
    - 배열내 원소의 총 개수

## 배열(ndarray)

- Numpy에서 제공하는 자료구조. N 차원 배열 객체
- 같은 타입의 값들만 가질 수 있다.
- 축(Axis)별 데이터의 개수는 모두 동일하다.
- 빠르고 메모리를 효율적으로 사용하며 벡터 연산과 브로드캐스팅 기능을 제공한다. 

> ### 차원 (dimension)
> - **Vector에서 차원**: 원소의 개수
> - **넘파이 배열에서 차원**: 축의 개수

### 배열 생성 함수

#### array(iterable [, dtype])

- Iterable 객체가 가진 원소들로 구성된 numpy 배열 생성
- 원하는 값들로 구성된 배열을 만들때 사용한다.
- 다차원(2차원이상) 배열을 만들 경우 각 axis(축)의 size(데이터의 개수)가 동일하도록 한다.

 ### 데이터 타입

> - 원소들의 데이터 타입
> - ndarray 는 같은 타입의 데이터만 모아서 관리한다.
> - 배열 생성시 dtype 속성을 이용해 데이터 타입 설정 가능
> - ndarray.dtype 속성을 이용해 조회
> - ndarray.astype(데이터타입)
>     - 데이터타입 변환하는 메소드
>     - 변환한 새로운 ndarray객체를 반환
> - **데이터 타입**
>     - 문자열과 numpy 모듈에서 제공하는 변수를 통해 지정할 수 있다.


|분류|문자열|numpy 변수|
|-|-|-|
|**정수형**|"int8"|np.int8|
||"int16"|np.int16|
||"int32"|np.int32|
||"int64"|np.int64|
|**부호없는정수형**|"uint8"|np.uint8|
||"uint16"|np.uint16|
||"uint32"|np.int32|
||"uint64"|np.uint64|
|**실수형**|"float16"|np.float16|
||"float32"|np.float32|
||"float64"|np.float64|
|**논리형**|"bool"|np.bool|
|**문자열**|"str"|np.str|


```py
import numpy as np

# 원하는 값들로 구성된 배열
a1 = np.array([1,2,3,4,5])

print("원소들의 타입:", a1.dtype)
print("원소 개수:", a1.size)
print("배열의 차원(Rank):", a1.ndim)
print("배열의 shape:", a1.shape) # tuple
```
    원소들의 타입: int32
    원소 개수: 5
    배열의 차원(Rank): 1
    배열의 shape: (5,)

```py
# 타입 변경
a2 = a1.astype("float32")

l1 = [[1, 2],
       [3, 4],
       [5, 6]]
a3 = np.array(l1)

l2 = [[10, 20],
       [30, 40],
       [50, 60]]
l3 = [[-1, -2],
       [-3, -4],
       [-5, -6]]

# type 지정, type 변환 -> 모든 원소들을 가질 수 있는 타입으로 지정
a4 = np.array(l3, dtype="uint8")
a5 = np.array([l1, l2, l3], dtype="float64")
```

### 동일한 값들로 구성된 배열

#### zeros(shape [, dtype])
- 영벡터 생성 : 원소들을 0으로 채운 배열
- shape : 형태 지정
    - 정수: 1차원일 경우 원소의 개수를 지정
    - 튜플: 다차원 배열의 각 축별 size를 설정
- dtype : 데이터타입 지정(생략시 float64)

#### ones(shape  [, dtype])
- 일벡터 생성 : 원소들을 1로 채운 배열을 생성
- shape : 형태 지정
    - 정수: 1차원일 경우 원소의 개수를 지정
    - 튜플: 다차원 배열의 각 축별 size를 설정
- dtype : 데이터타입 지정(생략시 float64)

#### full(shape, fill_value [, dtype]))
- 원소들을 원하는 값으로 채운 배열 생성
- shape : 형태 지정
    - 정수: 1차원일 경우 원소의 개수를 지정
    - 튜플: 다차원 배열의 각 축별 size를 설정
- fill_vlaue : 채울 값
- dtype : 데이터타입 지정(생략시 float64)

```py
a11 = np.zeros(shape=(5,4,3))
a13 = np.ones(shape=(6,5))
a14 = np.full(shape=(5,2,3), fill_value=15)

a15 = np.zeros_like(a5) # 배열 a5와 동일한 shape의 0으로 채운 배열을 생성
a16 = np.ones_like(a5)
a17 = np.full_like(a5, fill_value=3.2)
```

### 특정 범위내에서 동일한 간격의 값들로 구성된 배열

#### arange(start, stop, step, dtype)
- start에서 stop 범위에서 step의 일정한 간격의 값들로 구성된 배열 리턴  
  1차원 배열만 생성할 수 있다.
- start : 범위의 시작값으로 포함된다.(생략가능 - 기본값:0)
- stop : 범위의 끝값으로 **포함되지 않는다.** (필수)
- step : 간격 (기본값 1)
- dtype : 요소의 타입
- 1차원 배열만 생성가능

#### linspace(start, stop, num=50, endpoint=True, retstep=False, dtype=None)
- 시작과 끝을 균등하게 나눈 값들을 가지는 배열을 생성 
- start : 시작값
- stop : 종료값
- num : 나눌 개수. 기본-50, 양수 여야한다.
- endpoint : stop을 포함시킬 것인지 여부. 기본 True
- retstep : 생성된 배열 샘플과 함께 간격(step)도 리턴할지 여부  
  True일경우 간격도 리턴(sample, step) => 튜플로 받는다.
- dtype : 데이터 타입
- 1차원 배열만 생성가능

```py
a21 = np.arange(0, 10) # stop은 포함안함
a21
> array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])

a30 = np.linspace(0, 100) # 0 ~ 100까지 같은 간격으로 떨어진 값들 50개로 구성된 배열
np.linspace(0, 100, retstep=True)
np.linspace(0, 1, num=10, endpoint=False)
> array([0. , 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9])
```

### 난수를 원소로 하는 ndarray 생성
- random 패키지에서 제공하는 함수들을 이용해 생성

#### np.random.seed(시드값)
- 난수 발생 알고리즘이 사용할 시작값(시드값)을 설정
- 시드값을 설정하면 항상 일정한 순서의 난수(random value)가 발생한다.

> 랜덤함수는 특정숫자부터 시작하는 일렬의 수열을 만들어 값을 제공하는 함수이다.    
>
> 시작 숫자는 실행할때 마다 바뀌므로 다른 값들이 나오는데 
> 시드값은 시작값을 고정시키면 항상 시작 값이 같으므로 같은 값들이 순서대로 제공된다.    
>
> 매번 실행할때 마다 같은 순서의 임의의 값이(난수) 나오도록 할때 시드값을 설정한다.

#### np.random.rand([axis0, axis1, axis2, ...])    
- 0~1사이의 실수를 리턴
- 축의 크기는 순서대로 나열한다.

```py
np.random.rand(1)

np.random.seed(0)
np.random.rand(4)

np.random.rand() # 0 ~ 1 값 1개
np.random.rand(5) # (5, )
np.random.rand(3, 2, 10)

np.random.seed(0)
np.random.rand(3, 2, 10)
```

### 정규분포를 따르는 난수

#### np.random.normal(loc=0.0, scale=1.0, size=None) 

- loc: 평균
- scale: 표준편차
- loc, scale 생략시 표준정규 분포를 따르는 난수를 제공 

> ## 정규분포
> - **평균**: 데이터셋의 값들을 대표하는 값
>     - 정규분포에서 값들이 가장 많이 있을 것이라 생각되는 값이 평균 
> - **편차**: 데이터셋의 각 값들이 평균과 얼마나 차이가 있는지
> - **표준편차**: 편차의 평균 (평균으로 부터 각 값들이 얼마나 떨어져 있는지에 대한 평균)
> - **분산**: 표준편차의 제곱으로 표준편차 계산시 나오는 값. 
> - **분포**: 값이 흩어져 있는 상태를 말한다.
> - **정규분포** 
>     - 연속 확률 분포중 하나. 종모양을 하고 있다.
>     - **1표준편차 범위의 전체 데이터의 68%가  
        2표준편차 범위에 전체 데이터의 95% 정도가 분포한다.  
        (3표준편차범위에 약 99.7%가 분포)**
> - **표준정규분포**
>      - 평균 : 0, 표준편차 : 1 인 정규 분포 
> - 정규분포는 평균과 표준편차로 표현한다.

```py
np.random.normal(size=[3, 2])
np.random.normal(loc=10, scale=5, size=[3, 7])
v = np.round(np.random.normal(loc=70, scale=10, size=1000), 2)
v.mean(), v.std()
plt.hist(v, bins=100);
```

### 임의의 정수를 가지는 배열

#### np.random.randint(low, high=None, size=None, dtype='int32')
- low ~ high 사이의 정수 리턴. high는 포함안됨
- high 생략시 0 ~ low 사이 정수 리턴. low는 포함안됨
- size : 배열의 크기. 다차원은 튜플로 지정 기본 1개
- dtype : 원소의 타입

```py
np.random.randint(0, 10) # 0 ~ 10-1 사이 정수
np.random.randint(10) # low 생략 -> 0
np.random.randint(10, 50, size=10)
np.random.randint(10, 50, size=[2, 10])
np.random.randint(10, 50, size=[2, 3, 2, 10])
```

#### np.random.choice(a, size=None, replace=True, p=None)
- 샘플링(표본추출) 메소드
- a : 샘플링대상. 1차원 배열 또는 정수 (정수일 경우 0 ~ 정수, 정수 불포함)
- size : 샘플 개수
- replace : True-복원추출(기본), False-비복원추출
- p: 샘플링할 대상 값들이 추출될 확률 지정한 배열

```py
v = np.random.choice([True, False], # 추출할 대상 배열
                     size=10, # 샘플`개수, shape
                     p=[0.1, 0.9], # 각 원소가 추출될 확률
                     # replace=False
                    )
np.unique(v, return_counts=True)
```

### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)