# Untitled_01_BE




## 1. Getting Started

### 1-1. Requirements

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

### 1-2. Configure

* Create a `application-local.yml` file from the environment template file `application-example.yml`
  * location : `src/main/resources/application-local.yml` 

### 1-3. Running

```bash
git clone https://github.com/megymj/Untitled_01_BE.git
cd Untitled_01_BE
chmod +x ./gradlew
./gradlew bootRun
```

Open [http://localhost:8080](http://localhost:8080) with your browser to see the result.



## 2. Commit Convention
**범위 (Scope)**

- 선택적입니다. 변경이 발생한 모듈이나 컴포넌트를 나타냅니다. 예: `auth`, `api`, `ui`, `frontend`, `backend`.

**제목 (Subject)**

- 첫 글자는 대문자로 작성합니다.
- 50자 이내로 작성합니다.
- 명령형 동사로 시작합니다 (예: "Add", "Fix", "Update").

**본문 (Body)**

- 선택적입니다.
- 변경 이유와 방법에 대해 설명합니다.
- 72자 이내로 줄을 나누어 작성합니다.

**푸터 (Footer)**

- 선택적입니다.
- 이슈가 연결된 경우 `Closes #이슈번호` 형식으로 작성합니다.

```markdown
feat(auth): Add user registration feature

- 사용자가 이메일과 비밀번호로 등록할 수 있는 기능 추가
- 이메일 형식 검증 로직 추가
- 등록 완료 후 로그인 페이지로 리다이렉트

Closes #45
```

| 태그이름   | 내용                                                         |
| ---------- | ------------------------------------------------------------ |
| `feat`     | 새로운 기능 추가                                             |
| `fix`      | 버그 수정                                                    |
| `docs`     | 문서 수정 (README, API 문서 등)                              |
| `style`    | 코드 포맷팅, 세미콜론 누락 등 비즈니스 로직에 영향을 미치지 않는 수정 |
| `refactor` | 코드 리팩토링 (기능 변경 없이 코드 구조 개선)                |
| `comment`  | 필요한 주석 추가 및 변경                                     |
| `test`     | 테스트 추가 또는 기존 테스트 수정                            |
| `chore`    | 빌드 작업, 패키지 매니저 설정, 기타 잡무 (비즈니스 로직에 영향 없음) |
| `rename`   | 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우           |
| `ci/cd`    | CI/CD 관련 작업 (예: GitHub Actions, Travis CI 설정 등)      |
