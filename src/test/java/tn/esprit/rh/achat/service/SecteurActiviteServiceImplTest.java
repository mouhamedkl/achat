package tn.esprit.rh.achat.service;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;

import java.util.Optional;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecteurActiviteServiceImplTest {

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Test
    @Order(1)
    public void testAddSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setLibelleSecteurActivite("testSecteurActivite");

        Mockito.when(secteurActiviteRepository.save(Mockito.any(SecteurActivite.class))).thenReturn(secteurActivite);

        SecteurActivite savedSecteurActivite = secteurActiviteService.addSecteurActivite(secteurActivite);

        Mockito.verify(secteurActiviteRepository, Mockito.times(1)).save(secteurActivite);
        Assertions.assertEquals(secteurActivite, savedSecteurActivite);
    }

    @Test
    @Order(2)
    public void testRetrieveSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setLibelleSecteurActivite("testSecteurActivite");

        Mockito.when(secteurActiviteRepository.findById(1L)).thenReturn(Optional.of(secteurActivite));

        SecteurActivite foundSecteurActivite = secteurActiviteService.retrieveSecteurActivite(1L);

        Mockito.verify(secteurActiviteRepository, Mockito.times(1)).findById(1L);
        Assertions.assertEquals(secteurActivite, foundSecteurActivite);
    }

    @Test
    @Order(3)
    public void testUpdateSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setLibelleSecteurActivite("testSecteurActivite");

        Mockito.when(secteurActiviteRepository.save(Mockito.any(SecteurActivite.class))).thenReturn(secteurActivite);

        SecteurActivite updatedSecteurActivite = secteurActiviteService.updateSecteurActivite(secteurActivite);

        Mockito.verify(secteurActiviteRepository, Mockito.times(1)).save(secteurActivite);
        Assertions.assertEquals(secteurActivite, updatedSecteurActivite);
    }

    @Test
    @Order(4)
    public void testDeleteSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        secteurActivite.setIdSecteurActivite(1L);
        secteurActivite.setLibelleSecteurActivite("testSecteurActivite");

        Mockito.doNothing().when(secteurActiviteRepository).delete(secteurActivite);

        secteurActiviteService.deleteSecteurActivite(1L);

        Mockito.verify(secteurActiviteRepository, Mockito.times(1)).deleteById(1L);
    }
}
