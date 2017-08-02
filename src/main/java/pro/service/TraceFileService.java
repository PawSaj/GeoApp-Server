package pro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.dao.TraceFileRepository;
import pro.model.entity.TraceFile;

@Service
@Transactional
public class TraceFileService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TraceFileRepository traceFileRepository;

    public void insertFileToDatabase(TraceFile traceFile) {
        traceFileRepository.save(traceFile);
    }
}
