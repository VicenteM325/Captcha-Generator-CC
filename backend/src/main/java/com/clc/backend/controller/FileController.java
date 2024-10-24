package com.clc.backend.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vicente
 */
public class FileController {

    public static String readFile(String path) {
        StringBuilder texto = new StringBuilder();
        try {
            File archivo = new File(path);
            Scanner lectura = new Scanner(archivo);
            while (lectura.hasNext()) {
                texto.append(lectura.nextLine()).append("\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        }
        return texto.toString();
    }

    public static void saveFile(String path, String texto) {
        try ( PrintWriter escribir = new PrintWriter(path)) {
            escribir.print(texto);
        } catch (IOException ex) {
            System.out.println("No se encontró el archivo");
        }
    }

    public static boolean deleteFile(String path) {
        return new File(path).delete();
    }

    public static boolean deleteDirectory(File file) {

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteDirectory(f);
            }
        }
        return file.delete();
    }

    public static void createDirectory(String directory) {
        File directorio = new File(directory);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    public static List<String> getfileNames(String path) {
        File file = new File(path);
        List<String> fileNames = new ArrayList();

        if (file.exists()) {
            fileNames = Arrays.asList(file.list());
        }
        return fileNames;
    }

    public static boolean verifyFile(String archivo) {
        return new File(archivo).exists();
    }
}