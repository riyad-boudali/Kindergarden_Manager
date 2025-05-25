package com.example.kindergardenmanager.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.kindergardenmanager.data.database.Converters;
import com.example.kindergardenmanager.data.model.Attendance;
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
public final class AttendanceDao_Impl implements AttendanceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Attendance> __insertionAdapterOfAttendance;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Attendance> __deletionAdapterOfAttendance;

  private final EntityDeletionOrUpdateAdapter<Attendance> __updateAdapterOfAttendance;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAttendanceForClassAndDate;

  public AttendanceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAttendance = new EntityInsertionAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `attendance` (`attendanceId`,`childId`,`classId`,`date`,`isPresent`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.getAttendanceId());
        stmt.bindLong(2, value.getChildId());
        stmt.bindLong(3, value.getClassId());
        final Long _tmp = __converters.dateToTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        final int _tmp_1 = value.isPresent() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        if (value.getNotes() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNotes());
        }
      }
    };
    this.__deletionAdapterOfAttendance = new EntityDeletionOrUpdateAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `attendance` WHERE `attendanceId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.getAttendanceId());
      }
    };
    this.__updateAdapterOfAttendance = new EntityDeletionOrUpdateAdapter<Attendance>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `attendance` SET `attendanceId` = ?,`childId` = ?,`classId` = ?,`date` = ?,`isPresent` = ?,`notes` = ? WHERE `attendanceId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Attendance value) {
        stmt.bindLong(1, value.getAttendanceId());
        stmt.bindLong(2, value.getChildId());
        stmt.bindLong(3, value.getClassId());
        final Long _tmp = __converters.dateToTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp);
        }
        final int _tmp_1 = value.isPresent() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        if (value.getNotes() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNotes());
        }
        stmt.bindLong(7, value.getAttendanceId());
      }
    };
    this.__preparedStmtOfDeleteAttendanceForClassAndDate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM attendance WHERE classId = ? AND date = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAttendance(final Attendance attendance,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfAttendance.insertAndReturnId(attendance);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAttendance(final Attendance attendance,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAttendance.handle(attendance);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateAttendance(final Attendance attendance,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAttendance.handle(attendance);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAttendanceForClassAndDate(final long classId, final Date date,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAttendanceForClassAndDate.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, classId);
        _argIndex = 2;
        final Long _tmp = __converters.dateToTimestamp(date);
        if (_tmp == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindLong(_argIndex, _tmp);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAttendanceForClassAndDate.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAttendanceById(final long attendanceId,
      final Continuation<? super Attendance> continuation) {
    final String _sql = "SELECT * FROM attendance WHERE attendanceId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, attendanceId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Attendance>() {
      @Override
      public Attendance call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAttendanceId = CursorUtil.getColumnIndexOrThrow(_cursor, "attendanceId");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "isPresent");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final Attendance _result;
          if(_cursor.moveToFirst()) {
            final long _tmpAttendanceId;
            _tmpAttendanceId = _cursor.getLong(_cursorIndexOfAttendanceId);
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpIsPresent;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPresent);
            _tmpIsPresent = _tmp_1 != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _result = new Attendance(_tmpAttendanceId,_tmpChildId,_tmpClassId,_tmpDate,_tmpIsPresent,_tmpNotes);
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
  public LiveData<List<Attendance>> getAttendanceByChildId(final long childId) {
    final String _sql = "SELECT * FROM attendance WHERE childId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, childId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"attendance"}, false, new Callable<List<Attendance>>() {
      @Override
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAttendanceId = CursorUtil.getColumnIndexOrThrow(_cursor, "attendanceId");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "isPresent");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Attendance _item;
            final long _tmpAttendanceId;
            _tmpAttendanceId = _cursor.getLong(_cursorIndexOfAttendanceId);
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpIsPresent;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPresent);
            _tmpIsPresent = _tmp_1 != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new Attendance(_tmpAttendanceId,_tmpChildId,_tmpClassId,_tmpDate,_tmpIsPresent,_tmpNotes);
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
  public LiveData<List<Attendance>> getAttendanceByClassAndDate(final long classId,
      final Date date) {
    final String _sql = "SELECT * FROM attendance WHERE classId = ? AND date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    _argIndex = 2;
    final Long _tmp = __converters.dateToTimestamp(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"attendance"}, false, new Callable<List<Attendance>>() {
      @Override
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAttendanceId = CursorUtil.getColumnIndexOrThrow(_cursor, "attendanceId");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "isPresent");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Attendance _item;
            final long _tmpAttendanceId;
            _tmpAttendanceId = _cursor.getLong(_cursorIndexOfAttendanceId);
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsPresent;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsPresent);
            _tmpIsPresent = _tmp_2 != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new Attendance(_tmpAttendanceId,_tmpChildId,_tmpClassId,_tmpDate,_tmpIsPresent,_tmpNotes);
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
  public Object getAttendanceByChildAndDate(final long childId, final Date date,
      final Continuation<? super Attendance> continuation) {
    final String _sql = "SELECT * FROM attendance WHERE childId = ? AND date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, childId);
    _argIndex = 2;
    final Long _tmp = __converters.dateToTimestamp(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Attendance>() {
      @Override
      public Attendance call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAttendanceId = CursorUtil.getColumnIndexOrThrow(_cursor, "attendanceId");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "isPresent");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final Attendance _result;
          if(_cursor.moveToFirst()) {
            final long _tmpAttendanceId;
            _tmpAttendanceId = _cursor.getLong(_cursorIndexOfAttendanceId);
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsPresent;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsPresent);
            _tmpIsPresent = _tmp_2 != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _result = new Attendance(_tmpAttendanceId,_tmpChildId,_tmpClassId,_tmpDate,_tmpIsPresent,_tmpNotes);
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
  public LiveData<List<Attendance>> getAttendanceByClassAndDateRange(final long classId,
      final Date startDate, final Date endDate) {
    final String _sql = "SELECT * FROM attendance WHERE classId = ? AND date BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    _argIndex = 2;
    final Long _tmp = __converters.dateToTimestamp(startDate);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 3;
    final Long _tmp_1 = __converters.dateToTimestamp(endDate);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"attendance"}, false, new Callable<List<Attendance>>() {
      @Override
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAttendanceId = CursorUtil.getColumnIndexOrThrow(_cursor, "attendanceId");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "isPresent");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Attendance _item;
            final long _tmpAttendanceId;
            _tmpAttendanceId = _cursor.getLong(_cursorIndexOfAttendanceId);
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final Date _tmpDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp_2);
            final boolean _tmpIsPresent;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsPresent);
            _tmpIsPresent = _tmp_3 != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new Attendance(_tmpAttendanceId,_tmpChildId,_tmpClassId,_tmpDate,_tmpIsPresent,_tmpNotes);
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
  public LiveData<Integer> getChildPresentDaysCount(final long childId) {
    final String _sql = "SELECT COUNT(*) FROM attendance WHERE childId = ? AND isPresent = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, childId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"attendance"}, false, new Callable<Integer>() {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getAttendanceWithChildInfo(final long classId, final Date date,
      final Continuation<? super List<Attendance>> continuation) {
    final String _sql = "SELECT * FROM attendance WHERE classId = ? AND date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    _argIndex = 2;
    final Long _tmp = __converters.dateToTimestamp(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Attendance>>() {
      @Override
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAttendanceId = CursorUtil.getColumnIndexOrThrow(_cursor, "attendanceId");
          final int _cursorIndexOfChildId = CursorUtil.getColumnIndexOrThrow(_cursor, "childId");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "isPresent");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Attendance _item;
            final long _tmpAttendanceId;
            _tmpAttendanceId = _cursor.getLong(_cursorIndexOfAttendanceId);
            final long _tmpChildId;
            _tmpChildId = _cursor.getLong(_cursorIndexOfChildId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final Date _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp_1);
            final boolean _tmpIsPresent;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsPresent);
            _tmpIsPresent = _tmp_2 != 0;
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _item = new Attendance(_tmpAttendanceId,_tmpChildId,_tmpClassId,_tmpDate,_tmpIsPresent,_tmpNotes);
            _result.add(_item);
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
