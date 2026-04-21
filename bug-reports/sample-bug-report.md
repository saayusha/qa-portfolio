# Bug Report Template

---

## Bug ID: BUG_001
**Project:** MeroPet  
**Module:** Appointment Booking  
**Reported By:** Aayusha Sharma  
**Date:** 2026-04-21  
**Severity:** High  
**Priority:** High  
**Status:** Fixed  

### Summary
Order status does not update in real-time after marking as Delivered.

### Environment
- OS: Windows 11
- Browser: Chrome 124
- App Version: v1.2.3

### Steps to Reproduce
1. Login as user/admin
2. Go to Appointment Booking
3. Select pet and doctor
4. Choose a past date and time
5. Click Book Appointment

### Expected Result
The system should prevent booking for past dates/times and display a validation message such as:

Appointment date and time cannot be in the past.

### Actual Result
Appointment is successfully created even when a past date and time is selected.



## Bug ID: BUG_002
**Project:** MeroPet  
**Module:** Login  
**Severity:** Medium  
**Status:** Fixed  

### Summary
No validation error shown when email field is left empty on login form.

### Steps to Reproduce
1. Open login page
2. Leave email field blank
3. Enter any password
4. Click Login

### Expected Result
Validation message: "Email is required"

### Actual Result
Form submits and shows generic server error instead of field-level validation.
