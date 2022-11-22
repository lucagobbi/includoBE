package it.lucagobbi.includo.service;

import it.lucagobbi.includo.model.dto.Curriculum;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface CurriculumService {

    JasperPrint generateCV(Curriculum curriculum) throws IOException, JRException;

}
