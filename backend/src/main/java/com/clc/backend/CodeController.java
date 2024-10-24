package com.clc.backend;

import com.clc.backend.analyzer.CCAnalyzer;
import com.clc.backend.generator.Generator;
import com.clc.backend.generator.HtmlGenerator;
import com.clc.backend.model.Captcha;
import com.clc.backend.model.errores.ErrorAnalisis;
import com.clc.backend.datos.CaptchaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import static com.clc.backend.controller.FileController.saveFile;
import static com.clc.backend.controller.FileController.createDirectory;
import com.clc.backend.model.tags.CC;

@RestController
@RequestMapping("/api")
public class CodeController {

    private final CaptchaDAO captchaDAO = new CaptchaDAO();

    @PostMapping("/processCode")
    public ResponseEntity<Map<String, Object>> processCode(@RequestBody String code) {
        Map<String, Object> response = new HashMap<>();
        CCAnalyzer analyzer = new CCAnalyzer(code);
        analyzer.analyze();
        
        List<ErrorAnalisis> errores = analyzer.getErrores();

        if (errores.isEmpty()) {
            // Sin errores, generar el captcha y guardar el archivo HTML
            CC cc = analyzer.getCc();
            String PATH_CAPTCHAS = "/home/vicente/NetBeansProjects/Captcha-Generator-CC/captchas/";
            Generator htmlGenerator = new HtmlGenerator(cc);
            createDirectory(PATH_CAPTCHAS);
            
            saveFile(PATH_CAPTCHAS + cc.getParameterValue("id") + ".html", htmlGenerator.generate());

            // Actualizar la lista de captchas
            List<Captcha> captchas;
            if (!captchaDAO.exists()) {
                captchas = new ArrayList<>();
            } else {
                captchas = captchaDAO.getObject();
            }
            captchas.add(new Captcha(cc.getParameterValue("id"),
                                     cc.getParameterValue("name"),
                                     "0", "0", "0", LocalDate.now().toString()));

            captchaDAO.create(captchas);

            // Preparar la respuesta con las variables analizadas
            response.put("vars", analyzer.getVariables());
        } else {
            // Si hay errores, devolver los errores
            response.put("errores", errores);
        }

        response.put("inputText", code);
        return ResponseEntity.ok(response);
    }
}
