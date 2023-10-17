package org.santiago_ricardo.repository;

import java.util.List;
import org.santiago_ricardo.model.Grade;

public interface GradeRepository {

  List<Grade> findAllGrades();
}
