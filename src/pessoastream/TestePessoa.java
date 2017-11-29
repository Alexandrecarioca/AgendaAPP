/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoastream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Comparator.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import java.util.stream.IntStream;

/**
 *
 * @author Alexandre
 */
public class TestePessoa {

    public static void main(String[] args) throws IOException {
        Pessoa pessoa1 = new Pessoa("p1", "Matheus Henrique", "Brasil", 18);
        Pessoa pessoa2 = new Pessoa("p2", "Hernandez Roja", "Mexio", 21);
        Pessoa pessoa3 = new Pessoa("p4", "Neymar Junior", "Brasil", 22);
        Pessoa pessoa4 = new Pessoa("p4", "Neymar Junior", "Brasil", 22);
        
        List<Pessoa> list = new ArrayList<Pessoa>();

        list.add(pessoa1);
        list.add(pessoa2);
        list.add(pessoa3);
        list.add(pessoa4);
        Set<Pessoa> nova = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(nova);
        
        System.out.println(list);
        
        System.out.println("Lista sem duplicado");
        
        Set<Pessoa> set = list.stream()
            .collect(Collectors.toCollection(() -> 
                 new TreeSet<>(Comparator.comparing(Pessoa::getNome))));
        list.clear();
        list.addAll(set);
        System.out.println(list);
        
        
        
        List<String> al = new ArrayList<>();
		al.add("1");
		al.add("4");
		al.add("7");
		al.add("1");
		al.add("3");
		al.add("4");
		System.out.println(al);
		// add elements to al, including duplicates
		Set<String> hs = new LinkedHashSet<>(al);
		// Set<String> hs = new HashSet<>();
		hs.addAll(al);
		al.clear();
		al.addAll(hs);
		System.out.println(al);

        
        

}
}
