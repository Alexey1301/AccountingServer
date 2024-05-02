package by.accupro.accountingserver.controllers;

import by.accupro.accountingserver.dto.ReportDTO;
import by.accupro.accountingserver.entities.Report;
import by.accupro.accountingserver.services.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;
    private final ModelMapper modelMapper;

    @Autowired
    public ReportController(ReportService reportService, ModelMapper modelMapper) {
        this.reportService = reportService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ReportDTO getReport(@PathVariable("id") int id) {
        return convertToReportDTO(reportService.findOne(id));
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createReport(@RequestBody ReportDTO reportDTO) {
        reportService.save(convertToReport(reportDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<HttpStatus> updateReport(@RequestBody ReportDTO reportDTO, @PathVariable("id") int id) {
        reportService.update(id, convertToReport(reportDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{id}"})
    public HttpStatus deleteReport(@PathVariable("id") int id) {
        reportService.delete(id);
        return HttpStatus.OK;
    }

    private ReportDTO convertToReportDTO(Report report) {
        return modelMapper.map(report, ReportDTO.class);
    }

    private Report convertToReport(ReportDTO reportDTO){
        return modelMapper.map(reportDTO, Report.class);
    }
}
