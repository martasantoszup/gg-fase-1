package br.com.backend.Desafio01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListaArquivoDiretorio {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o diretorio desejado:");
        String dir = sc.next();

        //C:\Users\marta\Desktop\Testes\TestesMP
        File currentDir = new File(dir.replace("\\","\\"));
        listFilesDirectory(currentDir);

    }

    public static void listFilesDirectory(File dir) {
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    listFilesDirectory(file);
                } else {
                    System.out.println("file:" + file.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
