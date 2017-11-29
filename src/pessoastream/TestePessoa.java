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
import java.util.List;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 *
 * @author Alexandre
 */
public class TestePessoa {

    public static void main(String[] args) throws IOException {
        List<Pessoa> pessoas = new Pessoa().popularPessoa();

        //Criando stream apartir de uma lista.
        pessoas.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .forEach(pessoa -> System.out.println(pessoa.getNome()));

        //utilizando map
        IntStream intStream = pessoas.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .mapToInt(Pessoa::getIdade);

}
}
