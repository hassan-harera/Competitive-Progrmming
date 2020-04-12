
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class GFG {

    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(1);

        for (int i = 0; i < 10; i++) {
            sum.add(new BigDecimal((int)999999999));
        }
        System.out.println(sum);

    }

}
