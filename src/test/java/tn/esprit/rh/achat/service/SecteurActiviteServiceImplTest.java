package tn.esprit.rh.achat.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.*;

@ExtendWith(MockitoExtension.class)
class SecteurActiviteServiceImplTest {
    @Mock
    SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteService;

    SecteurActivite f = new SecteurActivite(1L, "fournisseur0", "libelle");

    List<SecteurActivite> activites = new ArrayList<>(Arrays.asList(
            new SecteurActivite(1L, "fournisseur0", "libelle"),
            new SecteurActivite(2L, "fournisseur0", "libelle"),
            new SecteurActivite(3L, "fournisseur0", "libelle")
    ));

    @Test
    void testRetrieveSecteurActivite() {
        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
        SecteurActivite f1 = secteurActiviteService.retrieveSecteurActivite(1L);
        Assertions.assertNotNull(f1);
    }

    @Test
    void testRetrieveAllSecteurActivite() {
        Mockito.when(secteurActiviteRepository.findAll()).thenReturn(activites);
        List<SecteurActivite> retrieveAllSecteurActivite = secteurActiviteService.retrieveAllSecteurActivite();
        Assertions.assertNotNull(retrieveAllSecteurActivite);
        Assertions.assertEquals(3, retrieveAllSecteurActivite.size());
    }

    @Test
    void testAddSecteurActivite() {
        Mockito.when(secteurActiviteRepository.save(f)).thenReturn(f);
        SecteurActivite secteurActivite = secteurActiviteService.addSecteurActivite(f);
        Assertions.assertNotNull(secteurActivite);
    }

    @Test
    void testUpdateSecteurActivite() {
        // Mock an updated object
        SecteurActivite updatedSecteur = new SecteurActivite(1L, "updatetest", "updatedLibelle");

        Mockito.when(secteurActiviteRepository.save(updatedSecteur)).thenReturn(updatedSecteur);
        SecteurActivite updated = secteurActiviteService.updateSecteurActivite(updatedSecteur);
        Assertions.assertNotNull(updated);
        Assertions.assertEquals("updatetest", updated.getCodeSecteurActivite());
        Assertions.assertEquals("updatedLibelle", updated.getLibelleSecteurActivite());
    }

    @Test
    void testDeleteSecteurActivite() {
        Mockito.doNothing().when(secteurActiviteRepository).deleteById(1L);
        Object isDeleted = secteurActiviteService.deleteSecteurActivite(1L);
        Assertions.assertNull(isDeleted);
    }
}
