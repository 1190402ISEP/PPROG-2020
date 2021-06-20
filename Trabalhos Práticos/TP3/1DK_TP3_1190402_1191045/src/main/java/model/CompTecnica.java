package model;

/**
 * Cria instâncias de CompTecnica - Competências técnicas
 *
 * @author 1190402-1191045
 */
public final class CompTecnica {

    /**
     * Código da Competência Técnica.
     */
    private String codigo;
    /**
     * Descrição da Competência Técnica.
     */
    private String descricao;
    /**
     * Grau de Proficiência associado à Competência Técnica.
     */
    private GrauProficiencia grauDeProficiencia;

    /**
     * Constrói uma instância de competência técnica recebendo por parâmetro o
     * código,a descrição e o grau de proficiência
     *
     * @param codigo codigo da Competência
     * @param descricao descrição da Competência
     * @param grauDeProficiencia Grau de Proficiência associado à Competência
     */
    public CompTecnica(String codigo, String descricao, GrauProficiencia grauDeProficiencia) {
        setCodigo(codigo);
        setDescricao(descricao);
        setGrauDeProficiencia(grauDeProficiencia);
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the grauDeProficiencia
     */
    public GrauProficiencia getGrauDeProficiencia() {
        return grauDeProficiencia;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("Código Inválido!");
        }
        this.codigo = codigo;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição Breve Inválida!");
        }
        this.descricao = descricao;
    }

    /**
     * @param grauDeProficiencia the grauDeProficiencia to set
     */
    public void setGrauDeProficiencia(GrauProficiencia grauDeProficiencia) {
        this.grauDeProficiencia = grauDeProficiencia;
    }

    /**
     * Devolve a descrição textual acerca da Competência.
     *
     * @return informação sobre a competência
     */
    @Override
    public String toString() {
        return String.format("Código: %s\nDescrição: %s\nGrau de Proficiência: %s\n", codigo, descricao, grauDeProficiencia);
    }
}
