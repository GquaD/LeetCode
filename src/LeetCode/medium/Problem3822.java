package LeetCode.medium;

public class Problem3822 {
    //5min
    //Runtime
    //207
    //ms
    //Beats
    //11.88%
    //Analyze Complexity
    //Memory
    //69.08
    //MB
    //Beats
    //54.46%
    //Analyze Complexity


    //class OrderManagementSystem {
    //
    //    Map<Integer, Order> map;
    //
    //    public OrderManagementSystem() {
    //        map = new HashMap<>();
    //    }
    //
    //    public void addOrder(int orderId, String orderType, int price) {
    //        Order order = new Order(orderId, price, orderType);
    //        map.put(orderRuntime
    //207
    //ms
    //Beats
    //11.88%
    //Analyze Complexity
    //Memory
    //69.08
    //MB
    //Beats
    //54.46%
    //Analyze ComplexityId, order);
    //    }
    //
    //    public void modifyOrder(int orderId, int newPrice) {
    //        map.get(orderId).price = newPrice;
    //    }
    //
    //    public void cancelOrder(int orderId) {
    //        map.get(orderId).isActive = false;
    //    }
    //
    //    public int[] getOrdersAtPrice(String orderType, int price) {
    //        List<Integer> list = map.values().stream().filter(o -> o.isActive && orderType.equals(o.orderType) && price == o.price).map(o -> o.orderId).collect(Collectors.toList());
    //
    //        int[] result = new int[list.size()];
    //        for (int i = 0; i < result.length; i++) {
    //            result[i] = list.get(i);
    //        }
    //
    //        return result;
    //    }
    //
    //
    //}
    //
    //class Order {
    //    int orderId, price;
    //    String orderType;
    //    boolean isActive;
    //
    //    public  Order(int id, int p, String type) {
    //        orderId = id;
    //        price = p;
    //        this.orderType = type;
    //        isActive = true;
    //    }
    //}
    //
    ///**
    // * Your OrderManagementSystem object will be instantiated and called as such:
    // * OrderManagementSystem obj = new OrderManagementSystem();
    // * obj.addOrder(orderId,orderType,price);
    // * obj.modifyOrder(orderId,newPrice);
    // * obj.cancelOrder(orderId);
    // * int[] param_4 = obj.getOrdersAtPrice(orderType,price);
    // */
}
