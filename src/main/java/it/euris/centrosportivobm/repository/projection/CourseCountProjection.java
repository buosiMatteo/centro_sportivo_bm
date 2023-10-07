package it.euris.centrosportivobm.repository.projection;

public interface CourseCountProjection {

  Long getCountAll();

  Long getCountOk();

  Long getCountDeleted();
}
