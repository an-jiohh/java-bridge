# 미션 - 다리건너기

## 🧑‍💻미션 설명

다리 건너기 게임을 만들어보자

## 절차적 기능 명세

- 다리의 길이를 입력 받는다.
- 이동할 칸을 선택한다.
- 이동할 수 있는 지 확인한다.
- 이동한다. or 게임을 재시작 또는 종료한다.
- 결과를 출력한다.

## 📝기능 명세

- [X] 다리의 길이를 입력받는다.
    - [X] [ERROR] 빈칸이 입력되었을 경우
    - [X] [ERROR] 숫자가 아닐 경우
    - [ ] [ERROR] 다리 길이는 3부터 20 사이의 숫자가 아닐 경우

- [X] 플레이어가 이동할 칸을 입력받는다.
    - [X] [ERROR] 빈칸이 입력되었을 경우
    - [X] [ERROR] U 또는 D가 아닐 경우

- [X] 다리를 생성한다.
    - [X] 랜덤값을 이용해서 다리를 생성한다.

- [X] 플레이어를 다음 칸으로 이동 시킨다.
    - [X] 플레이어가 이동한 다음 칸을 저장한다.
    - [X] 건널수 있는지 없는지를 저장한다.

- [X] 플레이어가 게임을 다시 시도할지 여부를 입력받는다.
    - [X] [ERROR] 빈칸이 입력되었을 경우
    - [X] [ERROR] R 또는 Q가 아닐 경우