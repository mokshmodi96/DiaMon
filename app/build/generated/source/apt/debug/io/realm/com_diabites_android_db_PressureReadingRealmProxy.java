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
public class com_diabites_android_db_PressureReadingRealmProxy extends com.diabites.android.db.PressureReading
    implements RealmObjectProxy, com_diabites_android_db_PressureReadingRealmProxyInterface {

    static final class PressureReadingColumnInfo extends ColumnInfo {
        long idIndex;
        long minReadingIndex;
        long maxReadingIndex;
        long createdIndex;

        PressureReadingColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("PressureReading");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.minReadingIndex = addColumnDetails("minReading", "minReading", objectSchemaInfo);
            this.maxReadingIndex = addColumnDetails("maxReading", "maxReading", objectSchemaInfo);
            this.createdIndex = addColumnDetails("created", "created", objectSchemaInfo);
        }

        PressureReadingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PressureReadingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PressureReadingColumnInfo src = (PressureReadingColumnInfo) rawSrc;
            final PressureReadingColumnInfo dst = (PressureReadingColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.minReadingIndex = src.minReadingIndex;
            dst.maxReadingIndex = src.maxReadingIndex;
            dst.createdIndex = src.createdIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private PressureReadingColumnInfo columnInfo;
    private ProxyState<com.diabites.android.db.PressureReading> proxyState;

    com_diabites_android_db_PressureReadingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PressureReadingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.diabites.android.db.PressureReading>(this);
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
    public double realmGet$minReading() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.minReadingIndex);
    }

    @Override
    public void realmSet$minReading(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.minReadingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.minReadingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$maxReading() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.maxReadingIndex);
    }

    @Override
    public void realmSet$maxReading(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.maxReadingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.maxReadingIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("PressureReading", 4, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("minReading", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("maxReading", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("created", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static PressureReadingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new PressureReadingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "PressureReading";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "PressureReading";
    }

    @SuppressWarnings("cast")
    public static com.diabites.android.db.PressureReading createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.diabites.android.db.PressureReading obj = null;
        if (update) {
            Table table = realm.getTable(com.diabites.android.db.PressureReading.class);
            PressureReadingColumnInfo columnInfo = (PressureReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_diabites_android_db_PressureReadingRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_diabites_android_db_PressureReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.PressureReading.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_diabites_android_db_PressureReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.PressureReading.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_diabites_android_db_PressureReadingRealmProxyInterface objProxy = (com_diabites_android_db_PressureReadingRealmProxyInterface) obj;
        if (json.has("minReading")) {
            if (json.isNull("minReading")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'minReading' to null.");
            } else {
                objProxy.realmSet$minReading((double) json.getDouble("minReading"));
            }
        }
        if (json.has("maxReading")) {
            if (json.isNull("maxReading")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxReading' to null.");
            } else {
                objProxy.realmSet$maxReading((double) json.getDouble("maxReading"));
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
    public static com.diabites.android.db.PressureReading createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.diabites.android.db.PressureReading obj = new com.diabites.android.db.PressureReading();
        final com_diabites_android_db_PressureReadingRealmProxyInterface objProxy = (com_diabites_android_db_PressureReadingRealmProxyInterface) obj;
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
            } else if (name.equals("minReading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$minReading((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'minReading' to null.");
                }
            } else if (name.equals("maxReading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$maxReading((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxReading' to null.");
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

    public static com.diabites.android.db.PressureReading copyOrUpdate(Realm realm, com.diabites.android.db.PressureReading object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.diabites.android.db.PressureReading) cachedRealmObject;
        }

        com.diabites.android.db.PressureReading realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.diabites.android.db.PressureReading.class);
            PressureReadingColumnInfo columnInfo = (PressureReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_diabites_android_db_PressureReadingRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.diabites.android.db.PressureReading copy(Realm realm, com.diabites.android.db.PressureReading newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.diabites.android.db.PressureReading) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.diabites.android.db.PressureReading realmObject = realm.createObjectInternal(com.diabites.android.db.PressureReading.class, ((com_diabites_android_db_PressureReadingRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_diabites_android_db_PressureReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_PressureReadingRealmProxyInterface) newObject;
        com_diabites_android_db_PressureReadingRealmProxyInterface realmObjectCopy = (com_diabites_android_db_PressureReadingRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$minReading(realmObjectSource.realmGet$minReading());
        realmObjectCopy.realmSet$maxReading(realmObjectSource.realmGet$maxReading());
        realmObjectCopy.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    public static long insert(Realm realm, com.diabites.android.db.PressureReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.PressureReading.class);
        long tableNativePtr = table.getNativePtr();
        PressureReadingColumnInfo columnInfo = (PressureReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.minReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$minReading(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.maxReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$maxReading(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.PressureReading.class);
        long tableNativePtr = table.getNativePtr();
        PressureReadingColumnInfo columnInfo = (PressureReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.PressureReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.PressureReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.minReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$minReading(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.maxReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$maxReading(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.diabites.android.db.PressureReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.PressureReading.class);
        long tableNativePtr = table.getNativePtr();
        PressureReadingColumnInfo columnInfo = (PressureReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.minReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$minReading(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.maxReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$maxReading(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.PressureReading.class);
        long tableNativePtr = table.getNativePtr();
        PressureReadingColumnInfo columnInfo = (PressureReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.PressureReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.PressureReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.PressureReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.minReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$minReading(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.maxReadingIndex, rowIndex, ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$maxReading(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_PressureReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
            }
        }
    }

    public static com.diabites.android.db.PressureReading createDetachedCopy(com.diabites.android.db.PressureReading realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.diabites.android.db.PressureReading unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.diabites.android.db.PressureReading();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.diabites.android.db.PressureReading) cachedObject.object;
            }
            unmanagedObject = (com.diabites.android.db.PressureReading) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_diabites_android_db_PressureReadingRealmProxyInterface unmanagedCopy = (com_diabites_android_db_PressureReadingRealmProxyInterface) unmanagedObject;
        com_diabites_android_db_PressureReadingRealmProxyInterface realmSource = (com_diabites_android_db_PressureReadingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$minReading(realmSource.realmGet$minReading());
        unmanagedCopy.realmSet$maxReading(realmSource.realmGet$maxReading());
        unmanagedCopy.realmSet$created(realmSource.realmGet$created());

        return unmanagedObject;
    }

    static com.diabites.android.db.PressureReading update(Realm realm, com.diabites.android.db.PressureReading realmObject, com.diabites.android.db.PressureReading newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_diabites_android_db_PressureReadingRealmProxyInterface realmObjectTarget = (com_diabites_android_db_PressureReadingRealmProxyInterface) realmObject;
        com_diabites_android_db_PressureReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_PressureReadingRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$minReading(realmObjectSource.realmGet$minReading());
        realmObjectTarget.realmSet$maxReading(realmObjectSource.realmGet$maxReading());
        realmObjectTarget.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PressureReading = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{minReading:");
        stringBuilder.append(realmGet$minReading());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxReading:");
        stringBuilder.append(realmGet$maxReading());
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
        com_diabites_android_db_PressureReadingRealmProxy aPressureReading = (com_diabites_android_db_PressureReadingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPressureReading.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPressureReading.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPressureReading.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
