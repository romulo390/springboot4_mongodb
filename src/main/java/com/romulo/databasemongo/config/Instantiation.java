package com.romulo.databasemongo.config;

import com.romulo.databasemongo.util.Util;
import com.romulo.databasemongo.repository.PostRepository;
import com.romulo.databasemongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public static void formatValo(String texto) {
        System.out.println("Detalhes: " + texto);
    }

    public static Date converterStringOfDate(String texto) {
        try {
            return Date.from(LocalDate.parse(texto).atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void run(String... args) throws Exception {

        //Teste de git reset --soft HEAD~1
        String mes = "0106";
        System.out.println(Util.extraiMes(mes));

        String ano = "202602";
        System.out.println(Util.extrairAno(ano));

        //String valorString="058 005 39464";
//        System.out.println(Util.recuperarPrimeiroNome(valorString));
//        System.out.println(Util.recuperarUltimoNome(valorString));
        //System.out.println(Util.incluirAsterisk(valorString));

//        System.out.println("Data:: " + converterStringOfDate("2026-04-01"));
//
//        Long inicio = System.currentTimeMillis();
//        LocalDateTime dataInicio = LocalDateTime.now();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
//        Instant instant = Instant.parse("2026-04-01T10:00:00.00Z");
//
//        System.out.println("Data global para local: " + formatter.format(instant));
//
//        Instant instant2 = Instant.parse("2026-04-02T01:30:00.00Z");
//
//        LocalDate r1 = LocalDate.ofInstant(instant, ZoneId.systemDefault());
//
//        System.out.println("R1: " +r1);
//
//        Date d1  = Date.from(Instant.parse("2026-05-05T10:00:00.00Z"));
//
//        Calendar cal =  Calendar.getInstance();
//        cal.setTime(d1);
//        cal.add(Calendar.DAY_OF_MONTH, 1);
//        d1 = cal.getTime();
//        int hr = cal.get(Calendar.HOUR_OF_DAY);
//        int ano = cal.get(Calendar.YEAR);
//        int mes = cal.get(Calendar.MONDAY);
//        int dia = cal.get(Calendar.DAY_OF_MONTH);
//
//        String formata = String.format("dia: %d mês %d ano %d hora %d", dia,mes,ano,hr);
//
//
//        System.out.println("Calendar: " +formatter.format(d1.toInstant()));
//        System.out.println("Formatado:" + formata);
//
//
//
//
//        Integer num = 10;
//        Long logNun = 1000L;
//        double doubleNun = 60.98784;
//        float floatNun = 50.9f;
//
//        String nome = "João";
//        int idade = 25;
//
//        String valorFormatado0 = String.format("Usuario: %s tem %d anos", nome, idade);
//
//        String valorFormatado1 = String.format("%d",num);
//        String valorFormatado2 = String.format("%d", logNun);
//        String valorFormatado3 = String.format("%.2f", doubleNun);
//        String valorFormatado4 = String.format("%.2f", floatNun);
//
//
//        formatValo(valorFormatado0);
//        formatValo(valorFormatado1);
//        formatValo(valorFormatado2);
//        formatValo(valorFormatado3);
//        formatValo(valorFormatado4);
//
//        Thread.sleep(1500);
//
//
//        Long fim = System.currentTimeMillis();
//        LocalDateTime dataFim = LocalDateTime.now();
//
//        Duration tempo = Duration.between(dataInicio,dataFim);
//
//        System.out.println("Tempo:  " +  (fim - inicio) + " ms");
//        System.out.println("Tempo2:  " + tempo.toMillis() + " ms");


//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//
//        userRepository.deleteAll();
//        postRepository.deleteAll();
//
//        User maria = new User(null, "Maria Brown", "maria@gmail.com");
//        User alex = new User(null, "Alex Green", "alex@gmail.com");
//        User bob = new User(null, "Bob Grey", "bob@gmail.com");
//
//        userRepository.saveAll(Arrays.asList(maria,alex,bob));

//        Post post1 = new Post(null, Date.from(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant(ZoneOffset.UTC)),
//                    "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
//        Post post2 = new Post(null, Date.from(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant(ZoneOffset.UTC)),
//                "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

//        CommentDto comment1 = new CommentDto("Boa Viagem mano!",sdf.parse("16/03/2026"), new AuthorDto(alex));
//        CommentDto comment2 = new CommentDto("Aproveita!",new Date(), new AuthorDto(bob));
//        CommentDto comment3 = new CommentDto("Tenha um bom dia",new Date(), new AuthorDto(alex));

//        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
//        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));
//
//        CommentDto comment1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(alex));
//        CommentDto comment2 = new CommentDto("Aproveite", sdf.parse("22/03/2018"), new AuthorDto(bob));
//        CommentDto comment3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDto(alex));
//
//        post1.getComments().addAll(Arrays.asList(comment1,comment2));
//        post2.getComments().add(comment3);
//        postRepository.saveAll(Arrays.asList(post1,post2));
//
//        maria.setPosts(Arrays.asList(post1,post2));
//        userRepository.save(maria);
    }
}
