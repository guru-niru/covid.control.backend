package org.iitbact.cc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the facility_contacts database table.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="facility_inventory")
@TypeDef(
	    name = "json",
	    typeClass = JsonStringType.class
	)
@NamedQuery(name="FacilityInventory.findAll", query="SELECT f FROM FacilityInventory f")
public class FacilityInventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer facilityId;
	
	@Type(type = "json")
    @Column(columnDefinition = "json")
	private Object data;

	//bi-directional one-to-one association to Facility
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	@MapsId
	private Facility facility;
}