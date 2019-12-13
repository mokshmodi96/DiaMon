package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_diabites_android_db_GlucoseReadingRealmProxy extends com.diabites.android.db.GlucoseReading
    implements RealmObjectProxy, com_diabites_android_db_GlucoseReadingRealmProxyInterface {

    static final class GlucoseReadingColumnInfo extends ColumnInfo {
        long idIndex;
        long readingIndex;
        long reading_typeIndex;
        long notesIndex;
        long user_idIndex;
        long createdIndex;

        GlucoseReadingColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("GlucoseReading");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.readingIndex = addColumnDetails("reading", "reading", objectSchemaInfo);
            this.reading_typeIndex = addColumnDetails("reading_type", "reading_type", objectSchemaInfo);
            this.notesIndex = addColumnDetails("notes", "notes", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.createdIndex = addColumnDetails("created", "created", objectSchemaInfo);
        }

        GlucoseReadingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GlucoseReadingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GlucoseReadingColumnInfo src = (GlucoseReadingColumnInfo) rawSrc;
            final GlucoseReadingColumnInfo dst = (GlucoseReadingColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.readingIndex = src.readingIndex;
            dst.reading_typeIndex = src.reading_typeIndex;
            dst.notesIndex = src.notesIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.createdIndex = src.createdIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private GlucoseReadingColumnInfo columnInfo;
    private ProxyState<com.diabites.android.db.GlucoseReading> proxyState;

    com_diabites_android_db_GlucoseReadingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GlucoseReadingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.diabites.android.db.GlucoseReading>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$reading() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.readingIndex);
    }

    @Override
    public void realmSet$reading(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.readingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.readingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$reading_type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.reading_typeIndex);
    }

    @Override
    public void realmSet$reading_type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.reading_typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.reading_typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.reading_typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.reading_typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$notes() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.notesIndex);
    }

    @Override
    public void realmSet$notes(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.notesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.notesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.notesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.notesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$user_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.user_idIndex);
    }

    @Override
    public void realmSet$user_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.user_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.user_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$created() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.createdIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.createdIndex);
    }

    @Override
    public void realmSet$created(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.createdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.createdIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("GlucoseReading", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("reading", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("reading_type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("notes", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("created", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GlucoseReadingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GlucoseReadingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "GlucoseReading";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "GlucoseReading";
    }

    @SuppressWarnings("cast")
    public static com.diabites.android.db.GlucoseReading createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.diabites.android.db.GlucoseReading obj = null;
        if (update) {
            Table table = realm.getTable(com.diabites.android.db.GlucoseReading.class);
            GlucoseReadingColumnInfo columnInfo = (GlucoseReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_diabites_android_db_GlucoseReadingRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_diabites_android_db_GlucoseReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.GlucoseReading.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_diabites_android_db_GlucoseReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.GlucoseReading.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_diabites_android_db_GlucoseReadingRealmProxyInterface objProxy = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) obj;
        if (json.has("reading")) {
            if (json.isNull("reading")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'reading' to null.");
            } else {
                objProxy.realmSet$reading((double) json.getDouble("reading"));
            }
        }
        if (json.has("reading_type")) {
            if (json.isNull("reading_type")) {
                objProxy.realmSet$reading_type(null);
            } else {
                objProxy.realmSet$reading_type((String) json.getString("reading_type"));
            }
        }
        if (json.has("notes")) {
            if (json.isNull("notes")) {
                objProxy.realmSet$notes(null);
            } else {
                objProxy.realmSet$notes((String) json.getString("notes"));
            }
        }
        if (json.has("user_id")) {
            if (json.isNull("user_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
            } else {
                objProxy.realmSet$user_id((int) json.getInt("user_id"));
            }
        }
        if (json.has("created")) {
            if (json.isNull("created")) {
                objProxy.realmSet$created(null);
            } else {
                Object timestamp = json.get("created");
                if (timestamp instanceof String) {
                    objProxy.realmSet$created(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$created(new Date(json.getLong("created")));
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.diabites.android.db.GlucoseReading createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.diabites.android.db.GlucoseReading obj = new com.diabites.android.db.GlucoseReading();
        final com_diabites_android_db_GlucoseReadingRealmProxyInterface objProxy = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((long) reader.nextLong());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("reading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$reading((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'reading' to null.");
                }
            } else if (name.equals("reading_type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$reading_type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$reading_type(null);
                }
            } else if (name.equals("notes")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$notes((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$notes(null);
                }
            } else if (name.equals("user_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$user_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
                }
            } else if (name.equals("created")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$created(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$created(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$created(JsonUtils.stringToDate(reader.nextString()));
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.diabites.android.db.GlucoseReading copyOrUpdate(Realm realm, com.diabites.android.db.GlucoseReading object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.diabites.android.db.GlucoseReading) cachedRealmObject;
        }

        com.diabites.android.db.GlucoseReading realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.diabites.android.db.GlucoseReading.class);
            GlucoseReadingColumnInfo columnInfo = (GlucoseReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_diabites_android_db_GlucoseReadingRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.diabites.android.db.GlucoseReading copy(Realm realm, com.diabites.android.db.GlucoseReading newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.diabites.android.db.GlucoseReading) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.diabites.android.db.GlucoseReading realmObject = realm.createObjectInternal(com.diabites.android.db.GlucoseReading.class, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_diabites_android_db_GlucoseReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) newObject;
        com_diabites_android_db_GlucoseReadingRealmProxyInterface realmObjectCopy = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$reading(realmObjectSource.realmGet$reading());
        realmObjectCopy.realmSet$reading_type(realmObjectSource.realmGet$reading_type());
        realmObjectCopy.realmSet$notes(realmObjectSource.realmGet$notes());
        realmObjectCopy.realmSet$user_id(realmObjectSource.realmGet$user_id());
        realmObjectCopy.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    public static long insert(Realm realm, com.diabites.android.db.GlucoseReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.GlucoseReading.class);
        long tableNativePtr = table.getNativePtr();
        GlucoseReadingColumnInfo columnInfo = (GlucoseReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading(), false);
        String realmGet$reading_type = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading_type();
        if (realmGet$reading_type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.reading_typeIndex, rowIndex, realmGet$reading_type, false);
        }
        String realmGet$notes = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$notes();
        if (realmGet$notes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.notesIndex, rowIndex, realmGet$notes, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$user_id(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.GlucoseReading.class);
        long tableNativePtr = table.getNativePtr();
        GlucoseReadingColumnInfo columnInfo = (GlucoseReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.GlucoseReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.GlucoseReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading(), false);
            String realmGet$reading_type = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading_type();
            if (realmGet$reading_type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.reading_typeIndex, rowIndex, realmGet$reading_type, false);
            }
            String realmGet$notes = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$notes();
            if (realmGet$notes != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.notesIndex, rowIndex, realmGet$notes, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$user_id(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.diabites.android.db.GlucoseReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.GlucoseReading.class);
        long tableNativePtr = table.getNativePtr();
        GlucoseReadingColumnInfo columnInfo = (GlucoseReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading(), false);
        String realmGet$reading_type = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading_type();
        if (realmGet$reading_type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.reading_typeIndex, rowIndex, realmGet$reading_type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.reading_typeIndex, rowIndex, false);
        }
        String realmGet$notes = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$notes();
        if (realmGet$notes != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.notesIndex, rowIndex, realmGet$notes, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.notesIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$user_id(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.GlucoseReading.class);
        long tableNativePtr = table.getNativePtr();
        GlucoseReadingColumnInfo columnInfo = (GlucoseReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.GlucoseReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.GlucoseReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.GlucoseReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading(), false);
            String realmGet$reading_type = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$reading_type();
            if (realmGet$reading_type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.reading_typeIndex, rowIndex, realmGet$reading_type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.reading_typeIndex, rowIndex, false);
            }
            String realmGet$notes = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$notes();
            if (realmGet$notes != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.notesIndex, rowIndex, realmGet$notes, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.notesIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$user_id(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_GlucoseReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
            }
        }
    }

    public static com.diabites.android.db.GlucoseReading createDetachedCopy(com.diabites.android.db.GlucoseReading realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.diabites.android.db.GlucoseReading unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.diabites.android.db.GlucoseReading();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.diabites.android.db.GlucoseReading) cachedObject.object;
            }
            unmanagedObject = (com.diabites.android.db.GlucoseReading) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_diabites_android_db_GlucoseReadingRealmProxyInterface unmanagedCopy = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) unmanagedObject;
        com_diabites_android_db_GlucoseReadingRealmProxyInterface realmSource = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$reading(realmSource.realmGet$reading());
        unmanagedCopy.realmSet$reading_type(realmSource.realmGet$reading_type());
        unmanagedCopy.realmSet$notes(realmSource.realmGet$notes());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());
        unmanagedCopy.realmSet$created(realmSource.realmGet$created());

        return unmanagedObject;
    }

    static com.diabites.android.db.GlucoseReading update(Realm realm, com.diabites.android.db.GlucoseReading realmObject, com.diabites.android.db.GlucoseReading newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_diabites_android_db_GlucoseReadingRealmProxyInterface realmObjectTarget = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) realmObject;
        com_diabites_android_db_GlucoseReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_GlucoseReadingRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$reading(realmObjectSource.realmGet$reading());
        realmObjectTarget.realmSet$reading_type(realmObjectSource.realmGet$reading_type());
        realmObjectTarget.realmSet$notes(realmObjectSource.realmGet$notes());
        realmObjectTarget.realmSet$user_id(realmObjectSource.realmGet$user_id());
        realmObjectTarget.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GlucoseReading = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reading:");
        stringBuilder.append(realmGet$reading());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reading_type:");
        stringBuilder.append(realmGet$reading_type() != null ? realmGet$reading_type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{notes:");
        stringBuilder.append(realmGet$notes() != null ? realmGet$notes() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user_id:");
        stringBuilder.append(realmGet$user_id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{created:");
        stringBuilder.append(realmGet$created() != null ? realmGet$created() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_diabites_android_db_GlucoseReadingRealmProxy aGlucoseReading = (com_diabites_android_db_GlucoseReadingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGlucoseReading.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGlucoseReading.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGlucoseReading.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
