package tn.esprit.rh.achat;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FactureMockTest {

    @Mock
    FactureRepository fr;
    @InjectMocks
    FactureServiceImpl fs;

    Facture o = new Facture(120,1000,false);

    @Test
    @Order(0)
    void TestAddFacture() {
        Facture f = new Facture();
        List<Facture> Factures = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
            f.setIdFacture(i);
            f.setMontantFacture(1500);
            f.setMontantRemise(200);
            f.setArchivee(false);

            Facture fa=fr.save(f);
            Factures.add(fa);
        }
        assertEquals(10,Factures.size());
    }
    @Test
    @Order(3)
    void TestDeleteAllFacture() {
        fr.deleteAll();
        assertEquals(0,fr.findAll().spliterator().estimateSize());
    }
    @Test
    @Order(2)
    void TestRetrieveFacture() {
        Mockito.when(fr.findById(Mockito.anyLong())).thenReturn(Optional.of(o));

        Mockito.when(fr.findById(Mockito.anyLong())).thenReturn(Optional.of(o))
        ;
        Facture op = fs.retrieveFacture(2L);
        Assertions.assertNotNull(op);


    }
    @Test
    @Order(4)
    void TestGetAllFacture(){
        Iterable<Facture> Factures = fr.findAll();
        Assertions.assertNotNull(Factures);
    }

}
