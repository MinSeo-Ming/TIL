package hello.core.order;

public interface OrderService {
    Order crateOrder(Long memberId, String itemName,int itemPrice);
}
