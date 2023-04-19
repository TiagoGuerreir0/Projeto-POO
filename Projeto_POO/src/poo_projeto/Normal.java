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
public class Normal extends Empregado{

    public Normal(String nome, int codEmpregado, Data dataEntrada, String categoria, Valores valores) {
        super(nome, codEmpregado, dataEntrada, categoria,valores);
    }

   @Override
   public double salEmp(){
       
       return super.salEmp();
   
   }
    
    
}
