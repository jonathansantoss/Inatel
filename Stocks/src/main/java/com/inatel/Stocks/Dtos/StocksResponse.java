package com.inatel.Stocks.Dtos;

import com.inatel.Stocks.Model.Stocks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StocksResponse {
    private String name;
    private List<QuotesResponse> quotes;

    public static StocksResponse of(Stocks stocks) {
        return StocksResponse.builder()
                .name(stocks.getName())
                .quotes(QuotesResponse.of(stocks.getQuotes()))
                .build();
    }

    public static List<StocksResponse> of(List<Stocks> stocks) {
        return stocks.stream()
                .map(StocksResponse::of)
                .collect(Collectors.toList());
    }
}
