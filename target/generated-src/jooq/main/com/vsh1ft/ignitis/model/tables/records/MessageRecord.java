/*
 * This file is generated by jOOQ.
 */
package com.vsh1ft.ignitis.model.tables.records;


import com.vsh1ft.ignitis.model.tables.Message;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MessageRecord extends UpdatableRecordImpl<MessageRecord> implements Record4<String, String, String, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PUBLIC.MESSAGE.ID</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.MESSAGE.ID</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>PUBLIC.MESSAGE.PERSON_ID</code>.
     */
    public void setPersonId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.MESSAGE.PERSON_ID</code>.
     */
    public String getPersonId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PUBLIC.MESSAGE.CONTENT</code>.
     */
    public void setContent(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.MESSAGE.CONTENT</code>.
     */
    public String getContent() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.MESSAGE.TIME_RECEIVED</code>.
     */
    public void setTimeReceived(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.MESSAGE.TIME_RECEIVED</code>.
     */
    public LocalDateTime getTimeReceived() {
        return (LocalDateTime) get(3);
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
    public Row4<String, String, String, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Message.MESSAGE.ID;
    }

    @Override
    public Field<String> field2() {
        return Message.MESSAGE.PERSON_ID;
    }

    @Override
    public Field<String> field3() {
        return Message.MESSAGE.CONTENT;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Message.MESSAGE.TIME_RECEIVED;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getPersonId();
    }

    @Override
    public String component3() {
        return getContent();
    }

    @Override
    public LocalDateTime component4() {
        return getTimeReceived();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getPersonId();
    }

    @Override
    public String value3() {
        return getContent();
    }

    @Override
    public LocalDateTime value4() {
        return getTimeReceived();
    }

    @Override
    public MessageRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public MessageRecord value2(String value) {
        setPersonId(value);
        return this;
    }

    @Override
    public MessageRecord value3(String value) {
        setContent(value);
        return this;
    }

    @Override
    public MessageRecord value4(LocalDateTime value) {
        setTimeReceived(value);
        return this;
    }

    @Override
    public MessageRecord values(String value1, String value2, String value3, LocalDateTime value4) {
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
     * Create a detached MessageRecord
     */
    public MessageRecord() {
        super(Message.MESSAGE);
    }

    /**
     * Create a detached, initialised MessageRecord
     */
    public MessageRecord(String id, String personId, String content, LocalDateTime timeReceived) {
        super(Message.MESSAGE);

        setId(id);
        setPersonId(personId);
        setContent(content);
        setTimeReceived(timeReceived);
        resetChangedOnNotNull();
    }
}
