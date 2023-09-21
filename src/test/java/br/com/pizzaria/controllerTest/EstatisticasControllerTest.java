package br.com.pizzaria.controllerTest;

import br.com.pizzaria.controller.EstatisticasController;
import br.com.pizzaria.dto.EstatisticasDTO;
import br.com.pizzaria.service.EstatisticasService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EstatisticasControllerTest {

    @Mock
    private EstatisticasService estatisticasService;

    @InjectMocks
    private EstatisticasController estatisticasController;

    @Before
    public void setUp() {

        when(estatisticasService.calcularEstatisticasDoDia()).thenReturn(new EstatisticasDTO());
        when(estatisticasService.calcularEstatisticasDoMes()).thenReturn(new EstatisticasDTO());
        when(estatisticasService.calcularEstatisticasDoAno()).thenReturn(new EstatisticasDTO());
    }

    @Test
    public void testObterEstatisticasDiarias() {
        ResponseEntity<EstatisticasDTO> response = estatisticasController.obterEstatisticasDiarias();
        verify(estatisticasService, times(1)).calcularEstatisticasDoDia();
        assert(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void testObterEstatisticasMensais() {
        ResponseEntity<EstatisticasDTO> response = estatisticasController.obterEstatisticasMensais();
        verify(estatisticasService, times(1)).calcularEstatisticasDoMes();
        assert(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void testObterEstatisticasAnuais() {
        ResponseEntity<EstatisticasDTO> response = estatisticasController.obterEstatisticasAnuais();
        verify(estatisticasService, times(1)).calcularEstatisticasDoAno();
        assert(response.getStatusCode() == HttpStatus.OK);
    }
}

