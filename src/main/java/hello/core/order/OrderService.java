package hello.core.order;

public interface OrderService {

    // 주문생성시 memberId, itemName, itemPrice
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
