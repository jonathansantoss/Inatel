package com.inatel.Stocks.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StocksRequest {
    private String name;
    private List<QuotesRequest> quotes;
}
