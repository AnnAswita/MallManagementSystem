package com.mall.repository;

import com.mall.entity.Agreement;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgreementJsonRepository {

    private final String filePath = "src/main/resources/data/agreements.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Agreement> loadAgreements() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();

            return mapper.readValue(file, new TypeReference<List<Agreement>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveAgreements(List<Agreement> agreements) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), agreements);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Agreement save(Agreement agreement) {
        List<Agreement> agreements = loadAgreements();

        if (agreement.getId() == null) {
            agreement.setId(generateId(agreements));
        }

        agreements.removeIf(a -> a.getId().equals(agreement.getId()));
        agreements.add(agreement);

        saveAgreements(agreements);
        return agreement;
    }

    public Optional<Agreement> findById(Long id) {
        return loadAgreements().stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public List<Agreement> findAll() {
        return loadAgreements();
    }

    public void delete(Long id) {
        List<Agreement> agreements = loadAgreements();
        agreements.removeIf(a -> a.getId().equals(id));
        saveAgreements(agreements);
    }

    private Long generateId(List<Agreement> agreements) {
        return agreements.stream().mapToLong(Agreement::getId).max().orElse(0) + 1;
    }
}

