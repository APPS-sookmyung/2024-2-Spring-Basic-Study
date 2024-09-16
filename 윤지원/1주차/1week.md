## 스프링 입문 섹션 1-3

### View 환경설정

- 스프링 부트가 제공하는 Welcome Page 기능
  static/index.html 을 올려두면 Welcome page 기능을 제공한다.
  https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/springboot-features.html#boot-features-spring-mvc-welcome-page

- **thymeleaf** 템플릿 엔진
  - thymeleaf 공식 사이트: https://www.thymeleaf.org/
  - 스프링 공식 튜토리얼: https://spring.io/guides/gs/serving-web-content/
  - 스프링부트 메뉴얼: https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/
    spring-boot-features.html#boot-features-spring-mvc-template-engines
    컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
- 스프링 부트 템플릿엔진 기본 viewName 매핑
  resources:templates/ +{ViewName}+ .html
  참고: spring-boot-devtools 라이브러리를 추가하면, -html 파일을 컴파일만 해주면 서버 재시작
  없이 View 파일 변경이 가능하다.

- 인텔리J 컴파일 방법: 메뉴 build Recompile

### 빌드 &실행
