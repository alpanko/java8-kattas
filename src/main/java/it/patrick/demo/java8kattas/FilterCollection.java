/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.patrick.demo.java8kattas;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author patrickn
 */
public class FilterCollection {
    
    public static List<String> transform(List<String> collection){
        List<String> ret = collection.stream().filter(value -> value.length()<4).collect(Collectors.toList());
        return ret;
        
    }
    
}
