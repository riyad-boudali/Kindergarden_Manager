package com.example.kindergardenmanager.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.kindergardenmanager.data.database.Converters;
import com.example.kindergardenmanager.data.model.Child;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ChildDao_Impl implements ChildDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Child> __insertionAdapterOfChild;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Child> __deletionAdapterOfChild;

  private final EntityDeletionOrUpdateAdapter<Child> __updateAdapterOfChild;

  public ChildDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChild = new EntityInsertionAdapter<Child>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `children` (`childId`,`firstName`,`lastName`,`birthDate`,`parentId`,`classId`,`gender`,`allergies`,`medicalNotes`,`emergencyContact`,`enrollmentDate`,`isActive`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Child value) {
        stmt.bindLong(1, value.getChildId());
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
        final Long _tmp = __converters.dateToTimestamp(value.getBirthDate());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        stmt.bindLong(5, value.getParentId());
        if (value.getClassId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getClassId());
        }
        if (value.getGender() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGender());
        }
        if (value.getAllergies() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAllergies());
        }
        if (value.getMedicalNotes() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMedicalNotes());
        }
        if (value.getEmergencyContact() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEmergencyContact());
        }
        final Long _tmp_1 = __converters.dateToTimestamp(value.getEnrollmentDate());
        if (_tmp_1 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp_1);
        }
        final int _tmp_2 = value.isActive() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
      }
    };
    this.__deletionAdapterOfChild = new EntityDeletionOrUpdateAdapter<Child>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `children` WHERE `childId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Child value) {
        stmt.bindLong(1, value.getChildId());
      }
    };
    this.__updateAdapterOfChild = new EntityDeletionOrUpdateAdapter<Child>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `children` SET `childId` = ?,`firstName` = ?,`lastName` = ?,`birthDate` = ?,`parentId` = ?,`classId` = ?,`gender` = ?,`allergies` = ?,`medicalNotes` = ?,`emergencyContact` = ?,`enrollmentDate` = ?,`isActive` = ? WHERE `childId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Child value) {
        stmt.bindLong(1, value.getChildId());
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
        final Long _tmp = __converters.dateToTimestamp(value.getBirthDate());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        stmt.bindLong(5, value.getParentId());
        if (value.getClassId() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getClassId());
        }
        if (value.getGender() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGender());
        }
        if (value.getAllergies() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAllergies());
        }
        if (value.getMedicalNotes() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMedicalNotes());
        }
        if (value.getEmergencyContact() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getEmergencyContact());
        }
        final Long _tmp_1 = __converters.dateToTimestamp(value.getEnrollmentDate());
        if (_tmp_1 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, _tmp_1);
        }
        final int _tmp_2 = value.isActive() ? 1 : 0;
        stmt.bindLong(12, _tmp_2);
        stmt.bindLong(13, value.getChildId());
      }
    };
  }

  @Override
  public Object insertChild(final Child child, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfChild.insertAndReturnId(child);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteChild(final Child child, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfChild.handle(child);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateChild(final Child child, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfChild.handle(child);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getChildById(final long childId, final Continuation<? super Child> continuation) {
    final String _sql = "SELECT * FROM children WHERE childId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, childId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Child>() {
      @Override
      public Child call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parentId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfMedicalNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalNotes");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfEnrollmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "enrollmentDate");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final Child _result;
          if(_cursor.moveToFirst()) {
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final Date _tmpBirthDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __converters.fromTimestamp(_tmp);
            final long _tmpParentId;
            _tmpParentId = _cursor.getLong(_cursorIndexOfParentId);
            final Long _tmpClassId;
            if (_cursor.isNull(_cursorIndexOfClassId)) {
              _tmpClassId = null;
            } else {
              _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpMedicalNotes;
            if (_cursor.isNull(_cursorIndexOfMedicalNotes)) {
              _tmpMedicalNotes = null;
            } else {
              _tmpMedicalNotes = _cursor.getString(_cursorIndexOfMedicalNotes);
            }
            final String _tmpEmergencyContact;
            if (_cursor.isNull(_cursorIndexOfEmergencyContact)) {
              _tmpEmergencyContact = null;
            } else {
              _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            }
            final Date _tmpEnrollmentDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEnrollmentDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfEnrollmentDate);
            }
            _tmpEnrollmentDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            _result = new Child(_tmpChildId,_tmpFirstName,_tmpLastName,_tmpBirthDate,_tmpParentId,_tmpClassId,_tmpGender,_tmpAllergies,_tmpMedicalNotes,_tmpEmergencyContact,_tmpEnrollmentDate,_tmpIsActive);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Child>> getChildrenByParentId(final long parentId) {
    final String _sql = "SELECT * FROM children WHERE parentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, parentId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"children"}, false, new Callable<List<Child>>() {
      @Override
      public List<Child> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parentId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfMedicalNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalNotes");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfEnrollmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "enrollmentDate");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Child> _result = new ArrayList<Child>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Child _item;
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final Date _tmpBirthDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __converters.fromTimestamp(_tmp);
            final long _tmpParentId;
            _tmpParentId = _cursor.getLong(_cursorIndexOfParentId);
            final Long _tmpClassId;
            if (_cursor.isNull(_cursorIndexOfClassId)) {
              _tmpClassId = null;
            } else {
              _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpMedicalNotes;
            if (_cursor.isNull(_cursorIndexOfMedicalNotes)) {
              _tmpMedicalNotes = null;
            } else {
              _tmpMedicalNotes = _cursor.getString(_cursorIndexOfMedicalNotes);
            }
            final String _tmpEmergencyContact;
            if (_cursor.isNull(_cursorIndexOfEmergencyContact)) {
              _tmpEmergencyContact = null;
            } else {
              _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            }
            final Date _tmpEnrollmentDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEnrollmentDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfEnrollmentDate);
            }
            _tmpEnrollmentDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            _item = new Child(_tmpChildId,_tmpFirstName,_tmpLastName,_tmpBirthDate,_tmpParentId,_tmpClassId,_tmpGender,_tmpAllergies,_tmpMedicalNotes,_tmpEmergencyContact,_tmpEnrollmentDate,_tmpIsActive);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Child>> getChildrenByClassId(final long classId) {
    final String _sql = "SELECT * FROM children WHERE classId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"children"}, false, new Callable<List<Child>>() {
      @Override
      public List<Child> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parentId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfMedicalNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalNotes");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfEnrollmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "enrollmentDate");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Child> _result = new ArrayList<Child>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Child _item;
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final Date _tmpBirthDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __converters.fromTimestamp(_tmp);
            final long _tmpParentId;
            _tmpParentId = _cursor.getLong(_cursorIndexOfParentId);
            final Long _tmpClassId;
            if (_cursor.isNull(_cursorIndexOfClassId)) {
              _tmpClassId = null;
            } else {
              _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpMedicalNotes;
            if (_cursor.isNull(_cursorIndexOfMedicalNotes)) {
              _tmpMedicalNotes = null;
            } else {
              _tmpMedicalNotes = _cursor.getString(_cursorIndexOfMedicalNotes);
            }
            final String _tmpEmergencyContact;
            if (_cursor.isNull(_cursorIndexOfEmergencyContact)) {
              _tmpEmergencyContact = null;
            } else {
              _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            }
            final Date _tmpEnrollmentDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEnrollmentDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfEnrollmentDate);
            }
            _tmpEnrollmentDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            _item = new Child(_tmpChildId,_tmpFirstName,_tmpLastName,_tmpBirthDate,_tmpParentId,_tmpClassId,_tmpGender,_tmpAllergies,_tmpMedicalNotes,_tmpEmergencyContact,_tmpEnrollmentDate,_tmpIsActive);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Child>> getAllChildren() {
    final String _sql = "SELECT * FROM children";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"children"}, false, new Callable<List<Child>>() {
      @Override
      public List<Child> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parentId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfMedicalNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalNotes");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfEnrollmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "enrollmentDate");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Child> _result = new ArrayList<Child>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Child _item;
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final Date _tmpBirthDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __converters.fromTimestamp(_tmp);
            final long _tmpParentId;
            _tmpParentId = _cursor.getLong(_cursorIndexOfParentId);
            final Long _tmpClassId;
            if (_cursor.isNull(_cursorIndexOfClassId)) {
              _tmpClassId = null;
            } else {
              _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpMedicalNotes;
            if (_cursor.isNull(_cursorIndexOfMedicalNotes)) {
              _tmpMedicalNotes = null;
            } else {
              _tmpMedicalNotes = _cursor.getString(_cursorIndexOfMedicalNotes);
            }
            final String _tmpEmergencyContact;
            if (_cursor.isNull(_cursorIndexOfEmergencyContact)) {
              _tmpEmergencyContact = null;
            } else {
              _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            }
            final Date _tmpEnrollmentDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEnrollmentDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfEnrollmentDate);
            }
            _tmpEnrollmentDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            _item = new Child(_tmpChildId,_tmpFirstName,_tmpLastName,_tmpBirthDate,_tmpParentId,_tmpClassId,_tmpGender,_tmpAllergies,_tmpMedicalNotes,_tmpEmergencyContact,_tmpEnrollmentDate,_tmpIsActive);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Child>> getActiveChildren() {
    final String _sql = "SELECT * FROM children WHERE isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"children"}, false, new Callable<List<Child>>() {
      @Override
      public List<Child> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfParentId = CursorUtil.getColumnIndexOrThrow(_cursor, "parentId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfAllergies = CursorUtil.getColumnIndexOrThrow(_cursor, "allergies");
          final int _cursorIndexOfMedicalNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "medicalNotes");
          final int _cursorIndexOfEmergencyContact = CursorUtil.getColumnIndexOrThrow(_cursor, "emergencyContact");
          final int _cursorIndexOfEnrollmentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "enrollmentDate");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Child> _result = new ArrayList<Child>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Child _item;
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final String _tmpFirstName;
            if (_cursor.isNull(_cursorIndexOfFirstName)) {
              _tmpFirstName = null;
            } else {
              _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
            }
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            final Date _tmpBirthDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfBirthDate);
            }
            _tmpBirthDate = __converters.fromTimestamp(_tmp);
            final long _tmpParentId;
            _tmpParentId = _cursor.getLong(_cursorIndexOfParentId);
            final Long _tmpClassId;
            if (_cursor.isNull(_cursorIndexOfClassId)) {
              _tmpClassId = null;
            } else {
              _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            }
            final String _tmpGender;
            if (_cursor.isNull(_cursorIndexOfGender)) {
              _tmpGender = null;
            } else {
              _tmpGender = _cursor.getString(_cursorIndexOfGender);
            }
            final String _tmpAllergies;
            if (_cursor.isNull(_cursorIndexOfAllergies)) {
              _tmpAllergies = null;
            } else {
              _tmpAllergies = _cursor.getString(_cursorIndexOfAllergies);
            }
            final String _tmpMedicalNotes;
            if (_cursor.isNull(_cursorIndexOfMedicalNotes)) {
              _tmpMedicalNotes = null;
            } else {
              _tmpMedicalNotes = _cursor.getString(_cursorIndexOfMedicalNotes);
            }
            final String _tmpEmergencyContact;
            if (_cursor.isNull(_cursorIndexOfEmergencyContact)) {
              _tmpEmergencyContact = null;
            } else {
              _tmpEmergencyContact = _cursor.getString(_cursorIndexOfEmergencyContact);
            }
            final Date _tmpEnrollmentDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfEnrollmentDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfEnrollmentDate);
            }
            _tmpEnrollmentDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsActive;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_2 != 0;
            _item = new Child(_tmpChildId,_tmpFirstName,_tmpLastName,_tmpBirthDate,_tmpParentId,_tmpClassId,_tmpGender,_tmpAllergies,_tmpMedicalNotes,_tmpEmergencyContact,_tmpEnrollmentDate,_tmpIsActive);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getChildrenCountByClassId(final long classId,
      final Continuation<? super Integer> continuation) {
    final String _sql = "SELECT COUNT(*) FROM children WHERE classId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
