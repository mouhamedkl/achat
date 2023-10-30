package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit; // Assuming you have a Produit entity
import tn.esprit.rh.achat.repositories.ProduitRepository; // Assuming you have a ProduitRepository
import tn.esprit.rh.achat.services.ProduitServiceImpl; // Assuming you have a ProduitServiceImpl

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Mock
    private ProduitRepository produitRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    public void testRetrieveAllProduits() {
        Produit produit1 = new Produit(1L, "produit1","a" ,100,20/02/2020,20/05/2020); // Adjust fields based on your Produit entity
        Produit produit2 = new Produit(2L, "produit2","a" ,100,20/02/2020,20/05/2020);
        List<Produit> produits = List.of(produit1, produit2);

        Mockito.when(produitRepository.findAll()).thenReturn(produits);

        List<Produit> result = produitService.retrieveAllProduits();

        assertNotNull(result);
        assertEquals(2, result.size());
    }
*/
    @Test
    public void testAddProduit() {
        Produit produit = new Produit(1L, "produit1","a" ,100,20/02/2020,20/05/2020); // Adjust fields based on your Produit entity
        Mockito.when(produitRepository.save(produit)).thenReturn(produit);

        Produit result = produitService.addProduit(produit);

        assertNotNull(result);
        assertEquals(produit, result);
    }

    @Test
    public void testDeleteProduit() {
        Long produitId = 1L;
        produitService.deleteProduit(produitId);

        Mockito.verify(produitRepository, Mockito.times(1)).deleteById(produitId);
    }

    @Test
    public void testUpdateProduit() {
        Produit produit = new Produit(3L, "produit3","a" ,100,20/02/2020,20/05/2020); // Adjust fields based on your Produit entity
        Mockito.when(produitRepository.save(produit)).thenReturn(produit);

        Produit result = produitService.updateProduit(produit);

        assertNotNull(result);
        assertEquals(produit, result);
    }

    @Test
    public void testRetrieveProduit() {
        Long produitId = 1L;
        Produit produit = new Produit(1L, "produit1","a" ,100,20/02/2020,20/05/2020); // Adjust fields based on your Produit entity
        Mockito.when(produitRepository.findById(produitId)).thenReturn(Optional.of(produit));

        Produit result = produitService.retrieveProduit(produitId);

        assertNotNull(result);
        assertEquals(produit, result);
    }
}
