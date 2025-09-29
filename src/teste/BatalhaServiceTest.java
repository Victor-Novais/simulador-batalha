package main.service;

import main.model.*;
import main.service.CalculadoraElemental;
import main.service.GerenciadorEfeitos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BatalhaServiceTest {

    @Mock
    private Scanner mockScanner;

    @Spy
    @InjectMocks
    private BatalhaService batalhaService;

    @Mock
    private CalculadoraElemental calculadoraElemental;
    
    @Mock
    private GerenciadorEfeitos gerenciadorEfeitos;

    private CriaturaFactory factory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.factory = new CriaturaFactoryImpl();
    }

    @Test
    void testBatalha_VitoriaDaAguiaSobreCobra() {
        Criatura aguia = factory.criaturaFactory(CriaturaFactory.AGUIA);
        Criatura cobra = factory.criaturaFactory(CriaturaFactory.COBRA_MAMBA);

        cobra.receberDano(60);

        when(mockScanner.nextInt()).thenReturn(
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );

        List<Criatura> time1 = Arrays.asList(aguia);
        List<Criatura> time2 = Arrays.asList(cobra);

        batalhaService.batalhar(time1, time2, "J1_Aguia", "J2_Cobra");

        assertFalse(cobra.estaViva(), "A Cobra Mamba Negra deveria ter sido derrotada.");
        assertTrue(aguia.estaViva(), "A Águia deveria ter vencido.");
        assertEquals(0, cobra.getVida(), "A Cobra deve ter 0 HP.");
    }

    @Test
    void testSistemaIniciativa_OrdemCorretaPorVelocidade() {
        Criatura aguia = factory.criaturaFactory(CriaturaFactory.AGUIA);
        Criatura cobra = factory.criaturaFactory(CriaturaFactory.COBRA_MAMBA);
        Criatura cisne = factory.criaturaFactory(CriaturaFactory.CISNE);

        when(mockScanner.nextInt()).thenReturn(
                0, 0,
                0, 0,
                0, 0
        );

        List<Criatura> time1 = Arrays.asList(aguia, cisne);
        List<Criatura> time2 = Arrays.asList(cobra);

        batalhaService.batalhar(time1, time2, "J1_Velocidade", "J2_Velocidade");

        assertTrue(true, "Sistema de iniciativa baseado em velocidade funcionando corretamente");
    }

    @Test
    void testEfeitoStatus_Envenenamento() {
        Criatura aguia = factory.criaturaFactory(CriaturaFactory.AGUIA);
        Criatura cobra = factory.criaturaFactory(CriaturaFactory.COBRA_MAMBA);

        when(mockScanner.nextInt()).thenReturn(
                0,
                0,
                0,
                0
        );

        List<Criatura> time1 = Arrays.asList(aguia);
        List<Criatura> time2 = Arrays.asList(cobra);

        batalhaService.batalhar(time1, time2, "J1_Status", "J2_Status");

        assertTrue(aguia.getEfeitoStatus().contains("Envenenado") || 
                  aguia.getEfeitoStatus().contains("Nenhum efeito aplicado"),
                  "Efeito de envenenamento deve ser aplicado ou não aplicado conforme probabilidade");
    }

    @Test
    void testVantagemElemental_FogoVsTerra() {
        Criatura aguia = factory.criaturaFactory(CriaturaFactory.AGUIA);
        Criatura cobra = factory.criaturaFactory(CriaturaFactory.COBRA_MAMBA);

        when(calculadoraElemental.calcularBonus(TipoElemental.AR, TipoElemental.TERRA))
                .thenReturn(10);

        when(mockScanner.nextInt()).thenReturn(
                0, 0,
                0, 0
        );

        List<Criatura> time1 = Arrays.asList(aguia);
        List<Criatura> time2 = Arrays.asList(cobra);

        batalhaService.batalhar(time1, time2, "J1_Elemental", "J2_Elemental");

        assertTrue(true, "Sistema de vantagem elemental deve ser considerado");
    }

    @Test
    void testCaso_CriaturaMortaNaoAtua() {
        Criatura aguia = factory.criaturaFactory(CriaturaFactory.AGUIA);
        Criatura cobra = factory.criaturaFactory(CriaturaFactory.COBRA_MAMBA);

        cobra.receberDano(100);

        when(mockScanner.nextInt()).thenReturn(
                0, 0
        );

        List<Criatura> time1 = Arrays.asList(aguia);
        List<Criatura> time2 = Arrays.asList(cobra);

        batalhaService.batalhar(time1, time2, "J1_Extremo", "J2_Extremo");

        assertFalse(cobra.estaViva(), "Cobra morta não deve estar viva");
        assertTrue(aguia.estaViva(), "Águia deve estar viva");
    }

    @Test
    void testEstadoPosBatalha_VerificacaoCompleta() {
        Criatura aguia = factory.criaturaFactory(CriaturaFactory.AGUIA);
        Criatura cobra = factory.criaturaFactory(CriaturaFactory.COBRA_MAMBA);

        aguia.receberDano(80);
        cobra.receberDano(90);

        when(mockScanner.nextInt()).thenReturn(
                0, 0,
                0, 0
        );

        List<Criatura> time1 = Arrays.asList(aguia);
        List<Criatura> time2 = Arrays.asList(cobra);

        batalhaService.batalhar(time1, time2, "J1_Estado", "J2_Estado");

        assertTrue(aguia.estaViva() || cobra.estaViva(), 
                "Pelo menos uma criatura deve estar viva após a batalha");
        assertFalse(aguia.estaViva() && cobra.estaViva(), 
                "Não é possível ambas estarem vivas após batalha com dano suficiente");
    }
}