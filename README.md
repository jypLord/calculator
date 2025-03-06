## 1. 프로그램 소개
간단한 사칙연산이 가능한 콘솔기반 계산기입니다.

## 2. 사용 설명
실행하여 콘솔에 + - × / 를 사용하여 계산합니다.
'''1 + 2''' 같은 단일 계산 뿐만 아니라
'''1 + 2 - 3 * 4 / 5 ''' 같은 다중 계산도 할 수 있습니다.

다만 아직 다중 계산일 때 곱하기와 나누기를 우선적으로 시행하는 기능은 없습니다.

## 3. 코드 구조

- Main
 
  InputScanner.Class의 유일한 메서드의 실행만 합니다.

- InputScanner

  사용자 입력을 받습니다.

  입력을 숫자와 문자를 구분하여 배열에 담습니다.

  정규식을 통하여 본 클래스에서 유효성을 1차 검증하고

  문자의 유효성을 Enum Command에서 검증합니다.

  유효성 검증이 완료되면 해당 메서드에서
  Calculator.Class 의 계산 메서드를 호출하여 계산합니다.


- Calculator
  - calcurate 메서드
    
     사용자 입력 배열을 입력받고 그 것을 자료형 타입에 맞게 변환하여 배열을 새로 만듭니다.
     
     그 배열의 첫 번째와 두 번째 인덱스를 계산하고, 그 값을 두 번째 인덱스에 저장합니다.

     다시 두 번째 인덱스와 세 번째 인덱스를 계산하는 식으로 LOOP합니다.

  - add, substract, divide, multiply 메서드
 
    사칙연산합니다. 정수형과 실수형을 전부 계산할 수 있습니다.

  - getResult 메서드

    지금까지 계산한 결과를 출력합니다.

  - deletrResult 메서드
 
    저장 된 결과 중 맨 처음 결과를 삭제합니다.

- Command

  ENUM 타입으로 계산기에서 받을 수 있는 모든 문자를 나열합니다

  입력된 문자의 유효성을 검증하며 사칙연산 이외의 커맨드를 실행합니다.

  r 과 d 를 입력하면 아래의 예외를 던집니다.

- CommandLoopException

  커맨드를 입력했을 때 InputScanner의 해당 while루프를 종료하기 위한 예외입니다. 
