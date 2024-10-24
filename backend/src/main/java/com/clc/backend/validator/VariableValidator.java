package com.clc.backend.validator;

import java.util.ArrayList;
import java.util.List;
import com.clc.backend.model.scripting.Expresion;
import com.clc.backend.model.scripting.Variable;
/**
 *
 * @author vicente
 */
public class VariableValidator {

    public VariableValidator() {
    }

    public Expresion validate(List<Variable> variables, String variableName, String proceso) {
        Expresion expr = new Expresion(null);

        Variable var = null;
        for (Variable v : variables) {
            if (variableName.equals(v.getId())) {
                var = v;
            }
        }

        if (var == null) {
            expr.setText("La variable " + variableName + " no esta declarada");
        } else if (!var.getHasValue()) {
            expr.setText("La variable " + variableName + " no tiene un valor asignado");
        } else {
            expr.setTipo(var.getType());
            expr.setText("getValue('" + variableName + "', '" + proceso + "')");
        }

        return expr;
    }
    
    public List<String> validate(List<Variable> variables, List<String> newVars) {
        List<String> errores = new ArrayList();
        
        newVars.forEach(nv -> {
            variables.forEach(v -> {
                if (nv.equals(v.getId())) {
                    errores.add("La variable " + nv + " ya ha sido declarada antes");
                }
            });
        });
        
        return errores;
    }
}