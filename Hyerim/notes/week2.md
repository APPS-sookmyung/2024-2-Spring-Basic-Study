## 스프링 입문편 section4

## 강의 내용 정리

일반적인 웹 애플리케이션 계층 구조
Controller: 웹 요청을 처리
Service: 핵심 비즈니스 로직을 구현
Repository: 데이터베이스에 접근하여 데이터를 저장하고 관리
Domain: 비즈니스 객체를 의미하며, 예제에서는 회원 객체를 나타냄

given-when-then: 테스트 준비-테스트 실행-테스트 검증

@AfterEach : 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다. 이렇게
되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다. @AfterEach 를 사용하면 각 테스트가 종료
될 때 마다 이 기능을 실행한다. 여기서는 메모리 DB에 저장된 데이터를 삭제한다.

@BeforeEach : 각 테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하
고, 의존관계도 새로 맺어준다.
