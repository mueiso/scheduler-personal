# Scheduler-Personal Project
## 프로젝트 소개
간단한 일정 관리 앱 입니다.<br>
일정에 댓글도 달고 상호 소통이 가능하도록 하는 앱을 구현하고자 했습니다.

<br>

-----

<br>

## ERD
![Image](https://github.com/user-attachments/assets/ba6b90a0-e93f-44a1-be81-eb5040466a42)
|:---:|

<br>

-----

<br>

## API 명세서
|[🔗API URL](https://www.notion.so/teamsparta/API-ERD-1e62dc3ef51481bf920bcf6fd64be831)

|:---:|

<br>

-----

<br>

## 기능 소개

### 일정 도메인
- 일정 생성, 일정 목록 조회, 일정 단건 상세 조회, 일정 수정, 일정 삭제<br>

### 댓글 도메인
- 댓글 생성, 댓글 수정, 댓글 삭제<br>

### 대댓글 도메인
- 댓글에 대한 답글 생성, 답글 조회, 답글 수정, 답글 삭제<br>

<br>

-----

<br>

## 기술 스택
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> 

<br>

-----

<br>

## 프로젝트 구조
```bas      
📁 OutsourcingProject
            └─ common
                   ├─dto
                   ├─entity
                   ├─enums
                   ├─exception
                   ├─util
            └─ domain
                   ├─comment
                   │  └─controller, dto, entity, repository, service
                   ├─reply
                   │  └─controller, dto, entity, repository, service
                   ├─schedule
                   │  └─controller, dto, entity, repository, service
                   └─user
                      └─controller, dto, entity, repository, service
```

<br>
<br>
