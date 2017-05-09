package lzy;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.RoundingMode;

/**
 * https://github.com/JodaOrg/joda-money
 * User: longzhiyou
 * Date: 2017/5/8
 * Time: 14:07
 */
@SpringBootTest
public class JodaMoneyTest {

    @Test
    public void demo(){

        // create a monetary value
        Money money = Money.parse("USD 23.87");

// add another amount with safe double conversion
        CurrencyUnit usd = CurrencyUnit.of("USD");
        money = money.plus(Money.of(usd, 12.43d));

// subtracts an amount in dollars
        money = money.minusMajor(2);

// multiplies by 3.5 with rounding
        money = money.multipliedBy(3.5d, RoundingMode.DOWN);

// compare two amounts
//        boolean bigAmount = money.isGreaterThan(dailyWage);

// convert to GBP using a supplied rate
//        BigDecimal conversionRate = ...;  // obtained from code outside Joda-Money
//        Money moneyGBP = money.convertedTo(CurrencyUnit.GBP, conversionRate, RoundingMode.HALF_EVEN);
//
//// use a BigMoney for more complex calculations where scale matters
//        BigMoney moneyCalc = money.toBigMoney();
    }
}
