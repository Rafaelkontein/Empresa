package com.rafa.empresa.Uteis;

import java.util.List;
import java.util.zip.GZIPOutputStream;

public class Povoar {

    public List<String> povoando(List<String> list){
        list.add("AC - Acre");
        list.add("AL - Alagoas");
        list.add("AM - Amazonas");
        list.add("BA - Bahia");
        list.add("CE - Ceará");
        list.add("DF - Distrido Federal ");
        list.add("ES - Esperito Santo");
        list.add("GO - Goiás");
        list.add("MA - Maranhão");
        list.add("MT - Mato Grosso");
        list.add("MS - Mato Grosso do Sul");
        list.add("MG - Minas Gerais");
        list.add("PA - Pará");
        list.add("PB - Paraíba");
        list.add("PR - Paraná");
        list.add("PE - Pernambuco");
        list.add("PI - Piauí");
        list.add("RJ - Rio de Janeiro");
        list.add("RN - Rio Grande do Norte");
        list.add("RS - Rio Grande do Sul");
        list.add("RO - Rondônia");
        list.add("RR - Roraima");
        list.add("SC -Santa Catarina");
        list.add("SP - São Paulo");
        list.add("SE - Sergipe");
        list.add("TO - Tocantins");


        return list;
    }

    public String selecionar(String uf){

        if (uf =="RO"){
            uf ="11";
        }else  if (uf == "AC"){
            uf ="12";
        }else  if(uf=="AM"){
            uf ="13";

        }else if(uf == "RR"){
            uf="14";

        }else if(uf == "PA"){
            uf = "15";
        }else if(uf == "AP"){
            uf = "16";
        }else if(uf == "TO"){
            uf = "17";
        }else if(uf == "MA"){
            uf = "21";
        }else if(uf == "PI"){
            uf = "22";
        }else if(uf == "CE"){
            uf = "23";
        }else if(uf == "RN"){
            uf = "24";
        }else if(uf == "PB"){
            uf = "25";
        }else if(uf == "PE"){
            uf = "26";
        }else if(uf == "AL"){
            uf = "27";
        }else if(uf == "SE"){
            uf = "28";
        }else if(uf == "BA"){
            uf = "29";
        }else if(uf == "MG"){
            uf = "31";
        }else if(uf == "ES"){
            uf = "32";
        }else if(uf == "RJ"){
            uf = "33";
        }else if(uf == "SP"){
            uf = "35";
        }else if(uf == "PR"){
            uf = "41";
        }else if(uf == "SC"){
            uf = "42";
        }else if(uf == "RS"){
            uf = "43";
        }else if(uf == "MS"){
            uf = "50";
        }else if(uf == "MT"){
            uf = "51";
        }else if(uf == "GO"){
            uf = "52";
        }else if(uf == "DF"){
            uf = "53";
        }

        return uf;
    }
}
