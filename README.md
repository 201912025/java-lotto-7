# 로또

## 기능 요구 사항
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

## 프로그래밍 요구 사항
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
- 값을 하드 코딩하지 않는다
- 변수 이름에 자료형은 사용하지 않는다.
- 클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성한다.

## 구현할 기능 목록

### 1. 입력
- 로또 구입 금액 입력 받기
    - 1,000원 단위로 입력 받음
    - 1,000원 단위 아닐 시 예외 처리
    - 양수 아닐 시 예외 처리
- 당첨 번호 입력 받기
  - 당첨 번호는 "','"를 기준으로 구분
  - 기호 "','"이외 입력시 예외 처리
  - 1~45 사이의 정수 이외 입력시 예외 처리
  - 중복된 번호 입력시 예외 처리
  - 당첨 번호 6개 아닐시 예외 처리
- 보너스 번호 입력 받기
  - 1~45 사이의 정수를 하나 입력 받음
  - 1~45 사이의 정수 아닐 시 예외 처리

### 2. 출력
- 구매한 개수와 구매한 개수만큼 로또 번호 오름차순으로 정렬 후 출력
- 당첨 내역 출력
- 총 수익률 출력

### 3. 로또 번호 생성
- 구입금액을 1,000으로 나눠 로또 구입 개수 생성 하는 기능
- 로또 구입 개수만큼 로또 번호 생성 후 정렬

### 4. 로또 당첨 확인
- 입력 받은 당첨 번호 문자열 ,구분자 제거 기능
- 구분자 제거 문자열 정수형 리스트로 변환 기능 
- 구분자 제거된 정수형 리스트인 당첨 번호로 각 로또 비교후 같은 개수 계산 기능
- 입력 받은 보너스 번호 문자열 정수형으로 변환 기능
- 변환된 정수형 보너스 번호로 각 로또 비교후 같은 개수 계산 기능
- 같은 개수 별로 당첨 통계 계산 기능

### 5. 수익률 계산
- 총 당첨 금액 합 계산
- 총 당청 금액을 로또 구입 금액을 나눠 수익률 게산 

