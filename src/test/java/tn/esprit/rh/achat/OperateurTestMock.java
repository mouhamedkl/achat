package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OperateurTestMock {
    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurService;
    Operateur user = new Operateur(1L, "Khammeri","Lina","789");
    ArrayList<Operateur> listOperateurs = new ArrayList<Operateur>() {
        {
            add(new Operateur(2L,"ahmed", "ahmed", "123"));
            add(new Operateur(3L,"khalil", "khalil", "456"));
        }
    };
    @Test
    void testRetrieveOperateur(){
        when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Operateur op1=operateurService.retrieveOperateur(1L);
        assertNotNull(op1);
        System.out.println(op1);
        System.out.println(" testRetrieveOperateur-> MARCHE  !!!!!");
    }
    @Test
    void testAddOperateur(){
        when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Operateur p =operateurService.retrieveOperateur(2L);
        operateurService.addOperateur(p);
        System.out.println(p);
        System.out.println(" testAddOperateur -> test successfull  !!!!!");
    }
    @Test
    void testDeleteOperateur()  {
        Operateur op = new Operateur();
        op.setNom("Khammeri");
        op.setIdOperateur(1L);
        when(operateurRepository.findById(op.getIdOperateur())).thenReturn(Optional.of(op));
        Operateur o = operateurService.retrieveOperateur(1L);
        operateurService.deleteOperateur(o.getIdOperateur());
        verify(operateurRepository).deleteById(o.getIdOperateur());
        System.out.println(op);
        System.out.println("  testDeleteOperateur ->test successfull !!!! ");
    }
    @Test
    void testupdateOperateur( ) {
        when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Operateur pr =operateurService.retrieveOperateur(2L);
        pr.setPassword("333");
        assertThat(pr.getPassword()).isEqualTo("333");
        System.out.println(pr);
        System.out.println("  testupdateOperateur ->test successfull !!!! ");
    }

    @Test
    void  testretrieveAllOperateurs(){
        when(operateurRepository.findAll()).thenReturn(listOperateurs);
        List<Operateur> op =operateurService.retrieveAllOperateurs();
        assertNotNull(op);
        System.out.println(" testretrieveAllOperateurs ->test successfull !!!! ");

    }
}
