[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/fnZ3vxy8)

# 심층 강화학습을 이용한 주식투자 전략 개발

## 프로젝트 소개

### 프로젝트 목표
강화학습을 수행하여, 모델을 생성, 평가하여 가장 적합한 매개변수를 판별해 가장 적합한 모델을 개발한다. 강화학습 모델의 결과를 웹으로 제공함으로 써 투자자에게 가치 있는 의사 결정 도구를 제공하는데 기여하고자 한다.
### 원본 Repository
Front-End : https://github.com/minmunui/project-parasol-FE.git
Reinforcement Learning : https://github.com/minmunui/project-parasol-crawl-rl
Back-End : https://github.com/minmunui/project-parasol-be
## 팀 소개
### 박동진
- 전체적인 프로젝트 구상
- 프론트앤드 개발
- 강화학습 에이전트 학습 환경 개발
### 정희영
- 강화학습 에이전트 학습
- 하이퍼파라미터 튜닝
- 전체적인 강화학습 파트 구상
### 신재환
- 백앤드 개발
- 강화학습을 위한 데이터 수집
## 구성도

## 소개 및 시연 영상

## 사용법

각 기능별 디렉토리 내부의 `README.md` 파일을 참고하세요.
### 1. 프로젝트 클론

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