package com.mgcss;

import com.mgcss.domain.Solicitud;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MgcssTrackL2group5ApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void uniqueIdSolicitud() {
        Solicitud solicitud1 = new Solicitud();
        Solicitud solicitud2 = new Solicitud();

        boolean resultado = Solicitud.differentIds(solicitud1,solicitud2);
        assertFalse(resultado);
    }
}
