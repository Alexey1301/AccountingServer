package services;

import by.accupro.accountingserver.entities.Document;
import by.accupro.accountingserver.repositories.DocumentRepository;
import by.accupro.accountingserver.services.DocumentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DocumentServiceTest {

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private DocumentService documentService;

    @Test
    public void testFindOne() {
        int documentId = 1;
        Document mockDocument = new Document();
        mockDocument.setId(documentId);
        mockDocument.setType("Type");
        mockDocument.setDate(new Date());
        mockDocument.setSum(100.0);
        when(documentRepository.findById(documentId)).thenReturn(Optional.of(mockDocument));

        Document foundDocument = documentService.findOne(documentId);

        assertEquals(mockDocument, foundDocument);
        assertEquals(documentId, foundDocument.getId());
        assertEquals("Type", foundDocument.getType());
        assertEquals(100.0, foundDocument.getSum());
        assertEquals(mockDocument.getDate(), foundDocument.getDate());
    }

    @Test
    public void testSave() {
        Document documentToSave = new Document();
        documentToSave.setType("Type");
        Date currentDate = new Date();
        documentToSave.setDate(currentDate);
        documentToSave.setSum(100.0);

        documentService.save(documentToSave);

        verify(documentRepository, times(1)).save(documentToSave);
        assertEquals("Type", documentToSave.getType());
        assertEquals(100.0, documentToSave.getSum());
        assertEquals(currentDate, documentToSave.getDate());
    }
}


