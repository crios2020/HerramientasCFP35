package ar.org.centro35.herramientas.utils.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilidad para el manejo de archivos de carácter.
 *
 * @author carlos
 */
public class FileText implements I_File {

    private File file;

    public FileText(File file) {
        this.file = file;
    }

    public FileText(String file) {
        this.file = new File(file);
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        int car;
        try (FileReader in = new FileReader(file)) {
            while ((car = in.read()) != -1) {
                sb.append((char) car);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();
    }

    @Override
    public void setText(String text) {
        try (FileWriter out = new FileWriter(file)) {
            out.write(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void appendText(String text) {
        try (FileWriter out = new FileWriter(file, true)) {
            out.write(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<String> getAll() {
        List<String> list = new ArrayList();
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            list = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void addLines(List<String> lines) {
        try (FileWriter out = new FileWriter(file, true)) {
            for (String st : lines) {
                out.write(st + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
