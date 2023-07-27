
INSERT INTO catalogs_tbl (id,catalog_name,sheetname_name) VALUES (101,'TST-Catalog (Excluding ABC)','Catalog (Excluding ABC)');

INSERT INTO catalogs_tbl (id,catalog_name,sheetname_name) VALUES (201,'TST-Catalog-ABC','1-Apple');

INSERT INTO catalogs_tbl (id,catalog_name,sheetname_name) VALUES (202,'TST-Catalog-ABC','2-backup');


INSERT INTO archive_objects_tbl (id,catalog_id,bucket_name,object_key,size,tag_data) VALUES (
    1,
    101,
    'some-test-bucket',
    'TEST/TEST.zip',
    '100MB',
    '{"tags": {
        "AppID": "TEST_APPID01",
        "Classification": "NA"
    }}'
);

INSERT INTO archive_objects_tbl (id,catalog_id,bucket_name,object_key,size,tag_data) VALUES (
    2,
    101,
    'some-test-bucket',
    'TEST/SOMEFILE.zip',
    '100MB',
    '{"tags": {
        "AppID": "TEST_APPID02",
        "Classification": "NA"
    }}'
);
