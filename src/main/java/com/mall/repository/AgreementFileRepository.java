package com.mall.repository;

import com.mall.model.Agreement;
import com.mall.repository.IAgreementRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AgreementFileRepository implements IAgreementRepository {

    private static final String FILE_PATH = "src/main/resources/data/agreements.json";
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Agreement> loadAgreements() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return Arrays.asList(mapper.readValue(file, Agreement[].class));
        } catch (Exception e) {
            throw new RuntimeException("Error reading agreements.json", e);
        }
    }

    @Override
    public void saveAgreements(List<Agreement> agreements) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), agreements);
        } catch (Exception e) {
            throw new RuntimeException("Error writing agreements.json", e);
        }
    }
}
