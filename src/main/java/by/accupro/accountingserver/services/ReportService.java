package by.accupro.accountingserver.services;

import by.accupro.accountingserver.entities.Report;
import by.accupro.accountingserver.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report findOne(int id){
        Optional<Report> foundReport = reportRepository.findById(id);
        return foundReport.orElse(null);
    }

    public void save(Report report){
        reportRepository.save(report);
    }

    public void update(int id, Report updatedReport){
        updatedReport.setId(id);
        reportRepository.save(updatedReport);
    }

    public void delete(int id){
        reportRepository.deleteById(id);
    }
}
