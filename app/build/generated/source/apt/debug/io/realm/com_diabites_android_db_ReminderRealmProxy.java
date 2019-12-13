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
public class com_diabites_android_db_ReminderRealmProxy extends com.diabites.android.db.Reminder
    implements RealmObjectProxy, com_diabites_android_db_ReminderRealmProxyInterface {

    static final class ReminderColumnInfo extends ColumnInfo {
        long idIndex;
        long alarmTimeIndex;
        long oneTimeIndex;
        long activeIndex;
        long labelIndex;
        long metricIndex;

        ReminderColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Reminder");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.alarmTimeIndex = addColumnDetails("alarmTime", "alarmTime", objectSchemaInfo);
            this.oneTimeIndex = addColumnDetails("oneTime", "oneTime", objectSchemaInfo);
            this.activeIndex = addColumnDetails("active", "active", objectSchemaInfo);
            this.labelIndex = addColumnDetails("label", "label", objectSchemaInfo);
            this.metricIndex = addColumnDetails("metric", "metric", objectSchemaInfo);
        }

        ReminderColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ReminderColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ReminderColumnInfo src = (ReminderColumnInfo) rawSrc;
            final ReminderColumnInfo dst = (ReminderColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.alarmTimeIndex = src.alarmTimeIndex;
            dst.oneTimeIndex = src.oneTimeIndex;
            dst.activeIndex = src.activeIndex;
            dst.labelIndex = src.labelIndex;
            dst.metricIndex = src.metricIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ReminderColumnInfo columnInfo;
    private ProxyState<com.diabites.android.db.Reminder> proxyState;

    com_diabites_android_db_ReminderRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ReminderColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.diabites.android.db.Reminder>(this);
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
    public Date realmGet$alarmTime() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.alarmTimeIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.alarmTimeIndex);
    }

    @Override
    public void realmSet$alarmTime(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.alarmTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.alarmTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.alarmTimeIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.alarmTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$oneTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.oneTimeIndex);
    }

    @Override
    public void realmSet$oneTime(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.oneTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.oneTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$active() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.activeIndex);
    }

    @Override
    public void realmSet$active(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.activeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.activeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$label() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.labelIndex);
    }

    @Override
    public void realmSet$label(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.labelIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.labelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.labelIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.labelIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$metric() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.metricIndex);
    }

    @Override
    public void realmSet$metric(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.metricIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.metricIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.metricIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.metricIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Reminder", 6, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("alarmTime", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("oneTime", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("active", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("label", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("metric", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ReminderColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ReminderColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Reminder";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Reminder";
    }

    @SuppressWarnings("cast")
    public static com.diabites.android.db.Reminder createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.diabites.android.db.Reminder obj = null;
        if (update) {
            Table table = realm.getTable(com.diabites.android.db.Reminder.class);
            ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_diabites_android_db_ReminderRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_diabites_android_db_ReminderRealmProxy) realm.createObjectInternal(com.diabites.android.db.Reminder.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_diabites_android_db_ReminderRealmProxy) realm.createObjectInternal(com.diabites.android.db.Reminder.class, json.getLong("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_diabites_android_db_ReminderRealmProxyInterface objProxy = (com_diabites_android_db_ReminderRealmProxyInterface) obj;
        if (json.has("alarmTime")) {
            if (json.isNull("alarmTime")) {
                objProxy.realmSet$alarmTime(null);
            } else {
                Object timestamp = json.get("alarmTime");
                if (timestamp instanceof String) {
                    objProxy.realmSet$alarmTime(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$alarmTime(new Date(json.getLong("alarmTime")));
                }
            }
        }
        if (json.has("oneTime")) {
            if (json.isNull("oneTime")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'oneTime' to null.");
            } else {
                objProxy.realmSet$oneTime((boolean) json.getBoolean("oneTime"));
            }
        }
        if (json.has("active")) {
            if (json.isNull("active")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'active' to null.");
            } else {
                objProxy.realmSet$active((boolean) json.getBoolean("active"));
            }
        }
        if (json.has("label")) {
            if (json.isNull("label")) {
                objProxy.realmSet$label(null);
            } else {
                objProxy.realmSet$label((String) json.getString("label"));
            }
        }
        if (json.has("metric")) {
            if (json.isNull("metric")) {
                objProxy.realmSet$metric(null);
            } else {
                objProxy.realmSet$metric((String) json.getString("metric"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.diabites.android.db.Reminder createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.diabites.android.db.Reminder obj = new com.diabites.android.db.Reminder();
        final com_diabites_android_db_ReminderRealmProxyInterface objProxy = (com_diabites_android_db_ReminderRealmProxyInterface) obj;
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
            } else if (name.equals("alarmTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$alarmTime(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$alarmTime(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$alarmTime(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("oneTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$oneTime((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'oneTime' to null.");
                }
            } else if (name.equals("active")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$active((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'active' to null.");
                }
            } else if (name.equals("label")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$label((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$label(null);
                }
            } else if (name.equals("metric")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$metric((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$metric(null);
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

    public static com.diabites.android.db.Reminder copyOrUpdate(Realm realm, com.diabites.android.db.Reminder object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.diabites.android.db.Reminder) cachedRealmObject;
        }

        com.diabites.android.db.Reminder realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.diabites.android.db.Reminder.class);
            ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_diabites_android_db_ReminderRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.diabites.android.db.Reminder copy(Realm realm, com.diabites.android.db.Reminder newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.diabites.android.db.Reminder) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.diabites.android.db.Reminder realmObject = realm.createObjectInternal(com.diabites.android.db.Reminder.class, ((com_diabites_android_db_ReminderRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_diabites_android_db_ReminderRealmProxyInterface realmObjectSource = (com_diabites_android_db_ReminderRealmProxyInterface) newObject;
        com_diabites_android_db_ReminderRealmProxyInterface realmObjectCopy = (com_diabites_android_db_ReminderRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$alarmTime(realmObjectSource.realmGet$alarmTime());
        realmObjectCopy.realmSet$oneTime(realmObjectSource.realmGet$oneTime());
        realmObjectCopy.realmSet$active(realmObjectSource.realmGet$active());
        realmObjectCopy.realmSet$label(realmObjectSource.realmGet$label());
        realmObjectCopy.realmSet$metric(realmObjectSource.realmGet$metric());
        return realmObject;
    }

    public static long insert(Realm realm, com.diabites.android.db.Reminder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        java.util.Date realmGet$alarmTime = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$alarmTime();
        if (realmGet$alarmTime != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.alarmTimeIndex, rowIndex, realmGet$alarmTime.getTime(), false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.oneTimeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$oneTime(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$active(), false);
        String realmGet$label = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        }
        String realmGet$metric = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$metric();
        if (realmGet$metric != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metricIndex, rowIndex, realmGet$metric, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.Reminder object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.Reminder) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            java.util.Date realmGet$alarmTime = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$alarmTime();
            if (realmGet$alarmTime != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.alarmTimeIndex, rowIndex, realmGet$alarmTime.getTime(), false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.oneTimeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$oneTime(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$active(), false);
            String realmGet$label = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$label();
            if (realmGet$label != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
            }
            String realmGet$metric = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$metric();
            if (realmGet$metric != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metricIndex, rowIndex, realmGet$metric, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.diabites.android.db.Reminder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        java.util.Date realmGet$alarmTime = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$alarmTime();
        if (realmGet$alarmTime != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.alarmTimeIndex, rowIndex, realmGet$alarmTime.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.alarmTimeIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.oneTimeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$oneTime(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$active(), false);
        String realmGet$label = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$label();
        if (realmGet$label != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
        }
        String realmGet$metric = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$metric();
        if (realmGet$metric != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metricIndex, rowIndex, realmGet$metric, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.metricIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.Reminder.class);
        long tableNativePtr = table.getNativePtr();
        ReminderColumnInfo columnInfo = (ReminderColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.Reminder.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.Reminder object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.Reminder) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            java.util.Date realmGet$alarmTime = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$alarmTime();
            if (realmGet$alarmTime != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.alarmTimeIndex, rowIndex, realmGet$alarmTime.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.alarmTimeIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.oneTimeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$oneTime(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.activeIndex, rowIndex, ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$active(), false);
            String realmGet$label = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$label();
            if (realmGet$label != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.labelIndex, rowIndex, realmGet$label, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.labelIndex, rowIndex, false);
            }
            String realmGet$metric = ((com_diabites_android_db_ReminderRealmProxyInterface) object).realmGet$metric();
            if (realmGet$metric != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metricIndex, rowIndex, realmGet$metric, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.metricIndex, rowIndex, false);
            }
        }
    }

    public static com.diabites.android.db.Reminder createDetachedCopy(com.diabites.android.db.Reminder realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.diabites.android.db.Reminder unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.diabites.android.db.Reminder();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.diabites.android.db.Reminder) cachedObject.object;
            }
            unmanagedObject = (com.diabites.android.db.Reminder) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_diabites_android_db_ReminderRealmProxyInterface unmanagedCopy = (com_diabites_android_db_ReminderRealmProxyInterface) unmanagedObject;
        com_diabites_android_db_ReminderRealmProxyInterface realmSource = (com_diabites_android_db_ReminderRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$alarmTime(realmSource.realmGet$alarmTime());
        unmanagedCopy.realmSet$oneTime(realmSource.realmGet$oneTime());
        unmanagedCopy.realmSet$active(realmSource.realmGet$active());
        unmanagedCopy.realmSet$label(realmSource.realmGet$label());
        unmanagedCopy.realmSet$metric(realmSource.realmGet$metric());

        return unmanagedObject;
    }

    static com.diabites.android.db.Reminder update(Realm realm, com.diabites.android.db.Reminder realmObject, com.diabites.android.db.Reminder newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_diabites_android_db_ReminderRealmProxyInterface realmObjectTarget = (com_diabites_android_db_ReminderRealmProxyInterface) realmObject;
        com_diabites_android_db_ReminderRealmProxyInterface realmObjectSource = (com_diabites_android_db_ReminderRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$alarmTime(realmObjectSource.realmGet$alarmTime());
        realmObjectTarget.realmSet$oneTime(realmObjectSource.realmGet$oneTime());
        realmObjectTarget.realmSet$active(realmObjectSource.realmGet$active());
        realmObjectTarget.realmSet$label(realmObjectSource.realmGet$label());
        realmObjectTarget.realmSet$metric(realmObjectSource.realmGet$metric());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Reminder = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{alarmTime:");
        stringBuilder.append(realmGet$alarmTime() != null ? realmGet$alarmTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{oneTime:");
        stringBuilder.append(realmGet$oneTime());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{active:");
        stringBuilder.append(realmGet$active());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{label:");
        stringBuilder.append(realmGet$label() != null ? realmGet$label() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{metric:");
        stringBuilder.append(realmGet$metric() != null ? realmGet$metric() : "null");
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
        com_diabites_android_db_ReminderRealmProxy aReminder = (com_diabites_android_db_ReminderRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aReminder.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aReminder.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aReminder.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
