package by.accupro.accountingserver.services;

import by.accupro.accountingserver.entities.Document;
import by.accupro.accountingserver.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document findOne(int id) {
        Optional<Document> foundDocument = documentRepository.findById(id);
        return foundDocument.orElse(null);
    }

    public void save(Document document) {
        documentRepository.save(document);
    }


}
