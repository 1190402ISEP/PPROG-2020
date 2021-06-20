/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imposto;

/**
 *
 * @author pokem
 */
public abstract class Contador {
    private final String id;
    private String cliente;
    private int consumo;

    public Contador(String id, String cliente, int consumo) {
        this.id = id;
        this.cliente = cliente;
        this.consumo = consumo;
    }

    public String getId() {
        return this.id;
    }

    public String getCliente() {
        return this.cliente;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return String.format("Contador: %s Dono: %s", this.getId(), this.getCliente());
    }

    public abstract double calcularCusto();
}
