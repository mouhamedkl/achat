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
    public void findall() {
        List<SecteurActivite> secteurActivites= secteurActiviteService.retrieveAllSecteurActivite();
        Assertions.assertEquals(2,secteurActivites.size());
    }
    @Test
    @Order(2)
    public void  addsecteur() {
        SecteurActivite secteur = new SecteurActivite();
        SecteurActivite secteurActivites= secteurActiviteService.addSecteurActivite(secteur);
        secteurId = secteurActivites.getIdSecteurActivite();
        Assertions.assertNotNull(secteur);

    }
    @Test
    @Order(3)
    public void  findbyId() {
        Assertions.assertNotNull(secteurActiviteService.retrieveSecteurActivite(Long.valueOf(3)));

    }
    @Test
    @Order(5)
    public void update() {
        // Retrieve a SecteurActivite
        SecteurActivite secteur = secteurActiviteService.retrieveSecteurActivite(Long.valueOf(3));

        // Check if the secteur is not null
        Assertions.assertNotNull(secteur);

        // Make changes to the SecteurActivite
        secteur.setCodeSecteurActivite("Code");
        secteur.setLibelleSecteurActivite("Libelle");

        // Update the SecteurActivite
        SecteurActivite updatedSecteur = secteurActiviteService.updateSecteurActivite(secteur);

        // Check if the updatedSecteur is not null
        Assertions.assertNotNull(updatedSecteur);

        // Optionally, you can further validate if the updates were successful
        Assertions.assertEquals("Code", updatedSecteur.getCodeSecteurActivite());
        Assertions.assertEquals("Libelle", updatedSecteur.getLibelleSecteurActivite());
    }

    @Test
    @Order(4)
    public void  delete() {
        Assertions.assertNotNull(secteurActiviteService.deleteSecteurActivite(secteurId));

    }
}
