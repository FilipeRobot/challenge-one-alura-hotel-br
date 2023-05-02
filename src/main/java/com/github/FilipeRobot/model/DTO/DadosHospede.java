package com.github.FilipeRobot.model.DTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public record DadosHospede(String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade,
                           String telefone, Long reserva) {
    private static final List<String> paises = List.of("alemão", "andorrano", "angolano", "antiguano", "saudita", "argelino", "argentino", "armênio", "australiano", "austríaco", "azerbaijano", "bahamense", "bangladês, bangladense", "barbadiano", "bahreinita", "belga", "belizenho", "beninês", "belarusso", "boliviano", "bósnio", "botsuanês", "brasileiro", "bruneíno", "búlgaro", "burkineonse, burkinabé", "burundês", "butanês", "cabo-verdiano", "camerounês", "cambojano", "catariano", "canadense", "cazaque", "chadiano", "chileno", "chinês", "cipriota", "colombiano", "comoriano", "congolês", "congolês", "sul-coreano", "norte-coreano", "costa-marfinense, marfinense", "costa-ricense", "croata", "cubano", "dinamarquês", "djiboutiano", "dominiquense", "egípcio", "salvadorenho", "emiradense, emirático", "equatoriano", "eritreu", "eslovaco", "esloveno", "espanhol", "estadunidense, (norte-)americano", "estoniano", "etíope", "fijiano", "filipino", "finlandês", "francês", "gabonês", "gambiano", "ganês ou ganense", "georgiano", "granadino", "grego", "guatemalteco", "guianês", "guineense", "guineense, bissau-guineense", "equato-guineense", "haitiano", "hondurenho", "húngaro", "iemenita", "cookiano", "marshallês", "salomonense", "indiano", "indonésio", "iraniano", "iraquiano", "irlandês", "islandês", "34", "jamaicano", "japonês", "jordaniano", "kiribatiano", "kuwaitiano", "laosiano", "lesotiano", "letão", "libanês", "liberiano", "líbio", "liechtensteiniano", "lituano", "luxemburguês", "macedônio", "madagascarense", "malásio37", "malawiano", "maldivo", "maliano", "maltês", "marroquino", "mauriciano", "mauritano", "mexicano", "myanmarense", "micronésio", "moçambicano", "moldovo", "monegasco", "mongol", "montenegrino", "namibiano", "nauruano", "nepalês", "nicaraguense", "nigerino", "nigeriano", "niuiano", "norueguês", "neozelandês", "omani", "neerlandês", "palauano", "palestino", "panamenho", "papua, papuásio", "paquistanês", "paraguaio", "peruano", "polonês, polaco", "português", "queniano", "quirguiz", "britânico", "centro-africano", "tcheco", "dominicano", "romeno", "ruandês", "russo", "samoano", "santa-lucense", "são-cristovense", "samarinês", "santomense", "são-vicentino", "seichelense", "senegalês", "sérvio", "singapurense", "sírio", "somaliano, somali", "sri-lankês", "suázi", "sudanês", "sul-sudanês", "sueco", "suíço", "surinamês", "tajique", "tailandês", "tanzaniano", "timorense", "togolês", "tonganês", "trinitário", "tunisiano", "turcomeno", "turco", "tuvaluano", "ucraniano", "ugandês", "uruguaio", "uzbeque", "vanuatuense", "vaticano", "venezuelano", "vietnamita", "zambiano", "zimbabueano");

    public DadosHospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, String txtNreserva) {
        this(
                nome,
                sobrenome,
                dataNascimento.toInstant().atZone(ZoneId.of("-03:00")).toLocalDate(),
                nacionalidade,
                telefone,
                Long.valueOf(txtNreserva)
        );
    }

    public static void validar(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, String txtNreserva) {
        if (nome.isBlank()) {
            throw new RuntimeException("Nome não informado!");
        }
        if (sobrenome.isBlank()) {
            throw new RuntimeException("Sobrenome não informado!");
        }
        if (dataNascimento == null) {
            throw new RuntimeException("Data não informado!");
        }
        if (!paises.contains(nacionalidade)) {
            throw new RuntimeException("Nacionalidade informada é inválida");
        }
        if (telefone.isBlank() || telefone.length() > 15) {
            throw new RuntimeException("Telefone não informado ou é inválido");
        }
        if (txtNreserva.isBlank()) {
            throw new RuntimeException("Código da reserva não informado");
        } else {
            try {
                Long value = Long.valueOf(txtNreserva);
            } catch (NumberFormatException numberFormatException) {
                throw new RuntimeException("Código de reserva informado não é um numero");
            }
        }
    }
}
