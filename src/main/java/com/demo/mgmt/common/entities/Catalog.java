package com.demo.mgmt.common.entities;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "catalogs_tbl", uniqueConstraints = {
	@UniqueConstraint(name = "catalogUniqueCatalogNameAndSheetName", columnNames = { "catalog_name",
			"sheetname_name" }) })
@Entity
@Cacheable
@NoArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@RegisterForReflection
public class Catalog extends PanacheEntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_catalog", initialValue = 1, allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_catalog")
	@Column(name = "id", updatable = false, nullable = false)
	@EqualsAndHashCode.Include
	private Long id;


	@Column(name = "catalog_name", nullable = false)
	private String catalogName;

	@Column(name = "sheetname_name", nullable = false)
	private String sheetName;	


	public Catalog(String catalogName, String sheetName) {
		this.catalogName = catalogName;
		this.sheetName = sheetName;
	}

	public static Optional<Catalog> findByCatalogNameAndSheetName(String catalogName, String sheetName) {
		return find("catalogName = :catalogName and sheetName = :sheetName",
				Map.of("catalogName", catalogName, "sheetName", sheetName)).singleResultOptional();
	}
}
