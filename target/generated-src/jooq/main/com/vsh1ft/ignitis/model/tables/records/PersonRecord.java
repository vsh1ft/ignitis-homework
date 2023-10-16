/*
 * This file is generated by jOOQ.
 */
package com.vsh1ft.ignitis.model.tables.records;


import com.vsh1ft.ignitis.model.tables.Person;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PersonRecord extends UpdatableRecordImpl<PersonRecord> implements Record4<String, Boolean, Boolean, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PUBLIC.PERSON.ID</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.PERSON.ID</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.IS_ADMIN</code>.
     */
    public void setIsAdmin(Boolean value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.PERSON.IS_ADMIN</code>.
     */
    public Boolean getIsAdmin() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.IS_ACTIVE</code>.
     */
    public void setIsActive(Boolean value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.PERSON.IS_ACTIVE</code>.
     */
    public Boolean getIsActive() {
        return (Boolean) get(2);
    }

    /**
     * Setter for <code>PUBLIC.PERSON.NAME</code>.
     */
    public void setName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.PERSON.NAME</code>.
     */
    public String getName() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, Boolean, Boolean, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, Boolean, Boolean, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Person.PERSON.ID;
    }

    @Override
    public Field<Boolean> field2() {
        return Person.PERSON.IS_ADMIN;
    }

    @Override
    public Field<Boolean> field3() {
        return Person.PERSON.IS_ACTIVE;
    }

    @Override
    public Field<String> field4() {
        return Person.PERSON.NAME;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public Boolean component2() {
        return getIsAdmin();
    }

    @Override
    public Boolean component3() {
        return getIsActive();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public Boolean value2() {
        return getIsAdmin();
    }

    @Override
    public Boolean value3() {
        return getIsActive();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public PersonRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public PersonRecord value2(Boolean value) {
        setIsAdmin(value);
        return this;
    }

    @Override
    public PersonRecord value3(Boolean value) {
        setIsActive(value);
        return this;
    }

    @Override
    public PersonRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public PersonRecord values(String value1, Boolean value2, Boolean value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PersonRecord
     */
    public PersonRecord() {
        super(Person.PERSON);
    }

    /**
     * Create a detached, initialised PersonRecord
     */
    public PersonRecord(String id, Boolean isAdmin, Boolean isActive, String name) {
        super(Person.PERSON);

        setId(id);
        setIsAdmin(isAdmin);
        setIsActive(isActive);
        setName(name);
        resetChangedOnNotNull();
    }
}
