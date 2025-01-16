package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.Client.ReportesClient;
import MpReportes.mcsvreportes.DTO.UsernameDTO;
import MpReportes.mcsvreportes.Entities.Reportes;
import MpReportes.mcsvreportes.persistence.ReporteRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
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
    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public List<Reportes> BuscaReportes() {
        return reporteRepository.findAll();
    }

    @Override
    public Reportes guardarReporte(Reportes reportes) {
        reportes.setHora(LocalTime.now());
        reportes.setFecha(LocalDate.now());
        reportes.setEstatus("Rojo");

        List<UsernameDTO> destinatarios;
        try {
            destinatarios = reportesClient.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        for (UsernameDTO destinatario : destinatarios) {
            try {
                sendEmailWithTemplate(destinatario.getUsername(), reportes.getEtiquetau(), reportes.getClasificacion(), reportes.getEstado());
            } catch (MessagingException e) {
                e.printStackTrace(); }
        }
        return reporteRepository.save(reportes);
    }

    private void sendEmailWithTemplate(String to, String etiquetau, String clasificacion, String estado) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom("brayandelgadodiaz03@gmail.com");
        helper.setTo(to);
        helper.setSubject("Reporte de Incidencia");
        Context context = new Context();
        context.setVariable("etiq", etiquetau);
        context.setVariable("clasif", clasificacion);
        context.setVariable("estado", estado);
        String htmlContent = templateEngine.process("emailTemplate", context);
        helper.setText(htmlContent, true);
        mailSender.send(message);
    }

//    public Reportes guardarReporte(Reportes reportes) {
//        reportes.setHora(LocalTime.now());
//        reportes.setFecha(LocalDate.now());
//        reportes.setEstatus("Rojo");
//
//        List<UsernameDTO> destinatarios;
//        try {
//            destinatarios = reportesClient.findAll();
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            return null;
//        }
//
//        for (UsernameDTO destinatario : destinatarios) {
//            try {
//                SimpleMailMessage email = new SimpleMailMessage();
//                email.setFrom("brayandelgadodiaz03@gmail.com");
//                email.setTo(destinatario.getUsername());
//                email.setSubject("Reporte de " + reportes.getEtiquetau());
//                email.setText("Bote de " + reportes.getClasificacion() + " se encuentra " + reportes.getEstado());
//                mailSender.send(email);
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//        }
//
//        return reporteRepository.save(reportes);
//    }


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

    @Override
    public List<Object[]> countReportesInLastWeek() {
        return reporteRepository.countReportesInLastWeek();
    }

    @Override
    public List<Object[]> countReportesInLastMonth() {
        return reporteRepository.countReportesInLastMonth();
    }


}
