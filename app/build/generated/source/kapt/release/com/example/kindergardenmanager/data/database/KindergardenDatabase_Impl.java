package com.example.kindergardenmanager.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.kindergardenmanager.data.dao.AttendanceDao;
import com.example.kindergardenmanager.data.dao.AttendanceDao_Impl;
import com.example.kindergardenmanager.data.dao.ChildDao;
import com.example.kindergardenmanager.data.dao.ChildDao_Impl;
import com.example.kindergardenmanager.data.dao.ClassDao;
import com.example.kindergardenmanager.data.dao.ClassDao_Impl;
import com.example.kindergardenmanager.data.dao.MessageDao;
import com.example.kindergardenmanager.data.dao.MessageDao_Impl;
import com.example.kindergardenmanager.data.dao.UserDao;
import com.example.kindergardenmanager.data.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class KindergardenDatabase_Impl extends KindergardenDatabase {
  private volatile UserDao _userDao;

  private volatile ClassDao _classDao;

  private volatile ChildDao _childDao;

  private volatile AttendanceDao _attendanceDao;

  private volatile MessageDao _messageDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`userId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `username` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `role` TEXT NOT NULL, `firstName` TEXT NOT NULL, `lastName` TEXT NOT NULL, `phoneNumber` TEXT, `isActive` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `classes` (`classId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `className` TEXT NOT NULL, `ageRangeStart` INTEGER NOT NULL, `ageRangeEnd` INTEGER NOT NULL, `teacherId` INTEGER NOT NULL, `capacity` INTEGER NOT NULL, `roomNumber` TEXT, `description` TEXT, `isActive` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `children` (`childId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `firstName` TEXT NOT NULL, `lastName` TEXT NOT NULL, `birthDate` INTEGER NOT NULL, `parentId` INTEGER NOT NULL, `classId` INTEGER, `gender` TEXT NOT NULL, `allergies` TEXT, `medicalNotes` TEXT, `emergencyContact` TEXT, `enrollmentDate` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, FOREIGN KEY(`parentId`) REFERENCES `users`(`userId`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`classId`) REFERENCES `classes`(`classId`) ON UPDATE NO ACTION ON DELETE SET NULL )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_children_parentId` ON `children` (`parentId`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_children_classId` ON `children` (`classId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `attendance` (`attendanceId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `childId` INTEGER NOT NULL, `classId` INTEGER NOT NULL, `date` INTEGER NOT NULL, `isPresent` INTEGER NOT NULL, `notes` TEXT, FOREIGN KEY(`childId`) REFERENCES `children`(`childId`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`classId`) REFERENCES `classes`(`classId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_attendance_childId` ON `attendance` (`childId`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_attendance_classId` ON `attendance` (`classId`)");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_attendance_childId_date` ON `attendance` (`childId`, `date`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `messages` (`messageId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `senderId` INTEGER NOT NULL, `recipientId` INTEGER NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, FOREIGN KEY(`senderId`) REFERENCES `users`(`userId`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`recipientId`) REFERENCES `users`(`userId`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_messages_senderId` ON `messages` (`senderId`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `index_messages_recipientId` ON `messages` (`recipientId`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'df078e6b49c95e9a4ce4ff69883ccc8d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `users`");
        _db.execSQL("DROP TABLE IF EXISTS `classes`");
        _db.execSQL("DROP TABLE IF EXISTS `children`");
        _db.execSQL("DROP TABLE IF EXISTS `attendance`");
        _db.execSQL("DROP TABLE IF EXISTS `messages`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(9);
        _columnsUsers.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("firstName", new TableInfo.Column("firstName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("lastName", new TableInfo.Column("lastName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(_db, "users");
        if (! _infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.example.kindergardenmanager.data.model.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsClasses = new HashMap<String, TableInfo.Column>(9);
        _columnsClasses.put("classId", new TableInfo.Column("classId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("className", new TableInfo.Column("className", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("ageRangeStart", new TableInfo.Column("ageRangeStart", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("ageRangeEnd", new TableInfo.Column("ageRangeEnd", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("teacherId", new TableInfo.Column("teacherId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("capacity", new TableInfo.Column("capacity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("roomNumber", new TableInfo.Column("roomNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClasses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClasses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClasses = new TableInfo("classes", _columnsClasses, _foreignKeysClasses, _indicesClasses);
        final TableInfo _existingClasses = TableInfo.read(_db, "classes");
        if (! _infoClasses.equals(_existingClasses)) {
          return new RoomOpenHelper.ValidationResult(false, "classes(com.example.kindergardenmanager.data.model.KindergartenClass).\n"
                  + " Expected:\n" + _infoClasses + "\n"
                  + " Found:\n" + _existingClasses);
        }
        final HashMap<String, TableInfo.Column> _columnsChildren = new HashMap<String, TableInfo.Column>(12);
        _columnsChildren.put("childId", new TableInfo.Column("childId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("firstName", new TableInfo.Column("firstName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("lastName", new TableInfo.Column("lastName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("birthDate", new TableInfo.Column("birthDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("parentId", new TableInfo.Column("parentId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("classId", new TableInfo.Column("classId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("gender", new TableInfo.Column("gender", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("allergies", new TableInfo.Column("allergies", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("medicalNotes", new TableInfo.Column("medicalNotes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("emergencyContact", new TableInfo.Column("emergencyContact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("enrollmentDate", new TableInfo.Column("enrollmentDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsChildren.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysChildren = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysChildren.add(new TableInfo.ForeignKey("users", "CASCADE", "NO ACTION",Arrays.asList("parentId"), Arrays.asList("userId")));
        _foreignKeysChildren.add(new TableInfo.ForeignKey("classes", "SET NULL", "NO ACTION",Arrays.asList("classId"), Arrays.asList("classId")));
        final HashSet<TableInfo.Index> _indicesChildren = new HashSet<TableInfo.Index>(2);
        _indicesChildren.add(new TableInfo.Index("index_children_parentId", false, Arrays.asList("parentId"), Arrays.asList("ASC")));
        _indicesChildren.add(new TableInfo.Index("index_children_classId", false, Arrays.asList("classId"), Arrays.asList("ASC")));
        final TableInfo _infoChildren = new TableInfo("children", _columnsChildren, _foreignKeysChildren, _indicesChildren);
        final TableInfo _existingChildren = TableInfo.read(_db, "children");
        if (! _infoChildren.equals(_existingChildren)) {
          return new RoomOpenHelper.ValidationResult(false, "children(com.example.kindergardenmanager.data.model.Child).\n"
                  + " Expected:\n" + _infoChildren + "\n"
                  + " Found:\n" + _existingChildren);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendance = new HashMap<String, TableInfo.Column>(6);
        _columnsAttendance.put("attendanceId", new TableInfo.Column("attendanceId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("childId", new TableInfo.Column("childId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("classId", new TableInfo.Column("classId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("isPresent", new TableInfo.Column("isPresent", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendance = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysAttendance.add(new TableInfo.ForeignKey("children", "CASCADE", "NO ACTION",Arrays.asList("childId"), Arrays.asList("childId")));
        _foreignKeysAttendance.add(new TableInfo.ForeignKey("classes", "CASCADE", "NO ACTION",Arrays.asList("classId"), Arrays.asList("classId")));
        final HashSet<TableInfo.Index> _indicesAttendance = new HashSet<TableInfo.Index>(3);
        _indicesAttendance.add(new TableInfo.Index("index_attendance_childId", false, Arrays.asList("childId"), Arrays.asList("ASC")));
        _indicesAttendance.add(new TableInfo.Index("index_attendance_classId", false, Arrays.asList("classId"), Arrays.asList("ASC")));
        _indicesAttendance.add(new TableInfo.Index("index_attendance_childId_date", true, Arrays.asList("childId","date"), Arrays.asList("ASC","ASC")));
        final TableInfo _infoAttendance = new TableInfo("attendance", _columnsAttendance, _foreignKeysAttendance, _indicesAttendance);
        final TableInfo _existingAttendance = TableInfo.read(_db, "attendance");
        if (! _infoAttendance.equals(_existingAttendance)) {
          return new RoomOpenHelper.ValidationResult(false, "attendance(com.example.kindergardenmanager.data.model.Attendance).\n"
                  + " Expected:\n" + _infoAttendance + "\n"
                  + " Found:\n" + _existingAttendance);
        }
        final HashMap<String, TableInfo.Column> _columnsMessages = new HashMap<String, TableInfo.Column>(7);
        _columnsMessages.put("messageId", new TableInfo.Column("messageId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("senderId", new TableInfo.Column("senderId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("recipientId", new TableInfo.Column("recipientId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessages.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMessages = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysMessages.add(new TableInfo.ForeignKey("users", "CASCADE", "NO ACTION",Arrays.asList("senderId"), Arrays.asList("userId")));
        _foreignKeysMessages.add(new TableInfo.ForeignKey("users", "CASCADE", "NO ACTION",Arrays.asList("recipientId"), Arrays.asList("userId")));
        final HashSet<TableInfo.Index> _indicesMessages = new HashSet<TableInfo.Index>(2);
        _indicesMessages.add(new TableInfo.Index("index_messages_senderId", false, Arrays.asList("senderId"), Arrays.asList("ASC")));
        _indicesMessages.add(new TableInfo.Index("index_messages_recipientId", false, Arrays.asList("recipientId"), Arrays.asList("ASC")));
        final TableInfo _infoMessages = new TableInfo("messages", _columnsMessages, _foreignKeysMessages, _indicesMessages);
        final TableInfo _existingMessages = TableInfo.read(_db, "messages");
        if (! _infoMessages.equals(_existingMessages)) {
          return new RoomOpenHelper.ValidationResult(false, "messages(com.example.kindergardenmanager.data.model.Message).\n"
                  + " Expected:\n" + _infoMessages + "\n"
                  + " Found:\n" + _existingMessages);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "df078e6b49c95e9a4ce4ff69883ccc8d", "950d930115cd14b5ac59009d1260710b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","classes","children","attendance","messages");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `classes`");
      _db.execSQL("DELETE FROM `children`");
      _db.execSQL("DELETE FROM `attendance`");
      _db.execSQL("DELETE FROM `messages`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ClassDao.class, ClassDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ChildDao.class, ChildDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AttendanceDao.class, AttendanceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MessageDao.class, MessageDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ClassDao classDao() {
    if (_classDao != null) {
      return _classDao;
    } else {
      synchronized(this) {
        if(_classDao == null) {
          _classDao = new ClassDao_Impl(this);
        }
        return _classDao;
      }
    }
  }

  @Override
  public ChildDao childDao() {
    if (_childDao != null) {
      return _childDao;
    } else {
      synchronized(this) {
        if(_childDao == null) {
          _childDao = new ChildDao_Impl(this);
        }
        return _childDao;
      }
    }
  }

  @Override
  public AttendanceDao attendanceDao() {
    if (_attendanceDao != null) {
      return _attendanceDao;
    } else {
      synchronized(this) {
        if(_attendanceDao == null) {
          _attendanceDao = new AttendanceDao_Impl(this);
        }
        return _attendanceDao;
      }
    }
  }

  @Override
  public MessageDao messageDao() {
    if (_messageDao != null) {
      return _messageDao;
    } else {
      synchronized(this) {
        if(_messageDao == null) {
          _messageDao = new MessageDao_Impl(this);
        }
        return _messageDao;
      }
    }
  }
}
