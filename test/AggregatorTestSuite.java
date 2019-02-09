import com.ag.aggregator.CreditRatingAverageAggregator;
import com.ag.aggregator.IAggregator;
import com.ag.config.ExchangeRatesHolder;
import com.ag.data.CreditData;
import com.ag.data.GroupingKey;
import com.ag.load.DelimitedFileLoader;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.ag.config.FileConfig.CREDIT_DATA_FILE;

public class AggregatorTestSuite extends TestCase {

    private ExchangeRatesHolder exchangeRatesHolder;

    @Before
    public void setup() throws IOException {

    }

    @Test
    public void testFileDataLoad() throws IOException {
        DelimitedFileLoader<CreditData> dataFileLoader = new DelimitedFileLoader<>(CREDIT_DATA_FILE.getFilePath());
        List<CreditData> creditDataList = dataFileLoader.loadData(CreditData.mapToCreditData);

        assertEquals(19, creditDataList.size());

    }

    @Test
    public void testCreditDataAggregator() throws IOException {
        DelimitedFileLoader<CreditData> dataFileLoader = new DelimitedFileLoader<>(CREDIT_DATA_FILE.getFilePath());
        List<CreditData> creditDataList = dataFileLoader.loadData(CreditData.mapToCreditData);

        IAggregator<GroupingKey, Double, CreditData> creditRatingAggregator = new CreditRatingAverageAggregator();

        Map<GroupingKey, Double> result = creditRatingAggregator.compute(creditDataList);

        assertFalse(result.isEmpty());

    }
}
