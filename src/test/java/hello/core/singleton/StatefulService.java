package hello.core.singleton;

public class StatefulService {

    // 문제발생 : 상태를 유지하는 필드
    //private int price;

    /**
     *
     * @return price
     * 무상태로 만들기
     * 데이터 값을 유지할 필요없이 price 를 넘겨버린다.
     */
    public int order(String name, int price) {
       // this.pirce = price; // 문제발생: 여기가 문제 ! ! !
        return price;
    }

   /* public int getPirce() {
        return pirce;
    }*/


}
