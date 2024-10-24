package com.clc.backend.validator.and;

import com.clc.backend.model.scripting.Expresion;
import com.clc.backend.model.scripting.TipoDato;
import static com.clc.backend.model.scripting.TipoDato.*;
import com.clc.backend.validator.OperatorValidator;

/**
 *
 * @author vicente
 */
public class AndValidator extends OperatorValidator {

    public AndValidator() {
    }

    @Override
    public Expresion validate(Expresion expr1, Expresion expr2) {
        if (expr1.getTipo() != null && expr2.getTipo() != null) {
            switch (expr1.getTipo()) {
                case BOOLEAN    -> setTipos(expr2, new TipoDato[]{null,  null, null, null, BOOLEAN});
                default         -> setTipos(expr2, new TipoDato[]{null,  null, null, null, null});
            }
            expr.setText("(" + expr1.getText() + "&&" + expr2.getText() + ")");
        }

        return expr;
    }

}
