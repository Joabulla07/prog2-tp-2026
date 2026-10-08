package org.curso.externo;

import org.curso.modelo.Celular;

public class CelularPremium extends Celular {

    public CelularPremium(String marca, String modelo, String color, double saldo) {
        super(marca, modelo, color, saldo);
    }

    public void mostrarAccesoProtegido() {
        System.out.println("Acceso protected desde subclase en otro paquete:");
        System.out.println("Costo de llamada: $" + String.format("%.2f", getCostoLlamadaProtegido()));
        System.out.println("Hay llamada activa: " + estaEnLlamadaProtegido());

        // System.out.println(getResumenTecnico());
        // ERROR de compilacion esperado:
        // getResumenTecnico() no es visible porque tiene acceso default (package-private)
        // y CelularPremium esta en otro paquete.
    }
}
