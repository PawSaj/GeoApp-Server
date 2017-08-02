package pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pro.model.entity.TraceFile;

@Transactional(propagation = Propagation.MANDATORY)
public interface TraceFileRepository extends JpaRepository<TraceFile, Long> {
}
