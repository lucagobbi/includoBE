package it.lucagobbi.includo.controller;

import it.lucagobbi.includo.model.dto.Curriculum;
import it.lucagobbi.includo.service.CurriculumService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/curriculum")
@Slf4j
public class CurriculumRestFullEndpoint {

    @Autowired
    private CurriculumService curriculumService;

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public void generateCV(
            HttpServletResponse response,
            @RequestBody Curriculum curriculum
            ) throws JRException, IOException {
        log.info("Inizio chiamata generateCV");
        JasperPrint jasperPrint = curriculumService.generateCV(curriculum);
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"cv.pdf\""));
        OutputStream out = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
        log.info("Fine chiamata generateCV");
    }
}
