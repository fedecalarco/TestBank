/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.service;

import com.banco.model.Movements;
import java.util.Date;

/**
 *
 * @author fedec
 */
public class MovimientosServiceImpl{

    
    

   public static Movements setMovimiento(String operacion, long id, double dinero) {
        
        Movements movs = new Movements();
        Date dia = new Date();
        movs.setDate(dia.toString());
        
        switch (operacion) {
            case "Registro":
                movs.setAction("Creacion de cuenta");
                break;
            case "Envio_Transferencia":
                movs.setAction("Trasferencia: Envio $" + dinero + " a cuenta Nº " + id);
                break;
            case "Recibio_Transferencia":
                movs.setAction("Trasferencia: Recibio $" + dinero + " "+"de cuenta Nº " + id);
                break;
            default: 
                movs.setAction("OP desconocida");
                break;
        }

        return movs;
    }

}
