package singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }
    //다른클래스에서 new 사용불가
    private SingletonService(){

    }

    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
