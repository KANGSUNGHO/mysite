# 메인
<img width="702" alt="스크린샷 2020-08-15 오전 2 11 50" src="https://user-images.githubusercontent.com/48710171/90275116-bcade980-de9c-11ea-99f0-107af5de6475.png">

# 방명록
<img width="699" alt="스크린샷 2020-08-15 오전 2 09 11" src="https://user-images.githubusercontent.com/48710171/90274971-7c4e6b80-de9c-11ea-851b-8074c5512280.png">

# 게시판
<img width="703" alt="스크린샷 2020-08-15 오전 2 14 22" src="https://user-images.githubusercontent.com/48710171/90275327-0eef0a80-de9d-11ea-8240-0738ae2a6f95.png">

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
