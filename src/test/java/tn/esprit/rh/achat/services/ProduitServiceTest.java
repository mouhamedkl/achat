package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @InjectMocks
    private ProduitServiceImpl produitService;

    @Mock
    private ProduitRepository produitRepository;

    @Test
    @Order(1)
    public void testRetreiveAllUsers() {
        // Créez un mock de la méthode retrieveAllProduits
        List<Produit> produits = new ArrayList<>();

        // Définissez le comportement du mock lorsque la méthode retrieveAllProduits est appelée
        Mockito.when(produitRepository.findAll()).thenReturn(produits);

        // Appelez la méthode de service que vous testez
        List<Produit> listProduits = produitService.retrieveAllProduits();

        // Assurez-vous que la méthode du service a été appelée
        Mockito.verify(produitRepository).findAll();

        // Effectuez votre assertion
        Assertions.assertEquals(0, listProduits.size());
    }
}
