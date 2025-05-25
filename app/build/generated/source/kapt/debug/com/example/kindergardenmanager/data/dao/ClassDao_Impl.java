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
import com.example.kindergardenmanager.data.model.KindergartenClass;
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
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ClassDao_Impl implements ClassDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<KindergartenClass> __insertionAdapterOfKindergartenClass;

  private final EntityDeletionOrUpdateAdapter<KindergartenClass> __deletionAdapterOfKindergartenClass;

  private final EntityDeletionOrUpdateAdapter<KindergartenClass> __updateAdapterOfKindergartenClass;

  public ClassDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKindergartenClass = new EntityInsertionAdapter<KindergartenClass>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `classes` (`classId`,`className`,`ageRangeStart`,`ageRangeEnd`,`teacherId`,`capacity`,`roomNumber`,`description`,`isActive`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KindergartenClass value) {
        stmt.bindLong(1, value.getClassId());
        if (value.getClassName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClassName());
        }
        stmt.bindLong(3, value.getAgeRangeStart());
        stmt.bindLong(4, value.getAgeRangeEnd());
        stmt.bindLong(5, value.getTeacherId());
        stmt.bindLong(6, value.getCapacity());
        if (value.getRoomNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRoomNumber());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDescription());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(9, _tmp);
      }
    };
    this.__deletionAdapterOfKindergartenClass = new EntityDeletionOrUpdateAdapter<KindergartenClass>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `classes` WHERE `classId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KindergartenClass value) {
        stmt.bindLong(1, value.getClassId());
      }
    };
    this.__updateAdapterOfKindergartenClass = new EntityDeletionOrUpdateAdapter<KindergartenClass>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `classes` SET `classId` = ?,`className` = ?,`ageRangeStart` = ?,`ageRangeEnd` = ?,`teacherId` = ?,`capacity` = ?,`roomNumber` = ?,`description` = ?,`isActive` = ? WHERE `classId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KindergartenClass value) {
        stmt.bindLong(1, value.getClassId());
        if (value.getClassName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClassName());
        }
        stmt.bindLong(3, value.getAgeRangeStart());
        stmt.bindLong(4, value.getAgeRangeEnd());
        stmt.bindLong(5, value.getTeacherId());
        stmt.bindLong(6, value.getCapacity());
        if (value.getRoomNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRoomNumber());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDescription());
        }
        final int _tmp = value.isActive() ? 1 : 0;
        stmt.bindLong(9, _tmp);
        stmt.bindLong(10, value.getClassId());
      }
    };
  }

  @Override
  public Object insertClass(final KindergartenClass kindergartenClass,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfKindergartenClass.insertAndReturnId(kindergartenClass);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteClass(final KindergartenClass kindergartenClass,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfKindergartenClass.handle(kindergartenClass);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateClass(final KindergartenClass kindergartenClass,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfKindergartenClass.handle(kindergartenClass);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getClassById(final long classId,
      final Continuation<? super KindergartenClass> continuation) {
    final String _sql = "SELECT * FROM classes WHERE classId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<KindergartenClass>() {
      @Override
      public KindergartenClass call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfAgeRangeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeStart");
          final int _cursorIndexOfAgeRangeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeEnd");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final KindergartenClass _result;
          if(_cursor.moveToFirst()) {
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpAgeRangeStart;
            _tmpAgeRangeStart = _cursor.getInt(_cursorIndexOfAgeRangeStart);
            final int _tmpAgeRangeEnd;
            _tmpAgeRangeEnd = _cursor.getInt(_cursorIndexOfAgeRangeEnd);
            final long _tmpTeacherId;
            _tmpTeacherId = _cursor.getLong(_cursorIndexOfTeacherId);
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpRoomNumber;
            if (_cursor.isNull(_cursorIndexOfRoomNumber)) {
              _tmpRoomNumber = null;
            } else {
              _tmpRoomNumber = _cursor.getString(_cursorIndexOfRoomNumber);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _result = new KindergartenClass(_tmpClassId,_tmpClassName,_tmpAgeRangeStart,_tmpAgeRangeEnd,_tmpTeacherId,_tmpCapacity,_tmpRoomNumber,_tmpDescription,_tmpIsActive);
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
  public LiveData<List<KindergartenClass>> getClassesByTeacherId(final long teacherId) {
    final String _sql = "SELECT * FROM classes WHERE teacherId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, teacherId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"classes"}, false, new Callable<List<KindergartenClass>>() {
      @Override
      public List<KindergartenClass> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfAgeRangeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeStart");
          final int _cursorIndexOfAgeRangeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeEnd");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<KindergartenClass> _result = new ArrayList<KindergartenClass>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KindergartenClass _item;
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpAgeRangeStart;
            _tmpAgeRangeStart = _cursor.getInt(_cursorIndexOfAgeRangeStart);
            final int _tmpAgeRangeEnd;
            _tmpAgeRangeEnd = _cursor.getInt(_cursorIndexOfAgeRangeEnd);
            final long _tmpTeacherId;
            _tmpTeacherId = _cursor.getLong(_cursorIndexOfTeacherId);
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpRoomNumber;
            if (_cursor.isNull(_cursorIndexOfRoomNumber)) {
              _tmpRoomNumber = null;
            } else {
              _tmpRoomNumber = _cursor.getString(_cursorIndexOfRoomNumber);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new KindergartenClass(_tmpClassId,_tmpClassName,_tmpAgeRangeStart,_tmpAgeRangeEnd,_tmpTeacherId,_tmpCapacity,_tmpRoomNumber,_tmpDescription,_tmpIsActive);
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
  public LiveData<List<KindergartenClass>> getAllClasses() {
    final String _sql = "SELECT * FROM classes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"classes"}, false, new Callable<List<KindergartenClass>>() {
      @Override
      public List<KindergartenClass> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfAgeRangeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeStart");
          final int _cursorIndexOfAgeRangeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeEnd");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<KindergartenClass> _result = new ArrayList<KindergartenClass>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KindergartenClass _item;
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpAgeRangeStart;
            _tmpAgeRangeStart = _cursor.getInt(_cursorIndexOfAgeRangeStart);
            final int _tmpAgeRangeEnd;
            _tmpAgeRangeEnd = _cursor.getInt(_cursorIndexOfAgeRangeEnd);
            final long _tmpTeacherId;
            _tmpTeacherId = _cursor.getLong(_cursorIndexOfTeacherId);
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpRoomNumber;
            if (_cursor.isNull(_cursorIndexOfRoomNumber)) {
              _tmpRoomNumber = null;
            } else {
              _tmpRoomNumber = _cursor.getString(_cursorIndexOfRoomNumber);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new KindergartenClass(_tmpClassId,_tmpClassName,_tmpAgeRangeStart,_tmpAgeRangeEnd,_tmpTeacherId,_tmpCapacity,_tmpRoomNumber,_tmpDescription,_tmpIsActive);
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
  public LiveData<Integer> getChildCountForClass(final long classId) {
    final String _sql = "SELECT COUNT(*) FROM children WHERE classId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"children"}, false, new Callable<Integer>() {
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
  public LiveData<List<KindergartenClass>> getActiveClasses() {
    final String _sql = "SELECT * FROM classes WHERE isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"classes"}, false, new Callable<List<KindergartenClass>>() {
      @Override
      public List<KindergartenClass> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfAgeRangeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeStart");
          final int _cursorIndexOfAgeRangeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "ageRangeEnd");
          final int _cursorIndexOfTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherId");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<KindergartenClass> _result = new ArrayList<KindergartenClass>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final KindergartenClass _item;
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final int _tmpAgeRangeStart;
            _tmpAgeRangeStart = _cursor.getInt(_cursorIndexOfAgeRangeStart);
            final int _tmpAgeRangeEnd;
            _tmpAgeRangeEnd = _cursor.getInt(_cursorIndexOfAgeRangeEnd);
            final long _tmpTeacherId;
            _tmpTeacherId = _cursor.getLong(_cursorIndexOfTeacherId);
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpRoomNumber;
            if (_cursor.isNull(_cursorIndexOfRoomNumber)) {
              _tmpRoomNumber = null;
            } else {
              _tmpRoomNumber = _cursor.getString(_cursorIndexOfRoomNumber);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new KindergartenClass(_tmpClassId,_tmpClassName,_tmpAgeRangeStart,_tmpAgeRangeEnd,_tmpTeacherId,_tmpCapacity,_tmpRoomNumber,_tmpDescription,_tmpIsActive);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
