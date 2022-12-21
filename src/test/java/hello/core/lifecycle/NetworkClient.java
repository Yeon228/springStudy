package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
// InitializingBean, DisposableBean (초기화, 소멸) 인터페이스는 전적으로 스프링에 의존하는 단점 있음
// 메서드 이름 변경이 불가능함. 지금은 거의 사용 x
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }
    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    //의존관계 주입이 끝나면 호출되는 메서드
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    //빈 삭제시 호출되는 메서드@Override
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
