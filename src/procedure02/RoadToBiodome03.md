# 시간 복잡도 분석 보고서

작성자: 김민수

---

## 목차

1. [시간 복잡도의 정의와 필요성](#1-시간-복잡도의-정의와-필요성)
2. [Big O 표기법의 개념과 상황별 예시](#2-big-o-표기법의-개념과-상황별-예시)
3. [문제01 코드의 시간 복잡도 분석](#3-문제01-코드의-시간-복잡도-분석)
4. [문제02 코드의 시간 복잡도 분석](#4-문제02-코드의-시간-복잡도-분석)
5. [병목 현상 분석 및 최적화 방안](#5-병목-현상-분석-및-최적화-방안)

---

## 1. 시간 복잡도의 정의와 필요성

시간 복잡도란 입력 크기 n에 따라 알고리즘이 수행하는 연산의 횟수가 어떻게 증가하는지를 나타내는 척도이다.

같은 결과를 내는 코드라도 입력이 커질수록 실행 시간이 크게 달라질 수 있다. 예를 들어 입력이 10개일 때는 차이가 없어 보이지만, 100만 개가 되면 알고리즘에 따라 수십 배에서 수백만 배까지 차이가 날 수 있다. 시간 복잡도를 분석하면 코드가 실제로 얼마나 효율적인지 판단하고, 성능 문제가 생기기 전에 병목을 찾아낼 수 있다.

---

## 2. Big O 표기법의 개념과 상황별 예시

Big O 표기법은 알고리즘의 최악의 경우 성능을 나타내는 방법이다. 상수나 낮은 차수의 항은 무시하고 가장 지배적인 항만 표기한다.

| 표기법 | 이름 | 예시 |
|--------|------|------|
| O(1) | 상수 시간 | 배열의 특정 인덱스 접근 |
| O(log n) | 로그 시간 | 이진 탐색 |
| O(n) | 선형 시간 | 배열 순회 |
| O(n log n) | 선형 로그 시간 | 병합 정렬 |
| O(n²) | 이차 시간 | 이중 for문 |
| O(2ⁿ) | 지수 시간 | 재귀적 피보나치 |

---

## 3. 문제01 코드의 시간 복잡도 분석

문제01은 입력 배열에서 1번만 등장하는 숫자를 찾는 프로그램이다. 입력 크기를 n (입력된 숫자의 개수), 값의 범위를 M (= 1001) 로 정의한다.

### 3-1. 입력 파싱

```java
for (int i = 0; i < args.length; i++) {
    str += args[i] + " ";
}
str = str.replace("[", "").replace("]", "").replace(",", "");
String[] strings = str.split(" ");
```

- args 순회: **O(n)**
- replace, split: 문자열 길이에 비례 → **O(n)**
- 단, `str += args[i]`는 String 불변 특성으로 인해 실제로는 **O(n²)**

### 3-2. 카운팅 (핵심 연산)

```java
private static int[] countOccurrences(List<Integer> inputs) {
    int[] counts = new int[1001];
    for (int i = 0; i < inputs.size(); i++) {
        counts[inputs.get(i)] += 1;
    }
    return counts;
}
```

- 입력 리스트 순회: **O(n)**
- 각 원소 접근 및 카운트 증가: **O(1)**
- 전체: **O(n)**

### 3-3. 결과 출력

```java
for (int i = 0; i < counted.length; i++) {
    if (counted[i] == 1) {
        System.out.println(i);
    }
}
```

- counted 배열 순회: **O(M)** (M = 1001, 상수이므로 사실상 O(1))

### 3-4. 문제01 전체 시간 복잡도

| 단계 | 시간 복잡도 |
|------|-------------|
| 입력 파싱 (str +=) | O(n²) |
| 카운팅 | O(n) |
| 결과 출력 | O(M) ≈ O(1) |
| **전체** | **O(n²)** |

---

## 4. 문제02 코드의 시간 복잡도 분석

문제02는 입력 문자열을 스택으로 역순 출력하고, 회문 여부를 검사하는 프로그램이다. 입력 문자열의 길이를 n으로 정의한다.

### 4-1. 역순 출력 (핵심 연산)

```java
for (int i = 0; i < str.length(); i++) {
    biodome.push(str.charAt(i));
}
while (!biodome.isEmpty()) {
    result += biodome.pop();
}
```

- push n번: **O(n)**
- pop n번: **O(n)**
- `result += pop()`: String은 불변 객체라 매번 새 문자열 생성 → **O(n²)**
- 전체: **O(n²)**

### 4-2. 회문 검사

```java
for (int i = 0; i < str.length(); i++) {
    this.push(str.charAt(i));       // O(n)
}
for (int i = 0; i < str.length() / 2; i++) {
    compareStack.push(this.pop());  // O(n/2)
}
while (!this.isEmpty() && !compareStack.isEmpty()) {
    char ch1 = this.pop();
    char ch2 = compareStack.pop(); // O(n/2)
}
```

- 전체: **O(n)**

### 4-3. 문제02 전체 시간 복잡도

| 단계 | 시간 복잡도 |
|------|-------------|
| 역순 출력 (push/pop) | O(n) |
| String 문자열 연결 | O(n²) |
| 회문 검사 | O(n) |
| **전체** | **O(n²)** |

---

## 5. 병목 현상 분석 및 최적화 방안

### 5-1. 문제01 병목: 입력 파싱의 String 연결

`str += args[i]`에서 String은 불변 객체이므로 매번 새 문자열을 생성한다. n번 반복하면 O(1 + 2 + ... + n) = **O(n²)** 이 된다.

**최적화 — char 배열 직접 사용:**

```java
// 기존: O(n²)
String str = "";
for (int i = 0; i < args.length; i++) {
    str += args[i] + " ";
}

// 개선: O(n)
char[] buffer = new char[totalLength];
int idx = 0;
for (int i = 0; i < args.length; i++) {
    for (int j = 0; j < args[i].length(); j++) {
        buffer[idx++] = args[i].charAt(j);
    }
    buffer[idx++] = ' ';
}
String str = new String(buffer, 0, idx);
```

### 5-2. 문제02 병목: 역순 문자열 생성의 String 연결

`result += biodome.pop()`에서 동일한 String 불변 문제가 발생한다. 과제 제약상 StringBuilder를 사용할 수 없으므로 char 배열로 대체한다.

**최적화 — char 배열 직접 사용:**

```java
// 기존: O(n²)
String result = "";
while (!biodome.isEmpty()) {
    result += biodome.pop();
}

// 개선: O(n)
char[] resultArr = new char[str.length()];
int idx = 0;
while (!biodome.isEmpty()) {
    resultArr[idx++] = biodome.pop();
}
String result = new String(resultArr);
```

### 5-3. 최적화 전후 비교

| 코드 | 기존 | 최적화 후 |
|------|------|-----------|
| 문제01 입력 파싱 | O(n²) | O(n) |
| 문제02 역순 문자열 생성 | O(n²) | O(n) |
| 문제02 회문 검사 | O(n) | O(n) |
| **문제01 전체** | **O(n²)** | **O(n)** |
| **문제02 전체** | **O(n²)** | **O(n)** |

---

## 참고

- Big O 표기법 시각화: https://www.bigocheatsheet.com