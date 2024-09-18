## 스프링 입문편 section1~3

## 강의 내용 정리

view 환경설정: 컨트롤러에서 리턴값으로 문자를 반환하면 viewResolver 에서 스프링이 templates/hello.html를 찾아서 타임리프 템플릿 엔진처리->웹브라우저로 반환
model(data:hello!!)=={데이터에 저장된 값==hello!!}

정적 컨텐츠: 클라이언트의 요청을 받고 서버에 미리 저장된 HTML, CSS, JS 등의 파일을 그대로 응답해 보여줌

동적 컨텐츠:
MVC( Model, View, Controller): 클라이언트가 서버에 웹 문서를 요청할 경우, HTML을 동적으로 바꾸어 응답
localhost:8080/hello-mvc?name=spring 에서 데이터 ${name} 에 모델 spring을 대입해줌(쿼리 파라미터)

API: JSON방식
문자반환: Body에 데이터를 그대로 직접 넣음
객체반환: return hello; -->문자가 아닌 객체를 반환. 스프링에서 json스타일로 데이터를 만들어서 html응답에 반환
{key: value}의 구조 이때 key가 private로 정의된다면(외부에서 데이터에 접근하지 않도록) getset메소드를 공개, 이용하여 데이터에 접근하도록 유도

참고
@ResponseBody 를 사용
HTTP의 BODY에 문자 내용을 직접 반환.
viewResolver 대신에 HttpMessageConverter 가 동작.
기본 문자처리: StringHttpMessageConverter
기본 객체처리: MappingJackson2HttpMessageConverter
byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음

## 컨트롤러역할

클라이언트의 요청(Request)에 대한 응답(Response)를 수행하는 역할을 전담
내부가 어떻게 돌아가는지는 컨트롤러에게 있어서는 상관이 없고, 어떤 요청이 들어왔는지, 그래서 어떤 결과가 튀어나왔는지만 보여주는 역할을 함

## localhost:8080 의 뜻

현재 본인 컴퓨터의 포트번호
웹 서버는 클라이언트의 요청을 처리할때 데이터를 어떤 프로그램이 사용할지 구분하기 위한 포트라는 개념을 사용. 데이터흐름을 구분.
기본적으로 HTTP 서버는 80번 포트를 사용하지만, 8080은 테스트나 개발 중인 웹 애플리케이션이 실행되는 포트를 나타냄
