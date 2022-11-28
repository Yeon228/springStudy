package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    //static으로 하면 runtime 실행 시 클래스 만들어줌
    public static SingletonService getInstance(){
        return instance;
    }
    //생성자를 private으로 해서 자기 자신 외에는 생성 불가
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
