package br.com.erudio.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO create(@RequestBody PersonVO person) {
        return service.create(person);
    }

    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO update(@RequestBody PersonVO person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

//import br.com.erudio.data.dto.v1.PersonDTO;
//import br.com.erudio.services.PersonServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/person/v1")
//public class PersonController {
//
//    @Autowired
//    private PersonServices service;
//
//    @GetMapping(produces = {
//            MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE,
//            MediaType.APPLICATION_YAML_VALUE})
//    public List<PersonDTO> findAll() {
//        return service.findAll();
//    }
//
//    @GetMapping(value = "/{id}",
//            produces = {
//                    MediaType.APPLICATION_JSON_VALUE,
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_YAML_VALUE}
//    )
//    public PersonDTO findById(@PathVariable("id") Long id) {
//        return service.findById(id);
//    }
//
//    @PostMapping(
//            consumes = {
//                    MediaType.APPLICATION_JSON_VALUE,
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_YAML_VALUE},
//            produces = {
//                    MediaType.APPLICATION_JSON_VALUE,
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_YAML_VALUE}
//    )
//    public PersonDTO create(@RequestBody PersonDTO person) {
//        return service.create(person);
//    }
//
//    @PutMapping(
//            consumes = {
//                    MediaType.APPLICATION_JSON_VALUE,
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_YAML_VALUE},
//            produces = {
//                    MediaType.APPLICATION_JSON_VALUE,
//                    MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_YAML_VALUE}
//    )
//    public PersonDTO update(@RequestBody PersonDTO person) {
//        return service.update(person);
//    }
//
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //    @PostMapping(value = "/v2",
////            consumes = MediaType.APPLICATION_JSON_VALUE,
////            produces = MediaType.APPLICATION_JSON_VALUE
////    )
////    public PersonDTOV2 create(@RequestBody PersonDTOV2 person) {
////        return service.createV2(person);
////    }
//}
