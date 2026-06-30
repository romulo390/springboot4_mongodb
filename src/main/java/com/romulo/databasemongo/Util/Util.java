package com.romulo.databasemongo.Util;

import com.romulo.databasemongo.domain.Post;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

public class Util {


    public static String extraiMes(String valor){
        String entradaTratada = tratarEntrada(valor);
        String mes = entradaTratada.substring(2);
        validarMes(mes);
        return mes;
    }

    public static String extrairAno(String entrada){
        String entradaTratada = tratarEntrada(entrada);
        String ano = entradaTratada.substring(0,2);
        int prefixoAno =LocalDate.now().getYear() / 100;
        return prefixoAno+ano;
    }

    private static void validarMes(String mes) {
        int mesInt = Integer.parseInt(mes);
        if (mesInt < 1 || mesInt > 12) {
            throw new IllegalArgumentException("Mês invalidao: "+ mes);
        }
    }

    private static String tratarEntrada(String entrada){
        String entradaTratada = entrada.replaceAll("[^0-9]","");
        if(entradaTratada.length() == 4 || entradaTratada.length() == 6){
            return entradaTratada;
        }else {
            throw new IllegalArgumentException("Formato invalido. A dada de expiracap deve conter 4 ou 6 digitos");
        }
    }

    public static String recuperarPrimeiroNome(String valorString) {
        String [] nomes =  valorString.split(" ");
        return nomes[0];
    }

    public static String recuperarUltimoNome(String valorString) {
        String [] nomes =  valorString.split(" ");
        return nomes[nomes.length-1];
    }

    public static String incluirAsterisk(String valorString) {
       return valorString.substring(0, 3) + "***" + valorString.substring(valorString.length() - 5);
    }

    public static String decodeParam(String param){
        try {
            return URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Date convertStringToDate(String textoDate, Date defaultValue){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textoDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
