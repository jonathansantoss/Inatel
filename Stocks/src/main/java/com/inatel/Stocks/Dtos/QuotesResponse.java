package com.inatel.Stocks.Dtos;

import com.inatel.Stocks.Model.Quotes;
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
public class QuotesResponse {
    private String name;

    public static QuotesResponse of(Quotes quotes) {
        return QuotesResponse.builder()
                .name(quotes.getName())
                .build();
    }

    public static List<QuotesResponse> of(List<Quotes> quotes) {
        return quotes.stream()
                .map(QuotesResponse::of)
                .collect(Collectors.toList());
    }
}
