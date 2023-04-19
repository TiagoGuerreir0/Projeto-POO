/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PC Multimédia
 */
public class Empresa {

    private Valores valores;
    private ArrayList<Empregado> empregados;

    public Empresa() {
        this.empregados = new ArrayList<Empregado>();
        this.valores = new Valores(68.18, 2.50, 0.20, 4.79, 0.5);
    }

//criacao de um empregado
    public void criarEmpregado() {
        InputReader reader = new InputReader();
        Empregado empregado;

        String nome = reader.getText("Nome do Empregado");
        try {
            if (nome.trim().matches(".*[0-9].*")) {
                throw new IllegalArgumentException("Dados inválidos");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("O nome é inválido: " + e.getMessage());
        }
        int codEmpregado = empregados.size() + 1;

        while (empregadoRepetido(codEmpregado)) {
            codEmpregado++;
        }

        //data local
        int dia = LocalDate.now().getDayOfMonth();
        int mes = LocalDate.now().getMonthValue();
        int ano = LocalDate.now().getYear();

        String categoria = reader.getText("Categoria do Empregado");

        try {
            if (categoria.trim().matches(".*[0-9].*")) {
                throw new IllegalArgumentException("Dados inválidos");
            }
       
        switch (categoria.toUpperCase()) {
            case "GESTOR":
                empregado = new Gestor(nome, codEmpregado, new Data(dia, mes, ano), categoria, valores);
                break;
            case "MOTORISTA":
                empregado = new Motorista(0, nome, codEmpregado, new Data(dia, mes, ano), categoria, valores);
                break;
            case "COMERCIAL":
                empregado = new Comercial(nome, codEmpregado, new Data(dia, mes, ano), categoria, valores);
                break;
            default:
                empregado = new Normal(nome, codEmpregado, new Data(dia, mes, ano), categoria, valores);

        }

        empregado.diasTrabalho();
        empregados.add(empregado);
    }
    catch(IllegalArgumentException e){
            System.out.println(" " + e.getMessage());
}
    }
    
    //verificar se existe empregado repetido por numero
    public boolean empregadoRepetido(int codEmpregado) {
        for (Empregado empregado : this.empregados) {
            if (empregado.getCodEmpregado() == codEmpregado) {
                return true;
            }
        }

        return false;
    }

    //ver ficha de empregado por pesquisa de codigo
    public void pesquisaNumEmpregado(int codEmpregado) {
        for (Empregado empregado : empregados) {
            if (empregado.getCodEmpregado() == codEmpregado) {
                System.out.println(empregado);
            }
        }
    }

//adiciona uma lista de empregados ao registo atual
    public void adicionarEmpregados(ArrayList<Empregado> listEmpregados) {
        empregados.addAll(listEmpregados);

    }

//numero atual de empregados de uma dada categoria
    public int consultarEmpregados(String categoria) {
        int contador = 0;
        switch (categoria.toUpperCase()) {

            case "GESTOR": {

                for (Empregado empregado : this.empregados) {

                    if (empregado instanceof Gestor) {
                        contador++;
                    }
                }
                break;
            }
            case "MOTORISTA": {

                for (Empregado empregado : this.empregados) {

                    if (empregado instanceof Motorista) {
                        contador++;
                    }
                }
                break;
            }
            case "COMERCIAL": {

                for (Empregado empregado : this.empregados) {

                    if (empregado instanceof Comercial) {
                        contador++;
                    }
                }
                break;
            }
            case "NORMAL": {

                for (Empregado empregado : this.empregados) {

                    if (empregado instanceof Normal) {
                        contador++;
                    }
                }
                break;
            }
        }

        return contador;
    }

    /**
     * Devolver o conjunto atual de fichas de empregados
     */
    public void fichasAtualEmpregado() {

        for (Empregado empregado : empregados) {
            System.out.println(empregado);
        }
    }

    //Devolver o conjunto atual de fichas de empregados por categoria
    public void fichasEmpregoCategoria(String categoria) {
        for (Empregado empregado : empregados) {
            switch (categoria.toUpperCase()) {

                case "GESTOR": {
                    if (empregado instanceof Gestor) {
                        System.out.println(empregado);
                    }
                    break;
                }
                case "MOTORISTA": {
                    if (empregado instanceof Motorista) {
                        System.out.println(empregado);
                    }
                    break;
                }
                case "COMERCIAL": {
                    if (empregado instanceof Comercial) {
                        System.out.println(empregado);
                    }
                    break;
                }
                case "NORMAL": {
                    if (empregado instanceof Normal) {
                        System.out.println(empregado);
                    }
                    break;
                }
            }
        }
    }

    //Calcular, a qualquer momento, o total de salários a pagar;
    public double salTotal() {

        double total = 0;

        for (Empregado empregado : empregados) {

            total += empregado.salEmp();
        }
        return total;
    }

    //Calcular e apresentar os custos trimestrais, semestrais e anuais com salários, devendo ter em conta os subsídios de natal e de férias
    public void custoAnual() {

        double total = 0;

        for (Empregado empregado : empregados) {

            total += empregado.calcAnual();

        }

        System.out.println("Custo Anual: " + total);

    }

    //Calcular e apresentar os custos trimestrais, semestrais e anuais com salários, devendo ter em conta os subsídios de natal e de férias
    public void custosSemestrais() {

        double semestre1 = 0;

        double semestre2 = 0;

        for (Empregado empregado : empregados) {

            semestre1 += empregado.calcSemestral();

            semestre2 += empregado.calcSemestral();

        }

        System.out.println("1º semestre: " + semestre1);

        System.out.println("2º semestre: " + semestre2);

    }

    //Calcular e apresentar os custos trimestrais, semestrais e anuais com salários, devendo ter em conta os subsídios de natal e de férias
    public void custosTrimestrais() {

        double trimestre1 = 0;

        double trimestre2 = 0;

        double trimestre3 = 0;

        double trimestre4 = 0;

        for (Empregado empregado : empregados) {

            trimestre1 += empregado.calcTrimestral();

            trimestre2 += empregado.calcTrimestral() + valores.getSubsidio();

            trimestre3 += empregado.calcTrimestral();

            trimestre4 += empregado.calcTrimestral() + valores.getSubsidio();

        }

        System.out.println("1º trimestre: " + trimestre1);

        System.out.println("2º trimestre: " + trimestre2);

        System.out.println("3º trimestre: " + trimestre3);

        System.out.println("4º trimestre: " + trimestre4);

    }

    //Guardar os empregados no ficheiro de Texto
    public void guardarEmpregados() {

        String nomeDoFicheiro = "Empregados.txt";

        File meuFicheiro = new File(nomeDoFicheiro);

        if (meuFicheiro.exists()) {
            System.out.println(meuFicheiro.getName() + " existente");
        } else {
            System.out.println(meuFicheiro.getName() + " não existente");
        }

        try {
            FileWriter fileWriter = new FileWriter(nomeDoFicheiro);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            for (Empregado empregado : empregados) {
                printWriter.println(empregado.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Ler os dados dos empregados que estão no ficheiro de texto
    public ArrayList<Empregado> LerFicheiro() {

        ArrayList<Empregado> adicionarEmpregados = new ArrayList<>();

        String nomeDoFicheiro = "Empregados.txt";

        File meuFicheiro = new File(nomeDoFicheiro);

        try {
            FileReader fileReader = new FileReader(meuFicheiro);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String readNome = "";
            readNome = bufferedReader.readLine();

            while (readNome != null) {

                String[] nomeSplit = readNome.split(": ", 2);
                String Nome = nomeSplit[1];

                String readCodigo = bufferedReader.readLine();
                String[] codigoSplit = readCodigo.split(": ", 2);
                int Codigo = Integer.parseInt(codigoSplit[1]);

                String readData = bufferedReader.readLine();
                String[] DataSplit = readData.split(": ", 2);
                String[] separatedDate = DataSplit[1].split("/", 3);
                int diaEntr = Integer.parseInt(separatedDate[0]);
                int mesEntr = Integer.parseInt(separatedDate[1]);
                int anoEntr = Integer.parseInt(separatedDate[2]);
                Data DatadeEntrada = new Data(diaEntr, mesEntr, anoEntr);

                String readCategoria = bufferedReader.readLine();
                String[] categoriaSplit = readCategoria.split(": ", 2);
                String Categoria = categoriaSplit[1];

                bufferedReader.readLine();

                Empregado empregado = new Empregado(Nome, Codigo, DatadeEntrada, Categoria, valores);
                adicionarEmpregados.add(empregado);

                readNome = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return adicionarEmpregados;
    }

}
