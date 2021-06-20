package model;

/**
 *
 * @author 1190402-1191045
 */
public enum GrauProficiencia {
    /**
     * Grau Proficiencia 1
     */
    NADA_SATISFATORIO {
        @Override
        public String toString() {
            return "Nada satisfatório!";
        }
    },
    /**
     * Grau Proficiencia 2
     */
    POUCO_SATISFATORIO {
        @Override
        public String toString() {
            return "Pouco satisfatório!";
        }
    },
    /**
     * Grau Proficiencia 3
     */
    SATISFATORIO {
        @Override
        public String toString() {
            return "Satisfatório!";
        }
    },
    /**
     * Grau Proficiencia 4
     */
    MUITO_SATISFATORIO {
        @Override
        public String toString() {
            return "Muito satisfatório!";
        }
    },
    /**
     * Grau Proficiencia 5
     */
    EXCELENTE {
        @Override
        public String toString() {
            return "Excelente!";
        }
    };
}
