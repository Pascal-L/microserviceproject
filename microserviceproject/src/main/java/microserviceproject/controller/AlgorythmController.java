package microserviceproject.controller;

import java.util.List;
import java.util.logging.Level;
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
   protected static final Logger LOGGER = Logger.getLogger(AlgorythmController.class
			.getName());
   private final AlgorythmRepository algorythmRepository;

   public AlgorythmController(AlgorythmRepository algorythmRepository) {
        this.algorythmRepository = algorythmRepository;
    }
   
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String status() {
        StringBuilder response = new StringBuilder();
        response.append("methods :").append("\n")
        .append("POST : /add [content Application/Json: {algorythm} ]").append("\n")
        .append("GET : /listAll").append("\n")
        .append("GET : /named/{name}").append("\n")
        .append("GET : /allNamed/{name}").append("\n")
        .append("GET : /allNamedLike/{namedLike}").append("\n")
        .append("POST : /deleteNamed [content Application/Json: {algorythm} ]").append("\n")
        .append("POST : /deleteAllNamed [content Application/Json: {algorythm} ]").append("\n")
        .append("GET : /allSortedByName").append("\n");
                
        return response.toString();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAlgorythm(@RequestBody Algorythm algorythm) {
        algorythmRepository.save(algorythm);
    }

    @GetMapping("/listAll")
    public List<Algorythm> getAlgorythms() {
        return algorythmRepository.findAll();
    }
    
    @GetMapping("/named/{name}")
    public Algorythm findByName(@PathVariable String name) {
        LOGGER.log(Level.INFO, "findByName() name: {0}", name);
        List<Algorythm> result = algorythmRepository.findByName(name);
        if (result.isEmpty()) {
            throw new AlgorythmNotFoundException(name);    
        } else if (result.size() > 1) {
            throw new DuplicateAlgorythmFoundException(name);
        }
        return result.get(0);
    }
    
    @GetMapping("/allNamed/{name}")
    public List<Algorythm> findAllByName(@PathVariable String name) {
    LOGGER.log(Level.INFO, "findAllByName() name: {0}", name);
        List<Algorythm> result = algorythmRepository.findByName(name);
        return result;
    }
    
    @GetMapping("/allNamedLike/{name}")
    public List<Algorythm> findAllByNameLike(@PathVariable String name) {
        List<Algorythm> result = algorythmRepository.findByNameLike(name);
        return result;
    }
    
    @PostMapping("/deleteNamed")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByName(@RequestBody Algorythm algorythm) {
        LOGGER.log(Level.INFO, "deleteByName() name: {0}", algorythm.getName());
        Algorythm algorythmToDelete = findByName(algorythm.getName());
        algorythmRepository.delete(algorythmToDelete);
    }
    
    @PostMapping("/deleteAllNamed")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllByName(@RequestBody Algorythm algorythm) throws AlgorythmNotFoundException,DuplicateAlgorythmFoundException{
        LOGGER.log(Level.INFO, "deleteByName() name: {0}", algorythm.getName());
        List<Algorythm> listAlgo = algorythmRepository.findByName(algorythm.getName());
        algorythmRepository.delete(listAlgo);
    }
    @GetMapping("/allSortedByName")
    public List<Algorythm> getAllSortedByName() {
        LOGGER.info("getAllSortedByName() ");
        return algorythmRepository.findAllByOrderByNameAsc();
    }
    
    
}
