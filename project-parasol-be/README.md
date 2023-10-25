# project-parasol-be

<img alt="java" src ="https://img.shields.io/badge/java-17.0.1-3776AB.svg?&style=for-the-badge&logo=Java&logoColor=white"/> 
<img alt="maven" src ="https://img.shields.io/badge/maven-3.9.5-3776AB.svg?&style=for-the-badge&logo=maven&logoColor=white"/> 
<img alt="spring" src ="https://img.shields.io/badge/spring-2.7.16-3776AB.svg?&style=for-the-badge&logo=spring&logoColor=white"/>

CSV파일로 저장된 데이터를 api요청에 따라 응답하는 서버입니다. data파일에 주가와 추천도 데이터가 필요합니다.

프로젝트를 빌드하기 위해서는 maven이 필요합니다.

`homebrew` 를 사용한다면 아래의 명령어로 설치할 수 있습니다.

```bash
brew install maven
```

## 프로젝트 실행

### 1. 프로젝트 클론
```bash
git clone <해당 프로젝트 주소>
```

### 2. 프로젝트 클린 및 설치

```basj
mvn clean
mvn install
```

### 3. 프로젝트 실행
```
java -jar ./target/Project-1.0.war
```

### 4. Troubleshooting

#### 4.1. mvn이 설치되지 않는다면

아키텍쳐(arm) 문제로 mvn이 설치되지 않는다면 아래 명령어로 시도해 보세요
```bash
arch -x86_64 brew install mvn
```

#### 4.2. Homebrew를 설치하는 방법

macos에서 패키지 관리자인 `homebrew`를 설치하는 방법은 아래의 명령어를 터미널에 입력하면 됩니다.

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```