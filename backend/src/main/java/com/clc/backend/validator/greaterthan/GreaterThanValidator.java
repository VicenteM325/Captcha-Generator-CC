package com.clc.backend.validator.greaterthan;

import com.clc.backend.model.scripting.Expresion;
import com.clc.backend.model.scripting.TipoDato;
import static com.clc.backend.model.scripting.TipoDato.BOOLEAN;
import com.clc.backend.validator.OperatorValidator;

/**
 *
 * @author vicente
 */
public class GreaterThanValidator extends OperatorValidator {

    public GreaterThanValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        if (expr1.getTipo() != null && expr2.getTipo() != null) {
            switch (expr1.getTipo()) {
                case INTEGER, DECIMAL -> setTipos(expr2, new TipoDato[]{BOOLEAN,  null,    BOOLEAN,  null,    null});
                default               -> setTipos(expr2, new TipoDato[]{null,     null,    null,     null,    null});
            }
            expr.setText("(" + expr1.getText() + "<" + expr2.getText() + ")");
        }

        return expr;
    }

}