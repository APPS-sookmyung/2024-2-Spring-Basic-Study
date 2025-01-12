package hello.core.order;

public class Order {

    //주문할때 주문서의 결과가 가격, 할인금액을 알려주도록 함 주문이 됐을때 만들어지는 객체
    private Long memberId;
    private String itemName;
    private int discountPrice;
    private int itemPrice;

    public Order(Long memberId, String itemName, int discountPrice, int itemPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.discountPrice = discountPrice;
        this.itemPrice = itemPrice;

    }
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int calculatePrice(){
        return itemPrice-discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", discountPrice=" + discountPrice +
                ", itemPrice=" + itemPrice +
                '}';
    }
}

