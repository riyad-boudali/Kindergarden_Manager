package com.example.kindergardenmanager.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020)H\u0002J\u0018\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0010\u00104\u001a\u0002002\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020)H\u0002J\u0010\u00108\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/example/kindergardenmanager/ui/activity/TakeAttendanceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter$AttendanceListener;", "()V", "adapter", "Lcom/example/kindergardenmanager/ui/adapter/AttendanceAdapter;", "attendanceRepository", "Lcom/example/kindergardenmanager/data/repository/AttendanceRepository;", "btnChangeDate", "Landroid/widget/Button;", "btnMarkAll", "btnSaveAttendance", "btnUnmarkAll", "childRepository", "Lcom/example/kindergardenmanager/data/repository/ChildRepository;", "children", "", "Lcom/example/kindergardenmanager/data/model/Child;", "classId", "", "classRepository", "Lcom/example/kindergardenmanager/data/repository/ClassRepository;", "dateFormat", "Ljava/text/SimpleDateFormat;", "kindergartenClass", "Lcom/example/kindergardenmanager/data/model/KindergartenClass;", "progressBar", "Landroid/widget/ProgressBar;", "recyclerViewAttendance", "Landroidx/recyclerview/widget/RecyclerView;", "selectedDate", "Ljava/util/Date;", "sessionManager", "Lcom/example/kindergardenmanager/util/SessionManager;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "tvClassName", "Landroid/widget/TextView;", "tvNoStudents", "tvSelectedDate", "checkExistingAttendance", "", "initUI", "loadClassDetails", "loadStudents", "onAttendanceChanged", "childId", "isPresent", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "saveAttendance", "setAllAttendance", "setupToolbar", "showDatePickerDialog", "showLoading", "isLoading", "app_debug"})
public final class TakeAttendanceActivity extends androidx.appcompat.app.AppCompatActivity implements com.example.kindergardenmanager.ui.adapter.AttendanceAdapter.AttendanceListener {
    private com.example.kindergardenmanager.data.repository.ClassRepository classRepository;
    private com.example.kindergardenmanager.data.repository.ChildRepository childRepository;
    private com.example.kindergardenmanager.data.repository.AttendanceRepository attendanceRepository;
    private com.example.kindergardenmanager.util.SessionManager sessionManager;
    private androidx.appcompat.widget.Toolbar toolbar;
    private android.widget.TextView tvClassName;
    private android.widget.TextView tvSelectedDate;
    private android.widget.Button btnChangeDate;
    private androidx.recyclerview.widget.RecyclerView recyclerViewAttendance;
    private android.widget.TextView tvNoStudents;
    private android.widget.ProgressBar progressBar;
    private android.widget.Button btnMarkAll;
    private android.widget.Button btnUnmarkAll;
    private android.widget.Button btnSaveAttendance;
    private com.example.kindergardenmanager.ui.adapter.AttendanceAdapter adapter;
    private long classId = 0L;
    private java.util.Date selectedDate;
    private java.text.SimpleDateFormat dateFormat;
    private com.example.kindergardenmanager.data.model.KindergartenClass kindergartenClass;
    private java.util.List<com.example.kindergardenmanager.data.model.Child> children;
    
    public TakeAttendanceActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initUI() {
    }
    
    private final void setupToolbar() {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void loadClassDetails() {
    }
    
    private final void loadStudents() {
    }
    
    private final void checkExistingAttendance() {
    }
    
    private final void showDatePickerDialog() {
    }
    
    private final void setAllAttendance(boolean isPresent) {
    }
    
    private final void saveAttendance() {
    }
    
    @java.lang.Override
    public void onAttendanceChanged(long childId, boolean isPresent) {
    }
    
    private final void showLoading(boolean isLoading) {
    }
}