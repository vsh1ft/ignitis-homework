/*
 * This file is generated by jOOQ.
 */
package com.vsh1ft.ignitis.model.tables;


import com.vsh1ft.ignitis.model.Keys;
import com.vsh1ft.ignitis.model.Public;
import com.vsh1ft.ignitis.model.tables.records.MessageRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Message extends TableImpl<MessageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC.MESSAGE</code>
     */
    public static final Message MESSAGE = new Message();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MessageRecord> getRecordType() {
        return MessageRecord.class;
    }

    /**
     * The column <code>PUBLIC.MESSAGE.ID</code>.
     */
    public final TableField<MessageRecord, String> ID = createField(DSL.name("ID"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.MESSAGE.PERSON_ID</code>.
     */
    public final TableField<MessageRecord, String> PERSON_ID = createField(DSL.name("PERSON_ID"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.MESSAGE.CONTENT</code>.
     */
    public final TableField<MessageRecord, String> CONTENT = createField(DSL.name("CONTENT"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>PUBLIC.MESSAGE.TIME_RECEIVED</code>.
     */
    public final TableField<MessageRecord, LocalDateTime> TIME_RECEIVED = createField(DSL.name("TIME_RECEIVED"), SQLDataType.LOCALDATETIME(6), this, "");

    private Message(Name alias, Table<MessageRecord> aliased) {
        this(alias, aliased, null);
    }

    private Message(Name alias, Table<MessageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>PUBLIC.MESSAGE</code> table reference
     */
    public Message(String alias) {
        this(DSL.name(alias), MESSAGE);
    }

    /**
     * Create an aliased <code>PUBLIC.MESSAGE</code> table reference
     */
    public Message(Name alias) {
        this(alias, MESSAGE);
    }

    /**
     * Create a <code>PUBLIC.MESSAGE</code> table reference
     */
    public Message() {
        this(DSL.name("MESSAGE"), null);
    }

    public <O extends Record> Message(Table<O> child, ForeignKey<O, MessageRecord> key) {
        super(child, key, MESSAGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<MessageRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_6;
    }

    @Override
    public List<ForeignKey<MessageRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_PERSONID);
    }

    private transient Person _person;

    /**
     * Get the implicit join path to the <code>PUBLIC.PERSON</code> table.
     */
    public Person person() {
        if (_person == null)
            _person = new Person(this, Keys.FK_PERSONID);

        return _person;
    }

    @Override
    public Message as(String alias) {
        return new Message(DSL.name(alias), this);
    }

    @Override
    public Message as(Name alias) {
        return new Message(alias, this);
    }

    @Override
    public Message as(Table<?> alias) {
        return new Message(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Message rename(String name) {
        return new Message(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Message rename(Name name) {
        return new Message(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Message rename(Table<?> name) {
        return new Message(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super String, ? super String, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super String, ? super String, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}