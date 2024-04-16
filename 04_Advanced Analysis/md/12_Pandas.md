### [전체 목차](../../README.md)
### [이전 페이지](../README.md)

# 12 일차

`Pandas`, `Series`, `DataFrame`

## 목차

- [Pandas](#pandas)
    - Series
        - Indexing
        - Slicing
- [벡터화(연산)](#벡터화연산)
- [Boolean 인덱싱](#boolean-인덱싱)

## [Pandas](#목차)

- 데이터 분석과 관련된 다양한 기능을 제공하는 파이썬 패키지
    - 데이터 셋을 이용한 다양한 통계 처리 기능을 제공한다.
    - 표 형태의 데이터를 다루는데 특화된 파이썬 모듈
    - **시리즈(Series)** 와 **데이터프레임(DataFrame)** 클래스 제공
        - Series: 1차원 자료구조를 표현
        - DataFrame: 2차원 행렬구조의 표(table)를 표현

### Series

- **1차원** 자료구조
- DataFrame(표)의 **한 행(row)** 이나 **한 열(column)** 을 표현한다.
- 각 원소는 **index**와 **index 이름**을 가지며 그것들을 이용해 사용할 수 있다.
- 벡터화 연산(element-wise 연산)을 지원
    - Series 객체에 연산을 하면 각각의 Series 원소들에 연산이 된다.
- 구문
    - `Series(1차원의 iterable)`
    - 1차원 구조의 자료구조에 값을 넣어 생성한다.
        - list, tuple, ndarray 등

```py
s1 = pd.Series([1,2,3,4])
s1
# index 이름: 0 1 2 3,
# 값: 1 2 3 4
> 0    1
> 1    2
> 2    3
> 3    4

# index name 조회
s1.index
> RangeIndex(start=0, stop=4, step=1)

s2 = pd.Series([100,70,90], index=["국어","영어","수학"])
s2
> 국어    100
> 영어     70
> 수학     90

s2.index
> Index(['국어', '영어', '수학'], dtype='object')
```

### Indexing
- 한개의 원소를 조회하거나 변경할 때 사용
- **index (순번) 으로 조회**
    - `Series.iloc[순번]`
- **index 이름으로 조회**
    - `Series.loc[index 이름]`
    - index 이름의 타입에 맞춰 조회한다.
        - `s.loc['name'], s.loc[2]`
    - Series.index이름
- **팬시(fancy) 인덱싱**
    -`Series[index리스트]`
    - 한번에 여러개의 원소를 조회할 경우 조회할 index들을 list로 묶어서 전달한다.
        - `series[["A", "B", "C"]`

```py
s2.iloc[1], s2.iloc[-1]
s2.loc['국어'], s2.loc['수학']
s2[['국어','영어']]
```

### Slicing
- 범위로 원소들을 조회할 때 사용한다.
- **Series[start index :  stop index : step]**
    - start index 생략 : 0번 부터
    - stop index
        - **index 순번일 경우는 포함 하지는다.**
        - **index 명의 경우는 포함한다.**
- **Slicing의 결과는 원본의 참조(View)를 반환**
    - Slicing은 shallow copy를 한다. 원소를 변경하면 원본도 같이 바뀐다.
    - `slicing결과.copy()` 를 이용해 deep copy를 해야 한다.

>    - **deep copy(깊은 복사)**
>        - 원본과 동일한 값을 가진 새로운 객체(복사본)를 만들어 반환한다.
>        - 그래서 복사본의 값을 변경해도 원본이 변경되지 않는다.
>        - 리스트는 slicing 시 deep copy를 한다.
>    - **shallow copy(얕은 복사)**
>        - 원본을 반환하여 값 변경시 원본에 영향을 준다.
>        - Series, DataFrame, 넘파이 배열(ndarray)은 slicing 시 shallow copy 한다.
>    - **copy() 메소드**
>        - Series, DataFrame, ndarray를 복사한다.

```py
s3.iloc[10:15] # step: 1
> 10    10
> ...
> 14    14

s3.loc[10:15] # index 이름으로 slicing -> stop도 포함
> 10    10
> ...
> 15    15
```

```py
s2['국어'] = 60 # 값을 변경 (있는 index에 값을 대입)
s2['과학'] = 100 # 없는 index 이름으로 대입 -> 추가
s2
> 국어      60
> 영어      70
> 수학      90
> 과학     100

b = s2['영어':'과학']
b['수학'] = 10
s2
> 국어      60
> 영어      70
> 수학      10
> 과학     100
```

## [벡터화(연산)](#목차)
- Pandas의 Series나 DataFrame은 연산을 하면 원소 단위로 연산을 한다.
    - **element-wise 연산** 이라고도 한다.
- Series/DataFrame과 값(scalar값)을 연산하면 각 원소들과 값을 연산한다.
- Series끼리 또는 DataFrame끼리 연산을 하면 같은 위치의 원소끼리 연산을 한다.
    - **Index 이름**이 (index가 아닌) 같은 원소끼리 연산한다. 

```py
s10 = pd.Series([1,2,3,4,5,-10,-9,-8])
s10 * 10 # s10의 모든 원소에 연산처리
> 0     10
> 1     20
> ...
> 6    -90
> 7    -80

s10 < 0
> 0    False
> 1    False
> ...
> 6     True
> 7     True

s11 = pd.Series([10,20,30,40,50,-100,-90,-80])
# Series와 Series 연산 => 같은 index 이름끼리 계산
s10 + s11
> 0     11
> 1     22
> ...
> 6    -99
> 7    -88
```


## [Boolean 인덱싱](#목차)
- Series의 indexing 연산자에 boolean 리스트를 넣으면 True인 index의 값들만 조회한다. 
    - **원하는 조건의 값들을 조회**할 때 사용한다.
|논리연산자|설명|
|:-:|-|
|&|and연산|
|\||or연산|
|~|not 연산|
    
    - 논리연산자의 피연산자들은 반드시 ( )로 묶어준다.
    - 파이썬과는 다르게 `and`, `or`, `not`은 예약어는 사용할 수 없다.

```py
s2[[True, False, False]] # True인 index에 있는 값들을 조회
> 국어    100

s2[s2 >= 80]
> 국어    100
> 수학     90

s10[~((s10 >= 2) & (s10 <= 10))]
> 0     1
> ...
> 7    -8

s10.between(2, 10) # 원소별로 2~10 사이에 있는지 확인
> 0    False
> 1     True
> ...
> 7    False

s10[~s10.between(2, 10)]
> 0     1
> ...
> 7    -8

s10[s10.between(2, 10)].index
np.where(s10.between(2, 10))
> Index([1, 2, 3, 4], dtype='int64')

np.where(s10.between(2, 10), '범위안', '범위밖')
> array(['범위밖', '범위안', ..., '범위밖'], dtype='<U3')
```

> - 한개의 원소를 조회할 경우
>     - indexing
> - 여러개의 원소를 선택해서 조회할 경우
>     - fancy indexing
> - 특정 조건의 원소들을 조회할 경우
>     - boolean indexing 


















### [목차로 돌아가기](#목차)
## [이전 페이지](../README.md)
