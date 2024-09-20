package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.Client.ReportesClient;
import MpReportes.mcsvreportes.DTO.UsernameDTO;
import MpReportes.mcsvreportes.Entities.Reportes;
import MpReportes.mcsvreportes.persistence.ReporteRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@Service

public class ReporteServicesImpl implements ReporteService{

    @Autowired
    private ReporteRepository reporteRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ReportesClient reportesClient;

    @Override
    public List<Reportes> BuscaReportes() {
        return reporteRepository.findAll();
    }

    @Override
    public Reportes guardarReporte(Reportes reportes) {
        reportes.setHora(LocalTime.now());
        reportes.setFecha(LocalDate.now());
        reportes.setEstatus("Rojo");

        List<UsernameDTO> destinatarios = reportesClient.findAll();

        for (UsernameDTO destinatario : destinatarios) {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setFrom("brayandelgadodiaz03@gmail.com");
            email.setTo(destinatario.getUsername()); // Enviar correo a cada destinatario
            email.setSubject("Reporte de " + reportes.getEtiquetau());
            email.setText("Bote de " + reportes.getClasificacion() + " se encuentra " + reportes.getEstado());
            mailSender.send(email);
        }


        return reporteRepository.save(reportes);

    }

    @Override
    public List<Reportes> findAllReportes(String estatus) {
        return reporteRepository.findByEstatus(estatus);
    }

    @Override
    public List<UsernameDTO> getAllUsernames() {
        return List.of();
    }

    @Override
    public Reportes getId(Long id) {
        return reporteRepository.findById(id).get();
    }

    @Override
    public Reportes updateEstatus(Reportes reportes) {
        return reporteRepository.save(reportes);
    }

    @Override
    public List<Reportes> findByClasificacionAndEstadoAndEstatusAndEtiquetau(String clasificacion, String estado, String estatus, String etiquetau) {
        return reporteRepository.findByClasificacionAndEstadoAndEstatusAndEtiquetau(clasificacion, estado, estatus, etiquetau);
    }


}
