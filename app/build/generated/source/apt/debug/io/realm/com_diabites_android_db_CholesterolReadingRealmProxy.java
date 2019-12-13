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
public class com_diabites_android_db_CholesterolReadingRealmProxy extends com.diabites.android.db.CholesterolReading
    implements RealmObjectProxy, com_diabites_android_db_CholesterolReadingRealmProxyInterface {

    static final class CholesterolReadingColumnInfo extends ColumnInfo {
        long idIndex;
        long totalReadingIndex;
        long LDLReadingIndex;
        long HDLReadingIndex;
        long createdIndex;

        CholesterolReadingColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("CholesterolReading");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.totalReadingIndex = addColumnDetails("totalReading", "totalReading", objectSchemaInfo);
            this.LDLReadingIndex = addColumnDetails("LDLReading", "LDLReading", objectSchemaInfo);
            this.HDLReadingIndex = addColumnDetails("HDLReading", "HDLReading", objectSchemaInfo);
            this.createdIndex = addColumnDetails("created", "created", objectSchemaInfo);
        }

        CholesterolReadingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CholesterolReadingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CholesterolReadingColumnInfo src = (CholesterolReadingColumnInfo) rawSrc;
            final CholesterolReadingColumnInfo dst = (CholesterolReadingColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.totalReadingIndex = src.totalReadingIndex;
            dst.LDLReadingIndex = src.LDLReadingIndex;
            dst.HDLReadingIndex = src.HDLReadingIndex;
            dst.createdIndex = src.createdIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private CholesterolReadingColumnInfo columnInfo;
    private ProxyState<com.diabites.android.db.CholesterolReading> proxyState;

    com_diabites_android_db_CholesterolReadingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CholesterolReadingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.diabites.android.db.CholesterolReading>(this);
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
    public double realmGet$totalReading() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.totalReadingIndex);
    }

    @Override
    public void realmSet$totalReading(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.totalReadingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.totalReadingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$LDLReading() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.LDLReadingIndex);
    }

    @Override
    public void realmSet$LDLReading(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.LDLReadingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.LDLReadingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$HDLReading() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.HDLReadingIndex);
    }

    @Override
    public void realmSet$HDLReading(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.HDLReadingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.HDLReadingIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("CholesterolReading", 5, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("totalReading", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("LDLReading", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("HDLReading", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("created", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CholesterolReadingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CholesterolReadingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "CholesterolReading";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "CholesterolReading";
    }

    @SuppressWarnings("cast")
    public static com.diabites.android.db.CholesterolReading createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.diabites.android.db.CholesterolReading obj = null;
        if (update) {
            Table table = realm.getTable(com.diabites.android.db.CholesterolReading.class);
            CholesterolReadingColumnInfo columnInfo = (CholesterolReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_diabites_android_db_CholesterolReadingRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_diabites_android_db_CholesterolReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.CholesterolReading.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_diabites_android_db_CholesterolReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.CholesterolReading.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_diabites_android_db_CholesterolReadingRealmProxyInterface objProxy = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) obj;
        if (json.has("totalReading")) {
            if (json.isNull("totalReading")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalReading' to null.");
            } else {
                objProxy.realmSet$totalReading((double) json.getDouble("totalReading"));
            }
        }
        if (json.has("LDLReading")) {
            if (json.isNull("LDLReading")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'LDLReading' to null.");
            } else {
                objProxy.realmSet$LDLReading((double) json.getDouble("LDLReading"));
            }
        }
        if (json.has("HDLReading")) {
            if (json.isNull("HDLReading")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'HDLReading' to null.");
            } else {
                objProxy.realmSet$HDLReading((double) json.getDouble("HDLReading"));
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
    public static com.diabites.android.db.CholesterolReading createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.diabites.android.db.CholesterolReading obj = new com.diabites.android.db.CholesterolReading();
        final com_diabites_android_db_CholesterolReadingRealmProxyInterface objProxy = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) obj;
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
            } else if (name.equals("totalReading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$totalReading((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalReading' to null.");
                }
            } else if (name.equals("LDLReading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$LDLReading((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'LDLReading' to null.");
                }
            } else if (name.equals("HDLReading")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HDLReading((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'HDLReading' to null.");
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

    public static com.diabites.android.db.CholesterolReading copyOrUpdate(Realm realm, com.diabites.android.db.CholesterolReading object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.diabites.android.db.CholesterolReading) cachedRealmObject;
        }

        com.diabites.android.db.CholesterolReading realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.diabites.android.db.CholesterolReading.class);
            CholesterolReadingColumnInfo columnInfo = (CholesterolReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_diabites_android_db_CholesterolReadingRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.diabites.android.db.CholesterolReading copy(Realm realm, com.diabites.android.db.CholesterolReading newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.diabites.android.db.CholesterolReading) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.diabites.android.db.CholesterolReading realmObject = realm.createObjectInternal(com.diabites.android.db.CholesterolReading.class, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_diabites_android_db_CholesterolReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) newObject;
        com_diabites_android_db_CholesterolReadingRealmProxyInterface realmObjectCopy = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$totalReading(realmObjectSource.realmGet$totalReading());
        realmObjectCopy.realmSet$LDLReading(realmObjectSource.realmGet$LDLReading());
        realmObjectCopy.realmSet$HDLReading(realmObjectSource.realmGet$HDLReading());
        realmObjectCopy.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    public static long insert(Realm realm, com.diabites.android.db.CholesterolReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.CholesterolReading.class);
        long tableNativePtr = table.getNativePtr();
        CholesterolReadingColumnInfo columnInfo = (CholesterolReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$totalReading(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.LDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$LDLReading(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.HDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$HDLReading(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.CholesterolReading.class);
        long tableNativePtr = table.getNativePtr();
        CholesterolReadingColumnInfo columnInfo = (CholesterolReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.CholesterolReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.CholesterolReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$totalReading(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.LDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$LDLReading(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.HDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$HDLReading(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.diabites.android.db.CholesterolReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.CholesterolReading.class);
        long tableNativePtr = table.getNativePtr();
        CholesterolReadingColumnInfo columnInfo = (CholesterolReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$totalReading(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.LDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$LDLReading(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.HDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$HDLReading(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.CholesterolReading.class);
        long tableNativePtr = table.getNativePtr();
        CholesterolReadingColumnInfo columnInfo = (CholesterolReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.CholesterolReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.CholesterolReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.CholesterolReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$totalReading(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.LDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$LDLReading(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.HDLReadingIndex, rowIndex, ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$HDLReading(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_CholesterolReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
            }
        }
    }

    public static com.diabites.android.db.CholesterolReading createDetachedCopy(com.diabites.android.db.CholesterolReading realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.diabites.android.db.CholesterolReading unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.diabites.android.db.CholesterolReading();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.diabites.android.db.CholesterolReading) cachedObject.object;
            }
            unmanagedObject = (com.diabites.android.db.CholesterolReading) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_diabites_android_db_CholesterolReadingRealmProxyInterface unmanagedCopy = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) unmanagedObject;
        com_diabites_android_db_CholesterolReadingRealmProxyInterface realmSource = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$totalReading(realmSource.realmGet$totalReading());
        unmanagedCopy.realmSet$LDLReading(realmSource.realmGet$LDLReading());
        unmanagedCopy.realmSet$HDLReading(realmSource.realmGet$HDLReading());
        unmanagedCopy.realmSet$created(realmSource.realmGet$created());

        return unmanagedObject;
    }

    static com.diabites.android.db.CholesterolReading update(Realm realm, com.diabites.android.db.CholesterolReading realmObject, com.diabites.android.db.CholesterolReading newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_diabites_android_db_CholesterolReadingRealmProxyInterface realmObjectTarget = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) realmObject;
        com_diabites_android_db_CholesterolReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_CholesterolReadingRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$totalReading(realmObjectSource.realmGet$totalReading());
        realmObjectTarget.realmSet$LDLReading(realmObjectSource.realmGet$LDLReading());
        realmObjectTarget.realmSet$HDLReading(realmObjectSource.realmGet$HDLReading());
        realmObjectTarget.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CholesterolReading = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalReading:");
        stringBuilder.append(realmGet$totalReading());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{LDLReading:");
        stringBuilder.append(realmGet$LDLReading());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HDLReading:");
        stringBuilder.append(realmGet$HDLReading());
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
        com_diabites_android_db_CholesterolReadingRealmProxy aCholesterolReading = (com_diabites_android_db_CholesterolReadingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCholesterolReading.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCholesterolReading.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCholesterolReading.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
