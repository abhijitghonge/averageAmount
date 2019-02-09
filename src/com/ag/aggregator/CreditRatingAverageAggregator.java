package com.ag.aggregator;

import com.ag.data.CreditData;
import com.ag.data.GroupingKey;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreditRatingAverageAggregator implements IAggregator<GroupingKey, Double, CreditData> {


    @Override
    public Map<GroupingKey, Double> compute(List<CreditData> creditDataList) {
        return creditDataList.stream().collect(Collectors.groupingBy(CreditData.groupCreditDataBy,
                Collectors.averagingDouble(CreditData::getAmountInEuros)));

    }
}
