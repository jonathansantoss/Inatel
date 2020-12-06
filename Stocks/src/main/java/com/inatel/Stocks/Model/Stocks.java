package com.inatel.Stocks.Model;

import com.inatel.Stocks.Dtos.StocksRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Stocks {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "SQ_STOCKS", sequenceName = "SQ_STOCKS", allocationSize = 1, initialValue=1)
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany
    @Column(name = "Quotes")
    private List<Quotes> quotes;

    public static Stocks of(StocksRequest request) {
        return Stocks.builder()
                .name(request.getName())
                .quotes(Quotes.of(request.getQuotes()))
                .build();
    }
}
