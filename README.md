<details>
<summary> 2주차 추가 (프로그래밍 요구사항2) 정리 </summary>

### 2주차 추가 (프로그래밍 요구사항2)

- 일급 콜렉션을 활용해 구현한다.
- 모든 원시값과 문자열을 포장한다.

### 원시값 포장 이란

- 원시 유형의 값(변수명)을 이용해 의미를 나타내지 않고, 의미있는 객체로 포장한다는 개념

### 일급 콜렉션 이란

- 콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다.
- 각 콜렉션은 그 자체로 포장돼 있으므로 이제 콜렉션과 관련된 동작은 근거지가 마련된셈이다.
- 필터가 이 새 클래스의 일부가 됨을 알 수 있다.
- 필터는 또한 스스로 함수 객체가 될 수 있다.
- 또한 새 클래스는 두 그룹을 같이 묶는다든가 그룹의 각 원소에 규칙을 적용하는 등의 동작을 처리할 수 있다.
- 이는 인스턴스 변수에 대한 규칙의 확실한 확장이지만 그 자체를 위해서도 중요하다.
- 많은 동작이 있지만 후임 프로그래머나 유지보수 담당자에 의미적 의도나 단초는 거의 없다. - 소트웍스 앤솔로지

</details>

<details>
<summary> 1주차 피드백 정리 </summary>

> 1주차 피드백 지키도록 노력하기  
> 커밋전 항상 아래 내용을 상기 시키며 커밋하도록 노력한다.

1. 프로그램 요구사항 미반영 검토하기 -> 모든 사항을 지킬 수 있도록 꼼꼼하게 프로그래밍하자!
2. RuntimeException 보다는 Exception 을 구체화 시켜 예외상황을 명확하게 정의하자.
3. 이름을 통해 의도를 드러내라. (불용어(Info, Data, a, an, the)를 추가하는 방식은 적절하지 못하다.)
4. 축약하지 마라. (의미를 들어낼 수 있다면 이름은 길어져도 괜찮다)
5. 개발 도구의 code format 기능을 활용
6. space(공백)도 convention 이다.
7. 불필요하게 공백 라인을 만들지 않는다.
8. 구현 순서도 convention 이다.
9. 반복하지 마라.
10. 들여쓰기에 space 와 tab 을 혼용하지 않는다.
11. 의미없는 주석을 달지 않는다. (주석보다는 의미있는 이름을 작성하도록 노력하자!)
12. 값을 하드코딩 하지 마라.(java 상수 개념)
    -> 상수이름은 대문자로 정의한다.
13. git commit 메시지를 의미있게 작성
14. 기능 목록 업데이트 (한번에 완벽하게 작성 보다는, 계속 된 업데이트를 통해 살아있는 문서를 만들도록 노력한다.)
15. 기능 목록 구현을 재검토한다. (너무 상새하게 작성하지 않는다. 기능 정리 정도까지. 예외상황도 기능목록에 정리한다.)
16. READEME.md를 상세히 작성. (READEME 를 통해 어떤 프로젝트이며, 어떤 기능을 담고 있는지 기술한다.)

</details>

# 기능 요구 사항

> 레이싱 게임 규칙 정리

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.

# 기능 설계

--- 

- [X] 자동차 구현
    - [X] 자동차 이름 지정
    - [X] 자동차 이름 5자 초과 실패 테스트
    - [X] 자동차 생성 테스트
    - [X] 자동차 4이상 전진 , 3이하 정지 기능

- [ ] 여러대 자동차 구현
    - [ ] Cars 생성
    - [ ] 자동차 이름 목록을 입력 받고 Cars 생성
    - [ ] Cars 이름예외 실패 테스트

- [ ] 랜덤 숫자 모델 구현

- [ ] 유저입력 프로세스 구현
    - [ ] ","로 구분된 자동차 이름을 받아, List 문자열로 변환 기능
    - [ ] 입력받은 "," 문자열로 여러대 자동차 생성
    - [ ] 시도횟수(숫자) 입력 받기
    - [ ] 시도횟수 문자 입력 실패

- [ ] 여러대 자동차 레이싱 구현
    - [ ] 각각 자동차들 랜덤(0~9) 숫자에 의해 전진 혹은 정지 실행 기능
    - [ ] 레이싱 후 우승자 검출 기능
    - [ ] 다중 우승자 기능

- [ ] 레이싱 서비스 구현(모델 클래스 접근 인터페이스)

- [ ] 레이싱 컨트롤러 구현
    - [ ] 레이싱 시작 사용자 입력 프로세스
    - [ ] 레이싱 진행 기능 구현
    - [ ] 레이싱 종료 구현

