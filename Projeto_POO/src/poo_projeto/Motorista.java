/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_projeto;

/**
 *
 * @author adiog
 */
public class Motorista extends Empregado{

    private double quilometros;

    public Motorista(double quilometros, String nome, int codEmpregado, Data dataEntrada, String categoria, Valores valores) {
        super(nome, codEmpregado, dataEntrada, categoria, valores);
        this.quilometros = quilometros;
    }

    @Override
    public double salEmp(){
     
     return super.salEmp() + (getValores().getpQuilometro()*quilometros) ;
        
    }
    
    
    
  

  
    
}
