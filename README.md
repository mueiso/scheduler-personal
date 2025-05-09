# Scheduler-Personal Project
## 프로젝트 소개
간단한 일정 관리 앱 입니다.<br>
일정에 댓글도 달고 상호 소통이 가능하도록 하는 앱을 구현하고자 했습니다.<br>

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

### 유저 도메인
- 유저 생성<br>

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

-----

<br>

## API 동작 맛보기

<br>

📍 유저

* 유저 생성

![Image](https://github.com/user-attachments/assets/6739f2e7-2878-4562-b4cb-979721f180b4)

<br>

-----

<br>

📍 일정

* 일정 생성

![Image](https://github.com/user-attachments/assets/8205fbb7-5fb4-4afc-ab93-403cc4445391)

<br>

* 일정 목록 조회

![Image](https://github.com/user-attachments/assets/a79017db-a9f5-49aa-8e53-34368716ed48)

<br>

* 일정 단건 상세 조회

![Image](https://github.com/user-attachments/assets/5c2015f5-02d9-475a-ae71-d587e242c52b)

<br>

* 일정 수정

![Image](https://github.com/user-attachments/assets/31c5ff9b-b6f3-4a5c-9cb4-69770df4ecff)

<br>

* 일정 삭제

![Image](https://github.com/user-attachments/assets/3ca31938-4f81-4904-b5ae-fca1e6490c02)

<br>

-----

<br>

📍 댓글

* 댓글 생성

![Image](https://github.com/user-attachments/assets/70a14c6e-648e-4191-bd92-6d850850a60c)

<br>

* 댓글 조회

![Image](https://github.com/user-attachments/assets/5fd7a9f8-7624-4c51-9096-202a1c8ba617)

<br>

* 댓글 수정

![Image](https://github.com/user-attachments/assets/d3be5cbb-82c6-4aa5-a843-726beea50885)

<br>

* 댓글 삭제

![Image](https://github.com/user-attachments/assets/c4ecfa71-f663-45ab-8d05-7430ee7c8987)

<br>

-----

<br>

📍 대댓글

* 대댓글 생성

![Image](https://github.com/user-attachments/assets/85821e3f-0fe7-49bf-8247-29cf112f8581)

<br>

* 대댓글 조회

![Image](https://github.com/user-attachments/assets/ef92a264-f370-4da4-bd13-65440b1d49b2)

<br>

* 대댓글 수정

![Image](https://github.com/user-attachments/assets/f8b739cf-145b-4195-80b2-97a26728447f)

<br>

* 대댓글 삭제

![Image](https://github.com/user-attachments/assets/5cb7fb91-aad5-4a8a-ba86-36f80e478022)

-----

<br>

## TroubleShooting

|[🔗TroubleShooting URL](https://velog.io/@jess_kim/%EB%B3%B8-%EC%BA%A0%ED%94%8457%EC%9D%BC%EC%B0%A8)
|:---:|

<br>

<br>
<br>
