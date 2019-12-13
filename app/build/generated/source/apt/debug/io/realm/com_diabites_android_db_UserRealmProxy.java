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
public class com_diabites_android_db_UserRealmProxy extends com.diabites.android.db.User
    implements RealmObjectProxy, com_diabites_android_db_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long preferred_languageIndex;
        long countryIndex;
        long ageIndex;
        long genderIndex;
        long d_typeIndex;
        long preferred_unitIndex;
        long preferred_unit_a1cIndex;
        long preferred_unit_weightIndex;
        long preferred_rangeIndex;
        long custom_range_minIndex;
        long custom_range_maxIndex;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(13);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nameIndex = addColumnDetails("name", "name", objectSchemaInfo);
            this.preferred_languageIndex = addColumnDetails("preferred_language", "preferred_language", objectSchemaInfo);
            this.countryIndex = addColumnDetails("country", "country", objectSchemaInfo);
            this.ageIndex = addColumnDetails("age", "age", objectSchemaInfo);
            this.genderIndex = addColumnDetails("gender", "gender", objectSchemaInfo);
            this.d_typeIndex = addColumnDetails("d_type", "d_type", objectSchemaInfo);
            this.preferred_unitIndex = addColumnDetails("preferred_unit", "preferred_unit", objectSchemaInfo);
            this.preferred_unit_a1cIndex = addColumnDetails("preferred_unit_a1c", "preferred_unit_a1c", objectSchemaInfo);
            this.preferred_unit_weightIndex = addColumnDetails("preferred_unit_weight", "preferred_unit_weight", objectSchemaInfo);
            this.preferred_rangeIndex = addColumnDetails("preferred_range", "preferred_range", objectSchemaInfo);
            this.custom_range_minIndex = addColumnDetails("custom_range_min", "custom_range_min", objectSchemaInfo);
            this.custom_range_maxIndex = addColumnDetails("custom_range_max", "custom_range_max", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.preferred_languageIndex = src.preferred_languageIndex;
            dst.countryIndex = src.countryIndex;
            dst.ageIndex = src.ageIndex;
            dst.genderIndex = src.genderIndex;
            dst.d_typeIndex = src.d_typeIndex;
            dst.preferred_unitIndex = src.preferred_unitIndex;
            dst.preferred_unit_a1cIndex = src.preferred_unit_a1cIndex;
            dst.preferred_unit_weightIndex = src.preferred_unit_weightIndex;
            dst.preferred_rangeIndex = src.preferred_rangeIndex;
            dst.custom_range_minIndex = src.custom_range_minIndex;
            dst.custom_range_maxIndex = src.custom_range_maxIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.diabites.android.db.User> proxyState;

    com_diabites_android_db_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.diabites.android.db.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$preferred_language() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.preferred_languageIndex);
    }

    @Override
    public void realmSet$preferred_language(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.preferred_languageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.preferred_languageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.preferred_languageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.preferred_languageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$country() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.countryIndex);
    }

    @Override
    public void realmSet$country(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.countryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.countryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.countryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.countryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$age() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ageIndex);
    }

    @Override
    public void realmSet$age(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$gender() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genderIndex);
    }

    @Override
    public void realmSet$gender(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.genderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genderIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genderIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$d_type() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.d_typeIndex);
    }

    @Override
    public void realmSet$d_type(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.d_typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.d_typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$preferred_unit() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.preferred_unitIndex);
    }

    @Override
    public void realmSet$preferred_unit(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.preferred_unitIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.preferred_unitIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.preferred_unitIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.preferred_unitIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$preferred_unit_a1c() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.preferred_unit_a1cIndex);
    }

    @Override
    public void realmSet$preferred_unit_a1c(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'preferred_unit_a1c' to null.");
            }
            row.getTable().setString(columnInfo.preferred_unit_a1cIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'preferred_unit_a1c' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.preferred_unit_a1cIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$preferred_unit_weight() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.preferred_unit_weightIndex);
    }

    @Override
    public void realmSet$preferred_unit_weight(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'preferred_unit_weight' to null.");
            }
            row.getTable().setString(columnInfo.preferred_unit_weightIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'preferred_unit_weight' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.preferred_unit_weightIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$preferred_range() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.preferred_rangeIndex);
    }

    @Override
    public void realmSet$preferred_range(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.preferred_rangeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.preferred_rangeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.preferred_rangeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.preferred_rangeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$custom_range_min() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.custom_range_minIndex);
    }

    @Override
    public void realmSet$custom_range_min(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.custom_range_minIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.custom_range_minIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$custom_range_max() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.custom_range_maxIndex);
    }

    @Override
    public void realmSet$custom_range_max(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.custom_range_maxIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.custom_range_maxIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("User", 13, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("preferred_language", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("country", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("age", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("gender", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("d_type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("preferred_unit", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("preferred_unit_a1c", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("preferred_unit_weight", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("preferred_range", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("custom_range_min", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("custom_range_max", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.diabites.android.db.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.diabites.android.db.User obj = null;
        if (update) {
            Table table = realm.getTable(com.diabites.android.db.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_diabites_android_db_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.com_diabites_android_db_UserRealmProxy) realm.createObjectInternal(com.diabites.android.db.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_diabites_android_db_UserRealmProxy) realm.createObjectInternal(com.diabites.android.db.User.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final com_diabites_android_db_UserRealmProxyInterface objProxy = (com_diabites_android_db_UserRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("preferred_language")) {
            if (json.isNull("preferred_language")) {
                objProxy.realmSet$preferred_language(null);
            } else {
                objProxy.realmSet$preferred_language((String) json.getString("preferred_language"));
            }
        }
        if (json.has("country")) {
            if (json.isNull("country")) {
                objProxy.realmSet$country(null);
            } else {
                objProxy.realmSet$country((String) json.getString("country"));
            }
        }
        if (json.has("age")) {
            if (json.isNull("age")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'age' to null.");
            } else {
                objProxy.realmSet$age((int) json.getInt("age"));
            }
        }
        if (json.has("gender")) {
            if (json.isNull("gender")) {
                objProxy.realmSet$gender(null);
            } else {
                objProxy.realmSet$gender((String) json.getString("gender"));
            }
        }
        if (json.has("d_type")) {
            if (json.isNull("d_type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'd_type' to null.");
            } else {
                objProxy.realmSet$d_type((int) json.getInt("d_type"));
            }
        }
        if (json.has("preferred_unit")) {
            if (json.isNull("preferred_unit")) {
                objProxy.realmSet$preferred_unit(null);
            } else {
                objProxy.realmSet$preferred_unit((String) json.getString("preferred_unit"));
            }
        }
        if (json.has("preferred_unit_a1c")) {
            if (json.isNull("preferred_unit_a1c")) {
                objProxy.realmSet$preferred_unit_a1c(null);
            } else {
                objProxy.realmSet$preferred_unit_a1c((String) json.getString("preferred_unit_a1c"));
            }
        }
        if (json.has("preferred_unit_weight")) {
            if (json.isNull("preferred_unit_weight")) {
                objProxy.realmSet$preferred_unit_weight(null);
            } else {
                objProxy.realmSet$preferred_unit_weight((String) json.getString("preferred_unit_weight"));
            }
        }
        if (json.has("preferred_range")) {
            if (json.isNull("preferred_range")) {
                objProxy.realmSet$preferred_range(null);
            } else {
                objProxy.realmSet$preferred_range((String) json.getString("preferred_range"));
            }
        }
        if (json.has("custom_range_min")) {
            if (json.isNull("custom_range_min")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'custom_range_min' to null.");
            } else {
                objProxy.realmSet$custom_range_min((double) json.getDouble("custom_range_min"));
            }
        }
        if (json.has("custom_range_max")) {
            if (json.isNull("custom_range_max")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'custom_range_max' to null.");
            } else {
                objProxy.realmSet$custom_range_max((double) json.getDouble("custom_range_max"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.diabites.android.db.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.diabites.android.db.User obj = new com.diabites.android.db.User();
        final com_diabites_android_db_UserRealmProxyInterface objProxy = (com_diabites_android_db_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("preferred_language")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$preferred_language((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$preferred_language(null);
                }
            } else if (name.equals("country")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$country((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$country(null);
                }
            } else if (name.equals("age")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$age((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'age' to null.");
                }
            } else if (name.equals("gender")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$gender((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$gender(null);
                }
            } else if (name.equals("d_type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$d_type((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'd_type' to null.");
                }
            } else if (name.equals("preferred_unit")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$preferred_unit((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$preferred_unit(null);
                }
            } else if (name.equals("preferred_unit_a1c")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$preferred_unit_a1c((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$preferred_unit_a1c(null);
                }
            } else if (name.equals("preferred_unit_weight")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$preferred_unit_weight((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$preferred_unit_weight(null);
                }
            } else if (name.equals("preferred_range")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$preferred_range((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$preferred_range(null);
                }
            } else if (name.equals("custom_range_min")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$custom_range_min((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'custom_range_min' to null.");
                }
            } else if (name.equals("custom_range_max")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$custom_range_max((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'custom_range_max' to null.");
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

    public static com.diabites.android.db.User copyOrUpdate(Realm realm, com.diabites.android.db.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.diabites.android.db.User) cachedRealmObject;
        }

        com.diabites.android.db.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.diabites.android.db.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.User.class);
            long pkColumnIndex = columnInfo.idIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.diabites.android.db.User.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_diabites_android_db_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.diabites.android.db.User copy(Realm realm, com.diabites.android.db.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.diabites.android.db.User) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.diabites.android.db.User realmObject = realm.createObjectInternal(com.diabites.android.db.User.class, ((com_diabites_android_db_UserRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_diabites_android_db_UserRealmProxyInterface realmObjectSource = (com_diabites_android_db_UserRealmProxyInterface) newObject;
        com_diabites_android_db_UserRealmProxyInterface realmObjectCopy = (com_diabites_android_db_UserRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectCopy.realmSet$preferred_language(realmObjectSource.realmGet$preferred_language());
        realmObjectCopy.realmSet$country(realmObjectSource.realmGet$country());
        realmObjectCopy.realmSet$age(realmObjectSource.realmGet$age());
        realmObjectCopy.realmSet$gender(realmObjectSource.realmGet$gender());
        realmObjectCopy.realmSet$d_type(realmObjectSource.realmGet$d_type());
        realmObjectCopy.realmSet$preferred_unit(realmObjectSource.realmGet$preferred_unit());
        realmObjectCopy.realmSet$preferred_unit_a1c(realmObjectSource.realmGet$preferred_unit_a1c());
        realmObjectCopy.realmSet$preferred_unit_weight(realmObjectSource.realmGet$preferred_unit_weight());
        realmObjectCopy.realmSet$preferred_range(realmObjectSource.realmGet$preferred_range());
        realmObjectCopy.realmSet$custom_range_min(realmObjectSource.realmGet$custom_range_min());
        realmObjectCopy.realmSet$custom_range_max(realmObjectSource.realmGet$custom_range_max());
        return realmObject;
    }

    public static long insert(Realm realm, com.diabites.android.db.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$preferred_language = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_language();
        if (realmGet$preferred_language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_languageIndex, rowIndex, realmGet$preferred_language, false);
        }
        String realmGet$country = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$country();
        if (realmGet$country != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countryIndex, rowIndex, realmGet$country, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$age(), false);
        String realmGet$gender = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.d_typeIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$d_type(), false);
        String realmGet$preferred_unit = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit();
        if (realmGet$preferred_unit != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_unitIndex, rowIndex, realmGet$preferred_unit, false);
        }
        String realmGet$preferred_unit_a1c = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_a1c();
        if (realmGet$preferred_unit_a1c != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_a1cIndex, rowIndex, realmGet$preferred_unit_a1c, false);
        }
        String realmGet$preferred_unit_weight = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_weight();
        if (realmGet$preferred_unit_weight != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_weightIndex, rowIndex, realmGet$preferred_unit_weight, false);
        }
        String realmGet$preferred_range = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_range();
        if (realmGet$preferred_range != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_rangeIndex, rowIndex, realmGet$preferred_range, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_minIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_min(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_maxIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_max(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.User object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            }
            String realmGet$preferred_language = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_language();
            if (realmGet$preferred_language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_languageIndex, rowIndex, realmGet$preferred_language, false);
            }
            String realmGet$country = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$country();
            if (realmGet$country != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.countryIndex, rowIndex, realmGet$country, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$age(), false);
            String realmGet$gender = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$gender();
            if (realmGet$gender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.d_typeIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$d_type(), false);
            String realmGet$preferred_unit = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit();
            if (realmGet$preferred_unit != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_unitIndex, rowIndex, realmGet$preferred_unit, false);
            }
            String realmGet$preferred_unit_a1c = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_a1c();
            if (realmGet$preferred_unit_a1c != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_a1cIndex, rowIndex, realmGet$preferred_unit_a1c, false);
            }
            String realmGet$preferred_unit_weight = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_weight();
            if (realmGet$preferred_unit_weight != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_weightIndex, rowIndex, realmGet$preferred_unit_weight, false);
            }
            String realmGet$preferred_range = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_range();
            if (realmGet$preferred_range != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_rangeIndex, rowIndex, realmGet$preferred_range, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_minIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_min(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_maxIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_max(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.diabites.android.db.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.diabites.android.db.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$preferred_language = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_language();
        if (realmGet$preferred_language != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_languageIndex, rowIndex, realmGet$preferred_language, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.preferred_languageIndex, rowIndex, false);
        }
        String realmGet$country = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$country();
        if (realmGet$country != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.countryIndex, rowIndex, realmGet$country, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.countryIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$age(), false);
        String realmGet$gender = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$gender();
        if (realmGet$gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.d_typeIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$d_type(), false);
        String realmGet$preferred_unit = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit();
        if (realmGet$preferred_unit != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_unitIndex, rowIndex, realmGet$preferred_unit, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.preferred_unitIndex, rowIndex, false);
        }
        String realmGet$preferred_unit_a1c = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_a1c();
        if (realmGet$preferred_unit_a1c != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_a1cIndex, rowIndex, realmGet$preferred_unit_a1c, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.preferred_unit_a1cIndex, rowIndex, false);
        }
        String realmGet$preferred_unit_weight = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_weight();
        if (realmGet$preferred_unit_weight != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_weightIndex, rowIndex, realmGet$preferred_unit_weight, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.preferred_unit_weightIndex, rowIndex, false);
        }
        String realmGet$preferred_range = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_range();
        if (realmGet$preferred_range != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preferred_rangeIndex, rowIndex, realmGet$preferred_range, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.preferred_rangeIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_minIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_min(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_maxIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_max(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.diabites.android.db.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.diabites.android.db.User.class);
        long pkColumnIndex = columnInfo.idIndex;
        com.diabites.android.db.User object = null;
        while (objects.hasNext()) {
            object = (com.diabites.android.db.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, rowIndex);
            String realmGet$name = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
            }
            String realmGet$preferred_language = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_language();
            if (realmGet$preferred_language != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_languageIndex, rowIndex, realmGet$preferred_language, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.preferred_languageIndex, rowIndex, false);
            }
            String realmGet$country = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$country();
            if (realmGet$country != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.countryIndex, rowIndex, realmGet$country, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.countryIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ageIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$age(), false);
            String realmGet$gender = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$gender();
            if (realmGet$gender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genderIndex, rowIndex, realmGet$gender, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.genderIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.d_typeIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$d_type(), false);
            String realmGet$preferred_unit = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit();
            if (realmGet$preferred_unit != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_unitIndex, rowIndex, realmGet$preferred_unit, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.preferred_unitIndex, rowIndex, false);
            }
            String realmGet$preferred_unit_a1c = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_a1c();
            if (realmGet$preferred_unit_a1c != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_a1cIndex, rowIndex, realmGet$preferred_unit_a1c, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.preferred_unit_a1cIndex, rowIndex, false);
            }
            String realmGet$preferred_unit_weight = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_unit_weight();
            if (realmGet$preferred_unit_weight != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_unit_weightIndex, rowIndex, realmGet$preferred_unit_weight, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.preferred_unit_weightIndex, rowIndex, false);
            }
            String realmGet$preferred_range = ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$preferred_range();
            if (realmGet$preferred_range != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.preferred_rangeIndex, rowIndex, realmGet$preferred_range, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.preferred_rangeIndex, rowIndex, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_minIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_min(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.custom_range_maxIndex, rowIndex, ((com_diabites_android_db_UserRealmProxyInterface) object).realmGet$custom_range_max(), false);
        }
    }

    public static com.diabites.android.db.User createDetachedCopy(com.diabites.android.db.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.diabites.android.db.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.diabites.android.db.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.diabites.android.db.User) cachedObject.object;
            }
            unmanagedObject = (com.diabites.android.db.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_diabites_android_db_UserRealmProxyInterface unmanagedCopy = (com_diabites_android_db_UserRealmProxyInterface) unmanagedObject;
        com_diabites_android_db_UserRealmProxyInterface realmSource = (com_diabites_android_db_UserRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$preferred_language(realmSource.realmGet$preferred_language());
        unmanagedCopy.realmSet$country(realmSource.realmGet$country());
        unmanagedCopy.realmSet$age(realmSource.realmGet$age());
        unmanagedCopy.realmSet$gender(realmSource.realmGet$gender());
        unmanagedCopy.realmSet$d_type(realmSource.realmGet$d_type());
        unmanagedCopy.realmSet$preferred_unit(realmSource.realmGet$preferred_unit());
        unmanagedCopy.realmSet$preferred_unit_a1c(realmSource.realmGet$preferred_unit_a1c());
        unmanagedCopy.realmSet$preferred_unit_weight(realmSource.realmGet$preferred_unit_weight());
        unmanagedCopy.realmSet$preferred_range(realmSource.realmGet$preferred_range());
        unmanagedCopy.realmSet$custom_range_min(realmSource.realmGet$custom_range_min());
        unmanagedCopy.realmSet$custom_range_max(realmSource.realmGet$custom_range_max());

        return unmanagedObject;
    }

    static com.diabites.android.db.User update(Realm realm, com.diabites.android.db.User realmObject, com.diabites.android.db.User newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_diabites_android_db_UserRealmProxyInterface realmObjectTarget = (com_diabites_android_db_UserRealmProxyInterface) realmObject;
        com_diabites_android_db_UserRealmProxyInterface realmObjectSource = (com_diabites_android_db_UserRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$name(realmObjectSource.realmGet$name());
        realmObjectTarget.realmSet$preferred_language(realmObjectSource.realmGet$preferred_language());
        realmObjectTarget.realmSet$country(realmObjectSource.realmGet$country());
        realmObjectTarget.realmSet$age(realmObjectSource.realmGet$age());
        realmObjectTarget.realmSet$gender(realmObjectSource.realmGet$gender());
        realmObjectTarget.realmSet$d_type(realmObjectSource.realmGet$d_type());
        realmObjectTarget.realmSet$preferred_unit(realmObjectSource.realmGet$preferred_unit());
        realmObjectTarget.realmSet$preferred_unit_a1c(realmObjectSource.realmGet$preferred_unit_a1c());
        realmObjectTarget.realmSet$preferred_unit_weight(realmObjectSource.realmGet$preferred_unit_weight());
        realmObjectTarget.realmSet$preferred_range(realmObjectSource.realmGet$preferred_range());
        realmObjectTarget.realmSet$custom_range_min(realmObjectSource.realmGet$custom_range_min());
        realmObjectTarget.realmSet$custom_range_max(realmObjectSource.realmGet$custom_range_max());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{preferred_language:");
        stringBuilder.append(realmGet$preferred_language() != null ? realmGet$preferred_language() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{country:");
        stringBuilder.append(realmGet$country() != null ? realmGet$country() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{age:");
        stringBuilder.append(realmGet$age());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gender:");
        stringBuilder.append(realmGet$gender() != null ? realmGet$gender() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{d_type:");
        stringBuilder.append(realmGet$d_type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{preferred_unit:");
        stringBuilder.append(realmGet$preferred_unit() != null ? realmGet$preferred_unit() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{preferred_unit_a1c:");
        stringBuilder.append(realmGet$preferred_unit_a1c());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{preferred_unit_weight:");
        stringBuilder.append(realmGet$preferred_unit_weight());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{preferred_range:");
        stringBuilder.append(realmGet$preferred_range() != null ? realmGet$preferred_range() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{custom_range_min:");
        stringBuilder.append(realmGet$custom_range_min());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{custom_range_max:");
        stringBuilder.append(realmGet$custom_range_max());
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
        com_diabites_android_db_UserRealmProxy aUser = (com_diabites_android_db_UserRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUser.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUser.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
