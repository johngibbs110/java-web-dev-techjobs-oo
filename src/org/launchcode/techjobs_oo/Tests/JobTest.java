package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job_id_one;
    Job test_job_id_two;

    @Before
    public void createJobObjects() {
        test_job_id_one = new Job();
        test_job_id_two = new Job();
    }

    @Test
    public void job_twoJobObjects_shouldContainUniqueIdNumber() {
        assertNotEquals(test_job_id_two.getId(), test_job_id_one.getId());
    }

    @Test
    public void job_twoJobObjects_shouldBeSequentialIntegers() {
        assertEquals(1, test_job_id_two.getId() - test_job_id_one.getId());
    }

    @Test
    public void job_testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void job_testJobsForEquality() {
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(newJobOne.getId(), newJobTwo.getId());
    }

    @Test
    public void job_testsForBlankLinesBeforeAndAfterJobInfo_shouldPass() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newJobString = newJob.toString();
        assertEquals('\n', newJobString.charAt(0));
        assertEquals('\n', newJobString.charAt(newJobString.length() - 1));
    }

    @Test
    public void job_eachStringHasLabelsAndData_shouldPass() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newJobString = newJob.toString();
        assertTrue(newJobString.contains(
                "ID: " + newJob.getId() + "\n" +
                "Name: " + newJob.getName() + "\n" +
                "Employer: " + newJob.getEmployer() + "\n" +
                "Location: " + newJob.getLocation() + "\n" +
                "Position Type: " + newJob.getPositionType() + "\n" +
                "Core Competency: " + newJob.getCoreCompetency() + "\n"
                ));
    }

    @Test
    public void job_ifNameIsEmpty_shouldReturnDataNotAvailable() {
        Job newJob = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newJobString = newJob.toString();
        assertTrue(newJobString.contains("Data not available"));
    }

    @Test
    public void job_ifEmployerIsEmpty_shouldReturnDataNotAvailable() {
        Job newJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newJobString = newJob.toString();
        assertTrue(newJobString.contains("Data not available"));
    }

    @Test
    public void job_ifLocationIsEmpty_shouldReturnDataNotAvailable() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newJobString = newJob.toString();
        assertTrue(newJobString.contains("Data not available"));
    }

    @Test
    public void job_ifPositionTypeIsEmpty_shouldReturnDataNotAvailable() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String newJobString = newJob.toString();
        assertTrue(newJobString.contains("Data not available"));
    }

    @Test
    public void job_ifCoreCompetencyIsEmpty_shouldReturnDataNotAvailable() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        String newJobString = newJob.toString();
        assertTrue(newJobString.contains("Data not available"));
    }

    @Test
    public void job_ifObjectContainsOnlyIdField_shouldReturnErrorMessage() {
        Job newJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String newJobString = newJob.toString();
        assertTrue(newJobString.contains("OOPS! This job does not seem to exist."));
    }
}