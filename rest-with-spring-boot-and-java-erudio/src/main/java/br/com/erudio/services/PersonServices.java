package br.com.erudio.services;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

//    private final AtomicLong counter = new AtomicLong();
//    private Logger logger = Logger.getLogger(PersonServices.class.getName());
//
//    @Autowired
//    PersonRepository repository;
//
//    @Autowired
//    PersonMapper converter;
//
//
//    public List<PersonDTO> findAll() {
//
//        logger.info("Finding all People!");
//
//        return parseListObjects(repository.findAll(), PersonDTO.class);
//    }
//
//    public PersonDTO findById(Long id) {
//        logger.info("Finding one Person!");
//
//        var entity = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
//
//        PersonDTO personDTO =  parseObject(entity, PersonDTO.class);
//        personDTO.setBirthDay(new Date());
////        personDTO.setPhoneNumber("(49) 9 9113-6801");
////        personDTO.setSensitiveData("Teste");
//        return parseObject(entity, PersonDTO.class);
//    }
//
//    public PersonDTO create(PersonDTO person) {
//
//        logger.info("Creating one Person!");
//        var entity = parseObject(person, Person.class);
//
//        return parseObject(repository.save(entity), PersonDTO.class);
//    }
//
//    public PersonDTOV2 createV2(PersonDTOV2 person) {
//
//        logger.info("Creating one Person V2!");
//        var entity = converter.convertDTOtoEntity(person);
//
//        return converter.convertEntityToDTO(repository.save(entity));
//    }
//
//    public PersonDTO update(PersonDTO person) {
//
//        logger.info("Updating one Person!");
//        Person entity = repository.findById(person.getId())
//                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
//
//        entity.setFirstName(person.getFirstName());
//        entity.setLastName(person.getLastName());
//        entity.setAddress(person.getAddress());
//        entity.setGender(person.getGender());
//
//        return parseObject(repository.save(entity), PersonDTO.class);
//    }
//
//    public void delete(Long id) {
//
//        logger.info("Deleting one Person!");
//
//        Person entity = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
//        repository.delete(entity);
//    }
}
