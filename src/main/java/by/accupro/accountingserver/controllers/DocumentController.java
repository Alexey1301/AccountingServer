package by.accupro.accountingserver.controllers;

import by.accupro.accountingserver.dto.DocumentDTO;
import by.accupro.accountingserver.entities.Document;
import by.accupro.accountingserver.services.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public DocumentDTO getDocumentById(@PathVariable("id") int id) {
        return convertToDocumentDto(documentService.findOne(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createDocument(@RequestBody DocumentDTO documentDTO) {
        documentService.save(convertToDocument(documentDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Document convertToDocument(DocumentDTO documentDTO){
        return modelMapper.map(documentDTO, Document.class);
    }

    private DocumentDTO convertToDocumentDto(Document document){
        return modelMapper.map(document, DocumentDTO.class);
    }
}
