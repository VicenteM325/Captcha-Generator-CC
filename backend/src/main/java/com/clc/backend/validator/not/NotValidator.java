package com.clc.backend.validator.not;

import com.clc.backend.model.scripting.Expresion;
import static com.clc.backend.model.scripting.TipoDato.BOOLEAN;
import com.clc.backend.validator.OperatorValidator;

/**
 *
 * @author vicente
 */
public class NotValidator extends OperatorValidator {

    public NotValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Expresion validate(Expresion expr1) {
        if (expr1.getTipo() != null) {
            switch (expr1.getTipo()) {
                case BOOLEAN -> setExpresion(BOOLEAN);
                default -> setExpresion(null);
            }
            expr.setText("!" + expr1.getText());
        }

        return expr;
    }

}