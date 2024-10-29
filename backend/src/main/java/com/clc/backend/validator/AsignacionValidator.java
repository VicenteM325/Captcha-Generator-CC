package com.clc.backend.validator;

import java.util.ArrayList;
import java.util.List;
import com.clc.backend.model.scripting.Expresion;
import com.clc.backend.model.scripting.TipoDato;
import com.clc.backend.model.scripting.Variable;

/**
 *
 * @author vicente
 */
public class AsignacionValidator {

    public AsignacionValidator() {
    }

    public List<String> validate(List<Variable> variables, List<String> newVars, TipoDato type, Expresion expr) {
    List<String> errores = new ArrayList<>();

    newVars.forEach(nv -> {
        variables.forEach(v -> {
            if (v.getId().equals(nv)) {
                errores.add("La variable " + nv + " ya ha sido declarada antes");
            }
        });
    });

    if (expr.getTipo() == null) {
        errores.add("La expresión contiene una operación entre tipos no válida");
    } else if (!esTipoCompatible(type, expr.getTipo())) {
        errores.add("La expresión de tipo " + expr.getTipo().name().toLowerCase()
                + " no se puede asignar a una variable de tipo " + type.name().toLowerCase());
    }


    if (!errores.isEmpty()) {
        System.out.println("Errores encontrados en la validación: " + errores);
    }

    return errores;
}

    private boolean esTipoCompatible(TipoDato tipoVariable, TipoDato tipoExpresion) {
        if (tipoVariable == tipoExpresion) {
            return true;
        }

        System.out.println("Verificando compatibilidad de tipos: Variable - " + tipoVariable + ", Expresión - " + tipoExpresion);

        switch (tipoVariable) {
            case BOOLEAN:
                return tipoExpresion == TipoDato.BOOLEAN;
            case INTEGER:
                return tipoExpresion == TipoDato.INTEGER;
            case STRING:
                return tipoExpresion == TipoDato.STRING;
            default:
                return false;
        }
    }

    public String validate(List<Variable> variables, String newVar, Expresion expr) {
        String error = "";

        Variable var = null;
        for (Variable v : variables) {
            if (newVar.equals(v.getId())) {
                var = v;
            }
        }

        if (var == null) {
            error = "La variable " + newVar + " no ha sido declarada";
        } else if (expr.getTipo() == null) {
            error = "La expresión contiene una operación entre tipos no válida";
        } else if (!esTipoCompatible(var.getType(), expr.getTipo())) {
            error = "La expresión de tipo " + expr.getTipo().name().toLowerCase()
                    + " no se puede asignar a una variable de tipo " + var.getType().name().toLowerCase();
        }

        return error;
    }
}
