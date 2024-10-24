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
        List<String> errores = new ArrayList();
        
        newVars.forEach(nv -> {
            variables.forEach(v -> {
                if (v.getId().equals(nv)) {
                    errores.add("La variable " + nv + " ya ha sido declarada antes");
                }
            });
        });
        
        if (expr.getTipo() == null) {
            errores.add("La expresion contiene una operacion entre tipos no valida");
        } else if (type != expr.getTipo()) {
            errores.add("La expresion de tipo " + expr.getTipo().name().toLowerCase() + " no se puede asignar a una variable tipo " + type.name().toLowerCase());
        }
        
        return errores;
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
            error = "La expresion contiene una operacion entre tipos no valida";
        } else if (var.getType() != expr.getTipo()) {
            error = "La expresion de tipo " + expr.getTipo().name().toLowerCase() + " no se puede asignar a una variable tipo " + var.getType().name().toLowerCase();
        }
        
        return error;
    }
}