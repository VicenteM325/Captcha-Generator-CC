package com.clc.backend.model.errores;

import java.io.Serializable;

/**
 *
 * @author vicente
 */
public enum TipoError implements Serializable {
    LEXICO, SINTACTICO, SEMANTICO;
}