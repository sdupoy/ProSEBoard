package fr.eseo.ld.proseboard.models;



import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class AuditReportTest {

	
	@Test
	public void testFirstConstructor() {
		//Long id, double note, Long idTeam, String report, String comment, int color1, int color2, int color3, int finalColor, int publicate
		AuditReport rep = new AuditReport(1L,12.5, 2L, "Report", "Comment", 1, 1, 1, 1, 0);
		assertNotNull(rep);
		assertEquals(1L, rep.getId(),0.1);
		assertEquals(12.5, rep.getNote(),0.1);
		assertEquals(2L, rep.getIdTeam(),0.1);
		assertEquals("Report",rep.getReport());
		assertEquals("Comment", rep.getComment());
		assertEquals(1, rep.getColor1());
		assertEquals(1, rep.getColor2());
		assertEquals(1, rep.getColor3());
		assertEquals(1, rep.getFinalColor());
		assertEquals(0, rep.getPublicate());
	}
	
	@Test
	public void testSecondConstructor() {
		//double note, Long idTeam, String report, String comment, int color1, int color2, int color3, int finalColor, int publicate
		AuditReport rep = new AuditReport(12.5, 2L, "Report", "Comment", 1, 1, 1, 1, 0);
		assertNotNull(rep);
		assertEquals(12.5, rep.getNote(),0.1);
		assertEquals(2L, rep.getIdTeam(),0.1);
		assertEquals("Report",rep.getReport());
		assertEquals("Comment", rep.getComment());
		assertEquals(1, rep.getColor1());
		assertEquals(1, rep.getColor2());
		assertEquals(1, rep.getColor3());
		assertEquals(1, rep.getFinalColor());
		assertEquals(0, rep.getPublicate());
	}
	
	@Test
	public void testAuditRepor2t() {
		AuditReport s1 = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		AuditReport s2 = new AuditReport(0L, 12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		AuditReport s3 = new AuditReport();
		assertNotNull(s1);
		assertNotNull(s2);
		assertNotNull(s3);
	}
	
	@Test
	public final void testGetId(){
		AuditReport rep = new AuditReport();
		assertNotNull(rep);
		rep.setId(12L);
		assertEquals(12L, rep.getId(),0.1);
	}
	
	@Test
	public final void testGetPublicate(){
		AuditReport rep = new AuditReport();
		assertNotNull(rep);
		rep.setPublicate(0);
		assertEquals(0, rep.getPublicate());
	}
	
	@Test
	public final void testGetNote() {
		AuditReport rep = new AuditReport();
		assertNotNull(rep);
		rep.setNote(12.3);
		assertEquals(12.3, rep.getNote(),0.1);
	}

	@Test
	public final void testGetIdAuditor(){
		AuditReport rep = new AuditReport();
		assertNotNull(rep);
		rep.setIdAuditor(12L);
		assertEquals(12L, rep.getIdAuditor(),0.1);
	}
	
	@Test
	public final void testGetPercent(){
		AuditReport rep = new AuditReport();
		assertNotNull(rep);
		rep.setPercent(80);
		assertEquals(80, rep.getPercent());
	}
	
	@Test
	public final void testGetDate() throws ParseException{
		AuditReport rep = new AuditReport();
		assertNotNull(rep);
		String s = "08/05/2015";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date d = sdf.parse(s);
		java.sql.Date sqlStartDate = new java.sql.Date(d.getTime());
		rep.setDate(sqlStartDate);
		assertEquals(d, rep.getDate());
		assertEquals("05/08/2015", rep.getDatePrintf());
	}
	
	@Test
	public final void testSetNote() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		s.setIdTeam(1L);
		assertEquals(s.getIdTeam(),1L,0.1);		
	}
	
	@Test
	public final void testGetReport() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		assertEquals(s.getReport(),"TEST");
	}

	@Test
	public final void testSetReport() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		s.setReport("TEST1");
		assertEquals(s.getReport(),"TEST1");		
	}
	
	@Test
	public final void testGetComment() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		assertEquals(s.getComment(),"SECRET");
	}

	@Test
	public final void testSetComment() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		s.setComment("REALLY SERCRET");
		assertEquals(s.getComment(),"REALLY SERCRET");
	}
	
	@Test
	public final void testGetColor1() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		assertEquals(s.getColor1(),1);
	}

	@Test
	public final void testSetColor1() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		s.setColor1(2);
		assertEquals(s.getColor1(),2);		
	}
	
	@Test
	public final void testGetColor2() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		assertEquals(s.getColor2(),1);
	}

	@Test
	public final void testSetColor2() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		s.setColor2(2);
		assertEquals(s.getColor2(),2);		
	}
	
	@Test
	public final void testGetColor3() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		assertEquals(s.getColor3(),1);
	}

	@Test
	public final void testSetColor3() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		s.setColor3(2);
		assertEquals(s.getColor3(),2);		
	}
	
	@Test
	public final void testGetFinalColor() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		assertEquals(s.getFinalColor(),1);
	}

	@Test
	public final void testSetFinalColor() {
		AuditReport s = new AuditReport(1L,12.5, 2L, "TEST", "SECRET", 1, 1, 1, 1,0);
		s.setFinalColor(2);
		assertEquals(s.getFinalColor(),2);		
	}
	
}
