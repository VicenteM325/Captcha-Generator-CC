package com.clc.backend.generator.body.scripting;

/**
 *
 * @author vicente
 */

public class TableHtmlCode {
public static String getCode() {
        return "<div id=\"tableS\" class=\"container-fluid fixed-bottom\">\n" +
            "    <div class=\"row bg-light py-2\">\n" +
            "        <div class=\"col-2\">\n" +
            "            <button class=\"btn btn-primary\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseTable\" aria-expanded=\"false\" aria-controls=\"collapseTable\">\n" +
            "                Ver tabla de simbolos\n" +
            "            </button>\n" +
            "        </div>\n" +
            "        <div class=\"col-8\">\n" +
            "            <div class=\"collapse\" id=\"collapseTable\">\n" +
            "                <div style=\"height: 250px; width: 100%; overflow-y: scroll;\">\n" +
            "                    <table class=\"table table-bordered table-dark\">\n" +
            "                        <thead class=\"thead-light\">\n" +
            "                            <tr>\n" +
            "                                <th>Posicion</th>\n" +
            "                                <th>Tipo</th>\n" +
            "                                <th>Identificador</th>\n" +
            "                                <th>Valor actual</th>\n" +
            "                                <th>Modo</th>\n" +
            "                                <th>Proceso</th>\n" +
            "                                <th>No. Ejecucion</th>\n" +
            "                            </tr>\n" +
            "                        </thead>\n" +
            "                        <tbody id=\"tableBody\">\n" +
            "                        </tbody>\n" +
            "                    </table>\n" +
            "                </div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</div>";
    }
}