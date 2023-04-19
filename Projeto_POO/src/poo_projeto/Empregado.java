/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_projeto;


/**
 *
 * @author PC Multimédia
 */
public class Empregado {

    private String nome;
    private int codEmpregado;
    private Data dataEntrada;
    private int diasTrabalho[];
    private String categoria;
    private Valores valores;

    public Empregado(String nome, int codEmpregado, Data dataEntrada, String categoria, Valores valores) {
        this.nome = nome;
        this.codEmpregado = codEmpregado;
        this.dataEntrada = dataEntrada;
         this.diasTrabalho = new int[12];
        this.categoria=categoria;
        this.valores = valores;
    }

//getter
    public String getNome() {
        return nome;
    }

    public int getCodEmpregado() {
        return codEmpregado;
    }

    public Data getDataEntrada() {
        return dataEntrada;
    }

    public int[] getDiasTrabalho() {
        return diasTrabalho;
    }

    public String getCategoria() {
        return categoria;
    }

    public Valores getValores() {
        return valores;
    }
    

//setter
    public void setNome(String nome) {
        if (nome.isBlank()) {
            this.nome = nome;
        } else {
            System.out.println(" Error - Nome Invalido");
        }
    }

    public void setCodEmpregado(int codEmpregado) {
        this.codEmpregado = codEmpregado;
    }

    public void setDataEntrada(Data dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDiasTrabalho(int[] diasTrabalho) {
        if(diasTrabalho != null){
            this.diasTrabalho = diasTrabalho;
        }
    }

    public void diasTrabalho() {
        InputReader reader = new InputReader();
        
        for(int i = 0; i < 12; i++){
          diasTrabalho[i] = reader.getIntegerNumber( i+1 + " " + "ºMês : " + "Número de dias trabalhados");
        }
    }
    
    //Uniao do total de dias de trabalho
    public int totaldias(){
    
        int total = 0;
        
        for(int i=0; i <diasTrabalho.length; i++ ){
            
           total+= diasTrabalho[i];
        }
        return total;
    }
    
    //Calcular o salário de cada empregado
    public double salEmp(){
        
        return ((valores.getOrdenadobase()*totaldias())+ (valores.getSubAlimentacao() * totaldias()))*(valores.getAntiguidade()+1);
    }
    
    //Calculo do valor anual
    public double calcAnual(){
    
    return salEmp() + (valores.getSubsidio()*2);
        
    }
    
    //Calculo do valor Semestral
    public double calcSemestral(){
    
    return (salEmp()*6) + valores.getSubsidio();
    }
    
    //Calculo do valor Trimestral
     public double calcTrimestral(){
    
    return (salEmp()*3);
    }
    
    @Override
    public String toString() {
        System.out.println("******Ficha de Empregado******");
        
        String nome = "Nome: " + this.nome;
        String codigo = "\nCódigo-Empregado: " + this.codEmpregado;
        String dataEntrada = "\nData de Entrada: " + this.dataEntrada;
        String diasEmp = "\nDias de trabalho: " + this.totaldias();
         String categoria = "\nCategoria: " + this.categoria;

        return nome + codigo + dataEntrada + categoria + diasEmp;
    }

    
}
