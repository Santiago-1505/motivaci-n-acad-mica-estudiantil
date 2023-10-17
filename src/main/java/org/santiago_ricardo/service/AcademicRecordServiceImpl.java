package org.santiago_ricardo.service;

import java.util.List;
import org.santiago_ricardo.model.Grade;
import org.santiago_ricardo.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademicRecordServiceImpl implements AcademicRecordService {

  private static final Logger logger = LoggerFactory.getLogger(AcademicRecordServiceImpl.class);
  private final GradeRepository gradeRepository;

  public AcademicRecordServiceImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  @Override
  public Double calculateAverage() {
    return null;
  }

  @Override
  public Integer sumNumberOfGrades() {
    System.out.println("Sumando el número de calificaciones");
    logger.info("Sumando el número de calificaciones");
    logger.warn("Sumando el número de calificaciones");
    logger.error("Sumando el número de calificaciones");

    List<Grade> gradeList = this.gradeRepository.findAllGrades();
    // TODO sum number of grades and return the summation
    return null;
  }
}
