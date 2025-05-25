# Kindergarten Manager

An Android application for managing kindergartens, including students, classes, teachers, and enrollments.

## Features

- Admin Dashboard for managing kindergarten operations
- User Management (Teachers, Parents, Staff)
- Class Management (Create, Edit, Delete classes)
- Student Enrollment Management
- Attendance Tracking

## Recent Fixes

### Database Migration Issues
- Added proper database migration between versions 1-2 and 2-3
- Used `fallbackToDestructiveMigration()` to prevent crashes when schema changes
- Added proper SQL statements to ensure tables exist with correct structure

### Error Handling
- Added try/catch blocks in key activities:
  - `ManageClassesActivity`
  - `ManageEnrollmentsActivity` 
  - `ClassDetailAdminActivity`
- Simplified complex code paths to reduce crash potential

### Navigation Issues
- Fixed navigation between activities with proper intent handling
- Added error handling for invalid data in intent extras

## Build and Installation
- Compile with Android Studio or Gradle
- Minimum SDK: 21 (Android 5.0)
- Target SDK: 31 (Android 12)

## Testing
- Unit tests for database migrations
- UI tests to verify activities open without crashing
