package com.demo.mgmt.common.dataservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.demo.mgmt.common.entities.Catalog;
import com.demo.mgmt.test.utils.Profiles.WithDB;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestTransaction
@TestProfile(WithDB.class)
class CatalogTest {

    @Test
    void givenEmptyCatalogTableAndValidCatalogObj_whenPersist_thenPersisted() {


        assertThat(Catalog.findByCatalogNameAndSheetName("TST-Catalog-02","TEST-SHEET01")).isEmpty();


        Catalog c = new Catalog("TST-Catalog-02","TEST-SHEET01");
        
        Catalog.persist(c);

        Optional<Catalog> oCatalog = Catalog.findByCatalogNameAndSheetName("TST-Catalog-02","TEST-SHEET01");
        assertThat(oCatalog).isNotEmpty();

        Catalog pCatalog = oCatalog.get();
        assertThat(pCatalog).isEqualTo(c);
    }  

}
