package it.euris.centrosportivobm.repository;

import it.euris.centrosportivobm.data.model.Course;
import it.euris.centrosportivobm.repository.projection.CourseCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course,Long> {

  @Query(
      value =
          "SELECT COUNT(a.id) as countAll, "
              + " SUM(CASE WHEN a.deleted=0 THEN 1 ELSE 0 END) as countOk, "
              + " SUM(CASE WHEN a.deleted=1 THEN 1 ELSE 0 END) as countDeleted "
              + "   FROM course a",
      nativeQuery = true)
  CourseCountProjection getCount();
}
