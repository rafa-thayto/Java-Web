package br.senai.sp.info.pweb.jucacontrol.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static Map<String, String> mapaDe(BindingResult bindingResult) {
        // Criar um mapa para armazenar os erros do binding result
        Map<String, String> mapaErros = new HashMap<>();

        //Pegar cada erro do binding resul e aplica-lo no mapa
        for (FieldError erro : bindingResult.getFieldErrors()) {
            mapaErros.put(erro.getField(), erro.getDefaultMessage());
        }

        return mapaErros;
    }

}
