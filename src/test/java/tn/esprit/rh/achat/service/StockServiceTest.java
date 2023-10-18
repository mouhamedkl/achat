package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {
        Stock stock1 = new Stock(1L, "Stock 1", 100, 10);
        Stock stock2 = new Stock(2L, "Stock 2", 200, 20);
        List<Stock> stocks = List.of(stock1, stock2);

        Mockito.when(stockRepository.findAll()).thenReturn(stocks);

        List<Stock> result = stockService.retrieveAllStocks();

        assertNotNull(result);
        assertEquals(2, result.size());
    }


    @Test
    public void testAddStock() {
        Stock stock = new Stock(1L, "Stock 1", 100, 10);
        Mockito.when(stockRepository.save(stock)).thenReturn(stock);

        Stock result = stockService.addStock(stock);

        assertNotNull(result);
        assertEquals(stock, result);
        System.out.println(stock);
        System.out.println(result);
    }

    @Test
    public void testDeleteStock() {
        Long stockId = 1L;
        stockService.deleteStock(stockId);

        Mockito.verify(stockRepository, Mockito.times(1)).deleteById(stockId);
    }


    @Test
    public void testUpdateStock() {
        Stock stock = new Stock(1L, "Stock 1", 100, 10);
        Mockito.when(stockRepository.save(stock)).thenReturn(stock);

        Stock result = stockService.updateStock(stock);

        assertNotNull(result);
        assertEquals(stock, result);
    }


    @Test
    public void testRetrieveStock() {
        Long stockId = 1L;
        Stock stock = new Stock(stockId, "Stock 1", 100, 10);
        Mockito.when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

        Stock result = stockService.retrieveStock(stockId);

        assertNotNull(result);
        assertEquals(stock, result);
    }

}


