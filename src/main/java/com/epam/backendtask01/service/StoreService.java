package com.epam.backendtask01.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StoreService {

    public Boolean validateItems(String[] items){

        Pattern pattern= Pattern.compile("^[a-zA-Z_]*$");
        for(String item: items){
            Matcher matcher=pattern.matcher(item);
            if(!matcher.matches()){
                return false;
            }
        }
        return true;
    }

    public List<String> eliminateDuplicates(String[] items){

        List<String> listWithoutDuplicates=new ArrayList<>();
        for(int i=0;i<items.length;i++){
            Boolean hasDuplicate=false;
            for(int j=i+1; j<items.length; j++){
                if(items[i].equalsIgnoreCase(items[j])){
                    hasDuplicate=true;
                    break;
                }
            }
            if(!hasDuplicate){
                listWithoutDuplicates.add(items[i]);
            }
        }
        return listWithoutDuplicates;
    }

    public List<String> findAndConvertSnakeCasesToCamelCase(List<String> items){

        for(int i=0; i<items.size(); i++){
            char[] letters=items.get(i).toCharArray();
            Boolean isSnakeCase=false;
            for(int j=0; j<letters.length; j++){
                if(letters[j]=='_'){
                    isSnakeCase=true;
                    break;
                }
            }
            if(isSnakeCase){
                items.set(i,convertItemFromSnakeToCamel(items.get(i)));
            }
        }

        return items;
    }

    public String convertItemFromSnakeToCamel(String item){
        StringBuilder builder = new StringBuilder(item);

        builder.replace(0,1,builder.substring(0,1).toUpperCase());

        for(int i=1; i<builder.length(); i++){
            if(builder.charAt(i)=='_'){
                builder.replace(i,i+2, builder.substring(i+1,i+2).toUpperCase());
            }
        }
        return builder.toString();
    }

}