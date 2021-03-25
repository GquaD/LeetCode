package StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Behzod on 21, March, 2021
 */
public class Reduce {
    public static void main(String[] args) {
        ProductInfo info = new ProductInfo("apples", "123", 1.00, 5);
        ProductInfo info2 = new ProductInfo("pear", "345", 2.00, 10);
        ProductInfo info3 = new ProductInfo("banana", "567", 0.33, 20);
        ProductInfo info4 = new ProductInfo("onions", "789", 0.89, 15);

        List<ProductInfo> products = new ArrayList<>(
                Arrays.asList(info, info2, info3, info4)
        );

        System.out.println(products);

        Integer sum = products.stream()
                .map(ProductInfo::getQuantity)
                .reduce(0, (a, b) -> {
                    return a + b;
                });
        System.out.println("sum = " + sum);
    }
}
