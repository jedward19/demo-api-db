package com.demo.mgmt.test.utils;


import java.util.Map;

import io.quarkus.test.junit.QuarkusTestProfile;

public class Profiles {

    public static class WithDB implements QuarkusTestProfile {

        @Override
        public boolean disableGlobalTestResources() {
            return true;
        }

        @Override
        public Map<String, String> getConfigOverrides() {
            return Map.of(
                "quarkus.hibernate-orm.database.generation", "drop-and-create",
                "quarkus.hibernate-orm.sql-load-script", "import-test.sql",
                "quarkus.datasource.devservices.enabled", "true",
                "quarkus.devservices.enabled","true",
                "quarkus.hibernate-orm.enabled","true",
                "quarkus.datasource.db-kind","pgsql"
            );
        }
    }
}
