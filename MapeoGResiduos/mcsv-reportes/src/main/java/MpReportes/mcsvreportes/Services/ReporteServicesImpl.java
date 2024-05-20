package MpReportes.mcsvreportes.Services;

import MpReportes.mcsvreportes.Entities.Reportes;
import MpReportes.mcsvreportes.persistence.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Reportes> BuscaReportes() {
        return reporteRepository.findAll();
    }

    @Override
    public Reportes guardarReporte(Reportes reportes) {
        reportes.setHora(LocalTime.now());
        reportes.setFecha(LocalDate.now());
        reportes.setEstatus("Rojo");

        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("brayandelgadodiaz03@gmail.com");

        email.setTo("ben10delgado@gmail.com");
        email.setSubject("Reporte de " + reportes.getEtiquetau());
        email.setText( "Bote de "+ reportes.getClasificacion() +" se encuentra " + reportes.getEstado());

        mailSender.send(email);


        return reporteRepository.save(reportes);

    }


}
