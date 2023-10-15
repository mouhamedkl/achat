package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @MockBean
    private StockRepository stockRepository;

    @Test
    public void testRetrieveStock() {
        // Define the behavior of the mock repository
        Mockito.when(stockRepository.findById(1L)).thenReturn(Optional.of(new Stock(1L, "Test Stock", 10, 5)));

        // Call the method you want to test
        Stock stock = stockService.retrieveStock(1L);

        // Perform assertions
        assertNotNull(stock);
        assertEquals("Test Stock", stock.getLibelleStock());
        assertEquals(Integer.valueOf(10), stock.getQte());
        assertEquals(Integer.valueOf(5), stock.getQteMin());
        System.out.println("Retrieve Stock test works !");
    }






//
//        @Mock
//        StockRepository stockRepository;
//
//        @InjectMocks
//        StockServiceImpl stockService;
//
//        Stock stock = new Stock(1L,"stock1", 10, 5);
//
//        List<Stock> stocks = new ArrayList<Stock>() {
//            {
//                add(new Stock(2L ,"stock2", 10, 5));
//                add(new Stock(3L ,"stock3", 20, 10));
//                add(new Stock(4L ,"stock4", 30, 15));
//            }
//        };
//
//        @Test
//        public void testRetrieveUser() {
//
//            Mockito.when(stockRepository.findById(1L)).thenReturn(Optional.of(stock));
//            Stock stock1 = stockService.retrieveStock(1L);
//            Assertions.assertNotNull(stock1);
//            System.out.println(stock1);
//        }
    }


