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
public class com_diabites_android_db_WeightReadingRealmProxy extends com.diabites.android.db.WeightReading
    implements RealmObjectProxy, com_diabites_android_db_WeightReadingRealmProxyInterface {

    static final class WeightReadingColumnInfo extends ColumnInfo {
        long idIndex;
        long readingIndex;
        long createdIndex;

        WeightReadingColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("WeightReading");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.readingIndex = addColumnDetails("reading", "reading", objectSchemaInfo);
            this.createdIndex = addColumnDetails("created", "created", objectSchemaInfo);
        }

        WeightReadingColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new WeightReadingColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final WeightReadingColumnInfo src = (WeightReadingColumnInfo) rawSrc;
            final WeightReadingColumnInfo dst = (WeightReadingColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.readingIndex = src.readingIndex;
            dst.createdIndex = src.createdIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private WeightReadingColumnInfo columnInfo;
    private ProxyState<com.diabites.android.db.WeightReading> proxyState;

    com_diabites_android_db_WeightReadingRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (WeightReadingColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.diabites.android.db.WeightReading>(this);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("WeightReading", 3, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("reading", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("created", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static WeightReadingColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new WeightReadingColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "WeightReading";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "WeightReading";
    }

    @SuppressWarnings("cast")
    public static com.diabites.android.db.WeightReading createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.diabites.android.db.WeightReading obj = null;
        if (update) {
            Table table = realm.getTable(com.diabites.android.db.WeightReading.class);
            WeightReadingColumnInfo columnInfo = (WeightReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_diabites_android_db_WeightReadingRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_diabites_android_db_WeightReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.WeightReading.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_diabites_android_db_WeightReadingRealmProxy) realm.createObjectInternal(com.diabites.android.db.WeightReading.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_diabites_android_db_WeightReadingRealmProxyInterface objProxy = (com_diabites_android_db_WeightReadingRealmProxyInterface) obj;
        if (json.has("reading")) {
            if (json.isNull("reading")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'reading' to null.");
            } else {
                objProxy.realmSet$reading((double) json.getDouble("reading"));
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
    public static com.diabites.android.db.WeightReading createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.diabites.android.db.WeightReading obj = new com.diabites.android.db.WeightReading();
        final com_diabites_android_db_WeightReadingRealmProxyInterface objProxy = (com_diabites_android_db_WeightReadingRealmProxyInterface) obj;
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

    public static com.diabites.android.db.WeightReading copyOrUpdate(Realm realm, com.diabites.android.db.WeightReading object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.diabites.android.db.WeightReading) cachedRealmObject;
        }

        com.diabites.android.db.WeightReading realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.diabites.android.db.WeightReading.class);
            WeightReadingColumnInfo columnInfo = (WeightReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_diabites_android_db_WeightReadingRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.diabites.android.db.WeightReading copy(Realm realm, com.diabites.android.db.WeightReading newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.diabites.android.db.WeightReading) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.diabites.android.db.WeightReading realmObject = realm.createObjectInternal(com.diabites.android.db.WeightReading.class, ((com_diabites_android_db_WeightReadingRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_diabites_android_db_WeightReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_WeightReadingRealmProxyInterface) newObject;
        com_diabites_android_db_WeightReadingRealmProxyInterface realmObjectCopy = (com_diabites_android_db_WeightReadingRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$reading(realmObjectSource.realmGet$reading());
        realmObjectCopy.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    public static long insert(Realm realm, com.diabites.android.db.WeightReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.WeightReading.class);
        long tableNativePtr = table.getNativePtr();
        WeightReadingColumnInfo columnInfo = (WeightReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$reading(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.WeightReading.class);
        long tableNativePtr = table.getNativePtr();
        WeightReadingColumnInfo columnInfo = (WeightReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.WeightReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.WeightReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$reading(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.diabites.android.db.WeightReading object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.WeightReading.class);
        long tableNativePtr = table.getNativePtr();
        WeightReadingColumnInfo columnInfo = (WeightReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$reading(), false);
        java.util.Date realmGet$created = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$created();
        if (realmGet$created != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.WeightReading.class);
        long tableNativePtr = table.getNativePtr();
        WeightReadingColumnInfo columnInfo = (WeightReadingColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.WeightReading.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.WeightReading object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.WeightReading) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            Table.nativeSetDouble(tableNativePtr, columnInfo.readingIndex, rowIndex, ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$reading(), false);
            java.util.Date realmGet$created = ((com_diabites_android_db_WeightReadingRealmProxyInterface) object).realmGet$created();
            if (realmGet$created != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.createdIndex, rowIndex, realmGet$created.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.createdIndex, rowIndex, false);
            }
        }
    }

    public static com.diabites.android.db.WeightReading createDetachedCopy(com.diabites.android.db.WeightReading realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.diabites.android.db.WeightReading unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.diabites.android.db.WeightReading();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.diabites.android.db.WeightReading) cachedObject.object;
            }
            unmanagedObject = (com.diabites.android.db.WeightReading) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_diabites_android_db_WeightReadingRealmProxyInterface unmanagedCopy = (com_diabites_android_db_WeightReadingRealmProxyInterface) unmanagedObject;
        com_diabites_android_db_WeightReadingRealmProxyInterface realmSource = (com_diabites_android_db_WeightReadingRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$reading(realmSource.realmGet$reading());
        unmanagedCopy.realmSet$created(realmSource.realmGet$created());

        return unmanagedObject;
    }

    static com.diabites.android.db.WeightReading update(Realm realm, com.diabites.android.db.WeightReading realmObject, com.diabites.android.db.WeightReading newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_diabites_android_db_WeightReadingRealmProxyInterface realmObjectTarget = (com_diabites_android_db_WeightReadingRealmProxyInterface) realmObject;
        com_diabites_android_db_WeightReadingRealmProxyInterface realmObjectSource = (com_diabites_android_db_WeightReadingRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$reading(realmObjectSource.realmGet$reading());
        realmObjectTarget.realmSet$created(realmObjectSource.realmGet$created());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("WeightReading = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reading:");
        stringBuilder.append(realmGet$reading());
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
        com_diabites_android_db_WeightReadingRealmProxy aWeightReading = (com_diabites_android_db_WeightReadingRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aWeightReading.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aWeightReading.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aWeightReading.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
