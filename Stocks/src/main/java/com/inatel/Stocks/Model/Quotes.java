package com.inatel.Stocks.Model;

import com.inatel.Stocks.Dtos.QuotesRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Quotes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "SQ_QUOTES", sequenceName = "SQ_QUOTES", allocationSize = 1, initialValue=1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public static Quotes of(QuotesRequest quotesRequest) {
        return Quotes.builder()
                .name(quotesRequest.getName())
                .build();
    }

    public static List<Quotes> of(List<QuotesRequest> quotesRequests ) {
        return quotesRequests.stream()
                .map(Quotes::of)
                .collect(Collectors.toList());
    }
}
