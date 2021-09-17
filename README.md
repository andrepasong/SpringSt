## 스프링부트 AWS 혼자 구현 책 실습


jdbc:h2:~/test

------------------------
org.junit.platform.launcher.core.EngineDiscoveryOrchestrator lambda$logTestDescriptorExclusionReasons$7
정보: 0 containers and 6 tests were Method or class mismatch
원인 : Test 메서드를 여러개 작성하고 하나만 실행하면 나오는 에러
해결 방법 : 테스트 메서드 실행시 주석처리 후 실행할 메서드만 주석 해제하여 실행


------------------------

### TODO
- 스프링 & 오라클 연동
- 스프링에서 프로시저 호출 테스트


- 도커 설치 후 실제 서버 환경테스트