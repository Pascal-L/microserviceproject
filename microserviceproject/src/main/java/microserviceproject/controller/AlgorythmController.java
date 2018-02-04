package microserviceproject.controller;

import java.util.List;
import java.util.logging.Logger;
import microserviceproject.exceptions.AlgorythmNotFoundException;
import microserviceproject.exceptions.DuplicateAlgorythmFoundException;
import microserviceproject.model.Algorythm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import microserviceproject.repository.AlgorythmRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AlgorythmController {
   protected Logger logger = Logger.getLogger(AlgorythmController.class
			.getName());
   private AlgorythmRepository algorythmRepository;

   public AlgorythmController(AlgorythmRepository algorythmRepository) {
        this.algorythmRepository = algorythmRepository;
    }
   
    @PostMapping("/algorythms")
    @ResponseStatus(HttpStatus.OK)
    public void status() {
        
    }
    
    @PostMapping("/algorythms/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAlgorythm(@RequestBody Algorythm algorythm) {
        algorythmRepository.save(algorythm);
    }

    @PostMapping("/algorythms/listAll")
    public List<Algorythm> getAlgorythms() {
        return algorythmRepository.findAll();
    }
    
    @GetMapping("/algorythms/named/{name}")
    public Algorythm findByName(@PathVariable String name) {
        logger.info("findByName() name: " + name);
        List<Algorythm> result = algorythmRepository.findByName(name);
        if (result.isEmpty()) {
            throw new AlgorythmNotFoundException(name);    
        } else if (result.size() > 1) {
            throw new DuplicateAlgorythmFoundException(name);
        }
        return result.get(0);
    }
    
    @GetMapping("/algorythms/allNamed/{name}")
    public List<Algorythm> findAllByName(@PathVariable String name) {
    logger.info("findAllByName() name: " + name);
        List<Algorythm> result = algorythmRepository.findByName(name);
        return result;
    }
    
    @GetMapping("/algorythms/allNamedLike/{name}")
    public List<Algorythm> findAllByNameLike(@PathVariable String name) {
        List<Algorythm> result = algorythmRepository.findByNameLike(name);
        return result;
    }
    
    @PostMapping("/algorythms/deleteNamed")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByName(@RequestBody Algorythm algorythm) {
        logger.info("deleteByName() name: " + algorythm.getName());
        Algorythm algorythmToDelete = findByName(algorythm.getName());
        algorythmRepository.delete(algorythmToDelete);
    }
    
    @PostMapping("/algorythms/deleteAllNamed")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllByName(@RequestBody Algorythm algorythm) throws AlgorythmNotFoundException,DuplicateAlgorythmFoundException{
        logger.info("deleteByName() name: " + algorythm.getName());
        List<Algorythm> listAlgo = algorythmRepository.findByName(algorythm.getName());
        algorythmRepository.delete(listAlgo);
    }
}
