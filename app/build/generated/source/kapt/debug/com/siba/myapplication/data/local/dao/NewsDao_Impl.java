package com.siba.myapplication.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.siba.myapplication.data.local.entity.ArticlesTable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsDao_Impl implements NewsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ArticlesTable> __insertionAdapterOfArticlesTable;

  private final EntityDeletionOrUpdateAdapter<ArticlesTable> __deletionAdapterOfArticlesTable;

  private final EntityDeletionOrUpdateAdapter<ArticlesTable> __updateAdapterOfArticlesTable;

  public NewsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArticlesTable = new EntityInsertionAdapter<ArticlesTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `ArticlesTable` (`publishedAt`,`author`,`urlToImage`,`description`,`title`,`url`,`content`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final ArticlesTable entity) {
        if (entity.getPublishedAt() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPublishedAt());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAuthor());
        }
        if (entity.getUrlToImage() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUrlToImage());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTitle());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getUrl());
        }
        if (entity.getContent() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getContent());
        }
      }
    };
    this.__deletionAdapterOfArticlesTable = new EntityDeletionOrUpdateAdapter<ArticlesTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `ArticlesTable` WHERE `publishedAt` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final ArticlesTable entity) {
        if (entity.getPublishedAt() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPublishedAt());
        }
      }
    };
    this.__updateAdapterOfArticlesTable = new EntityDeletionOrUpdateAdapter<ArticlesTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR REPLACE `ArticlesTable` SET `publishedAt` = ?,`author` = ?,`urlToImage` = ?,`description` = ?,`title` = ?,`url` = ?,`content` = ? WHERE `publishedAt` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final ArticlesTable entity) {
        if (entity.getPublishedAt() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPublishedAt());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAuthor());
        }
        if (entity.getUrlToImage() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUrlToImage());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescription());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTitle());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getUrl());
        }
        if (entity.getContent() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getContent());
        }
        if (entity.getPublishedAt() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPublishedAt());
        }
      }
    };
  }

  @Override
  public Object insertNewsData(final ArticlesTable articlesTable,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfArticlesTable.insert(articlesTable);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteNewData(final ArticlesTable articlesTable,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfArticlesTable.handle(articlesTable);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateNewData(final ArticlesTable articlesTable,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfArticlesTable.handle(articlesTable);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<ArticlesTable>> getAllDataFromTable() {
    final String _sql = "SELECT * FROM ArticlesTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ArticlesTable"}, new Callable<List<ArticlesTable>>() {
      @Override
      @NonNull
      public List<ArticlesTable> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final List<ArticlesTable> _result = new ArrayList<ArticlesTable>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ArticlesTable _item;
            final String _tmpPublishedAt;
            if (_cursor.isNull(_cursorIndexOfPublishedAt)) {
              _tmpPublishedAt = null;
            } else {
              _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpUrlToImage;
            if (_cursor.isNull(_cursorIndexOfUrlToImage)) {
              _tmpUrlToImage = null;
            } else {
              _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            _item = new ArticlesTable(_tmpPublishedAt,_tmpAuthor,_tmpUrlToImage,_tmpDescription,_tmpTitle,_tmpUrl,_tmpContent);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
