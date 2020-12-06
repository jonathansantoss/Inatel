package com.inatel.Stocks.Controller;

import com.inatel.Stocks.Dtos.StocksRequest;
import com.inatel.Stocks.Dtos.StocksResponse;
import com.inatel.Stocks.Service.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("stocks")
public class StocksController {

    @Autowired
    private StocksService service;

    @GetMapping
    public List<StocksResponse> getAllStocks() {
        return service.getAllStocks();
    }

    @PostMapping
    public void insert(@RequestBody StocksRequest stocksRequest) {
        service.save(stocksRequest);
    }

    @PutMapping("/id/{id}")
    public void update(@RequestParam Long id, @RequestBody StocksRequest stocksRequest) {
        service.update(id, stocksRequest);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
