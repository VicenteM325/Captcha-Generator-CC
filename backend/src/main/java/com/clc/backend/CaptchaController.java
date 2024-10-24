package com.clc.backend;

import com.clc.backend.datos.CaptchaDAO;
import com.clc.backend.model.Captcha;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author vicente
 */
@RestController
@RequestMapping("/api/captchas")
public class CaptchaController {
    

    private final String INIT_LINK = "http://localhost:8080/captchas/";
    private final CaptchaDAO captchaDAO = new CaptchaDAO();

    @GetMapping
    public List<Captcha> listCaptchas() {
        List<Captcha> captchas = captchaDAO.getObject();
        return captchas;
    }

    @PostMapping("/redirect")
    public ResponseEntity<String> redirectCaptcha(@RequestParam String id) {
        List<Captcha> captchas = captchaDAO.getObject();
        for (Captcha c : captchas) {
            if (c.getId().equals(id)) {
                int usos = Integer.parseInt(c.getUse()) + 1;
                c.setUse(String.valueOf(usos));
                c.setLastDate(LocalDate.now().toString());
                captchaDAO.create(captchas);
                String redirectUrl = INIT_LINK + id + ".html";
                return ResponseEntity.ok().body("{\"url\": \"" + redirectUrl + "\"}");
            }
        }
        throw new RuntimeException("Captcha no encontrado");
    }

    @PostMapping("/hits")
    public String incrementHits(@RequestParam String id, @RequestParam String link) {
        List<Captcha> captchas = captchaDAO.getObject();
        for (Captcha c : captchas) {
            if (c.getId().equals(id)) {
                int hits = Integer.parseInt(c.getHits()) + 1;
                c.setHits(String.valueOf(hits));
                captchaDAO.create(captchas);
                return link;
            }
        }
        throw new RuntimeException("Captcha no encontrado");
    }

    @PostMapping("/faults")
    public void incrementFaults(@RequestParam String id) {
        List<Captcha> captchas = captchaDAO.getObject();
        for (Captcha c : captchas) {
            if (c.getId().equals(id)) {
                int faults = Integer.parseInt(c.getFaults()) + 1;
                c.setFaults(String.valueOf(faults));
                captchaDAO.create(captchas);
                break;
            }
        }
    }
}