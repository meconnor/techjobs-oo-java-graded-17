package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {

    private Job job1;
    private Job job2;
    private Job job3;  // For testing equals method

    @Before
    public void setUp() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        // Two Job objects with different IDs but identical field values should NOT be equal
        assertFalse(job1.equals(job2));

        // Two Job objects with different IDs and different field values should NOT be equal
        assertFalse(job1.equals(job3));

        // Two Job objects with the same ID should be considered equal
        assertTrue(job1.equals(job1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Employer employer = new Employer("LaunchCode");
        Job job = new Job("Software Developer", employer, new Location("St. Louis"), new PositionType("Full Time"), new CoreCompetency("Java"));
        String jobString = job.toString();

        // Check if the string starts and ends with a newline character
        assertTrue(jobString.startsWith("\n"));
        assertTrue(jobString.endsWith("\n"));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();

        assertTrue(jobString.contains("ID: "));
        assertTrue(jobString.contains("Name: Product tester"));
        assertTrue(jobString.contains("Employer: ACME"));
        assertTrue(jobString.contains("Location: Desert"));
        assertTrue(jobString.contains("Position Type: Quality control"));
        assertTrue(jobString.contains("Core Competency: Persistence"));
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = job.toString();

        assertTrue(jobString.contains("ID: "));
        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }



}
