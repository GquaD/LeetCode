package LeetCode.medium;

public class Problem1357 {
    //https://leetcode.com/problems/apply-discount-every-n-orders/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/apply-discount-every-n-orders/submissions/829771730/
    //20-30 min
    //Runtime
    //276 ms
    //Beats
    //30.19%
    //Memory
    //127 MB
    //Beats
    //49.6%
    static class Cashier {
        int discountOnEach, numOfBills, discount;
        int[] products, prices;
        public Cashier(int n, int discount, int[] products, int[] prices) {
            discountOnEach = n;
            numOfBills = 0;
            this.discount = discount;
            this.products = products;
            this.prices = prices;
        }

        public double getBill(int[] product, int[] amount) {
            int sum = 0;
            numOfBills++;
            for (int i = 0; i < product.length; i++) {
                int pro = product[i];
                for (int j = 0; j < products.length; j++) {
                    if (pro == products[j]) {
                        sum += prices[j] * amount[i];
                    }
                }
            }
            if (numOfBills % discountOnEach == 0) {
                return sum * ((100 - discount) / 100.0);
            }
            return sum * 1.0;
        }
    }
}
