package com.clc.backend.datos;

import com.clc.backend.analyzer.StorageFileAnalyzer;
import static com.clc.backend.controller.FileController.readFile;
import static com.clc.backend.controller.FileController.saveFile;
import static com.clc.backend.controller.FileController.createDirectory;
import static com.clc.backend.controller.FileController.verifyFile;
import com.clc.backend.generator.StorageGenerator;
import java.io.StringReader;
import java.util.List;
import com.clc.backend.model.Captcha;

/**
 *
 * @author vicente
 */
public class CaptchaDAO {

    private final String USER_HOME_LINUX = System.getProperty("user.home");
    private final String PATH_FORMS = USER_HOME_LINUX + "/NetBeansProjects/Captcha-Generator-CC/data/";
    private final StorageFileAnalyzer analyzer = new StorageFileAnalyzer();
    private StorageGenerator storageG;

    public void create(List<Captcha> t) {
        storageG = new StorageGenerator(t);
        createDirectory(PATH_FORMS);
        saveFile(PATH_FORMS + "/captchas.db" , storageG.generate());
    }
     
  public List<Captcha> getObject() {
       StringReader text = new StringReader(readFile(PATH_FORMS + "/captchas.db"));
      return analyzer.analyzeData(text);
    }
    
    public boolean exists() {
        return verifyFile(PATH_FORMS + "/captchas.db");
    }
}
