package com.hexa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class LeaveDetailsTest {

    private LeaveDetails leaveDetails;

    @BeforeEach
    public void setUp() {
        leaveDetails = new LeaveDetails(
            1,
            1234,
            LeaveDetails.LeaveType.EL,
            LeaveDetails.LeaveStatus.PENDING,
            new Date(),
            new Date(),
            "Medical Leave"
        );
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(1, leaveDetails.getLeaveId());
        assertEquals(1234, leaveDetails.getEmpId());
        assertEquals(LeaveDetails.LeaveType.EL, leaveDetails.getLeaveType());
        assertEquals(LeaveDetails.LeaveStatus.PENDING, leaveDetails.getLeaveStatus());
        assertNotNull(leaveDetails.getLeaveStartDate());
        assertNotNull(leaveDetails.getLeaveEndDate());
        assertEquals("Medical Leave", leaveDetails.getLeaveReason());
    }

    @Test
    public void testSetters() {
        leaveDetails.setLeaveId(2);
        leaveDetails.setEmpId(5678);
        leaveDetails.setLeaveType(LeaveDetails.LeaveType.PL);
        leaveDetails.setLeaveStatus(LeaveDetails.LeaveStatus.ACCEPTED);
        Date newStartDate = new Date();
        leaveDetails.setLeaveStartDate(newStartDate);
        Date newEndDate = new Date();
        leaveDetails.setLeaveEndDate(newEndDate);
        leaveDetails.setLeaveReason("Vacation");

        assertEquals(2, leaveDetails.getLeaveId());
        assertEquals(5678, leaveDetails.getEmpId());
        assertEquals(LeaveDetails.LeaveType.PL, leaveDetails.getLeaveType());
        assertEquals(LeaveDetails.LeaveStatus.ACCEPTED, leaveDetails.getLeaveStatus());
        assertEquals(newStartDate, leaveDetails.getLeaveStartDate());
        assertEquals(newEndDate, leaveDetails.getLeaveEndDate());
        assertEquals("Vacation", leaveDetails.getLeaveReason());
    }

    @Test
    public void testToString() {
        String expectedString = "LeaveDetails{leaveId=1, empId=1234, leaveType=EL, leaveStatus=PENDING, "
                + "leaveStartDate=" + leaveDetails.getLeaveStartDate()
                + ", leaveEndDate=" + leaveDetails.getLeaveEndDate()
                + ", leaveReason='Medical Leave'}";
        assertEquals(expectedString, leaveDetails.toString());
    }
}
