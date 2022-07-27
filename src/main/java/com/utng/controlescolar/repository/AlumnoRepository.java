package com.utng.controlescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utng.controlescolar.model.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	@Query(value = "SELECT mtm.TXT_CLAVE, mtm.DES_MATERIA, mtp.TXT_NOMBRE, mtp.TXT_APE_PATERNO, mtp.TXT_APE_MATERNO, atc.NUM_CAL_UNIDAD_UNO, atc.NUM_CAL_UNIDAD_DOS, atc.NUM_CAL_UNIDAD_TRES \n"
			+ "FROM MASTER_TBL_ALUMNO AS mta \n"
			+ "INNER JOIN REL_TBL_ALUMNO_MATERIA AS rtam \n"
			+ "ON mta.PK_ALUMNO = rtam.FK_ALUMNO \n"
			+ "INNER JOIN MASTER_TBL_MATERIA AS mtm \n"
			+ "ON rtam.FK_MATERIA = mtm.PK_MATERIA  \n"
			+ "INNER JOIN AUX_TBL_CALIFICACIONES atc \n"
			+ "ON mtm.PK_MATERIA = atc.FK_MATERIA AND mta.PK_ALUMNO = atc.FK_ALUMNO \n"
			+ "INNER JOIN REL_TBL_PROFESOR_MATERIA AS rtpm \n"
			+ "ON ctp.FK_MATERIA = rtpm.FK_MATERIA \n"
			+ "INNER JOIN MASTER_TBL_PROFESOR AS mtp \n"
			+ "ON rtpm.FK_PROFESOR = mtp.PK_PROFESOR \n"
			+ "INNER JOIN REL_TBL_PROFESOR_ALUMNO AS rtpa \n"
			+ "ON mtp.PK_PROFESOR = rtpa.FK_PROFESOR AND mta.PK_ALUMNO = rtpa.FK_ALUMNO ", nativeQuery = true) 
		List<Object[]>mostrarDetallesAlumno();
		
		@Query(value = "SELECT mtm.TXT_CLAVE, mtm.DES_MATERIA, mtp.TXT_NOMBRE, mtp.TXT_APE_PATERNO, mtp.TXT_APE_MATERNO, atc.NUM_CAL_UNIDAD_UNO, atc.NUM_CAL_UNIDAD_DOS, atc.NUM_CAL_UNIDAD_TRES, atc.PK_CALIFICACION \n"
				+ "FROM MASTER_TBL_ALUMNO AS mta \n"
				+ "INNER JOIN REL_TBL_ALUMNO_MATERIA AS rtam \n"
				+ "ON mta.PK_ALUMNO = rtam.FK_ALUMNO \n"
				+ "INNER JOIN MASTER_TBL_MATERIA AS mtm \n"
				+ "ON rtam.FK_MATERIA = mtm.PK_MATERIA  \n"
				+ "INNER JOIN AUX_TBL_CALIFICACIONES atc \n"
				+ "ON mtm.PK_MATERIA = atc.FK_MATERIA AND mta.PK_ALUMNO = atc.FK_ALUMNO \n"
				+ "INNER JOIN REL_TBL_PROFESOR_MATERIA AS rtpm \n"
				+ "ON atc.FK_MATERIA = rtpm.FK_MATERIA \n"
				+ "INNER JOIN MASTER_TBL_PROFESOR AS mtp \n"
				+ "ON rtpm.FK_PROFESOR = mtp.PK_PROFESOR \n"
				+ "INNER JOIN REL_TBL_PROFESOR_ALUMNO AS rtpa \n"
				+ "ON mtp.PK_PROFESOR = rtpa.FK_PROFESOR AND mta.PK_ALUMNO = rtpa.FK_ALUMNO WHERE mta.PK_ALUMNO = ?1" , nativeQuery = true) 
			List<Object[]>mostrarMateriasAlumnoID(Integer idAlumno);
	
}
