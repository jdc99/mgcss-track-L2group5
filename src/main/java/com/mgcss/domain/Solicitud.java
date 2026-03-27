package com.mgcss.domain;

import java.util.Random;

public class Solicitud {
    //private Estado estado;
    //private Fecha fechaCreacion;
    private final Long id;

    public Solicitud() {
        this.id = new Random().nextLong();
    }

    public static boolean differentIds(Solicitud solicitud1, Solicitud solicitud2) {
        return solicitud1.id.equals(solicitud2.id);
    }
    // este comentario no sirve para nada
}
