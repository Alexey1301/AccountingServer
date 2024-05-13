package services;
import by.accupro.accountingserver.entities.Report;
import by.accupro.accountingserver.repositories.ReportRepository;
import by.accupro.accountingserver.services.ReportService;
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
public class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportService reportService;

    @Test
    public void testFindOne() {
        // Arrange
        int reportId = 1;
        Report mockReport = new Report();
        mockReport.setId(reportId);
        mockReport.setDate(new Date());
        when(reportRepository.findById(reportId)).thenReturn(Optional.of(mockReport));

        Report foundReport = reportService.findOne(reportId);

        assertEquals(mockReport, foundReport);
        assertEquals(reportId, foundReport.getId());
        assertEquals(mockReport.getDate(), foundReport.getDate());
    }

    @Test
    public void testSave() {
        Report reportToSave = new Report();
        reportToSave.setDate(new Date());

        reportService.save(reportToSave);

        verify(reportRepository, times(1)).save(reportToSave);
        assertEquals(new Date(), reportToSave.getDate());
    }

    @Test
    public void testUpdate() {
        int reportId = 1;
        Report updatedReport = new Report();
        updatedReport.setId(reportId);
        updatedReport.setDate(new Date());

        reportService.update(reportId, updatedReport);

        verify(reportRepository, times(1)).save(updatedReport);
        assertEquals(reportId, updatedReport.getId());
        assertEquals(new Date(), updatedReport.getDate());
    }

    @Test
    public void testDelete() {
        int reportId = 1;

        reportService.delete(reportId);

        verify(reportRepository, times(1)).deleteById(reportId);
    }
}



