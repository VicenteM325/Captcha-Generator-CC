#!/bin/bash

echo "procesando gramatica"

jison storage_parser.jison

mv storage_parser.js /home/vicente/NetBeansProjects/Captcha-Generator-CC/backend/src/main/resources/static/js/
