package com.clc.backend.generator.body.scripting;

/**
 *
 * @author vicente
 */

public class TableHtmlCode {
    public static String getCode() {
        return "<div id=\"tableS\" class=\"container-fluid fixed-bottom\">\n" +
               "    <div class=\"row bg-light py-3 shadow-sm\">\n" +
               "        <div class=\"col-2 text-center\">\n" +
               "            <button class=\"btn btn-secondary rounded-pill px-4\"\n" + 
               "                    type=\"button\" data-toggle=\"collapse\" data-target=\"#collapseTable\"\n" +
               "                    aria-expanded=\"false\" aria-controls=\"collapseTable\">\n" +
               "                Symbol Table\n" +
               "            </button>\n" +
               "        </div>\n" +
               "        <div class=\"col-10\">\n" +
               "            <div class=\"collapse\" id=\"collapseTable\">\n" +
               "                <div class=\"card shadow border-0 rounded-lg mt-3\">\n" +
               "                    <div class=\"card-body p-0\" style=\"height: 250px; overflow-y: auto; background-color: #f8f9fa;\">\n" + 
               "                        <table class=\"table table-hover mb-0\" style=\"background-color: #343a40; color: white;\">\n" + 
               "                            <thead class=\"bg-dark text-white\">\n" +  
               "                                <tr class=\"text-center\">\n" +
               "                                    <th scope=\"col\">Posición</th>\n" +
               "                                    <th scope=\"col\">Tipo</th>\n" +
               "                                    <th scope=\"col\">Identificador</th>\n" +
               "                                    <th scope=\"col\">Valor Actual</th>\n" +
               "                                    <th scope=\"col\">Modo</th>\n" +
               "                                    <th scope=\"col\">Proceso</th>\n" +
               "                                    <th scope=\"col\">No. Ejecución</th>\n" +
               "                                </tr>\n" +
               "                            </thead>\n" +
               "                            <tbody id=\"tableBody\" class=\"text-center\">\n" +
               "                                <!-- Table content populated dynamically -->\n" +
               "                            </tbody>\n" +
               "                        </table>\n" +
               "                    </div>\n" +
               "                </div>\n" +
               "            </div>\n" +
               "        </div>\n" +
               "    </div>\n" +
               "</div>";
    }
}


