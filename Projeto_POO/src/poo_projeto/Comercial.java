/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_projeto;

import java.util.Date;

/**
 *
 * @author adiog
 */
public class Comercial extends Empregado{

    private int nVendas;
    public Comercial(String nome, int codEmpregado, Data dataEntrada, String categoria, Valores valores) {
        super(nome, codEmpregado, dataEntrada, categoria,valores);
        this.nVendas=nVendas;
    }

  @Override
  public double salEmp(){
     
     return super.salEmp() +((getValores().getpVendas() + 1)*(nVendas)) ;
        
    }
    

   
    
}
