package pro.mapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pro.dto.TraceFileDto;
import pro.model.entity.TraceFile;

@Component
public class TraceFileMapper {
        private final Logger logger = LoggerFactory.getLogger(getClass());

        public TraceFileDto map(TraceFile traceFile) {
            logger.debug("map, traceFile={}", traceFile);
            if (traceFile == null) {
                return null;
            }

            TraceFileDto traceFileDto = new TraceFileDto();
            traceFileDto.setId(traceFile.getId());
            traceFileDto.setFilename(traceFile.getFilename());
            traceFileDto.setFilePath(traceFile.getFilePath());
            traceFileDto.setUser(traceFile.getUser());
            return traceFileDto;
        }
}
