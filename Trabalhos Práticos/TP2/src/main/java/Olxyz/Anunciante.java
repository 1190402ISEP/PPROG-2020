package Olxyz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1DK_1190402_1191045
 */
/**
 * Serve para criar Anunciantes
 */
public class Anunciante {

    /**
     * @param nome the nome do anunciante
     */
    private String nome;
    /**
     * @param endereco the endereco do anunciante
     */
    private Endereco endereco;
    /**
     * @param venda the lista de produtos para venda do anunciante
     */

    private List<Object> venda = new ArrayList<>();
    /**
     * @param aluguer the lista de produtos para aluguer do anunciante
     */
    private List<Object> aluguer = new ArrayList<>();

    /**
     * @param NOME_POR_OMISSAO the inicialização por defeito do nome do
     * anunciante
     */
    private static final String NOME_POR_OMISSAO = "Sem Nome";
    /**
     * @param ENDERECO_POR_OMISSAOthe inicialização por defeito do endereço do
     * anunciante
     */
    private static final Endereco ENDERECO_POR_OMISSAO = new Endereco();

    /**
     * Constrói um Anunciante com os seguintes parâmetros:
     *
     * @param nome the nome do anunciante
     * @param nomeDaRua the nomeDaRua onde o cliente habita
     * @param codigoPostal the código postal do endereço do anunciante
     * @param localidade the localidade de habitação do anunciante questão
     */
    public Anunciante(String nome, String nomeDaRua, String codigoPostal, String localidade) {
        this.nome = nome;
        this.endereco = new Endereco(nomeDaRua, codigoPostal, localidade);
    }

    /**
     * Constrói um Anunciante com os seguintes parâmetros:
     *
     * @param nome the nome do anunciante
     * @param endereco the endereço do cliente
     */
    public Anunciante(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = new Endereco(endereco);
    }

    /**
     * Constrói um Anunciante sem parâmetros:
     */
    public Anunciante() {
        nome = NOME_POR_OMISSAO;
        endereco = ENDERECO_POR_OMISSAO;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @return the venda
     */
    public List<Object> getVenda() {
        return venda;
    }

    /**
     * @return the aluguer
     */
    public List<Object> getAluguer() {
        return aluguer;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @param Rua the rua to set
     */
    public void setRua(String Rua) {
        this.endereco.setNomeDaRua(Rua);
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(String codigoPostal) {
        this.endereco.setCodigoPostal(codigoPostal);
    }

    /**
     * @param localidade the localidade to set
     */
    public void setLocalidade(String localidade) {
        this.endereco.setLocalidade(localidade);
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(List<Object> venda) {
        this.venda = venda;
    }

    /**
     * @param aluguer the aluguer to set
     */
    public void setAluguer(List<Object> aluguer) {
        this.aluguer = aluguer;
    }

    /**
     * @return the informação do anunciante
     */
    @Override
    public String toString() {
        return String.format("ANUNCIANTE\nNome: %s\n%s", nome, endereco);
    }

    /**
     * @return the quantidade de produtos alugáveis do anunciante
     */
    public int quantidadeProdutos() {
        return this.aluguer.size();
    }

    /**
     * introduz na lista de alugáveis do anunciante um automóvel
     *
     * @param marca the marca do automóvel
     * @param modelo the modelo do automóvel
     * @param valorDeVenda the valor de venda do automóvel (deve ser 0)
     * @param valorDeAluguer the valor de aluguer do automóvel
     */
    public void introduzirAlugavelAutomovel(String marca, String modelo, float valorDeVenda, float valorDeAluguer) {
        if (valorDeAluguer > 0 && valorDeVenda == 0 && aluguer.size() < 4) {
            this.aluguer.add(new Automovel(marca, modelo, valorDeVenda, valorDeAluguer));
        }
    }

    /**
     * introduz na lista de alugáveis do anunciante um automóvel
     *
     * @param automovel the automóvel que contém dados para copiar para este
     * (construtor cópia)
     */
    public void introduzirAlugavelAutomovel(Automovel automovel) {
        if (automovel.getValorDeAluguer() > 0 && automovel.getValorDeVenda() == 0 && aluguer.size() < 4) {
            this.aluguer.add(new Automovel(automovel));
        }
    }

    /**
     * introduz na lista de alugáveis do anunciante um apartamento
     *
     * @param nomeDaRua the nome da rua onde se localiza o apartamento
     * @param codigoPostal the código postal onde se localiza o apartamento
     * @param localidade the localidade onde se localiza o apartamento
     * @param area the area em m2 do apartamento
     * @param valorDeAluguer the valor de aluguer do apartamento
     */
    public void introduzirAlugavelApartamento(String nomeDaRua, String codigoPostal, String localidade, float area, float valorDeAluguer) {
        if (aluguer.size() < 4) {
            this.aluguer.add(new Apartamento(nomeDaRua, codigoPostal, localidade, area, valorDeAluguer));
        }
    }

    /**
     * introduz na lista de alugáveis do anunciante um apartamento
     *
     * @param endereco the endereco do apartamento
     * @param area the area em m2 do apartamento
     * @param valorDeAluguer the valor de aluguer do apartamento
     */
    public void introduzirAlugavelApartamento(Endereco endereco, float area, float valorDeAluguer) {
        if (aluguer.size() < 4) {
            this.aluguer.add(new Apartamento(endereco, area, valorDeAluguer));
        }
    }

    /**
     * introduz na lista de alugáveis do anunciante um apartamento
     *
     * @param apartamento the apartamento com os dados a copiar (construtor
     * cópia)
     */
    public void introduzirAlugavelApartamento(Apartamento apartamento) {
        if (aluguer.size() < 4) {
            this.aluguer.add(new Apartamento(apartamento));
        }
    }

    /**
     * introduz na lista de vendáveis do anunciante um automóvel
     *
     * @param marca the marca do automóvel
     * @param modelo the modelo do automóvel
     * @param valorDeVenda the valor de venda do automóvel
     * @param valorDeAluguer the valor de aluguer do automóvel (deve ser 0)
     */
    public void introduzirVendavelAutomovel(String marca, String modelo, float valorDeVenda, float valorDeAluguer) {
        if (valorDeAluguer == 0 && valorDeVenda > 0 && venda.size() < 3) {
            this.venda.add(new Automovel(marca, modelo, valorDeVenda, valorDeAluguer));
        }
    }

    /**
     * introduz na lista de vendáveis do anunciante um automóvel
     *
     * @param automovel the automovel com os dados a copiar (construtor cópia)
     */
    public void introduzirVendavelAutomovel(Automovel automovel) {
        if (automovel.getValorDeAluguer() == 0 && automovel.getValorDeVenda() > 0 && venda.size() < 3) {
            this.venda.add(new Automovel(automovel));
        }
    }

    /**
     * introduz na lista de vendáveis do anunciante um telemóvel
     *
     * @param designacao the designação do telemóvel
     * @param valorDeVenda the valor de aluguer do telemóvel
     */
    public void introduzirVendavelTelemovel(String designacao, float valorDeVenda) {
        if (venda.size() < 3) {
            this.venda.add(new Telemovel(designacao, valorDeVenda));
        }
    }

    /**
     * introduz na lista de vendáveis do anunciante um telemóvel
     *
     * @param telemovel the telemovel com os dados a copiar (construtor cópia)
     */
    public void introduzirVendavelTelemovel(Telemovel telemovel) {
        if (venda.size() < 3) {
            this.venda.add(new Telemovel(telemovel));
        }
    }

    /**
     * Procura e mostra o alugável com valor maior
     *
     * @return alugável com valor maior
     */
    public Object valorMaior() {
        float maiorAlugavel = 0;
        Object alugavelAux = 0;

        for (int i = 0; i < aluguer.size(); i++) {
            if (aluguer.get(i) instanceof Automovel && ((Automovel) aluguer.get(i)).getValorDeAluguer() > maiorAlugavel) {
                maiorAlugavel = ((Automovel) aluguer.get(i)).getValorDeAluguer();
                alugavelAux = ((Automovel) aluguer.get(i));
            }

            if (aluguer.get(i) instanceof Apartamento && ((Apartamento) aluguer.get(i)).getValorDeAluguer() > maiorAlugavel) {
                maiorAlugavel = ((Apartamento) aluguer.get(i)).getValorDeAluguer();
                alugavelAux = ((Apartamento) aluguer.get(i));
            }
        }

        return alugavelAux;
    }

    /**
     * Calcula o valor possível de vendas no total
     *
     * @return valor possível de vendas no total
     */
    public float totalPossivelVendas() {
        float temp = 0;

        for (int i = 0; i < venda.size(); i++) {
            if (venda.get(i) instanceof Telemovel) {
                temp += ((Telemovel) venda.get(i)).getValorDeVenda();
            }
            if (venda.get(i) instanceof Automovel) {
                temp += ((Automovel) venda.get(i)).getValorDeVenda();
            }
        }

        return temp;
    }
}
