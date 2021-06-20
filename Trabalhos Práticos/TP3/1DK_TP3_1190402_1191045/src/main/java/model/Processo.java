package model;

/**
 * Tipo de processos de Seriação
 *
 * @author 1190402-1191045
 */
public enum Processo {

    /**
     * Processo de Seriação 1
     */
    PROCESSO1 {
        @Override
        public String toString() {
            return "Processo 1";
        }
    },
    /**
     * Processo de Seriação 2
     */
    PROCESSO2 {
        @Override
        public String toString() {
            return "Processo 2";
        }
    };
}
