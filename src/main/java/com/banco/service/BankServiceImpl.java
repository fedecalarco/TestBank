/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.service;

import com.banco.daos.BankDAO;
import com.banco.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fedec
 */
@Service
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDAO bankDao;
    
    

    private boolean quitarSaldo(Account cuenta, float saldo) {
        if (cuenta.getBalance()>= saldo) {
            cuenta.setBalance(cuenta.getBalance()- saldo);
            return true;
        } else {
            // Saldo insuficiente
            return false;
        }
    }

    private void depositarSaldo(Account cuenta, float saldo) {
        cuenta.setBalance(cuenta.getBalance()+ saldo);
    }

    @Override
    public boolean transferencia(Account cuentaOrigen, Account cuentaDestino, float dinero) {
        // Descuento a saldo a cuenta origen 
        if (quitarSaldo(cuentaOrigen, dinero)) {
            
            depositarSaldo(cuentaDestino, dinero);
            // Agrego los movimientos realizados a la la lista 
            cuentaOrigen.addMovements(MovimientosServiceImpl.setMovimiento("Envio_Transferencia", cuentaDestino.getAccount_ID(), dinero));
            cuentaDestino.addMovements(MovimientosServiceImpl.setMovimiento("Recibio_Transferencia", cuentaOrigen.getAccount_ID(),dinero));  
            // Update cuentas 
            bankDao.update(cuentaOrigen);
            bankDao.update(cuentaDestino);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Account getCuentaById(long nroCuenta) {
        return bankDao.getAccountById(nroCuenta);
    }

}
