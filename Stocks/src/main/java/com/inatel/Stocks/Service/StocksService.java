package com.inatel.Stocks.Service;

import com.inatel.Stocks.Dtos.StocksRequest;
import com.inatel.Stocks.Dtos.StocksResponse;
import com.inatel.Stocks.Model.Quotes;
import com.inatel.Stocks.Model.Stocks;
import com.inatel.Stocks.Repository.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StocksService {

    @Autowired
    private StocksRepository repository;

    public List<StocksResponse> getAllStocks() {
        return StocksResponse.of((List<Stocks>) repository.findAll());
    }

    public void save(StocksRequest request) {
        repository.save(Stocks.of(request));
    }

    public void update(Long id, StocksRequest request) {
        var stock = repository.findById(id)
                .orElse(null);

        assert stock != null;

        stock.setName(request.getName());
        stock.setQuotes(Quotes.of(request.getQuotes()));
        repository.save(stock);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}