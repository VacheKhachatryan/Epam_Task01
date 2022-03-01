package com.epam.backendtask01.controller;


import com.epam.backendtask01.model.Store;
import com.epam.backendtask01.model.TransformedStore;
import com.epam.backendtask01.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService service;

    @PostMapping("/transformation")
    public ResponseEntity<TransformedStore> getTransformedStore(@RequestBody Store store){

        if(!service.validateItems(store.getItems())){
            return ResponseEntity.badRequest().build();
        }

        String name=store.getName();
        List<String> itemsList=service.eliminateDuplicates(store.getItems());
        service.findAndConvertSnakeCasesToCamelCase(itemsList);
        String[] items=new String[itemsList.size()];
        itemsList.toArray(items);
        Timestamp timestamp= new Timestamp(System.currentTimeMillis());

        TransformedStore transformedStore=new TransformedStore(name,items,timestamp );
        return ResponseEntity.ok().body(transformedStore);


    }
}