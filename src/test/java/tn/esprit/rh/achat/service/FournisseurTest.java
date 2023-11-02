package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.*;

@ExtendWith(MockitoExtension.class)
 class FournisseurTest {
    @Mock
    FournisseurRepository fournisseurRepository;
    @InjectMocks
    FournisseurServiceImpl fournisseurService;
    Fournisseur f=new Fournisseur("fournisseur0","libelle",CategorieFournisseur.ORDINAIRE);


    List<Fournisseur> fournisseurList = new ArrayList<>(Arrays.asList(
            new Fournisseur("fournisseur1", "libelle", CategorieFournisseur.ORDINAIRE),
            new Fournisseur("fournisseur2", "libelle", CategorieFournisseur.ORDINAIRE),
            new Fournisseur("fournisseur3", "libelle", CategorieFournisseur.ORDINAIRE)
    ));

    @Test
     void testRetrieveFournisseur() {
    Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
    Fournisseur f1 = fournisseurService.retrieveFournisseur(1L);
    Assertions.assertNotNull(f1);
}

    @Test
     void testRetrieveAllFournisseurs() {
        Mockito.when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
        List<Fournisseur> fournisseurListTest = fournisseurService.retrieveAllFournisseurs();
        Assertions.assertNotNull(fournisseurListTest);
        Assertions.assertEquals(3, fournisseurList.size());

    }

    @Test
     void testAddFournisseurs() {
        Mockito.when(fournisseurRepository.save(f)).thenReturn(f);
        Fournisseur fournisseur = fournisseurService.addFournisseur(f);
        Assertions.assertNotNull(fournisseur);
    }









}
