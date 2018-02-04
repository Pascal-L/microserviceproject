package microserviceproject.repository;

import java.util.List;

import microserviceproject.model.Algorythm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgorythmRepository extends JpaRepository<Algorythm, Long> {

    List<Algorythm> findByName(String name);
    List<Algorythm> findByNameLike(String name);

}
