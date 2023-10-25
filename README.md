# 심층 강화학습을 이용한 주식투자 전략 개발

## 프로젝트 소개

강화학습을 수행하여, 모델을 생성, 평가하여 가장 적합한 매개변수를 판별해 가장 적합한 모델을 개발한다. 강화학습 모델의 결과를 웹으로 제공함으로 써 투자자에게 가치 있는 의사 결정 도구를 제공하는데 기여하고자
한다.

### 프로젝트 구조

```
├── README.md
├── docs
├── project-parasol-be
├── project-parasol-crawl-rl
└── project-parasol-FE
```

`docs` 졸업과제 제출물들이 저장되어 있습니다.

`project-parasol-be` 프로젝트의 Backend 서버입니다.

`project-parasol-crawl-rl` 프로젝트의 강화학습 모델을 생성하는 파이썬 코드입니다.

`project-parasol-FE` 프로젝트의 Frontend 웹 어플리케이션입니다.

## 팀 소개

|        | 박동진                                                     | 정희영                                               | 신재환                           |
|--------|---------------------------------------------------------|-----------------------------------------------------|-------------------------------|
| e-mail | ehdwls1638@pusan.ac.kr                                  | h2young5618@pusan.ac.kr                             | jhjh307@naver.com             |
| github | https://github.com/minmunui                             | https://github.com/h2-young                         |                               |
| role   | - 전체적인 프로젝트 구상 <br> - 프론트앤드 개발 <br>- 강화학습 에이전트 학습 환경 개발 | - 강화학습 에이전트 학습 <br> - 하이퍼파라미터 튜닝 <br>- 전체적인 강화학습 파트 구상 | - 백앤드 개발<br>- 강화학습을 위한 데이터 수집 |


## 구성도

<img width="506" alt="image" src="https://github.com/pnucse-capstone/capstone-2023-1-30/assets/82745129/b4a032eb-54f3-483c-bb84-57a12556abfd">

## 소개 및 시연 영상

## 사용법

### 원본 Repository

각 기능별 디렉토리 내부의 `README.md` 파일을 참고하세요.

### 1. 프로젝트 클론

해당 레포지토리를 클론합니다.

안정적인 진행을 위해서는 모든 레포지터리를 각각 클론하여 작업을 진행하는 것을 추천합니다.
각 저장소 별 README.md를 참고하세요.

아래는 각 저장소의 주소입니다. 순서대로 클룬 및 작업을 진행하세요.

Reinforcement Learning : https://github.com/minmunui/project-parasol-crawl-rl

Back-End : https://github.com/minmunui/project-parasol-be

Front-End : https://github.com/minmunui/project-parasol-FE.git

```bash
git clone <해당 프로젝트 주소>
```

### 2. 크롤링, 강화학습 수행을 통한 예측 결과 생성

이 과정은 `project-parasol-crawl-rl` 프로젝트를 참고하세요.

예측결과 CSV파일은 `[종목코드]_[사용알고리즘].csv` 형식으로 `./project-parasol-be/data` 디렉토리에 저장되어야 합니다.

### 3. 백앤드 프로젝트 실행

이 과정은 `project-parasol-be` 프로젝트를 참고하세요.

### 4. 프론트앤드 프로젝트 실행

이 과정은 `project-parasol-FE` 프로젝트를 참고하세요.
웹 페이지가 실행되면 결과를 확인할 수 있습니다.
