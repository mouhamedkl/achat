package tn.esprit.rh.achat.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
 class ProduitServiceImplTest {

    @Mock
    ProduitRepository ProduitRepo;

    @InjectMocks
    ProduitServiceImpl ProduitService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduit() {
        Produit s = new Produit("produit test", 10, "100f");
        Produit savedProduit = ProduitService.addProduit(s);
        assertNotNull(savedProduit.getLibelleProduit());
        ProduitService.deleteProduit(savedProduit.getIdProduit());
    }

    @Test
    public void testGetAllProduit() {
        List<Produit> toDoList = new ArrayList<Produit>();
        toDoList.add(new Produit("produit test2", 101, "100f7"));
        toDoList.add(new Produit("produit test3", 102, "100f6"));
        toDoList.add(new Produit("produit test4", 104, "100fd"));
        when(ProduitRepo.findAll()).thenReturn(toDoList);

        List<Produit> result = ProduitService.retrieveAllProduits();
        assertEquals(3, result.size());
    }

    @Test
    public void testDeleteProduit() {
        Produit s = new Produit("produit test2", 101, "100f7");
        Produit savedProduit = ProduitService.addProduit(s);
        ProduitService.deleteProduit(savedProduit.getIdProduit());
        assertNull(ProduitService.retrieveProduit(savedProduit.getIdProduit()));
    }
}
