### 4. 스프링 빈과 의존관계

## 컴포넌트 스캔과 자동 의존관계 설정

- 회원 컨트롤러가 회원 서비스와 회원 리포지토리를 사용할 수 있게 의존관계를 준비. service- controller
- controller에서 서버 요청을 받고, services 에서 비지니스 로직을 수행, repository 에 데이터 저장
- DI (Dependency Injection): 객체 의존관계를 외부에서 주입하는 방식.
- 오류 발생: memberService가 스프링 빈으로 등록되지 않음.

### 스프링 빈 등록 방법

1. 컴포넌트 스캔과 자동 의존관계 설정

- @Component 애노테이션 방식 : component scan
- 있으면 스프링 빈으로 자동 등록.
- @Controller, @Service, @Repository 애노테이션도 포함.
- 서비스, 컨트롤러, 레포지토리 파일 안에 들어가면 @component 등록 되어 있음
- spring 은 애노테이션이 있으면 전부 컨테이너에 등록 = 자동 의존관계
- Q: 다른 패키지들은 스프링 빈으로 등록이 안 됨 = 컴포넌스 스캔이 안 됨
- 스프링 빈 등록할 때 싱글 톤으로 , 유일하게 한 개만 등록하여 공유한다. 같은 스프링 빈이면 같은 인스턴스이다.
- 웬만하면 single tone 으로 한다.

2. 자바 코드로 직접 스프링 빈 등록하기

- @Service, @Repository, @Autowired 애노테이션을 제거하고 자바 코드로 설정.

- 싱글톤: 스프링 컨테이너에 기본으로 하나만 등록되어 공유됨.
- DI 방법: 필드 주입, setter 주입, 생성자 주입 **(생성자 주입 권장).**

  - 생성자 주입: 생성자를 통해 memberservice 가 membercontroller에 들어오는 방법
  - 필드 주입 : 생성자를 빼고 field 에다 autowired. 하지만 필드 주입은 바꿀수있는 방법이 아예 없음
  - setter 주입 : setter 에다 autowired 넣어주고, 생성은 생성대로, setter는 나중에 호출됨. 예전엔 setter injection 많이 했었음. 하지만 누군가 membercontroller 을 호출했을때 열려있어야 함. public하게 노출 되기 때문에, 비추.

            > : 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.

            > 그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 _( 메모리 멤버 리포지토리를 바꿀 때, 기존 멤버 서비스나 나머지 코드 변경 없이 바꿔치기 할 수 있음 - 구현체 바꿔치기. )_ => **설정**을 통해 스프링 빈으로 등록한다.

            > : @Autowired 를 통한 DI는 helloController , memberService 등과 같이 스프링이 관리하는 객체에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체 (new) 에서는 동작하지 않는다. autowired 가 동작하지 않음.
