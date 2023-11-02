package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecteurActiviteServiceImplTest {

    @Autowired
    SecteurActiviteServiceImpl secteurActiviteService;

    private static Long secteurId;

    @Test
    @Order(1)
    public void findAllSecteurs() {
        List<SecteurActivite> secteurActivites = secteurActiviteService.retrieveAllSecteurActivite();
        Assertions.assertEquals(5, secteurActivites.size());
    }

    @Test
    @Order(2)
    public void addSecteur() {
        SecteurActivite secteur = new SecteurActivite();
        SecteurActivite addedSecteur = secteurActiviteService.addSecteurActivite(secteur);
        secteurId = addedSecteur.getIdSecteurActivite();
        Assertions.assertNotNull(addedSecteur);
        System.out.println("Added Secteur ID: " + secteurId);
    }

    @Test
    @Order(3)
    public void findSecteurById() {
        Assertions.assertNotNull(secteurId);
        SecteurActivite secteur = secteurActiviteService.retrieveSecteurActivite(secteurId);
        Assertions.assertNotNull(secteur);
        Assertions.assertEquals(secteurId, secteur.getIdSecteurActivite());
    }

    @Test
    @Order(4)
    public void updateSecteur() {
        Assertions.assertNotNull(secteurId);
        SecteurActivite secteur = secteurActiviteService.retrieveSecteurActivite(secteurId);
        Assertions.assertNotNull(secteur);

        secteur.setCodeSecteurActivite("Code");
        secteur.setLibelleSecteurActivite("Libelle");

        SecteurActivite updatedSecteur = secteurActiviteService.updateSecteurActivite(secteur);
        Assertions.assertNotNull(updatedSecteur);
        Assertions.assertEquals("Code", updatedSecteur.getCodeSecteurActivite());
        Assertions.assertEquals("Libelle", updatedSecteur.getLibelleSecteurActivite());
    }

    @Test
    @Order(5)
    public void deleteSecteur() {
        Assertions.assertNotNull(secteurId);
         secteurActiviteService.deleteSecteurActivite(secteurId);
        System.out.println("Deleted Secteur ID: " + secteurId);
    }
}
