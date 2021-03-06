# MySite

## :wolf: Contents
- 메인 화면
<img width="703" alt="스크린샷 2020-08-15 오전 2 45 06" src="https://user-images.githubusercontent.com/48710171/90277870-56779580-dea1-11ea-9ba1-bd5b203703e7.png">

- 방명록
<img width="701" alt="스크린샷 2020-08-15 오전 2 46 11" src="https://user-images.githubusercontent.com/48710171/90277939-7e66f900-dea1-11ea-940a-d65ebccd30a7.png">

- 게시판
<img width="703" alt="스크린샷 2020-08-15 오전 2 46 45" src="https://user-images.githubusercontent.com/48710171/90278008-9f2f4e80-dea1-11ea-8960-a5596ed21738.png">


## :dromedary_camel: Developer
- [강성호](https://github.com/KANGSUNGHO)

## :baby_chick: Languages & Frameworks 
- JAVA8, Spring 4.3.2, JSP, Eclipse
- css3, jQuery 
- 서버 환경 : tomcat v8.5
- 로컬 DB : mariaDB(MySql)

## :penguin: Environment
- macOS Catalina 10.15.5
- Google Chrome 브라우저에서 개발 및 테스트

## :ox: Copyright
- [참고한 깃허브](https://github.com/gachon-bitacademy/mysite)

# 

# Spring 진도   
  01. Spring 개념
  02. Spring MVC 기본 Annotation 연습
  03. DefaultServlet Handler
  04. View Resolver
  05. Exception Handler

  06. MyBatis
  07. Logging
  08. Intecetor & Annotaion
  09. MultipartResolver
  11. Validation
  12. AOP
  13. Spring Container

  14. Java Config(MySite04, MySite05)
  15. Spring Boot(MySite06)

<hr/> 

* Spring MVC   -> 서비스 웹페이지 (온프레미스(On-premise))
* Spring Boot  -> (서비스 웹페이지, API 서버)(도커, 컨테이너, Cloud, DevOps)

# 

# 스프링 프로젝트 만드는 방법
## 01. Mysite 프로젝트에 mystite03 모듈 생성
* .gitignore 생성(깃에 올릴때 제외할 파일들, 이클립스 프로젝트 설정파일 )
* web.xml(Deployment Descriptor) 생성
* pom.xml 기본 설정
    * Properties 세팅
    * Dependencies 세팅
    * Build 세팅(fileName 수정)
* target runtime (tomcat 설정)	

## 02. Package 만들기

* com.bit2020.mysite.controller
* com.bit2020.mysite.service
* com.bit2020.mysite.repository
* com.bit2020.mysite.vo

## 03. web.xml 설정하기
*	1. ContextLoaderListner 
*	2. CharacterEncodingFilter 
*   3. 	DispatcherServlet 


## 04.  applicationContext.xml 생성
   * component-scan 섹션의 base-package 수정

## 05.  Spring-servlet.xml 생성
   * component-scan 섹션의 base-package 수정


## 06. assets 작업 및 view jsp 작업(화면  디자인 + 퍼블리싱)
   * /WEB-INF/views

## 07. Test : MainController 작성 
