## 스프링 입문편 section7 1~4

## 강의 내용 정리

멤버리포지토리를 메모리에 저장하는 방식: 서버 재가동 시 데이터가 날아감 -> DB에 저장하자(h2 데이터베이스 설치)

순수 jdbc: Java 환경에서 DB에 접근하기 위한 표준 API인데 이제는 고대의 방식이다.
MemberRepository 인터페이스를 확장해서 새로운 JdbcMemeberRepository 클래스를 만들고 @Configuration만 수정함. 객체 지향하여 다형성 활용을 아주 편리하게 지원해줌

개방-폐쇄 원칙(OCP, Open-CLosed Principle): 확장에는 열려있고, 수정에는 닫혀있다.

스프링의 DI(Dependecies Injection)을 사용하면 "기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경" 할 수 있다.
기존에는 Repository가 메모리였음. 이제는 DB와 연동하여 데이터를 DB에 저장. 꺼내올 때에도 DB에서 꺼내옴.
결국 서버는 클라이언트에서 요청을 받아 DB에 접근해서 데이터를 가져오고 그 데이터를 이용한 로직을 통해 클라이언트에게 제공하는 식
Repository는 그 요청을 기반으로 DB에 접근하는 역할

스프링 통합 테스트
@SpringBootTest : 스프링을 띄운다. 스프링 컨테이너와 테스트를 함께 실행
@Transactional : 하나하나 트랜젝션 시작, 테스트 하나 실행, 롤백 -> 다음 테스트에 영향을 주지않기 위해

스프링 JdbcTemplate
순수 Jdbc와 동일한 환경설정
JdbcTemplate은 spring-jdbc 라이브러리에 포함 스프링으로 JDBC를 사용할 때 기본으로 사용되는 라이브러리 별도의 복잡한 설정 없이 바로 사용
JDBC를 직접 사용할 때 발생하는 대부분의 반복 작업을 대신 처리
