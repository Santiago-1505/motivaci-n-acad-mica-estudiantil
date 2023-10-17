package org.santiago_ricardo;

import java.text.MessageFormat;
import org.santiago_ricardo.repository.GradeInMemoryRepositoryImpl;
import org.santiago_ricardo.service.AcademicRecordService;
import org.santiago_ricardo.service.AcademicRecordServiceImpl;

public class ApplicationRunner {
  public static void main(String[] args) {

    AcademicRecordService academicRecordService =
        new AcademicRecordServiceImpl(new GradeInMemoryRepositoryImpl());

    System.out.println(
        MessageFormat.format(
            "Suma de número calificaciones: {0}", academicRecordService.sumNumberOfGrades()));

    System.out.println(
        MessageFormat.format("Promedio: {0}", academicRecordService.calculateAverage()));
  }
}
