import LeetCode.easy.Problem169;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Behzod on 13, March, 2021
 */
public class TestMajority {

    @Test
    public void testMajority() {
        int expectedResult = 3;
        int[] nums = {3, 1, 3};

        int result = Problem169.majorityElementWithMap(nums);

        assertEquals(expectedResult, result);
    }
}
