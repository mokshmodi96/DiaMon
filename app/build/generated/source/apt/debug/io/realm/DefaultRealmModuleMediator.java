package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(8);
        modelClasses.add(com.diabites.android.db.CholesterolReading.class);
        modelClasses.add(com.diabites.android.db.GlucoseReading.class);
        modelClasses.add(com.diabites.android.db.HB1ACReading.class);
        modelClasses.add(com.diabites.android.db.KetoneReading.class);
        modelClasses.add(com.diabites.android.db.PressureReading.class);
        modelClasses.add(com.diabites.android.db.Reminder.class);
        modelClasses.add(com.diabites.android.db.User.class);
        modelClasses.add(com.diabites.android.db.WeightReading.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(8);
        infoMap.put(com.diabites.android.db.CholesterolReading.class, io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.diabites.android.db.GlucoseReading.class, io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.diabites.android.db.HB1ACReading.class, io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.diabites.android.db.KetoneReading.class, io.realm.com_diabites_android_db_KetoneReadingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.diabites.android.db.PressureReading.class, io.realm.com_diabites_android_db_PressureReadingRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.diabites.android.db.Reminder.class, io.realm.com_diabites_android_db_ReminderRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.diabites.android.db.User.class, io.realm.com_diabites_android_db_UserRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.diabites.android.db.WeightReading.class, io.realm.com_diabites_android_db_WeightReadingRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            return io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            return io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            return io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            return io.realm.com_diabites_android_db_KetoneReadingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            return io.realm.com_diabites_android_db_PressureReadingRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            return io.realm.com_diabites_android_db_ReminderRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.diabites.android.db.User.class)) {
            return io.realm.com_diabites_android_db_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            return io.realm.com_diabites_android_db_WeightReadingRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            return "CholesterolReading";
        }
        if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            return "GlucoseReading";
        }
        if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            return "HB1ACReading";
        }
        if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            return "KetoneReading";
        }
        if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            return "PressureReading";
        }
        if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            return "Reminder";
        }
        if (clazz.equals(com.diabites.android.db.User.class)) {
            return "User";
        }
        if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            return "WeightReading";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_CholesterolReadingRealmProxy());
            }
            if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_GlucoseReadingRealmProxy());
            }
            if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_HB1ACReadingRealmProxy());
            }
            if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_KetoneReadingRealmProxy());
            }
            if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_PressureReadingRealmProxy());
            }
            if (clazz.equals(com.diabites.android.db.Reminder.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_ReminderRealmProxy());
            }
            if (clazz.equals(com.diabites.android.db.User.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_UserRealmProxy());
            }
            if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
                return clazz.cast(new io.realm.com_diabites_android_db_WeightReadingRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.CholesterolReading) obj, update, cache));
        }
        if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.GlucoseReading) obj, update, cache));
        }
        if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.HB1ACReading) obj, update, cache));
        }
        if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_KetoneReadingRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.KetoneReading) obj, update, cache));
        }
        if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_PressureReadingRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.PressureReading) obj, update, cache));
        }
        if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_ReminderRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.Reminder) obj, update, cache));
        }
        if (clazz.equals(com.diabites.android.db.User.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_UserRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.User) obj, update, cache));
        }
        if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_WeightReadingRealmProxy.copyOrUpdate(realm, (com.diabites.android.db.WeightReading) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.insert(realm, (com.diabites.android.db.CholesterolReading) object, cache);
        } else if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.insert(realm, (com.diabites.android.db.GlucoseReading) object, cache);
        } else if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.insert(realm, (com.diabites.android.db.HB1ACReading) object, cache);
        } else if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            io.realm.com_diabites_android_db_KetoneReadingRealmProxy.insert(realm, (com.diabites.android.db.KetoneReading) object, cache);
        } else if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            io.realm.com_diabites_android_db_PressureReadingRealmProxy.insert(realm, (com.diabites.android.db.PressureReading) object, cache);
        } else if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            io.realm.com_diabites_android_db_ReminderRealmProxy.insert(realm, (com.diabites.android.db.Reminder) object, cache);
        } else if (clazz.equals(com.diabites.android.db.User.class)) {
            io.realm.com_diabites_android_db_UserRealmProxy.insert(realm, (com.diabites.android.db.User) object, cache);
        } else if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            io.realm.com_diabites_android_db_WeightReadingRealmProxy.insert(realm, (com.diabites.android.db.WeightReading) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
                io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.insert(realm, (com.diabites.android.db.CholesterolReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
                io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.insert(realm, (com.diabites.android.db.GlucoseReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
                io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.insert(realm, (com.diabites.android.db.HB1ACReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
                io.realm.com_diabites_android_db_KetoneReadingRealmProxy.insert(realm, (com.diabites.android.db.KetoneReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
                io.realm.com_diabites_android_db_PressureReadingRealmProxy.insert(realm, (com.diabites.android.db.PressureReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.Reminder.class)) {
                io.realm.com_diabites_android_db_ReminderRealmProxy.insert(realm, (com.diabites.android.db.Reminder) object, cache);
            } else if (clazz.equals(com.diabites.android.db.User.class)) {
                io.realm.com_diabites_android_db_UserRealmProxy.insert(realm, (com.diabites.android.db.User) object, cache);
            } else if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
                io.realm.com_diabites_android_db_WeightReadingRealmProxy.insert(realm, (com.diabites.android.db.WeightReading) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
                    io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
                    io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
                    io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
                    io.realm.com_diabites_android_db_KetoneReadingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
                    io.realm.com_diabites_android_db_PressureReadingRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.Reminder.class)) {
                    io.realm.com_diabites_android_db_ReminderRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.User.class)) {
                    io.realm.com_diabites_android_db_UserRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
                    io.realm.com_diabites_android_db_WeightReadingRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.CholesterolReading) obj, cache);
        } else if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.GlucoseReading) obj, cache);
        } else if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.HB1ACReading) obj, cache);
        } else if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            io.realm.com_diabites_android_db_KetoneReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.KetoneReading) obj, cache);
        } else if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            io.realm.com_diabites_android_db_PressureReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.PressureReading) obj, cache);
        } else if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            io.realm.com_diabites_android_db_ReminderRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.Reminder) obj, cache);
        } else if (clazz.equals(com.diabites.android.db.User.class)) {
            io.realm.com_diabites_android_db_UserRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.User) obj, cache);
        } else if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            io.realm.com_diabites_android_db_WeightReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.WeightReading) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
                io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.CholesterolReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
                io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.GlucoseReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
                io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.HB1ACReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
                io.realm.com_diabites_android_db_KetoneReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.KetoneReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
                io.realm.com_diabites_android_db_PressureReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.PressureReading) object, cache);
            } else if (clazz.equals(com.diabites.android.db.Reminder.class)) {
                io.realm.com_diabites_android_db_ReminderRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.Reminder) object, cache);
            } else if (clazz.equals(com.diabites.android.db.User.class)) {
                io.realm.com_diabites_android_db_UserRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.User) object, cache);
            } else if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
                io.realm.com_diabites_android_db_WeightReadingRealmProxy.insertOrUpdate(realm, (com.diabites.android.db.WeightReading) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
                    io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
                    io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
                    io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
                    io.realm.com_diabites_android_db_KetoneReadingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
                    io.realm.com_diabites_android_db_PressureReadingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.Reminder.class)) {
                    io.realm.com_diabites_android_db_ReminderRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.User.class)) {
                    io.realm.com_diabites_android_db_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
                    io.realm.com_diabites_android_db_WeightReadingRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_KetoneReadingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_PressureReadingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_ReminderRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.diabites.android.db.User.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_WeightReadingRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_KetoneReadingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_PressureReadingRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_ReminderRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.diabites.android.db.User.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_WeightReadingRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.diabites.android.db.CholesterolReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_CholesterolReadingRealmProxy.createDetachedCopy((com.diabites.android.db.CholesterolReading) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.diabites.android.db.GlucoseReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_GlucoseReadingRealmProxy.createDetachedCopy((com.diabites.android.db.GlucoseReading) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.diabites.android.db.HB1ACReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_HB1ACReadingRealmProxy.createDetachedCopy((com.diabites.android.db.HB1ACReading) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.diabites.android.db.KetoneReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_KetoneReadingRealmProxy.createDetachedCopy((com.diabites.android.db.KetoneReading) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.diabites.android.db.PressureReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_PressureReadingRealmProxy.createDetachedCopy((com.diabites.android.db.PressureReading) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.diabites.android.db.Reminder.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_ReminderRealmProxy.createDetachedCopy((com.diabites.android.db.Reminder) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.diabites.android.db.User.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_UserRealmProxy.createDetachedCopy((com.diabites.android.db.User) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.diabites.android.db.WeightReading.class)) {
            return clazz.cast(io.realm.com_diabites_android_db_WeightReadingRealmProxy.createDetachedCopy((com.diabites.android.db.WeightReading) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
