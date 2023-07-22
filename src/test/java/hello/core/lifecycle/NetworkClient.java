package hello.core.lifecycle;

public class NetworkClient {

    // Mockup 로그 출력용

    private String url;

    // default 생성자
    public NetworkClient() {
        System.out.println("생성자 호출 시, url = " + url);
        // 객체 생성할때 connect , call
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url );
    }
}
