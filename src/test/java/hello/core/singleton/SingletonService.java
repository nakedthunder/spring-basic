package hello.core.singleton;

public class SingletonService {

    //자기자신을 내분에 private static 으로 가짐 -> 클래스 레벨의 올라가서 하나만 존재하게 됨
    //내부적으로 실행해서 자기자신을 참조로 넣어놈
    private static final SingletonService instance = new SingletonService();

    // 인스턴스를 참조를 꺼낼 수 있는 방법은 온니 getInstance()
    public static SingletonService getInstance() {
        return instance;
    }
    // 아무리 내부에 감추려고해도 임의로 new로 만들어버림을 방지하기 위해
    //private 생성자 생성을 막아야한다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
