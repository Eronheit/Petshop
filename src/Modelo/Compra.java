/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author Euxz
 */
public class Compra{
    
    private int cod;
    private String cpf;
    private int codanimal;
    private int servico;
    private Double desconto;
    private Double total;
    private String pagamento;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodanimal() {
        return codanimal;
    }

    public void setCodanimal(int codanimal) {
        this.codanimal = codanimal;
    }

    public int getServico() {
        return servico;
    }

    public void setServico(int servico) {
        this.servico = servico;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    
    
    
}
