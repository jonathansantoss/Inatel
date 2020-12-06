package com.inatel.Stocks.Repository;

import com.inatel.Stocks.Model.Stocks;
import org.springframework.data.repository.CrudRepository;

public interface StocksRepository extends CrudRepository<Stocks, Long> {
}
