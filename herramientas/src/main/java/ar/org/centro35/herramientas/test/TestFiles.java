package ar.org.centro35.herramientas.test;

import java.util.List;

import ar.org.centro35.herramientas.utils.files.FileText;
import ar.org.centro35.herramientas.utils.files.I_File;

/**
 * Clase para testear la clase FileText.
 *
 * @author carlos
 */
public class TestFiles {

    public static void main(String[] args) {
        String file = "texto.txt";
        I_File fText = new FileText(file);
        fText.setText("Curso de Java!\n");
        fText.appendText("Hoy es Lunes!!!\n");
        fText.addLine("Lunes.");
        fText.addLine("Martes.");
        fText.addLine("Miércoles.");
        fText.addLine("Jueves.");
        fText.addLine("Viernes.");
        fText.addLine("Sábado.");
        fText.addLine("Domingo.");
        fText.addLine("Lunes.");
        fText.addLine("Lunes.");
        fText.addLines(List.of("Primavera,Verano,Otoño,Invierno".split(",")));
        fText.remove("Domingo.");
        System.out.println(fText.getText());
        fText.print();
        fText.getAll().forEach(System.out::println);
        fText.getLikeFilter("v").forEach(System.out::println);
        fText.getLinkedHashSet().forEach(System.out::println);
        fText.getTreeSet().forEach(System.out::println);
        fText.getSortedLines().forEach(System.out::println);
        fText.getReversedSortedLines().forEach(System.out::println);
    }
}
