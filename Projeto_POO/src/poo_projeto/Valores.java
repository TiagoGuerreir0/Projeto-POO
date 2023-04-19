/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_projeto;

/**
 *
 * @author adiog
 */
public class Valores {
    //declaracao de variaveis
    private double ordenadobase;
    private double pQuilometro;
    private double pVendas;
    private double subAlimentacao;
    private double subsidio;
    private double antiguidade;
//construtor dos valores
    public Valores(double ordenadobase, double pQuilometro, double pVendas, double subAlimentacao, double antiguidade) {
        this.ordenadobase = ordenadobase;
        this.pQuilometro = pQuilometro;
        this.pVendas = pVendas;
        this.subAlimentacao = subAlimentacao;
        this.subsidio = ordenadobase*22;
        this.antiguidade = antiguidade;
    }
//getters
    public double getOrdenadobase() {
        return ordenadobase;
    }

    public double getpQuilometro() {
        return pQuilometro;
    }

    public double getpVendas() {
        return pVendas;
    }

    public double getSubAlimentacao() {
        return subAlimentacao;
    }

    public double getSubsidio() {
        return subsidio;
    }

    public double getAntiguidade() {
        return antiguidade;
    }
    
//setters
    public void setOrdenadobase(double ordenadobase) {
        this.ordenadobase = ordenadobase;
    }

    public void setpQuilometro(double pQuilometro) {
        this.pQuilometro = pQuilometro;
    }

    public void setpVendas(double pVendas) {
        this.pVendas = pVendas;
    }

    public void setSubAlimentacao(double subAlimentacao) {
        this.subAlimentacao = subAlimentacao;
    }

    public void setSubsidio(double subsidio) {
        this.subsidio = subsidio;
    }

    public void setAntiguidade(double antiguidade) {
        this.antiguidade = antiguidade;
    }
    
}
  

   
